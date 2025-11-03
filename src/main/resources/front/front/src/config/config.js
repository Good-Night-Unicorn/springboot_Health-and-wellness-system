export default {
	baseUrl: 'http://localhost:8080/springboot9kssmav8/',
	name: '/springboot9kssmav8',
	indexNav: [
		{
			name: '出诊医生',
			url: '/index/chuzhenyisheng',
		},
		{
			name: '健康视频',
			url: '/index/jiankangshipin',
		},
		{
			name: '健康论坛',
			url: '/index/forum'
		}, 
		{
			name: '留言板',
			url: '/index/messages'
		},
	],
	cateList: [
		{
			name: '出诊医生',
			refTable: 'keshi',
			refColumn: 'keshi',
		},
		{
			name: '健康视频',
			refTable: 'shipinleixing',
			refColumn: 'shipinleixing',
		},
		{
			name: '健康论坛',
			refTable: 'forumtype',
			refColumn: 'typename',
		},
	]
}
