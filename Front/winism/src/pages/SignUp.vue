<template>
  <div class="page-header clear-filter" filter-color="orange">
    <div
      class="page-header-image"
      style="background-image: url('img/login.jpg')"
    ></div>
    <div class="content">
      <div class="container">
        <div class="col-md-5 ml-auto mr-auto">
          <card type="login" plain>
            <div slot="header" class="logo-container">
              <img v-lazy="'img/now-logo.png'" alt="" />
            </div>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons users_circle-08"
              placeholder="E-mail"
              v-model="signupData.email"
            >
            </fg-input>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons text_caps-small"
              placeholder="Password"
              v-model="signupData.password"
            >
            </fg-input>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons text_caps-small"
              placeholder="Password Confirmation"
              
            >
            </fg-input>
            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons text_caps-small"
              placeholder="Age"
              v-model="signupData.age"
            >
            </fg-input>
            
            <div class="row">
              <n-radio color='white' v-model="signupData.gender" label='male' class="col-6">남</n-radio>
              <n-radio v-model="signupData.gender" label='female' class="col-6">여</n-radio>
            </div>
            <template slot="raw-content">
              <div class="card-footer text-center">
                <a
                  @click="signUp"
                  class="btn btn-primary btn-round btn-lg btn-block"
                  >Sign Up</a
                >
              </div>
              
              
            </template>
          </card>
        </div>
      </div>
    </div>
    
  </div>
</template>
<script>
import { Card, Button, FormGroupInput, Radio } from '@/components';
import axios from 'axios'
  const SERVER='http://k3a208.p.ssafy.io/api/'

export default {
  name: 'signup-page',
  bodyClass: 'signup-page',
  components: {
    Card,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
    [Radio.name]:Radio
  },
  data(){
    return{
      signupData:{
        email:"",
        password:"",
        gender:null,
        age:""
      }
    }
  },
  methods:{
    // 필요한거 이메일 형식 검사 , 비번 두개 일치 검사 
    async signUp(){
      await axios.post(`${SERVER}signup`,this.signupData,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
      }}).then(res =>{
        this.$store.commit('userData',this.signupData.email)
        this.$store.commit('isLoggedin',true)
        this.$router.push({name:'Main'})
      })
    }
  }
};
</script>
<style>
.radio label{
  color: aliceblue;
}
</style>
