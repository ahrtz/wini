<template>
  <navbar
    position="fixed"
    type="primary"
    :transparent="transparent"
    :color-on-scroll="colorOnScroll"
    menu-classes="ml-auto"
  >
    <template>
      <router-link v-popover:popover1 class="navbar-brand" to="/">
        WINISM
      </router-link>
      <el-popover
        ref="popover1"
        popper-class="popover"
        placement="bottom"
        width="200"
        trigger="hover"
      >
        
      </el-popover>
    </template>
    <template slot="navbar-menu">
      <li class="nav-item" style="cursor:pointer">
        <a
          class="nav-link"
          @click="$router.push({name:'Guide'})"
          target="_blank"
        >
          
          <p>Guide</p>
        </a>
      </li>
       <li class="nav-item" style="cursor:pointer">
        <a
          class="nav-link"
          @click="$router.push({name:'List'})"
          target="_blank"
        >
          
          <p>List</p>
        </a>
      </li>
       <li class="nav-item" style="cursor:pointer">
        <a
          class="nav-link"
          @click="$router.push({name:'Info'})"
          target="_blank"
        >
          
          <p>Info</p>
        </a>
      </li>
       <li class="nav-item" style="cursor:pointer">
        <a
          class="nav-link"
           @click="$router.push({name:'Recommend'})"
          target="_blank"
        >
          
          <p>Recommend</p>
        </a>
      </li>
       <li class="nav-item" v-if="islogin==false"  style="cursor:pointer">
        <a
          class="nav-link"
          @click="$router.push({name:'login'})"
          target="_blank"
        >
          
          <p><i class="now-ui-icons users_circle-08"></i> Login</p>
        </a>
      </li>
      

      <drop-down
              tag="li"
              title="My Cellar"
              icon="now-ui-icons design_image"
              class="nav-item"
              v-if="islogin==true"
      >
        <nav-link to="/" >
          <div @click="logout()"><i class="now-ui-icons users_circle-08"></i> logout
          </div>
        </nav-link>
        <nav-link to="/profile">
          <i class="now-ui-icons users_single-02"></i> Profile
        </nav-link>
      </drop-down>


    </template>
  </navbar>
</template>

<script>
import { DropDown, Navbar, NavLink } from '@/components';
import { Popover } from 'element-ui';
export default {
  name: 'main-navbar',
  props: {
    transparent: Boolean,
    colorOnScroll: Number
  },
  components: {
    DropDown,
    Navbar,
    NavLink,
    [Popover.name]: Popover
  },
  data(){
    return{
      

    }
  },
  methods:{
    logout(){
      this.$store.commit('userData',null)
      this.$store.commit('isLoggedin',false)
      
      
    }
  },
  computed:{
    islogin(){
      return  this.$store.getters.getlogin
  }}
};
</script>

<style scoped></style>
