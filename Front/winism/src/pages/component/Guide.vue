<template>
<div>
 <div class="page-header clear-filter">
      <parallax
        class="page-header-image"
        style="background-image:url('img/wine-bottle-grapes.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="content-center brand">

          <h3>Guide for Wine Choice</h3>
        </div>
       
      </div>
    </div>
<v-app>
  <v-container class="pt-5">
  <div style="margin-top:10px">
    
  </div>
   <v-tabs
      v-model="tab"
      background-color=#750049
      color="white"
      grow
    >
      <v-tab
        
      >
        For Beginner
      </v-tab>
      <v-tab
        
      >
        For Pro
      </v-tab>
       <v-tab-item
      >
        <v-card flat>
          <v-card-text>
            <h2>1. Choose your Wine Type</h2>
          레드, 화이트, 로제, 스파클링 중에 그날의 기분이나 곁들여 먹는 음식 등을 고려하여 구입할 와인의 종류와 예산을 먼저 정할 필요가 있다.
          </v-card-text>
          <v-card-text>
            <h2>1. Choose your Wine Type</h2>
          레드, 화이트, 로제, 스파클링 중에 그날의 기분이나 곁들여 먹는 음식 등을 고려하여 구입할 와인의 종류와 예산을 먼저 정할 필요가 있다.
          </v-card-text>
           <v-card-text>
            <h2>1. Choose your Wine Type</h2>
          레드, 화이트, 로제, 스파클링 중에 그날의 기분이나 곁들여 먹는 음식 등을 고려하여 구입할 와인의 종류와 예산을 먼저 정할 필요가 있다.
          </v-card-text>
           <v-card-text>
            <h2>1. Choose your Wine Type</h2>
          레드, 화이트, 로제, 스파클링 중에 그날의 기분이나 곁들여 먹는 음식 등을 고려하여 구입할 와인의 종류와 예산을 먼저 정할 필요가 있다.
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item
      >
        <v-card flat>
          <v-card-text>
            <h2>1. Choose your Wine Type</h2>
          레드, 화이트, 로제, 스파클링 중에 그날의 기분이나 곁들여 먹는 음식 등을 고려하여 구입할 와인의 종류와 예산을 먼저 정할 필요가 있다.
          </v-card-text>
         
        </v-card>
      </v-tab-item>
    </v-tabs>
    </v-container>

 
  </v-app>
  </div>

</template>
<script>

export default {
  name: 'Guide',
  bodyClass: 'index-page',
  components: {

  },
  data(){
      return{
        //wine list slider data
        tab: null,
      }
  }
};
</script>
<style scoped>

</style>
