<template>
	<div :style='{"padding":"30px 30px 20px 30px","margin":"30px 0 0 20px","fontSize":"15px","background":"#F2F8FF"}'>
		<el-form
			:style='{"border":"0px solid #BFBFBF","padding":"0","margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			label-width="180px"
		>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}'   v-if="flag=='yonghu'"  label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" readonly						placeholder="用户账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}'   v-if="flag=='yonghu'"  label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" 						placeholder="用户姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' v-if="flag=='yonghu'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="yonghutouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' v-if="flag=='yonghu'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in yonghuxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}'   v-if="flag=='yonghu'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" 						placeholder="年龄" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}'   v-if="flag=='yonghu'"  label="手机号码" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" 						placeholder="手机号码" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}'   v-if="flag=='yisheng'"  label="医生账号" prop="yishengzhanghao">
					<el-input v-model="ruleForm.yishengzhanghao" readonly						placeholder="医生账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' v-if="flag=='yisheng'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="yishengtouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}'   v-if="flag=='yisheng'"  label="医生姓名" prop="yishengxingming">
					<el-input v-model="ruleForm.yishengxingming" 						placeholder="医生姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' v-if="flag=='yisheng'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in yishengxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}'   v-if="flag=='yisheng'"  label="手机号码" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" 						placeholder="手机号码" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}'   v-if="flag=='yisheng'"  label="职称" prop="zhicheng">
					<el-input v-model="ruleForm.zhicheng" readonly						placeholder="职称" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' v-if="flag=='yisheng'"  label="科室" prop="keshi">
					<el-select v-model="ruleForm.keshi" :disabled="true" placeholder="请选择科室">
						<el-option
							v-for="(item,index) in yishengkeshiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' v-if="flag=='users'" label="用户名" prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"49%","padding":"0","margin":"0!important","display":"initial"}' v-if="flag=='users'" label="头像" prop="image">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.image?ruleForm.image:''"
						@change="usersimageUploadChange"
					></file-upload>
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
// 校验引入
import { 
	isMobile,
} from "@/utils/validate";

export default {
	data() {
		return {
			ruleForm: {},
			flag: '',
			usersFlag: false,
			yonghuxingbieOptions: [],
			yishengxingbieOptions: [],
			yishengkeshiOptions: [],
		};
	},
	mounted() {
		var table = this.$storage.get("sessionTable");
		this.flag = table;
		this.$http({
			url: `${this.$storage.get("sessionTable")}/session`,
			method: "get"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.ruleForm = data.data;
			} else {
				this.$message.error(data.msg);
			}
		});
		this.yonghuxingbieOptions = "男,女".split(',')
		this.yishengxingbieOptions = "男,女".split(',')
		this.$http({
			url: `option/keshi/keshi`,
			method: "get"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.yishengkeshiOptions = data.data;
			} else {
				this.$message.error(data.msg);
			}
		});
	},
	methods: {
		yonghutouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		yishengtouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		usersimageUploadChange(fileUrls) {
			this.ruleForm.image = fileUrls;
		},
		onUpdateHandler() {
			if((!this.ruleForm.yonghuzhanghao)&& 'yonghu'==this.flag){
				this.$message.error('用户账号不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
				this.$message.error('密码不能为空');
				return
			}

			if((!this.ruleForm.yonghuxingming)&& 'yonghu'==this.flag){
				this.$message.error('用户姓名不能为空');
				return
			}




			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}






			if( 'yonghu' ==this.flag && this.ruleForm.shoujihaoma&&(!isMobile(this.ruleForm.shoujihaoma))){
				this.$message.error(`手机号码应输入手机格式`);
				return
			}
			if((!this.ruleForm.yishengzhanghao)&& 'yisheng'==this.flag){
				this.$message.error('医生账号不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'yisheng'==this.flag){
				this.$message.error('密码不能为空');
				return
			}



			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}
			if((!this.ruleForm.yishengxingming)&& 'yisheng'==this.flag){
				this.$message.error('医生姓名不能为空');
				return
			}






			if( 'yisheng' ==this.flag && this.ruleForm.shoujihaoma&&(!isMobile(this.ruleForm.shoujihaoma))){
				this.$message.error(`手机号码应输入手机格式`);
				return
			}




			if('users'==this.flag && this.ruleForm.username.trim().length<1) {
				this.$message.error(`用户名不能为空`);
				return	
			}
			if(this.flag=='users'){
				this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
			}
			this.$http({
				url: `${this.$storage.get("sessionTable")}/update`,
				method: "post",
				data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					if(this.flag=='users'){
						this.$storage.set('headportrait',this.ruleForm.image)
					}
					this.$message({
						message: "修改信息成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							window.location.reload();
						}
					});
				} else {
					this.$message.error(data.msg);
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
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
