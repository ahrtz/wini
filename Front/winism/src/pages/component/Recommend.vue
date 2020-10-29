<template>
<div>
 <div class="page-header clear-filter">
      <parallax
        class="page-header-image"
        style="background-image:url('img/2628480.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="content-center brand">

          <h3>Recommend for You</h3>
        </div>
       
      </div>
    </div>
<v-app>
  <v-container class="pt-5">
  <div style="margin-top:10px">
    <div class="row text-center">
              <div class="col-12" :key="pro.id" v-for="pro in products">
                <v-hover v-slot:default="{ hover }">

<v-card>
      <v-container
        fluid
        grid-list-lg
      >
        <v-layout row wrap>
        <v-flex xs12>
          
              <v-layout>
                <v-flex xs3>
                  <v-img
                    src="../../../public/img/pngegg.png"
                    height="125px"
                    contain
                  ></v-img>
                </v-flex>
                <v-flex xs5>
                  <v-card-title primary-title>
                    <div>
                      <div class="headline">Alvaro Palacios Villa de Corullon</div>
                      <div>꿀레레레레레레레레레레</div>
                      <div>(Red)</div>
                    </div>
                  </v-card-title>
                </v-flex>
                <v-flex xs4>
                  <v-card-text>
                    <div>
                    <template>
                    sweetness<n-progress :value="sweetness" type="primary" :height="15" show-value>{{sweetness}}</n-progress>
                  </template>
                  <template>
                    acidity<n-progress :value="acidity" type="primary" :height="15" show-value>{{acidity}}</n-progress>
                  </template>
                  <template>
                    tannin<n-progress :value="tannin" type="primary" :height="15" show-value>{{tannin}}</n-progress>
                  </template>
                  <template>
                    body<n-progress :value="body" type="primary" :height="15" show-value>{{body}}</n-progress>
                  </template>
                      
                      
                    </div>
                  </v-card-text>
                </v-flex>

              </v-layout>

             
           
          </v-flex>

        </v-layout>
      </v-container>
       <v-expand-transition>
                        <div v-if="hover"
                          class="d-flex transition-fast-in-fast-out white darken-2 v-card--reveal display-3 white--text"
                          style="height: 100%;">
                          <v-btn v-if="hover" href="/product" class="" outlined>VIEW</v-btn>
                        </div>

                      </v-expand-transition>

</v-card>
                </v-hover>
              </div>
</div>
  </div>
    </v-container>

 
  </v-app>
  </div>

</template>
<script>
import {Progress} from '@/components'
export default {
  name: 'Recommend',
  bodyClass: 'index-page',
  components: {
      [Progress.name]: Progress

  },
  data(){
      return{
        //wine list slider data
        sweetness:4,
        body:0,
        tannin:3,
        acidity:0,

       products: [{
            id: 1,
            name: 'Alvaro Palacios Villa de Corullon',
            type: 'Red',
            price: '18.00',
            src: require('../../../public/img/wine-bottle-grapes.jpg')
          },
        ],
      }
  }
};
</script>
<style scoped>
  .v-card--reveal {
    align-items: center;
    bottom: 0;
    justify-content: center;
    opacity: .8;
    position: absolute;
    width: 100%;
  }

</style>
