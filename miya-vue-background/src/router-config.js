import index from './page/manage/Index.vue'

import activityPublish from './page/manage/activity/activityPublish.vue'
import step1 from './page/manage/activity/step1.vue'
import step2 from './page/manage/activity/step2.vue'
import step3 from './page/manage/activity/step3.vue'
import step4 from './page/manage/activity/step4.vue'


export default [
  {
    path: '/',
    name: 'Index',
    component: index
  },
  {
    path: '/activityPublish',
    component: activityPublish,
    // 配置子路由
    children: [
      { path: '', component: step1 },
      { path: 'step1', component: step1 },
      { path: 'step2', component: step2 },
      { path: 'step3', component: step3 },
      { path: 'step4', component: step4 }
    ]
  }

]

