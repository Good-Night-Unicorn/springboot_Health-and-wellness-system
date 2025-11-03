import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import zixunjilu from '@/views/modules/zixunjilu/list'
	import guahaoxinxi from '@/views/modules/guahaoxinxi/list'
	import jiankangshuju from '@/views/modules/jiankangshuju/list'
	import keshi from '@/views/modules/keshi/list'
	import yaopinxinxi from '@/views/modules/yaopinxinxi/list'
	import jiankangshipin from '@/views/modules/jiankangshipin/list'
	import forum from '@/views/modules/forum/list'
	import forumtype from '@/views/modules/forumtype/list'
	import jiankangjianyi from '@/views/modules/jiankangjianyi/list'
	import yonghu from '@/views/modules/yonghu/list'
	import forumreport from '@/views/modules/forumreport/list'
	import messages from '@/views/modules/messages/list'
	import chuzhenyisheng from '@/views/modules/chuzhenyisheng/list'
	import shipinleixing from '@/views/modules/shipinleixing/list'
	import yisheng from '@/views/modules/yisheng/list'
	import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/zixunjilu',
		name: '咨询记录',
		component: zixunjilu
	}
	,{
		path: '/guahaoxinxi',
		name: '挂号信息',
		component: guahaoxinxi
	}
	,{
		path: '/jiankangshuju',
		name: '健康数据',
		component: jiankangshuju
	}
	,{
		path: '/keshi',
		name: '科室',
		component: keshi
	}
	,{
		path: '/yaopinxinxi',
		name: '药品信息',
		component: yaopinxinxi
	}
	,{
		path: '/jiankangshipin',
		name: '健康视频',
		component: jiankangshipin
	}
	,{
		path: '/forum',
		name: '健康论坛',
		component: forum
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/jiankangjianyi',
		name: '健康建议',
		component: jiankangjianyi
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/forumreport',
		name: '举报记录',
		component: forumreport
	}
	,{
		path: '/messages',
		name: '留言板管理',
		component: messages
	}
	,{
		path: '/chuzhenyisheng',
		name: '出诊医生',
		component: chuzhenyisheng
	}
	,{
		path: '/shipinleixing',
		name: '视频类型',
		component: shipinleixing
	}
	,{
		path: '/yisheng',
		name: '医生',
		component: yisheng
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
