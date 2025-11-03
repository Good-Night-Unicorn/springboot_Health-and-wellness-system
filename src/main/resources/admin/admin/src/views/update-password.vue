<template>
	<div :style='{"padding":"60px","margin":"60px 20px 0 60px","borderRadius":"30px","background":"#fff"}'>
		<el-form
			:style='{"border":"0px solid #BFBFBF","padding":"0","margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex"}'
			class="add-update-preview"
			ref="ruleForm"
			:rules="rules"
			:model="ruleForm"
			label-width="180px"
		>
			<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' label="原密码" prop="password">
				<el-input type="password" v-model="ruleForm.password" ></el-input>
			</el-form-item>
			<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' label="新密码" prop="newpassword">
				<el-input type="password" v-model="ruleForm.newpassword" ></el-input>
			</el-form-item>
			<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' label="确认密码" prop="repassword">
				<el-input type="password" v-model="ruleForm.repassword" ></el-input>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"20px 0 0 0","display":"flex"}'>
				<el-button class="btn3" :style='{"border":"2px solid #0799D5","cursor":"pointer","padding":"0 10px","margin":"0 10px 0 0","color":"#0799D5","borderRadius":"4px","background":"none","width":"auto","fontSize":"16px","minWidth":"110px","height":"40px"}' type="primary" @click="onUpdateHandler">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","display":"none","height":"40px"}'></span>
					提交
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script>
export default {
	data() {
		return {
			dialogVisible: false,
			ruleForm: {},
			user: {},
			rules: {
				password: [
					{
						required: true,
						message: "密码不能为空",
						trigger: "blur"
					}
				],
				newpassword: [
					{
						required: true,
						message: "新密码不能为空",
						trigger: "blur"
					}
				],
				repassword: [
					{
						required: true,
						message: "确认密码不能为空",
						trigger: "blur"
					}
				]
			}
		};
	},
	mounted() {
		this.$http({
			url: `${this.$storage.get("sessionTable")}/session`,
			method: "get"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.user = data.data;
			} else {
				this.$message.error(data.msg);
			}
		});
	},
	methods: {
		onLogout() {
			this.$storage.remove("Token");
			this.$router.replace({ name: "login" });
		},
		// 修改密码
		async onUpdateHandler() {
			this.$refs["ruleForm"].validate(async valid => {
				if (valid) {
					var password = "";
					if (this.user.mima) {
						password = this.user.mima;
					} else if (this.user.password) {
						password = this.user.password;
					}
					if(this.$storage.get("sessionTable")=='users'){
						if (this.ruleForm.password != password) {
							this.$message.error("原密码错误");
							return;
						}
						if (this.ruleForm.newpassword != this.ruleForm.repassword) {
							this.$message.error("两次密码输入不一致");
							return;
						}
						this.user.password = this.ruleForm.newpassword;
						this.user.mima = this.ruleForm.newpassword;
						this.$http({
							url: `${this.$storage.get("sessionTable")}/update`,
							method: "post",
							data: this.user
						}).then(({ data }) => {
							if (data && data.code === 0) {
								this.$message({
									message: "修改密码成功,下次登录系统生效",
									type: "success",
									duration: 1500,
									onClose: () => {
									}
								});
							} else {
								this.$message.error(data.msg);
							}
						});
						return false
					}
					if (this.$storage.get("sessionTable") == 'yisheng') {
					}
					if (this.ruleForm.password != password) {
						this.$message.error("原密码错误");
						return;
					}
					if (this.ruleForm.newpassword != this.ruleForm.repassword) {
						this.$message.error("两次密码输入不一致");
						return;
					}
					if (this.ruleForm.newpassword == this.ruleForm.password) {
						this.$message.error("新密码与原密码相同");
						return;
					}
					this.user.password = this.ruleForm.newpassword;
					this.user.mima = this.ruleForm.newpassword;
					this.$http({
						url: `${this.$storage.get("sessionTable")}/update`,
						method: "post",
						data: this.user
					}).then(({ data }) => {
						if (data && data.code === 0) {
							this.$message({
								message: "修改密码成功,下次登录系统生效",
								type: "success",
								duration: 1500,
								onClose: () => {
								}
							});
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			});
		}
	}
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  border: 1px solid #C4C4C4;
	  	  padding: 0 10px 0 0;
	  	  margin: 0;
	  	  color: #333;
	  	  background: #F3F4F3;
	  	  font-weight: 600;
	  	  width: 180px;
	  	  font-size: 16px;
	  	  line-height: 70px;
	  	  text-align: center;
	  	  height: 70px;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  margin: 0;
	  	  color: #333;
	  	  width: auto;
	  	  font-size: 15px;
	  	  border-color: #C4C4C4;
	  	  border-width: 1px;
	  	  border-style: solid ;
	  	  min-width: 100%;
	  	  height: 70px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  margin: 0;
	  	  color: #333;
	  	  width: auto;
	  	  font-size: 15px;
	  	  border-color: #C4C4C4;
	  	  border-width: 1px;
	  	  border-style: solid ;
	  	  min-width: 100%;
	  	  height: 70px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 30px;
	  	  color: #333;
	  	  width: auto;
	  	  font-size: 15px;
	  	  border-color: #C4C4C4;
	  	  border-width: 1px;
	  	  border-style: solid ;
	  	  min-width: 100%;
	  	  height: 70px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  padding: 0 12px;
	  	  color: #C4C4C4;
	  	  font-weight: 500;
	  	  object-fit: cover;
	  	  font-size: 32px;
	  	  border-color: #C4C4C4;
	  	  line-height: 70px;
	  	  border-radius: 0px;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid ;
	  	  min-width: 100%;
	  	  height: 70px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  padding: 0 12px;
	  	  color: #C4C4C4;
	  	  font-weight: 500;
	  	  object-fit: cover;
	  	  font-size: 32px;
	  	  border-color: #C4C4C4;
	  	  line-height: 70px;
	  	  border-radius: 0px;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid ;
	  	  min-width: 100%;
	  	  height: 70px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #C4C4C4;
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  color: #333;
	  	  background: #fff;
	  	  width: 100%;
	  	  font-size: 15px;
	  	  min-width: 400px;
	  	  height: 70px;
	  	}
	
	.add-update-preview .btn3 {
				border: 2px solid #0799D5;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 10px 0 0;
				color: #0799D5;
				background: none;
				width: auto;
				font-size: 16px;
				min-width: 110px;
				height: 40px;
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
</style>
