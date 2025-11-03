<template>
	<div>

		<div class="container">
			<el-form class='rgs-form animate__animated animate__bounce' v-if="pageFlag=='register'" ref="registerForm" :model="registerForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于智能推荐的卫生健康系统的设计与实现注册</p></div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuzhanghao">
						<div class="label" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuxingming">
						<div class="label" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="nianling">
						<div class="label" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="shoujihaoma">
						<div class="label" :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
						<el-input v-model="registerForm.shoujihaoma"  placeholder="请输入手机号码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="yishengzhanghao">
						<div class="label" :class="changeRules('yishengzhanghao')?'required':''">医生账号：</div>
						<el-input v-model="registerForm.yishengzhanghao"  placeholder="请输入医生账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="yishengtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="yishengxingming">
						<div class="label" :class="changeRules('yishengxingming')?'required':''">医生姓名：</div>
						<el-input v-model="registerForm.yishengxingming"  placeholder="请输入医生姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yishengxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="shoujihaoma">
						<div class="label" :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
						<el-input v-model="registerForm.shoujihaoma"  placeholder="请输入手机号码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="zhicheng">
						<div class="label" :class="changeRules('zhicheng')?'required':''">职称：</div>
						<el-input v-model="registerForm.zhicheng" readonly placeholder="请输入职称" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yisheng'" prop="keshi">
						<div class="label" :class="changeRules('keshi')?'required':''">科室：</div>
						<el-select v-model="registerForm.keshi" placeholder="请选择科室" disabled>
							<el-option
								v-for="(item,index) in yishengkeshiOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<el-button class="register_btn" type="primary" @click="submitForm('registerForm')">注册</el-button>
						</div>
						<div class="register-btn2">
							<router-link class="has_btn" to="/login">已有账号，直接登录</router-link>
						</div>
					</div>
				</div>
				<div class="idea1"></div>
				<div class="idea2"></div>
			</el-form>
		</div>
	</div>
</div>
</template>

