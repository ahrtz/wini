<template>
  <div class="page-header clear-filter" filter-color="orange">
    <div
      class="page-header-image"
      style="background-image: url('img/login.jpg')"
    ></div>
    <div class="content">
      <div class="container">
        <div class="col-md-5 ml-auto mr-auto">
          <card type="login" plain >
            <div slot="header" >
              <img v-lazy="'img/winelogowhite.png'" alt="" />
            </div>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons users_circle-08"
              placeholder="email"
              v-model="loginData.email"
            >
            </fg-input>

            <fg-input
              class="no-border input-lg my-0"
              addon-left-icon="now-ui-icons text_caps-small"
              placeholder="password"
              type='password'
              v-model="loginData.password"
            >
            </fg-input>

            <template slot="raw-content">
              <div class="card-footer text-center">
                <a
                  @click="login"
                  class="btn btn-primary btn-round btn-lg btn-block"
                  >Login</a
                >
              </div>
              <div class="pull-left">
                <h6>
                  <a @click="$router.push({name:'signup'})" style="cursor:pointer" class="link footer-link">Create Account</a>
                </h6>
              </div>
              <!-- <div class="pull-right">
                <h6>
                  <a href="#pablo" class="link footer-link">Need Help?</a>
                </h6>
              </div> -->
            </template>
          </card>
        </div>
      </div>
    </div>
    <!-- <main-footer></main-footer> -->
  </div>
</template>
<script>
import { Card, Button, FormGroupInput } from '@/components';
import axios from 'axios'
  const SERVER='http://k3a208.p.ssafy.io/api/'

export default {
  name: 'login-page',
  bodyClass: 'login-page',
  components: {
    Card,

    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput
  },
  data(){
    return{
      loginData:{
        email:"",
        password:'',
      }

    }
  },
  methods:{
    async login(){
      await axios.post(`${SERVER}signin`,this.loginData,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
      }}).then(res=>{
        console.log(res.data)
        this.$store.commit('userData',this.loginData.email)
        this.$store.commit('isLoggedin',true)
        this.$router.push({name:'Main'})
      })
    }
  }
};
</script>
<style></style>
