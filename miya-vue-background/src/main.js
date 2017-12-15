import Vue from 'vue'
import App from './App'


// 引入router-config.js文件
import VueRouter from 'vue-router'
import routeConfig from './router-config'
Vue.use(VueRouter)
const router = new VueRouter({
  routes: routeConfig
})



//引入element-ui
import Element from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
Vue.use(Element)



Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
