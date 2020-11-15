<template>
  <div>
    <div class="page-header clear-filter">
      <parallax
        class="page-header-image"
        style="background-image:url('img/wine-grapes-drink.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="content-center brand">
          <img class="n-logo" src="img/winelogo_white.png">

          <h3>Wine site for wine newbie</h3>
        </div>
       
      </div>
    </div>
    <v-app>
    <v-card>
          <v-img
            :src="require('../../public/img/startertest_bg.jpg')"
            class="white--text align-center"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="960px"
          >
           <h2 class="text-center font-size">간단한 테스트로 와인 취향을 알아보자!</h2>
            <div class="text-center">
              <v-btn @click="$router.push({name:'StarterTest'})" class="white--text " outlined>Get start</v-btn>
            </div>


          </v-img>
        </v-card>
      </v-app>
      <!-- <div>
    <div class="page-header clear-filter"> -->
      <!-- <parallax
        class="page-header-image"
        style="background-image: url('img/startertest_bg.jpg')"
      >
      </parallax> -->
      <!-- <div>
        <StarterTestStart v-if="current == 0" @changeCurrent="changeCurrent"/>
        <StarterTestQuestion v-if="current == 1" @submitResult="getResult"/>
        <StarterTestResult v-if="current == 2" :result="result"/>
      </div>
    </div> -->
  <!-- </div> -->
<v-app>
 <div class="pl-4 pr-4 row">
      <div
       class="col-md-6 col-sm-6 col-xs-12"
      >
        <v-card>

          <v-img
            :src="require('../../public/img/wine-cheese-grapes.jpg')"
            class="white--text align-center"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="400px"
          >
           <h1 class="text-center font-size">Guide</h1>
            <div class="text-center">
              <v-btn @click="$router.push({name:'Guide'})" class="white--text " outlined>Go</v-btn>
            </div>


          </v-img>
        </v-card>

      </div>
      <div
        class="col-md-6 col-sm-6 col-xs-12"
      >
        <v-card>
          <v-img
            :src="require('../../public/img/wine-bottle-grapes.jpg')"
            class="white--text align-center"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="400px"
          >
            <h1 class="text-center font-size">List</h1>
            <div class="text-center">
              <v-btn  @click="$router.push({name:'List'})" class="white--text" outlined>Go</v-btn>
            </div>
          </v-img>
        </v-card>
      </div>
    </div>
    <div class="pl-4 pr-4 row">
      <div
       class="col-md-4 col-sm-4 col-xs-12"
      >
        <v-card outlined>
          <v-img
            :src="require('../../public/img/wine-wine-glasses-bottle.jpg')"
            class="white--text align-center"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="300px"
          >
            <h1 class="text-center font-size">Info</h1>
            <div class="text-center mt-2">
              <v-btn class="white--text caption"  @click="$router.push({name:'Info'})" text>Go <v-icon class="white--text caption">mdi-arrow-right</v-icon></v-btn>
            </div>
          </v-img>
        </v-card>
      </div>
      <div
        class="col-md-4 col-sm-4 col-xs-12"
      >
        <v-card outlined>
          <v-img
            :src="require('../../public/img/wine-grapes-drink.jpg')"
            class="white--text align-center"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="300px"
          >
            <h1 class="text-center font-size">Recommend</h1>
            <div class="text-center mt-2">
              <v-btn class="white--text caption" @click="$router.push({name:'Recommend'})" text>Go <v-icon class="white--text caption">mdi-arrow-right</v-icon></v-btn>
            </div>
          </v-img>
        </v-card>
      </div>
      <div
        class="col-md-4 col-sm-4 col-xs-12"
      >
        <v-card outlined>
          <v-img
            :src="require('../../public/img/wine-cheese-grapes.jpg')"
            class="white--text align-center"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="300px"
          >
            <h1 class="text-center font-size">My Cellar</h1>
            <div class="text-center mt-2">
              <v-btn class="white--text caption"  href="/" text>Go <v-icon class="white--text caption">mdi-arrow-right</v-icon></v-btn>
            </div>
          </v-img>
        </v-card>
      </div>
    </div>
</v-app>
 
  </div>
</template>
<script>
import StarterTestStart from "./component/StarterTestStart.vue";
// import StarterTestQuestion from "./component/StarterTestQuestion.vue";
// import StarterTestResult from "./component/StarterTestResult.vue";
import { Parallax } from '@/components';

import {  FormGroupInput, Button } from '@/components';
import axios from 'axios'
  const SERVER='http://k3a208.p.ssafy.io/'
export default {
  
  name: 'Main',
  bodyClass: 'index-page',
  components: {
    [FormGroupInput.name]: FormGroupInput,
    [Button.name]: Button,

    Parallax,
    // StarterTestStart, StarterTestQuestion, StarterTestResult 
 
  },
  data(){
    return{
      input:'',
      current: 0,
      show: false,
      tab: null,
      expand: false,
      result: null,

    }
  },
  methods:{
    submit(){
      axios.get(`${SERVER}get/search/`,{"keyword":this.input})
      .then(res=>console.log(res.data))
      .catch(err=>console.log(err))

    },
    changeCurrent(current) {
      console.log(current)
      this.current = current
    },
    getResult(result) {
      console.log(result)
      this.current = 2
      this.result = result

    }
  }
};
</script>
<style></style>
