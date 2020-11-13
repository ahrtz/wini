<template>
  <div class="page-header clear-filter" filter-color="orange">
    <div
      class="page-header-image"
      style="background-image: url('img/login.jpg')"
    ></div>
    <div class="content my-5">
      <div class="container" overflow:auto>
        <div class="col-md-5 ml-auto mr-auto">
          <card type="login"  plain>
            <div slot="header" class="">
              <img v-lazy="'img/winelogowhite.png'" alt="" />
            </div>
            
              <span class="signup-hint" :style="{visibility:visimail}">이메일 형식에 맞춰주세요</span>
              <v-icon
                v-if="checkmail"
                class="justify-end"
                
                :style="{visibility:visimail}"
              >mdi-check-bold</v-icon>
            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons users_circle-08"
              placeholder="E-mail"
              v-model="signupData.email"
              @focus="visimail='visible'"
              @blur="visimail='hidden'"
            >
            </fg-input>

            <span class="signup-hint" :style="{visibility:visipwd1}">6자 이상의 문자+ 숫자 + 특수 문자</span>
            <v-icon
                v-if="checkpwd"
                class="justify-end"
                :style="{visibility:visipwd1}"
                
              >mdi-check-bold</v-icon>
            
            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons text_caps-small"
              placeholder="Password"
              type='password'
              v-model="signupData.password"
              @focus="visipwd1='visible'"
              @blur="visipwd1='hidden'"
            >
            </fg-input>

            <span class="signup-hint" :style="{visibility:visipwd2}">한번더 입력 해 주세요</span>
            <v-icon
                v-if="checkpwd2 && checkpwd"
                class="justify-end"
                :style="{visibility:visipwd2}"
              >mdi-check-bold</v-icon>
            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons text_caps-small"
              placeholder="Password Confirmation"
              type='password'
              v-model="pwd2"
              @focus="visipwd2='visible'"
              @blur="visipwd2='hidden'"
            >
            </fg-input>

            <fg-input
              class="no-border input-lg py-4"
              addon-left-icon="now-ui-icons text_caps-small"
              placeholder="Age"
              v-model="signupData.age"
            >
            </fg-input>
            
            <div class="row">
              <n-radio color='white' v-model="signupData.gender" label='male' class="col-6">남</n-radio>
              <n-radio v-model="signupData.gender" label='female' class="col-6">여</n-radio>
            </div>
            <template >
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
      visipwd1:false,
      visipwd2:false,
      visimail:false,
      pwd2:'',
      signupData:{
        email:"",
        password:"",
        gender:null,
        age:""
      },
      
    }
  },
  methods:{
    // 필요한거 이메일 형식 검사 , 비번 두개 일치 검사 
    async signUp(){
      if (/^[\w-]+(\.[\w-]+)*@([a-z0-9-]+(\.[a-z0-9-]+)*?\.[a-z]{2,6}|(\d{1,3}\.){3}\d{1,3})(:\d{4})?$/.test(
        this.signupData.email
      )==false){
        alert('메일 양식을 지켜주세요')
      } else if (/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,}$/.test(
        this.signupData.password
      )==false) {
        alert('비밀 번호 양식을 지켜주세요 ')
      } else if(this.signupData.password != this.pwd2) {
        alert('비밀번호가 일치하지 않습니다')
      } else{

      await axios.post(`${SERVER}signup`,this.signupData,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
      }}).then(res =>{
        this.$store.commit('userData',this.signupData.email)
        this.$store.commit('isLoggedin',true)
        this.$router.push({name:'Main'})
      })
    }}
  },
  computed:{
    checkpwd() {
      
      return  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,}$/.test(
        this.signupData.password
      );
    },
    checkmail() {
      return /^[\w-]+(\.[\w-]+)*@([a-z0-9-]+(\.[a-z0-9-]+)*?\.[a-z]{2,6}|(\d{1,3}\.){3}\d{1,3})(:\d{4})?$/.test(
        this.signupData.email
      );
    },
    checkpwd2(){
      return this.pwd2==this.signupData.password
    }
  }
};
</script>
<style>
.radio label{
  color: aliceblue;
}
</style>
