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
          <img class="n-logo" src="img/winelogo.png" alt="" />


          <h3>Wine site for wine newbie</h3>
        </div>
       
      </div>
    </div>
 
  </div>
</template>
<script>
import { Parallax } from '@/components';

import {  FormGroupInput, Button } from '@/components';
import axios from 'axios'
  const SERVER='http://k3a208.p.ssafy.io/'
export default {
  
  name: 'StarterTestQuestion',
  bodyClass: 'index-page',
  components: {
    [FormGroupInput.name]: FormGroupInput,
    [Button.name]: Button,

    Parallax,
 
  },
  data(){
    return{
      input:'',

    }
  },
  methods:{
    submit(){
      axios.get(`${SERVER}get/search/`,{"keyword":this.input})
      .then(res=>console.log(res.data))
      .catch(err=>console.log(err))

    }
  }
};
</script>
<style></style>
