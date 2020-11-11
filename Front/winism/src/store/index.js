import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLogin:false,
    userid:null

  },
  mutations: {
    isLoggedin(state,val){
      state.isLogin = val
    },
    userData(state,val){
      state.userid = val
    }
  },
  actions: {
  },
  modules: {
  },
  getters:{
    getlogin: function(state) {
      return state.isLogin
    }
  }
})
