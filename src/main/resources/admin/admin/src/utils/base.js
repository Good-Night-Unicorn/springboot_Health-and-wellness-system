const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot9kssmav8/",
            name: "springboot9kssmav8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot9kssmav8/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于智能推荐的卫生健康系统的设计与实现"
        } 
    }
}
export default base
