<template>
	<div class="forum-preview">
		<div class="forum-title">
			<div>健康论坛</div>
		</div>
		<el-form :inline="true" :model="formSearch" class="list-form-pv">
			<el-form-item class="search-item">
				<el-input v-model="title" placeholder="标题"></el-input>
			</el-form-item>
			<div class="search-btn-item">
				<el-button class="searchBtn" type="primary" @click="getForumList(1)">
					<span class="icon iconfont icon-shouye-zhihui"></span>
					查询
				</el-button>
				<el-button class="pubBtn" type="primary" @click="toForumAdd">
					<span class="icon iconfont icon-shouye-zhihui"></span>
					发布帖子
				</el-button>
			</div>
		</el-form>
		<div class="category-list">
			<div class="item" @click="categoryClick(0)" :class="categoryIndex == 0 ? 'active' : ''">全部</div>
			<div v-for="(item,index) in categoryList" @click="categoryClick(index+1)" :key="index" class="item" :class="categoryIndex == index+1 ? 'active' : ''">{{item.typename}}</div>
		</div>
		<div class="z-box">
			<div class="section-content" v-for="item in forumList" :key="item.id" @click.stop="toForumDetail(item)">
				<img class="item-img" :src="$config.baseUrl + item.cover.split(',')[0]" @click.stop="imgPreView($config.baseUrl + item.cover.split(',')[0])" />
				<div class="item-title">{{item.title}}</div>
				<div class="item-user">发布人：{{item.isanon==1&&item.userid!=userid?'匿名':item.username}}</div>
				<div class="item-time">{{item.addtime}}</div>
			</div>
		</div>
		<el-pagination
			background
			id="pagination" class="pagination"
			:pager-count="7"
			:page-size="pageSize"
			:page-sizes="pageSizes"
			prev-text="<"
			next-text=">"
			:hide-on-single-page="true"
			:layout='["total","prev","pager","next","sizes","jumper"].join()'
			:total="total"
			@current-change="curChange"
			@size-change="sizeChange"
			@prev-click="prevClick"
			@next-click="nextClick"
			></el-pagination>
		<el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
			<img :src="previewImg" alt="" style="width: 100%;">
		</el-dialog>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				formSearch: {},
				title: '',
				layouts: '',
				forumList: [],
				total: 1,
				pageSize: 10,
				pageSizes: [],
				totalPage: 1,
				previewImg: '',
				previewVisible: false,
				userid: Number(localStorage.getItem('frontUserid')),
				categoryIndex: 0,
				categoryList: [],
			}
		},
		created() {
			this.getCategoryList()
		},
		watch:{
			$route(newValue){
				this.getCategoryList()
			}
		},
		//方法集合
		methods: {
			getCategoryList(){
				this.$http.get('forumtype/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data.list
						if(this.$route.query.homeFenlei){
							for(let i=0;i<this.categoryList.length;i++) {
								if(this.$route.query.homeFenlei == this.categoryList[i].typename) {
									this.categoryIndex = i + 1;
									const currentRoute = this.$route;
									const routeWithoutQuery = { ...currentRoute };
									delete routeWithoutQuery.query;
									this.$router.replace(routeWithoutQuery)
									break;
								}
							}
						}
						this.getForumList(1);
					}
				});
			},
			categoryClick(index) {
				this.categoryIndex = index
				this.getForumList()
			},
			imgPreView(url){
				this.previewImg = url
				this.previewVisible = true
			},
			getForumList(page) {
				let params = {page, limit: this.pageSize, isdone: '开放', sort: 'istop,toptime', order: 'desc,desc',delflag: 0};
				let searchWhere = {};
				if(this.title != '') searchWhere.title = '%' + this.title + '%';
				if(this.categoryIndex!=0){
					searchWhere.typename = this.categoryList[this.categoryIndex - 1].typename
				}
				this.$http.get('forum/flist', {params: Object.assign(params, searchWhere)}).then(res => {
					if (res.data.code == 0) {
						this.forumList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
						if(this.pageSizes.length==0){
							this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
						}
					}
				});
			},
			curChange(page) {
				this.getForumList(page);
			},
			prevClick(page) {
				this.getForumList(page);
			},
			sizeChange(size){
				this.pageSize = size
				this.getForumList(1);
			},
			nextClick(page) {
				this.getForumList(page);
			},
			toForumAdd() {
				this.$router.push('/index/forumAdd');
			},
			toForumDetail(item) {
				this.$router.push({path: '/index/forumDetail', query: {id: item.id}});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.forum-preview {
				padding: 20px 0;
				margin: 20px auto;
				background: #FAFCFF;
				width: 1270px;
				position: relative;
				.forum-title {
						width: 100%;
						div {
								color: #896785;
								background: url(http://codegen.caihongy.cn/20241122/cda88df66d42496fa403c0ed98bac06b.webp) no-repeat bottom;
								font-weight: 600px;
								width: 100%;
								font-size: 36px;
								line-height: 160px;
								text-align: center;
							}
		}
		.list-form-pv {
						padding: 10px;
						margin: 10px 0;
						background: none;
						display: flex;
						width: 100%;
						align-items: center;
						flex-wrap: wrap;
						height: auto;
						.search-item {
								margin: 0 10px;
								/deep/ .el-form-item__content {
										display: flex;
										align-items: center;
									}
				.el-input {
										width: 100%;
									}
				.el-input /deep/ .el-input__inner {
										border: 0;
										border-radius: 4px;
										padding: 0 10px;
										box-shadow: inset 0px 4px 10px 0px rgba(178,178,178,0.3);
										margin: 0;
										outline: none;
										color: #333;
										width: 280px;
										font-size: 14px;
										line-height: 42px;
										height: 42px;
									}
			}
			.search-btn-item {
								display: flex;
								.searchBtn {
										cursor: pointer;
										border: 0;
										border-radius: 4px;
										padding: 0px 15px;
										margin: 0 10px 0 0;
										outline: none;
										background: #896785;
										width: auto;
										font-size: 14px;
										line-height: 42px;
										height: 42px;
										.icon {
												margin: 0 10px 0 0;
												color: #fff;
											}
				}
				
				.searchBtn:hover {
										background: #896785;
									}
				
				.pubBtn {
										cursor: pointer;
										border: 0;
										border-radius: 4px;
										padding: 0px 15px;
										margin: 0 10px 0 0;
										outline: none;
										color: #fff;
										background: #2D2747;
										width: auto;
										font-size: 14px;
										line-height: 42px;
										height: 42px;
										.icon {
												margin: 0 10px 0 0;
												color: #fff;
												font-size: 14px;
											}
				}
				
				.pubBtn:hover {
										background: #2D2747;
									}
			}
		}
		.category-list {
						padding: 0;
						margin: 20px;
						background: none;
						display: flex;
						width: 100%;
						height: auto;
						.item {
								cursor: pointer;
								border-radius: 4px;
								margin: 0 10px 0 0;
								color: #000000;
								background: url(http://codegen.caihongy.cn/20241129/390806144eb44140a1a3f4c621b05a4a.png)  no-repeat center center / 100% 100%;
								width: auto;
								font-size: 14px;
								line-height: 50px;
								text-align: center;
								min-width: 120px;
							}
			
			.item:hover {
								cursor: pointer;
								border-radius: 4px;
								margin: 0 10px 0 0;
								color: #000000;
								background: url(http://codegen.caihongy.cn/20241122/6413041513c84d3ca9148687c9fed9f7.webp)  no-repeat center center / 100%100%;
								width: auto;
								font-size: 14px;
								line-height: 50px;
								text-align: center;
								min-width: 120px;
							}
			
			.item.active {
								cursor: pointer;
								border-radius: 4px;
								margin: 0 10px 0 0;
								color: #000000;
								background: url(http://codegen.caihongy.cn/20241122/6413041513c84d3ca9148687c9fed9f7.webp)  no-repeat center center / 100% 100%;
								width: auto;
								font-size: 14px;
								line-height: 50px;
								text-align: center;
								min-width: 120px;
							}
		}
		.z-box {
						padding: 20px;
						width: 100%;
						.section-content {
								cursor: pointer;
								padding: 20px;
								box-shadow: 0px 4px 5px 0px rgba(0,0,0,0.3), inset 0px 4px 10px 0px rgba(231,231,231,0.3);
								margin: 0 0 20px 0;
								background: #fff;
								display: flex;
								width: 100%;
								border-color: #efefef;
								border-width: 0 0 1px 0;
								align-items: center;
								border-style: solid;
								flex-wrap: wrap;
								.item-img {
										border-radius: 0px;
										flex: none;
										width: 40px;
										transition: all .4s;
										height: 40px;
										order: 1;
									}
				.item-title {
										padding: 10px;
										margin: 10px 0 0 0;
										color: #666;
										flex: 1;
										font-size: 14px;
										border-color: #000000;
										border-width: 1px 0 1px 1px;
										border-style: solid;
										order: 3;
									}
				.item-user {
										padding: 0 0 0 10px;
										color: #666;
										flex: auto;
										width: calc(100% - 40px);
										font-size: 14px;
										order: 2;
									}
				.item-time {
										padding: 10px;
										margin: 10px 0 0 0;
										color: #666;
										flex: 1;
										font-size: 14px;
										border-color: #000000;
										border-width: 1px 1px 1px 0;
										border-style: solid;
										order: 4;
									}
			}
			.section-content:hover {
								background: #e4e7ed;
								.item-title {
										color: #111;
									}
				.item-user {
										color: #111;
									}
				.item-time {
										color: #111;
									}
			}
		}
	}
</style>
