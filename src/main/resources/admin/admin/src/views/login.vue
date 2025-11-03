<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于智能推荐的卫生健康系统的设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
				<div class="idea-box1"></div>
				<div class="idea-box2">还没有账号？选择角色注册</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$nextTick(()=>{
							this.$http({
								url: this.tableName + '/session',
								method: "get"
							}).then(({
								data
							}) => {
								if (data && data.code === 0) {
									if(this.tableName == 'yonghu') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'yisheng') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'users') {
										this.$storage.set('headportrait',data.data.image)
									}
									this.$storage.set('userForm',JSON.stringify(data.data))
									this.$storage.set('userid',data.data.id);
								} else {
									let message = this.$message
									message.error(data.msg);
								}
								this.$router.replace({ path: "/" });
							});
						})
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20250218/8fea326389e447598e13635887b43691.jpg);
	background-repeat: no-repeat;
	background-size: cover !important;
	background: url(http://codegen.caihongy.cn/20250218/8fea326389e447598e13635887b43691.jpg);
	display: block;
	width: 100%;
	min-height: 100vh;
	justify-content: flex-start;
	align-items: center;
	background-position: center center;
	position: relative;

	.login_form {
		padding: 0;
		margin: 0 auto;
		z-index: 999;
		display: flex;
		min-height: 100vh;
		flex-wrap: wrap;
		border-radius: 0;
		box-shadow: inset 0px 0px 0px 0px #000;
		flex-direction: column;
		background: none;
		width: calc(100% - 200px);
		align-items: flex-start;
		position: relative;
		height: auto;
		.login_form2 {
			padding: 0 85px;
			margin: auto 0 auto 40%;
			z-index: 2;
			flex-direction: column;
			background: #fff;
			display: flex;
			width: 837px;
		}
		.title-container {
			padding: 50px  85px 20px ;
			margin: 0 0 0px 0;
			color: #000;
			top: 60px;
			left: 0;
			background: #fff;
			font-weight: 600;
			width: 100%;
			font-size: 28px;
			line-height: 40px;
			text-align: left;
		}
		.list-item {
			padding: 0;
			margin: 10px 0 10px 10px;
			display: flex;
			width: calc(100% - 0px);
			position: relative;
			align-items: center;
			.lable {
				color: #000;
				letter-spacing: 1px;
				width: auto;
				font-size: 16px;
				border-color: #000000;
				border-width: 0 0 2px 0;
				line-height: 40px;
				border-style: solid;
				text-align: left;
				min-width: 60px;
				height: 40px;
			}
			input {
				padding: 0 10px;
				outline: none;
				color: #666;
				flex: 1;
				background: none;
				font-size: 16px;
				border-color: #000000;
				border-width: 0 0 2px 0;
				height: 40px;
			}
			input:focus {
				padding: 0 10px;
				outline: none;
				color: #666;
				flex: 1;
				background: none;
				font-size: 16px;
				border-color: #000000;
				border-width: 0 0 2px 0;
				height: 40px;
			}
			.password-box {
				flex: 1;
				display: flex;
				position: relative;
				align-items: center;
				input {
					padding: 0 10px;
					color: #666;
					flex: 1;
					background: none;
					font-size: 16px;
					border-color: #000000;
					border-width: 0 0 2px 0;
					height: 40px;
				}
				input:focus {
					padding: 0 10px;
					color: #666;
					flex: 1;
					background: none;
					font-size: 16px;
					border-color: #000000;
					border-width: 0 0 2px 0;
					height: 40px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
		}
		.list-type {
			padding: 0;
			margin: 0;
			background: none;
			width: calc(100% - 0px);
			border-width: 0 0 2px 0;
			line-height: 40px;
			border-style: solid;
			height: 40px;
			/deep/ .el-radio__input .el-radio__inner {
				background: rgba(53, 53, 53, 0);
				border-color: #666;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				background: #0799D5;
				border-color: #0799D5;
			}
			/deep/ .el-radio__label {
				color: #666;
				font-size: 16px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				color: #0799D5;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 50px 0 0 10px;
			display: flex;
			width: 100%;
			justify-content: space-between;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 174px;
				height: 69px;
				order: 2;
			}
			.login-btn2 {
				margin: 20px 0  60px 0 ;
				background: none;
				display: flex;
				width: 100%;
				align-items: center;
				flex-wrap: wrap;
				order: 3;
			}
			.login-btn3 {
				width: auto;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 0;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff;
				background: #0799D5;
				font-weight: 700;
				width: 100%;
				font-size: 30px;
				min-width: 68px;
				height: 100%;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 2px solid #B8B8B8;
				cursor: pointer;
				border-radius: 10px;
				padding: 0 10px;
				margin: 0 20px 0 0 ;
				color: #666;
				background: #fff;
				width: auto;
				font-size: 16px;
				height: 40px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0;
				color: #000000;
				background: none;
				font-weight: 400;
				width: 100%;
				font-size: 15px;
				text-align: right;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
	.idea-box1 {
		top: 35%;
		background: #3A3A3A;
		font-weight: 600;
		width: 100%;
		font-size: 26px;
		position: absolute;
		height: 350px;
		order: -2;
	}
	.idea-box2 {
		margin: 5px 0 40px;
		color: #fff;
		top: 50%;
		left: 82px;
		font-weight: 400;
		width: 100%;
		font-size: 26px;
		position: absolute;
		height: 30px;
		order: -1;
	}
}

</style>
