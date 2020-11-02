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
   <v-text-field
            solo
            label="Search Wine"
            append-icon="mdi-magnify"
          ></v-text-field>


          <h3>Wine site for wine newbie</h3>
        </div>
       
      </div>
    </div>
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
              <v-btn  href="/guide" class="white--text " outlined>Go</v-btn>
            </div>


<!--            <v-expand-transition>-->
<!--              <div-->
<!--                v-if="hover"-->
<!--                class="d-flex transition-fast-in-fast-out orange darken-2 v-card&#45;&#45;reveal display-3 white&#45;&#45;text"-->
<!--                style="height: 100%;"-->
<!--              >-->

<!--                <h3>Top Picks</h3><br/>-->
<!--                <h3>sdfs</h3>-->
<!--              </div>-->
<!--            </v-expand-transition>-->
          </v-img>
        </v-card>
<!--        </v-hover>-->
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
              <v-btn  href="/list" class="white--text" outlined>Go</v-btn>
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
              <v-btn class="white--text caption"  href="/" text>Go <v-icon class="white--text caption">mdi-arrow-right</v-icon></v-btn>
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
              <v-btn class="white--text caption"  href="/news" text>Go <v-icon class="white--text caption">mdi-arrow-right</v-icon></v-btn>
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
import { Parallax } from '@/components';

import {  FormGroupInput, Button } from '@/components';

export default {
  name: 'Main',
  bodyClass: 'index-page',
  components: {
    [FormGroupInput.name]: FormGroupInput,
    [Button.name]: Button,

    Parallax,
 
  }
};
</script>
<style></style>
