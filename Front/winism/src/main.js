import Vue from 'vue';
import App from './App.vue';
// You can change this import to `import router from './starterRouter'` to quickly start development from a blank layout.
import router from './router';
import NowUiKit from './plugins/now-ui-kit';
import vuetify from './plugins/vuetify';
import store from './store'
require('@/assets/demo/demo.css')

Vue.config.productionTip = false;

Vue.use(NowUiKit);

new Vue({
 router,
 vuetify,
 store,
 render: h => h(App)
}).$mount('#app');
