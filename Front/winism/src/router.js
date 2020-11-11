import Vue from 'vue';
import Router from 'vue-router';
import Index from './pages/Index.vue';
import Landing from './pages/Landing.vue';
import Login from './pages/Login.vue';
import Profile from './pages/Profile.vue';
import MainNavbar from './layout/MainNavbar.vue';
import MainFooter from './layout/MainFooter.vue';

import SignUp from './pages/SignUp.vue'
import Product from './pages/Products.vue'

import Main from './pages/Main.vue';
import List from './pages/component/List.vue'
import Guide from './pages/component/Guide.vue'
import Recommend from './pages/component/Recommend.vue'
import Info from './pages/component/Info.vue'

import test from './pages/component/StarterTestQuestion.vue'
Vue.use(Router);

export default new Router({
  linkExactActiveClass: 'active',
  routes: [
    {
      path: '/index',
      name: 'index',
      components: { default: Index, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }
    },
    {
      path: '/',
      name: 'Main',
      components: { default: Main, header: MainNavbar },
      props: {
        header: { colorOnScroll: 400 },
      
      }
    },
    {
      path: '/list',
      name: 'List',
      components: { default: List, header: MainNavbar },
    },
    {
      path: '/guide',
      name: 'Guide',
      components: { default: Guide, header: MainNavbar },
    },
    {
      path: '/recommend',
      name: 'Recommend',
      components: { default: Recommend, header: MainNavbar },
      props: {
        header: { colorOnScroll: 50 },
      
      }
    },
    {
      path: '/info',
      name: 'Info',
      components: { default: Info, header: MainNavbar },
    },
    {
      path: '/landing',
      name: 'landing',
      components: { default: Landing, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }
    },
    {
      path: '/login',
      name: 'login',
      components: { default: Login, header: MainNavbar },
      props: {
        header: { colorOnScroll: 400 }
      }
    },
    {
      path: '/signup',
      name: 'signup',
      components:{ default : SignUp, header: MainNavbar},
      props:{
        header:{ colorOnScroll:400}
      }
    },

    {
      path: '/profile',
      name: 'profile',
      components: { default: Profile, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }
    },
    {
      path: '/product/:wid',
      name: 'product',
      components: { default: Product, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }
    },
    {
      path: '/testpage',
      name: 'testpage',
      components: { default: test, header: MainNavbar},
      props: {
        header: { colorOnScroll: 400 }
      }
    }
  ],
  scrollBehavior: to => {
    if (to.hash) {
      return { selector: to.hash };
    } else {
      return { x: 0, y: 0 };
    }
  }
});
