import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import yishengList from '../pages/yisheng/list'
import yishengDetail from '../pages/yisheng/detail'
import yishengAdd from '../pages/yisheng/add'
import keshiList from '../pages/keshi/list'
import keshiDetail from '../pages/keshi/detail'
import keshiAdd from '../pages/keshi/add'
import chuzhenyishengList from '../pages/chuzhenyisheng/list'
import chuzhenyishengDetail from '../pages/chuzhenyisheng/detail'
import chuzhenyishengAdd from '../pages/chuzhenyisheng/add'
import guahaoxinxiList from '../pages/guahaoxinxi/list'
import guahaoxinxiDetail from '../pages/guahaoxinxi/detail'
import guahaoxinxiAdd from '../pages/guahaoxinxi/add'
import zixunjiluList from '../pages/zixunjilu/list'
import zixunjiluDetail from '../pages/zixunjilu/detail'
import zixunjiluAdd from '../pages/zixunjilu/add'
import shipinleixingList from '../pages/shipinleixing/list'
import shipinleixingDetail from '../pages/shipinleixing/detail'
import shipinleixingAdd from '../pages/shipinleixing/add'
import jiankangshipinList from '../pages/jiankangshipin/list'
import jiankangshipinDetail from '../pages/jiankangshipin/detail'
import jiankangshipinAdd from '../pages/jiankangshipin/add'
import yaopinxinxiList from '../pages/yaopinxinxi/list'
import yaopinxinxiDetail from '../pages/yaopinxinxi/detail'
import yaopinxinxiAdd from '../pages/yaopinxinxi/add'
import jiankangshujuList from '../pages/jiankangshuju/list'
import jiankangshujuDetail from '../pages/jiankangshuju/detail'
import jiankangshujuAdd from '../pages/jiankangshuju/add'
import jiankangjianyiList from '../pages/jiankangjianyi/list'
import jiankangjianyiDetail from '../pages/jiankangjianyi/detail'
import jiankangjianyiAdd from '../pages/jiankangjianyi/add'
import forumtypeList from '../pages/forumtype/list'
import forumtypeDetail from '../pages/forumtype/detail'
import forumtypeAdd from '../pages/forumtype/add'
import forumreportList from '../pages/forumreport/list'
import forumreportDetail from '../pages/forumreport/detail'
import forumreportAdd from '../pages/forumreport/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'yisheng',
					component: yishengList
				},
				{
					path: 'yishengDetail',
					component: yishengDetail
				},
				{
					path: 'yishengAdd',
					component: yishengAdd
				},
				{
					path: 'keshi',
					component: keshiList
				},
				{
					path: 'keshiDetail',
					component: keshiDetail
				},
				{
					path: 'keshiAdd',
					component: keshiAdd
				},
				{
					path: 'chuzhenyisheng',
					component: chuzhenyishengList
				},
				{
					path: 'chuzhenyishengDetail',
					component: chuzhenyishengDetail
				},
				{
					path: 'chuzhenyishengAdd',
					component: chuzhenyishengAdd
				},
				{
					path: 'guahaoxinxi',
					component: guahaoxinxiList
				},
				{
					path: 'guahaoxinxiDetail',
					component: guahaoxinxiDetail
				},
				{
					path: 'guahaoxinxiAdd',
					component: guahaoxinxiAdd
				},
				{
					path: 'zixunjilu',
					component: zixunjiluList
				},
				{
					path: 'zixunjiluDetail',
					component: zixunjiluDetail
				},
				{
					path: 'zixunjiluAdd',
					component: zixunjiluAdd
				},
				{
					path: 'shipinleixing',
					component: shipinleixingList
				},
				{
					path: 'shipinleixingDetail',
					component: shipinleixingDetail
				},
				{
					path: 'shipinleixingAdd',
					component: shipinleixingAdd
				},
				{
					path: 'jiankangshipin',
					component: jiankangshipinList
				},
				{
					path: 'jiankangshipinDetail',
					component: jiankangshipinDetail
				},
				{
					path: 'jiankangshipinAdd',
					component: jiankangshipinAdd
				},
				{
					path: 'yaopinxinxi',
					component: yaopinxinxiList
				},
				{
					path: 'yaopinxinxiDetail',
					component: yaopinxinxiDetail
				},
				{
					path: 'yaopinxinxiAdd',
					component: yaopinxinxiAdd
				},
				{
					path: 'jiankangshuju',
					component: jiankangshujuList
				},
				{
					path: 'jiankangshujuDetail',
					component: jiankangshujuDetail
				},
				{
					path: 'jiankangshujuAdd',
					component: jiankangshujuAdd
				},
				{
					path: 'jiankangjianyi',
					component: jiankangjianyiList
				},
				{
					path: 'jiankangjianyiDetail',
					component: jiankangjianyiDetail
				},
				{
					path: 'jiankangjianyiAdd',
					component: jiankangjianyiAdd
				},
				{
					path: 'forumtype',
					component: forumtypeList
				},
				{
					path: 'forumtypeDetail',
					component: forumtypeDetail
				},
				{
					path: 'forumtypeAdd',
					component: forumtypeAdd
				},
				{
					path: 'forumreport',
					component: forumreportList
				},
				{
					path: 'forumreportDetail',
					component: forumreportDetail
				},
				{
					path: 'forumreportAdd',
					component: forumreportAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
