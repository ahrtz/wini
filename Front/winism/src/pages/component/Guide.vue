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
  <div  style="margin-top:160px">
     <v-tabs
    fixed-tabs
    background-color="#750049"
    dark
  >
    <v-tab>
      For Beginner
    </v-tab>
    <v-tab>
      For Pro
    </v-tab>
  
  </v-tabs>
  </div>
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
       
      }
  }
};
</script>
<style scoped>

</style>