<script>
	import 'animate.css';

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            yishengxingbieOptions: [],
            yishengkeshiOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuzhanghao: '',
					mima: '',
					mima2: '',
					yonghuxingming: '',
					touxiang: '',
					xingbie: '',
					nianling: '',
					shoujihaoma: '',
				}
			}
			if(this.tableName=='yisheng'){
				this.registerForm = {
					yishengzhanghao: '',
					mima: '',
					mima2: '',
					touxiang: '',
					yishengxingming: '',
					xingbie: '',
					shoujihaoma: '',
					zhicheng: '',
					keshi: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }];
				this.requiredRules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }];
				this.requiredRules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',');
			if ('yonghu' == this.tableName) {
				this.rules.shoujihaoma = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('yisheng' == this.tableName) {
				this.rules.yishengzhanghao = [{ required: true, message: '请输入医生账号', trigger: 'blur' }];
				this.requiredRules.yishengzhanghao = [{ required: true, message: '请输入医生账号', trigger: 'blur' }]
			}
			if ('yisheng' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yisheng' == this.tableName) {
				this.rules.yishengxingming = [{ required: true, message: '请输入医生姓名', trigger: 'blur' }];
				this.requiredRules.yishengxingming = [{ required: true, message: '请输入医生姓名', trigger: 'blur' }]
			}
			this.yishengxingbieOptions = "男,女".split(',');
			if ('yisheng' == this.tableName) {
				this.rules.shoujihaoma = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			this.$http({
				url: `option/keshi/keshi`,
				method: "get",
				params: {}
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.yishengkeshiOptions = data.data;
				}
			});
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
        // 下二随
		yonghutouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		yishengtouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},

		// 多级联动参数


		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					var url=this.tableName+"/register";
					if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(`yisheng` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					this.$http.post(url, this.registerForm).then(res => {
						if (res.data.code === 0) {
							this.$message({
								message: '注册成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.$router.push('/login');
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		background: url(http://codegen.caihongy.cn/20241119/d29fe23c4aa1479b93d17a78d1488b7f.jpg) no-repeat center / cover;
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: center;
		align-items: center;
		position: relative;
		background: url(http://codegen.caihongy.cn/20241119/d29fe23c4aa1479b93d17a78d1488b7f.jpg) no-repeat center / cover;
		.rgs-form {
			border-radius: 30px;
			padding: 4px;
			box-shadow: none;
			backdrop-filter: blur(5px);
			margin: 20px 0;
			z-index: 1;
			background: url(http://codegen.caihongy.cn/20241118/8f7a9988fb5e4c368c2f4469a80f6f99.webp) no-repeat center / 100% 100%;
			width: 710px;
			height: auto;
			.rgs-form2 {
				width: 100%;
				.title {
					border-radius: 30px 30px 0 0;
					margin: 0 0 40px 0;
					text-shadow: none;
					color: #FFF;
					background: #896785;
					font-weight: 700;
					width: 100%;
					font-size: 20px;
					line-height: 100px;
					text-align: center;
				}
				.subtitle {
					margin: 0 0 10px 0;
					text-shadow: 4px 4px 2px rgba(64, 158, 255, .5);
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.list-item {
					border-radius: 30px;
					padding: 0 0px;
					box-shadow: 0px 4px 5px 0px rgba(0,0,0,0.3);
					margin: 0 auto 30px auto;
					background: #FFFFFF;
					display: flex;
					width: 520px;
					/deep/.el-form-item__content {
						padding: 0 0 0 120px;
						display: block;
						width: calc(100% - 0px);
						.label {
							padding: 0 5px 0 0;
							z-index: 9;
							color: #333;
							left: 0;
							width: 120px;
							font-size: 16px;
							line-height: 60px;
							position: absolute !important;
							text-align: right;
						}
						
						.required {
							position: relative;
						}
						.required::after{
							margin: 0 10px 0 0;
							color: red;
							left: 110px;
							position: inherit;
							content: "*";
						}
						.el-input {
							flex: 1 1 auto;
							width: 100%;
						}
						.el-input .el-input__inner {
							border: none;
							border-radius: 30px;
							padding: 0 10px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.el-input .el-input__inner:focus {
							border: none;
							border-radius: 30px;
							padding: 0 10px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.el-input-number {
							flex: 1 1 auto;
							width: 100%;
						}
						.el-input-number .el-input__inner {
							text-align: left;
							border: none;
							border-radius: 30px;
							padding: 0 10px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.el-input-number .el-input-number__decrease {
							display: none;
						}
						.el-input-number .el-input-number__increase {
							display: none;
						}
						.el-select {
							width: 100%;
						}
						.el-select .el-input__inner {
							border: none;
							border-radius: 30px;
							padding: 0 10px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.el-select .el-input__inner:focus {
							border: none;
							border-radius: 30px;
							padding: 0 10px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.el-date-editor {
							width: 100%;
						}
						.el-date-editor .el-input__inner {
							border: none;
							border-radius: 30px;
							padding: 0 40px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.el-date-editor .el-input__inner:focus {
							border: none;
							border-radius: 30px;
							padding: 0 40px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.el-upload--picture-card {
							background: transparent;
							border: 0;
							border-radius: 0;
							width: auto;
							height: auto;
							line-height: initial;
							vertical-align: middle;
						}
						.upload .upload-img {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 8px;
							margin: 10px 0 0;
							color: #999;
							width: 80px;
							font-size: 26px;
							line-height: 60px;
							text-align: center;
							height: 60px;
						}
						.el-upload-list .el-upload-list__item {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 8px;
							margin: 10px 0 0;
							color: #999;
							width: 80px;
							font-size: 26px;
							line-height: 60px;
							text-align: center;
							height: 60px;
							font-size: 14px;
							line-height: 1.8;
						}
						.el-upload .el-icon-plus {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 8px;
							margin: 10px 0 0;
							color: #999;
							width: 80px;
							font-size: 26px;
							line-height: 60px;
							text-align: center;
							height: 60px;
						}
						.el-upload__tip {
							margin: 0;
							color: #838fa1;
							font-size: 14px;
						}
						.emailInput {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.emailInput:focus {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							width: 100%;
							font-size: 14px;
							height: 60px;
						}
						.el-btn {
							border: 0;
							cursor: pointer;
							padding: 0;
							margin: 0;
							color: #fff;
							font-size: 14px;
							float: right;
							border-radius: 30px;
							box-shadow: none;
							outline: none;
							background: #896785;
							width: 140px;
							position: relative;
							height: 60px;
						}
						.el-btn:hover {
							opacity: 0.8;
						}
						
						.el-input__inner::placeholder {
							color: #9E9E9E;
							font-size: 14px;
						}
						input::placeholder {
							color: #9E9E9E;
							font-size: 14px;
						}
						.editor {
							padding: 15px;
							width: 100%;
							height: auto;
						}
					}
				}
				.register-btn {
					padding:  0 0 20px 0;
					margin: 0 auto;
					flex-direction: column;
					display: flex;
					width: 520px;
				}
				.register-btn1 {
					width: 100%;
				}
				.register-btn2 {
					margin: 0 0 20px 0;
					width: 100%;
					text-align: center;
					order: -1;
				}
				.register_btn {
					border: 0;
					cursor: pointer;
					border-radius: 30px;
					padding: 0 24px;
					margin: 0 5px;
					outline: none;
					color: #fff;
					background: #896785;
					font-weight: 700;
					width: 100%;
					font-size: 24px;
					height: 60px;
				}
				.register_btn:hover {
					opacity: 0.8;
				}
				.has_btn {
					cursor: pointer;
					padding: 0 20px;
					color: #000000;
					display: inline-block;
					text-decoration: none;
					font-size: 14px;
					line-height: 1;
				}
				.has_btn:hover {
					opacity: 0.5;
				}
			}
			.idea1 {
				background: red;
				display: none;
				width: 100%;
				height: 40px;
			}
			.idea2 {
				background: blue;
				display: none;
				width: 100%;
				height: 40px;
			}
		}
	}
	
	::-webkit-scrollbar {
		display: none;
	}
</style>
