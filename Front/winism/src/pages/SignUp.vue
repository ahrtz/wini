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
            >
            </fg-input>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons text_caps-small"
              placeholder="Password"
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
            >
            </fg-input>
            <!-- <v-radio-group row v-model="signupData.gender" class="radio">
              <v-radio
                value='남'
                style="color:white"
                color='red'
              >
                <template v-slot:label>
                  <div style="color:white">남</div>
                </template>
              </v-radio>
              <v-radio
                
                value='여'
                style="color:white"
              >
                <template v-slot:label>
                  <div style="color:white">여</div>
                </template>
              </v-radio>
            </v-radio-group> -->
            <div class="row">
              <n-radio v-model="signupData.gender" label='male' class="col-6">남</n-radio>
              <n-radio v-model="signupData.gender" label='female' class="col-6">여</n-radio>
            </div>
            <template slot="raw-content">
              <div class="card-footer text-center">
                <a
                  href="#pablo"
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
  }
};
</script>
<style>
.radio label{
  color: aliceblue;
}
</style>
