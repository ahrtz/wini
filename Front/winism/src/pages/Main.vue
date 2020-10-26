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
   
         <fg-input
              addon-right-icon="now-ui-icons ui-1_zoom-bold"
              placeholder="Wine Search"
            >
            </fg-input>

          <h3>Wine site for wine newbie</h3>
        </div>
       
      </div>
    </div>


          
    <div class="pt-4 pl-4 pr-4 row">
      <div
       class="col-md-6 col-sm-6 col-xs-12"
      >
        <card class="card-plain" header-classes="text-center" >
          <template slot="header">
            <h3 class="card-title title-up">Guide</h3>
            
          </template>
         
          <div class="card-body text-center">
           <p>Hi</p>
          </div>
          <div class="card-footer text-center">
            <n-button type="primary" round>Get Started</n-button>
          </div>
        </card>
      </div>
       <div
       class="col-md-6 col-sm-6 col-xs-12"
      >
        <card class="card-plain" header-classes="text-center" color="orange">
          <template slot="header">
            <h3 class="card-title title-up">Sign Up</h3>
            
          </template>
          
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg">Get Started</n-button>
          </div>
        </card>
      </div>
 
     
    </div>
     <div class="pt-4 pl-4 pr-4 row">
      <div
       class="col-md-4 col-sm-4 col-xs-12"
      >
        <card class="card-plain" header-classes="text-center" >
          <template slot="header">
            <h3 class="card-title title-up">Guide</h3>
            
          </template>
         
          <div class="card-body text-center">
           <p>Hi</p>
          </div>
          <div class="card-footer text-center">
            <n-button type="primary" round>Get Started</n-button>
          </div>
        </card>
      </div>
       <div
       class="col-md-4 col-sm-4 col-xs-12"
      >
        <card class="card-plain" header-classes="text-center" color="orange">
          <template slot="header">
            <h3 class="card-title title-up">Sign Up</h3>
            
          </template>
          
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg">Get Started</n-button>
          </div>
        </card>
      </div>
      <div
       class="col-md-4 col-sm-4 col-xs-12"
      >
        <card class="card-plain" header-classes="text-center" color="orange">
          <template slot="header">
            <h3 class="card-title title-up">Sign Up</h3>
            
          </template>
          
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg">Get Started</n-button>
          </div>
        </card>
      </div>
 
     
    </div>

 
  </div>
</template>
<script>
import { Parallax } from '@/components';

import { Card, FormGroupInput, Button } from '@/components';

export default {
  name: 'Main',
  bodyClass: 'index-page',
  components: {
    [FormGroupInput.name]: FormGroupInput,
    [Button.name]: Button,
    Card,
    Parallax,
 
  }
};
</script>
<style></style>
