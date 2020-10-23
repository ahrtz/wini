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
          <h1 class="h1-seo">Winism</h1>
   
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
       class="col-md-3 col-sm-3 col-xs-12"
      >
        <card class="card-plain" header-classes="text-center" >
          <template slot="header">
            <h3 class="card-title">Filters</h3>
            
          </template>
<drop-down
              tag="li"
              title="Type"
              class="nav-item"
      >
        <nav-link to="/red">
          <i class="now-ui-icons education_paper"></i> Red
        </nav-link>
        <nav-link to="/white">
          <i class="now-ui-icons users_circle-08"></i> White
        </nav-link>
        <nav-link to="/sparkling">
          <i class="now-ui-icons users_single-02"></i> Sparkling
        </nav-link>
      </drop-down>
          <hr>
       
            <h3 class="card-body">Price</h3>
            <slider class="slider-info"
         v-model="range"
         :connect="true"
         type="primary">
 </slider>
 <div class="row pa-2" dense>
              <div class="col-12 col-sm-5">
                <label for="mini">Min</label>
    <input type="text"  id="mini" :placeholder="range[0]" @change="$set(range, 0, $event)">
              </div>
           <div class="col-12 col-sm-5">
                <p class="pt-2 text-center">TO</p>
              </div>
              <div class="col-12 col-sm-5">
                <label for="mini">Min</label>
    <input type="text"  id="mini" :placeholder="range[1]" @change="$set(range, 1, $event)">
              </div>
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

import { DropDown,Card, FormGroupInput, Button, NavLink,Slider} from '@/components';

export default {
  name: 'main',
  bodyClass: 'index-page',
  components: {
    [FormGroupInput.name]: FormGroupInput,
    [Button.name]: Button,
    Card,
    Parallax,
    DropDown,
    NavLink,
     [Slider.name]: Slider
 
  },
  data(){
      return{
          range: [0, 10000],
           min:0,
            max:10000,
      }
  }
};
</script>
<style></style>
