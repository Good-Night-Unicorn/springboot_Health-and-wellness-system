<template>
	<div class="home-preview">




		<!-- 商品推荐 -->
		<div id="animate_recommendjiankangshipin" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">健康视频推荐</span>
				<span class="recommend_subhead">{{'jiankangshipin'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="jiankangshipinRecommend.length" class="list list12 index-pv1 list12jiankangshipin">
				<div class="list-body">
					<div class="item list-item animation-box" v-for="item,index in jiankangshipinRecommend" :key="index" @click="toDetail('jiankangshipinDetail', item)">
						<img :name="item.id" v-if="preHttp(item.shipinfengmian)&&preHttp2(item.shipinfengmian)" :src="item.shipinfengmian" alt="" />
						<img :name="item.id" v-else-if="preHttp(item.shipinfengmian)" :src="item.shipinfengmian.split(',')[0]" alt="" />
						<img :name="item.id" v-else :src="baseUrl + (item.shipinfengmian?item.shipinfengmian.split(',')[0]:'')" alt="" />
						<div class="name">{{item.shipinmingcheng}}</div>
						<div class="name">{{item.faburiqi}}</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('jiankangshipin')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 特价商品 -->
		<div id="animate_listchuzhenyisheng" class="lists animate__animated">
			<div class="list_title_box">
				<span class="list_title">出诊医生展示</span>
				<span class="list_subhead">{{'chuzhenyisheng'.toUpperCase()}} SHOW</span>
			</div>
			<div class="list list20 index-pv1">
				<div class="list-body">
					<div v-if="chuzhenyishengList.length>0" class="list-item1" @click="toDetail('chuzhenyishengDetail', chuzhenyishengList[0])">
						<div class="img">
							<img v-if="preHttp(chuzhenyishengList[0].touxiang)" :src="chuzhenyishengList[0].touxiang.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (chuzhenyishengList[0].touxiang?chuzhenyishengList[0].touxiang.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{chuzhenyishengList[0].yishengxingming}}</div>
							<div class="name">挂号费:{{chuzhenyishengList[0].guahaofei}}</div>
							<div class="name">出诊日期:{{chuzhenyishengList[0].chuzhenriqi}}</div>
							<div class="time_item">
								<span class="icon iconfont "></span>
								<span class="label">发布时间：</span>
								<span class="text">{{chuzhenyishengList[0].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
					<div v-if="chuzhenyishengList.length>1" class="list-item2" @click="toDetail('chuzhenyishengDetail', chuzhenyishengList[1])">
						<div class="img">
							<img v-if="preHttp(chuzhenyishengList[1].touxiang)" :src="chuzhenyishengList[1].touxiang.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (chuzhenyishengList[1].touxiang?chuzhenyishengList[1].touxiang.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{chuzhenyishengList[1].yishengxingming}}</div>
							<div class="name">挂号费:{{chuzhenyishengList[1].guahaofei}}</div>
							<div class="name">出诊日期:{{chuzhenyishengList[1].chuzhenriqi}}</div>
							<div class="time_item">
								<span class="icon iconfon "></span>
								<span class="label">发布时间：</span>
								<span class="text">{{chuzhenyishengList[1].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
					<div v-if="chuzhenyishengList.length>2" class="list-item3" @click="toDetail('chuzhenyishengDetail', chuzhenyishengList[2])">
						<div class="img">
							<img v-if="preHttp(chuzhenyishengList[2].touxiang)" :src="chuzhenyishengList[2].touxiang.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (chuzhenyishengList[2].touxiang?chuzhenyishengList[2].touxiang.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{chuzhenyishengList[2].yishengxingming}}</div>
							<div class="name">挂号费:{{chuzhenyishengList[2].guahaofei}}</div>
							<div class="name">出诊日期:{{chuzhenyishengList[2].chuzhenriqi}}</div>
							<div class="time_item">
								<span class="icon iconfont "></span>
								<span class="label">发布时间：</span>
								<span class="text">{{chuzhenyishengList[2].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
					<div v-if="chuzhenyishengList.length>3" class="list-item4" @click="toDetail('chuzhenyishengDetail', chuzhenyishengList[3])">
						<div class="img">
							<img v-if="preHttp(chuzhenyishengList[3].touxiang)" :src="chuzhenyishengList[3].touxiang.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (chuzhenyishengList[3].touxiang?chuzhenyishengList[3].touxiang.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{chuzhenyishengList[3].yishengxingming}}</div>
							<div class="name">挂号费:{{chuzhenyishengList[3].guahaofei}}</div>
							<div class="name">出诊日期:{{chuzhenyishengList[3].chuzhenriqi}}</div>
							<div class="time_item">
								<span class="icon iconfont "></span>
								<span class="label">发布时间：</span>
								<span class="text">{{chuzhenyishengList[3].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
					<div v-if="chuzhenyishengList.length>4" class="list-item5" @click="toDetail('chuzhenyishengDetail', chuzhenyishengList[4])">
						<div class="img">
							<img v-if="preHttp(chuzhenyishengList[4].touxiang)" :src="chuzhenyishengList[4].touxiang.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (chuzhenyishengList[4].touxiang?chuzhenyishengList[4].touxiang.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{chuzhenyishengList[4].yishengxingming}}</div>
							<div class="name">挂号费:{{chuzhenyishengList[4].guahaofei}}</div>
							<div class="name">出诊日期:{{chuzhenyishengList[4].chuzhenriqi}}</div>
							<div class="time_item">
								<span class="icon iconfont "></span>
								<span class="label">发布时间：</span>
								<span class="text">{{chuzhenyishengList[4].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
					<div v-if="chuzhenyishengList.length>5" class="list-item6" @click="toDetail('chuzhenyishengDetail', chuzhenyishengList[5])">
						<div class="img">
							<img v-if="preHttp(chuzhenyishengList[5].touxiang)" :src="chuzhenyishengList[5].touxiang.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (chuzhenyishengList[5].touxiang?chuzhenyishengList[5].touxiang.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{chuzhenyishengList[5].yishengxingming}}</div>
							<div class="name">挂号费:{{chuzhenyishengList[5].guahaofei}}</div>
							<div class="name">出诊日期:{{chuzhenyishengList[5].chuzhenriqi}}</div>
							<div class="time_item">
								<span class="icon iconfont "></span>
								<span class="label">发布时间：</span>
								<span class="text">{{chuzhenyishengList[5].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
					<div v-if="chuzhenyishengList.length>6" class="list-item7" @click="toDetail('chuzhenyishengDetail', chuzhenyishengList[6])">
						<div class="img">
							<img v-if="preHttp(chuzhenyishengList[6].touxiang)" :src="chuzhenyishengList[6].touxiang.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (chuzhenyishengList[6].touxiang?chuzhenyishengList[6].touxiang.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{chuzhenyishengList[6].yishengxingming}}</div>
							<div class="name">挂号费:{{chuzhenyishengList[6].guahaofei}}</div>
							<div class="name">出诊日期:{{chuzhenyishengList[6].chuzhenriqi}}</div>
							<div class="time_item">
								<span class="icon iconfont "></span>
								<span class="label">发布时间：</span>
								<span class="text">{{chuzhenyishengList[6].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
					<div v-if="chuzhenyishengList.length>7" class="list-item8" @click="toDetail('chuzhenyishengDetail', chuzhenyishengList[7])">
						<div class="img">
							<img v-if="preHttp(chuzhenyishengList[7].touxiang)" :src="chuzhenyishengList[7].touxiang.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (chuzhenyishengList[7].touxiang?chuzhenyishengList[7].touxiang.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{chuzhenyishengList[7].yishengxingming}}</div>
							<div class="name">挂号费:{{chuzhenyishengList[7].guahaofei}}</div>
							<div class="name">出诊日期:{{chuzhenyishengList[7].chuzhenriqi}}</div>
							<div class="time_item">
								<span class="icon iconfont "></span>
								<span class="label">发布时间：</span>
								<span class="text">{{chuzhenyishengList[7].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('chuzhenyisheng')">
				<span class="text">查看更多</span>
				<i class="icon iconfont "></i>
			</div>
	

		</div>
		<!-- 特价商品 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				newsList: [],
				jiankangshipinRecommend: [],

				chuzhenyishengList: [],


				recommendIndex12jiankangshipin: 0,
				recommendList12jiankangshipin: [],
				recommendColumn12jiankangshipin: '',


			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getList();
			this.jiankangshipinRecommendCate()
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},
			jiankangshipinRecommendCate(){
				this.$http.get('shipinleixing/list',{
					params: {
						limit: Number(6)
					}
				}).then(res => {
					if (res.data.code == 0) {
						this.recommendList12jiankangshipin = res.data.data.list
					}
				});
				this.recommendColumn12jiankangshipin = 'shipinleixing'
			},
			recommendIndexClick12(index, name) {
				this['recommendIndex12' + name] = index
				this.getList()
				
				document.querySelectorAll('.recommend .list12' + name + ' .list .item').forEach(el => {
					el.classList.remove("active")
				})
				setTimeout(() => {
					document.querySelectorAll('.recommend .list12' + name + ' .list .item').forEach(el => {
						el.classList.add("active")
					})
				}, 1);
			},


			handleScroll() {
				let arr = [
					{id:'about',css:'animate__bounce'},
					{id:'system',css:'animate__bounce'},
					{id:'animate_listchuzhenyisheng',css:'animate__bounce'},
					{id:'animate_recommendjiankangshipin',css:'animate__bounce'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "jiankangshipin/autoSort";
				if(localStorage.getItem('frontToken')) {
					autoSortUrl = "jiankangshipin/autoSort2";
				}
				data = {
					page: 1,
					limit: 5,
				}
				if(this.recommendIndex12jiankangshipin != 0){
					data.shipinleixing = this.recommendList12jiankangshipin[this.recommendIndex12jiankangshipin - 1].shipinleixing
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.jiankangshipinRecommend = res.data.data.list;
					}
				});
			
				data = {
					page: 1,
					limit: 8,
				}

				this.$http.get('chuzhenyisheng/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.chuzhenyishengList = res.data.data.list;
					}
				});
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0;
		flex-direction: column;
		background: #FFF;
		display: flex;
		width: 100%;
		.recommend {
			margin: 0;
			background: #fff;
			position: relative;
			order: 1;
			.recommend_title_box {
				margin: 0;
				background: url(http://codegen.caihongy.cn/20241120/db3281a5ee5942b0a240b02cb82baf02.webp) no-repeat left;
				width: 100%;
				height: 220px;
				.recommend_title {
					padding: 0 0 0 425px;
					margin: 20px 0 0;
					color: #896785;
					font-weight: 600;
					display: inline-block;
					font-size: 36px;
				}
				.recommend_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 1.5;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1.2) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list12 {
				padding: 40px 0 0 0;
				flex-direction: column;
				background: url(http://codegen.caihongy.cn/20241120/4688a445041f4e79912a6367713301d9.webp);
				display: flex;
				width: 100%;
				justify-content: flex-start;
				align-items: center;
				height: 620px;
				.tab_view {
					padding: 40px 0 10px 0;
					margin: 0 auto;
					background: #FFFFFF;
					display: flex;
					gap: 20px;
					width: 1270px;
					justify-content: center;
					height: auto;
					.tab {
						cursor: pointer;
						border-radius: 10px;
						padding: 10px 20px;
						box-shadow: 0px 4px 5px 0px rgba(0,0,0,0.3), inset 0px 4px 10px 0px rgba(231,231,231,0.3);
						margin: 0;
						color: #9E9E9E;
						background: #FFFFFF;
						display: flex;
						align-items: center;
						min-width: auot;
						height: 70px;
						img {
							border-radius: 5px;
							margin: 0 15px 0 0;
							object-fit: cover;
							display: block;
							width: 40px;
							height: 40px;
						}
						.text {
							color: inherit;
							font-size: 16px;
						}
					}
					.tab:hover {
						color: #896785;
					}
					.tab.active {
						color: #896785;
						border-color: #999;
						border-width: 0 0 1px 0;
						border-style: solid;
					}
					.more_btn {
						cursor: pointer;
						padding: 5px 10px;
						margin: 0 10px;
						color: #666;
						background: #fff;
						display: flex;
						line-height: 44px;
						align-items: center;
						.text {
							color: inherit;
							font-size: 14px;
						}
						.icon {
							margin: 0 0 0 2px;
							color: inherit;
							font-size: 14px;
						}
					}
					.more_btn:hover {
						color: #896785;
					}
					.tab.active {
						animation-name: mymove;
					
						&:nth-of-type(1) {
							animation-duration: 1s;
						}
						&:nth-of-type(2) {
							animation-duration: 1.2s;
						}
						&:nth-of-type(3) {
							animation-duration: 1.4s;
						}
						&:nth-of-type(4) {
							animation-duration: 1.6s;
						}
						&:nth-of-type(5) {
							animation-duration: 1.8s;
						}
						&:nth-of-type(6) {
							animation-duration: 2s;
						}
					}
					
					@keyframes mymove {
						from {top: 320px;}
						to {top: 0;}
					}
				}
				.list-body {
					padding: 40px 60px 40px ;
					background: #fff;
					display: flex;
					width: 1270px;
					justify-content: space-between;
					height: auto;
					.list-item {
						border-radius: 10px;
						box-shadow: 0px 4px 5px 0px rgba(0,0,0,0.3), inset 0px 4px 10px 0px rgba(231,231,231,0.3);
						overflow: hidden;
						background: #FFF;
						width: 16%;
						position: relative;
						height: auto;
						img {
							object-fit: cover;
							display: block;
							width: 100%;
							height: 160px;
						}
						.name {
							padding: 0 10px;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-size: 18px;
							line-height: 32px;
							text-overflow: ellipsis;
							text-align: center;
						}
						.price {
							padding: 10px;
							color: #fff;
							background: #896785;
							font-size: 13px;
							line-height: 1.5;
							text-align: center;
						}
					}
					.list-item.active {
						animation-name: mymove;
					
						&:nth-of-type(1) {
							animation-duration: 1s;
						}
						&:nth-of-type(2) {
							animation-duration: 1.2s;
						}
						&:nth-of-type(3) {
							animation-duration: 1.4s;
						}
						&:nth-of-type(4) {
							animation-duration: 1.6s;
						}
						&:nth-of-type(5) {
							animation-duration: 1.8s;
						}
						&:nth-of-type(6) {
							animation-duration: 2s;
						}
					}
					
					@keyframes mymove {
						from {top: 320px;}
						to {top: 0;}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 0;
				top: 85px;
				background: url(http://codegen.caihongy.cn/20241122/6413041513c84d3ca9148687c9fed9f7.webp);
				display: block;
				width: 173px;
				line-height: 50px;
				position: absolute;
				right: calc(50% - 635px);
				text-align: center;
				height: 50px;
				.text {
					color: #000000;
					font-size: 18px;
				}
				.icon {
					color: #f5f5f5;
					display: none;
					font-size: 12px;
				}
			}
		}
		.lists {
			padding: 25px 0 55px 0;
			margin: 0 auto;
			background: #FFFFFF;
			width: 1270px;
			position: relative;
			order: 4;
			.list_title_box {
				padding: 14px 0 0 0;
				margin: 0 0 40px 0;
				background: url(http://codegen.caihongy.cn/20241122/cda88df66d42496fa403c0ed98bac06b.webp);
				width: 100%;
				text-align: center;
				height: 120px;
				.list_title {
					color: #896785;
					font-weight: 700;
					font-size: 36px;
				}
				.list_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 1.5;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list20 {
				margin: 0px auto;
				overflow: hidden;
				background: none;
				width: 100%;
				clear: both;
				.list-body {
					margin: 0px auto 30px;
					display: flex;
					width: 100%;
					justify-content: space-between;
					position: relative;
					flex-wrap: wrap;
					.list-item1 {
						border: 0px solid #fff;
						margin: 0 0 40px;
						z-index: 99;
						overflow: hidden;
						width: calc(25% - 10px);
						position: relative;
						height: 360px;
						.img {
							border: 0px solid #fff;
							width: 100%;
							height: 100%;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0px;
							bottom: -100%;
							display: flex;
							transition: all 0.5s;
							flex-wrap: wrap;
							flex-direction: row;
							align-content: center;
							left: 0px;
							background: rgba(255, 255, 255, .8);
							width: 100%;
							justify-content: center;
							align-items: center;
							position: absolute;
							text-align: center;
							.name {
								padding: 5px 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								display: block;
								width: 100%;
								font-size: 16px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 5px 10px;
								color: #f00;
								width: 100%;
								font-size: 16px;
							}
							.time_item {
								padding: 5px 0;
								width: 100%;
								order: 11;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item1:hover {
						border: 0px solid #339933;
						.img {
							border: 0px solid #68bf68;
							img {
								transform: scale(1);
								transition: all 0.5s ease-out;
							}
						}
						.infoBox {
							cursor: pointer;
							bottom: 0px;
							background: rgba(137,103,133,.7);
							height: 100%;
						}
					}
					.list-item2 {
						border: 0px solid #fff;
						padding: 20px;
						margin: 0 0 15px;
						z-index: 99;
						overflow: hidden;
						width: calc(25% - 10px);
						position: relative;
						height: 360px;
						.img {
							border: 0px solid #fff;
							width: 100%;
							height: 100%;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0px;
							bottom: -100%;
							display: flex;
							transition: all 0.5s;
							flex-wrap: wrap;
							flex-direction: row;
							align-content: center;
							left: 0px;
							background: rgba(255, 255, 255, .8);
							width: 100%;
							justify-content: center;
							align-items: center;
							position: absolute;
							text-align: center;
							.name {
								padding: 5px 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								display: block;
								width: 100%;
								font-size: 16px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 5px 10px;
								color: #f00;
								width: 100%;
								font-size: 16px;
							}
							.time_item {
								padding: 5px 0;
								width: 100%;
								order: 11;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2:hover {
						border: 0px solid #339933;
						.img {
							border: 0px solid #68bf68;
							img {
								transform: scale(1);
								transition: all 0.5s ease-out;
							}
						}
						.infoBox {
							cursor: pointer;
							bottom: 0px;
							background: rgba(137,103,133,.7);
							height: 100%;
						}
					}
					.list-item3 {
						border: 0px solid #fff;
						padding: 20px;
						margin: 0 0 15px;
						z-index: 99;
						overflow: hidden;
						width: calc(25% - 10px);
						position: relative;
						height: 360px;
						.img {
							border: 0px solid #fff;
							width: 100%;
							height: 100%;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0px;
							bottom: -100%;
							display: flex;
							transition: all 0.5s;
							flex-wrap: wrap;
							flex-direction: row;
							align-content: center;
							left: 0px;
							background: rgba(255, 255, 255, .8);
							width: 100%;
							justify-content: center;
							align-items: center;
							position: absolute;
							text-align: center;
							.name {
								padding: 5px 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								display: block;
								width: 100%;
								font-size: 16px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 5px 10px;
								color: #f00;
								width: 100%;
								font-size: 16px;
							}
							.time_item {
								padding: 5px 0;
								width: 100%;
								order: 11;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item3:hover {
						border: 0px solid #339933;
						.img {
							border: 0px solid #68bf68;
							img {
								transform: scale(1);
								transition: all 0.5s ease-out;
							}
						}
						.infoBox {
							cursor: pointer;
							bottom: 0px;
							background: rgba(137,103,133,.7);
							height: 100%;
						}
					}
					.list-item4 {
						border: 0px solid #fff;
						margin: 0 0 40px;
						z-index: 99;
						overflow: hidden;
						width: calc(25% - 10px);
						position: relative;
						height: 360px;
						.img {
							border: 0px solid #fff;
							width: 100%;
							height: 100%;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0px;
							bottom: -100%;
							display: flex;
							transition: all 0.5s;
							flex-wrap: wrap;
							flex-direction: row;
							align-content: center;
							left: 0px;
							background: rgba(255, 255, 255, .8);
							width: 100%;
							justify-content: center;
							align-items: center;
							position: absolute;
							text-align: center;
							.name {
								padding: 5px 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								display: block;
								width: 100%;
								font-size: 16px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 5px 10px;
								color: #f00;
								width: 100%;
								font-size: 16px;
							}
							.time_item {
								padding: 5px 0;
								width: 100%;
								order: 11;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item4:hover {
						border: 0px solid #339933;
						.img {
							border: 0px solid #68bf68;
							img {
								transform: scale(1);
								transition: all 0.5s ease-out;
							}
						}
						.infoBox {
							cursor: pointer;
							bottom: 0px;
							background: rgba(137,103,133,.7);
							height: 100%;
						}
					}
					.list-item5 {
						border: 0px solid #fff;
						margin: 0 0 15px;
						z-index: 99;
						overflow: hidden;
						width: calc(25% - 10px);
						position: relative;
						height: 360px;
						.img {
							border: 0px solid #fff;
							width: 100%;
							height: 100%;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0px;
							bottom: -100%;
							display: flex;
							transition: all 0.5s;
							flex-wrap: wrap;
							flex-direction: row;
							align-content: center;
							left: 0px;
							background: rgba(255, 255, 255, .8);
							width: 100%;
							justify-content: center;
							align-items: center;
							position: absolute;
							text-align: center;
							.name {
								padding: 5px 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								display: block;
								width: 100%;
								font-size: 16px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 5px 10px;
								color: #f00;
								width: 100%;
								font-size: 16px;
							}
							.time_item {
								padding: 5px 0;
								width: 100%;
								order: 11;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item5:hover {
						border: 0px solid #339933;
						.img {
							border: 0px solid #68bf68;
							img {
								transform: scale(1);
								transition: all 0.5s ease-out;
							}
						}
						.infoBox {
							cursor: pointer;
							bottom: 0px;
							background: rgba(137,103,133,.7);
							height: 100%;
						}
					}
					.list-item6 {
						border: 0px solid #fff;
						padding: 20px;
						margin: 0 0 15px;
						z-index: 99;
						overflow: hidden;
						width: calc(25% - 10px);
						position: relative;
						height: 360px;
						.img {
							border: 0px solid #fff;
							width: 100%;
							height: 100%;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0px;
							bottom: -100%;
							display: flex;
							transition: all 0.5s;
							flex-wrap: wrap;
							flex-direction: row;
							align-content: center;
							left: 0px;
							background: rgba(255, 255, 255, .8);
							width: 100%;
							justify-content: center;
							align-items: center;
							position: absolute;
							text-align: center;
							.name {
								padding: 5px 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								display: block;
								width: 100%;
								font-size: 16px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 5px 10px;
								color: #f00;
								width: 100%;
								font-size: 16px;
							}
							.time_item {
								padding: 5px 0;
								width: 100%;
								order: 11;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item6:hover {
						border: 0px solid #339933;
						.img {
							border: 0px solid #68bf68;
							img {
								transform: scale(1);
								transition: all 0.5s ease-out;
							}
						}
						.infoBox {
							cursor: pointer;
							bottom: 0px;
							background: rgba(137,103,133,.7);
							height: 100%;
						}
					}
					.list-item7 {
						border: 0px solid #fff;
						padding: 20px;
						margin: 0 0 15px;
						z-index: 99;
						overflow: hidden;
						width: calc(25% - 10px);
						position: relative;
						height: 360px;
						.img {
							border: 0px solid #fff;
							width: 100%;
							height: 100%;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0px;
							bottom: -100%;
							display: flex;
							transition: all 0.5s;
							flex-wrap: wrap;
							flex-direction: row;
							align-content: center;
							left: 0px;
							background: rgba(255, 255, 255, .8);
							width: 100%;
							justify-content: center;
							align-items: center;
							position: absolute;
							text-align: center;
							.name {
								padding: 5px 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								display: block;
								width: 100%;
								font-size: 16px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 5px 10px;
								color: #f00;
								width: 100%;
								font-size: 16px;
							}
							.time_item {
								padding: 5px 0;
								width: 100%;
								order: 11;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item7:hover {
						border: 0px solid #339933;
						.img {
							border: 0px solid #68bf68;
							img {
								transform: scale(1);
								transition: all 0.5s ease-out;
							}
						}
						.infoBox {
							cursor: pointer;
							bottom: 0px;
							background: rgba(137,103,133,.7);
							height: 100%;
						}
					}
					.list-item8 {
						border: 0px solid #fff;
						margin: 0 0 15px;
						z-index: 99;
						overflow: hidden;
						width: calc(25% - 10px);
						position: relative;
						height: 360px;
						.img {
							border: 0px solid #fff;
							width: 100%;
							height: 100%;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0px;
							bottom: -100%;
							display: flex;
							transition: all 0.5s;
							flex-wrap: wrap;
							flex-direction: row;
							align-content: center;
							left: 0px;
							background: rgba(255, 255, 255, .8);
							width: 100%;
							justify-content: center;
							align-items: center;
							position: absolute;
							text-align: center;
							.name {
								padding: 5px 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								display: block;
								width: 100%;
								font-size: 16px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 5px 10px;
								color: #f00;
								width: 100%;
								font-size: 18px;
							}
							.time_item {
								padding: 5px 0;
								width: 100%;
								order: 11;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								margin: 0 20px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item8:hover {
						border: 0px solid #339933;
						.img {
							border: 0px solid #68bf68;
							img {
								transform: scale(1);
								transition: all 0.5s ease-out;
							}
						}
						.infoBox {
							cursor: pointer;
							bottom: 0px;
							background: rgba(137,103,133,.7);
							height: 100%;
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 0;
				top: 40px;
				background: url(http://codegen.caihongy.cn/20241122/6413041513c84d3ca9148687c9fed9f7.webp);
				display: block;
				width: 173px;
				line-height: 50px;
				position: absolute;
				right: 0;
				text-align: center;
				height: 50px;
				.text {
					color: #000000;
					font-size: 18px;
				}
				.icon {
					color: #f5f5f5;
					font-size: 12px;
				}
			}
		}
	}
</style>
