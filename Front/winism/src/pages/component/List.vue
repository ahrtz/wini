<template>
  <div>
    <v-app >
      <v-container class="pt-5">
        <v-row style='margin-top:60px'>
          <v-col cols="12">
            <v-text-field label="Search Wine" append-outer-icon="mdi-magnify"></v-text-field>
          </v-col>
        </v-row>
        <div class="row">
          <div class="col-md-4 col-sm-4 col-xs-12" id="app">
            <v-card outlined>
              <v-card-title>Filters</v-card-title>
              <v-divider></v-divider>
              <template>
                <v-treeview :items="items" :open="[1]" :selected-color="'#fff'" activatable open-on-click dense>
                </v-treeview>
              </template>
              <v-divider></v-divider>
              <template>
                <v-treeview :items="pairings" :open="[1]" :selected-color="'#fff'" activatable open-on-click dense>
                </v-treeview>
              </template>
              <v-divider></v-divider>
              <v-card-title>Price</v-card-title>
              <v-range-slider v-model="range" :max="max" :min="min" :height="10" class="align-center some" dense>
              </v-range-slider>
              <v-row class="pa-2" dense>
                <v-col cols="12" sm="5">
                  <v-text-field :value="range[0]" label="Min" outlined dense @change="$set(range, 0, $event)">
                  </v-text-field>
                </v-col>
                <v-col cols="12" sm="2">
                  <p class="pt-2 text-center">TO</p>
                </v-col>
                <v-col cols="12" sm="5">
                  <v-text-field :value="range[1]" label="Max" outlined dense @change="$set(range, 1, $event)">
                  </v-text-field>
                </v-col>
              </v-row>
              <v-divider></v-divider>
              <v-card-title>Alcohol</v-card-title>
              <v-range-slider v-model="alcoholrange" :max="20" :min="10" :height="10" class="align-center" dense>
              </v-range-slider>
              <v-row class="pa-2" dense>
                <v-col cols="12" sm="5">
                  <v-text-field :value="alcoholrange[0]" label="Min" outlined dense @change="$set(range, 0, $event)">
                  </v-text-field>
                </v-col>
                <v-col cols="12" sm="2">
                  <p class="pt-2 text-center">TO</p>
                </v-col>
                <v-col cols="12" sm="5">
                  <v-text-field :value="alcoholrange[1]" label="Max" outlined dense @change="$set(range, 1, $event)">
                  </v-text-field>
                </v-col>
              </v-row>
              <v-divider></v-divider>
              <v-card-title class="pb-0">Customer Rating</v-card-title>
              <v-container class="pt-0" fluid>
                <v-checkbox append-icon="mdi-star" label="4 & above" hide-details dense></v-checkbox>
                <v-checkbox append-icon="mdi-star" label="3 & above" hide-details dense></v-checkbox>
                <v-checkbox append-icon="mdi-star" label="2 & above" hide-details dense></v-checkbox>
                <v-checkbox append-icon="mdi-star" label="1 & above" hide-details dense></v-checkbox>
              </v-container>
              <v-divider></v-divider>
              <v-card-title class="pb-0">Sweetness</v-card-title>
              <v-slider
            v-model="sweetness"
            class="align-center pb-5"
            :max=5
            :min=0
             :tick-labels="sweetlabel"
              step="1"
              tick-size="0"
            hide-details
          >
           
          </v-slider>
              
              <v-card-title class="pb-0">Body</v-card-title>
            <v-slider
            v-model="body"
            class="align-center pb-5"
            :max=5
            :min=0
             :tick-labels="bodylabel"
              step="1"
              tick-size="0"
            hide-details
          >
            
          </v-slider>
              <v-card-title class="pb-0">Acidity</v-card-title>
             <v-slider
            v-model="acidity"
            class="align-center pb-5"
            :max=5
            :min=0
             :tick-labels="acidlabel"
              step="1"
              tick-size="0"
            hide-details
          >
         
          </v-slider>
              <v-card-title class="pb-0">Tannin</v-card-title>
              <v-slider
            v-model="tannin"
            class="align-center pb-10"
            :max=5
            :min=0
             :tick-labels="acidlabel"
              step="1"
              tick-size="0"
            hide-details
          >
        
          </v-slider>
            </v-card>
          </div>
          <div class="col-md-8 col-sm-8 col-xs-12">
            <v-row dense>
              <v-col cols="12" sm="8" class="pl-6 pt-6">
                <small>Showing 1-12 of 200 products</small>
              </v-col>
              <v-col cols="12" sm="4">
                <v-select class="pa-0" v-model="select" :items="options" style="margin-bottom: -20px;" outlined dense>
                </v-select>
              </v-col>
            </v-row>

            <v-divider></v-divider>

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
                          <v-btn v-if="hover" href="/detail" class="" outlined>VIEW</v-btn>
                        </div>

                      </v-expand-transition>

</v-card>
                </v-hover>
              </div>
</div>
            <div class="text-center mt-12">
              <v-pagination v-model="page" :length="6"></v-pagination>
            </div>
          </div>
        </div>
      </v-container>


    </v-app>
  </div>

</template>
<script>
  import {
    Slider
  } from '@/components'
import {Progress} from '@/components'
  export default {
    name: 'List',
    components: {
      [Slider.name]: Slider,
       [Progress.name]: Progress
    },
    data() {
      return {

        //wine taste
        sweetness:0,
        body:0,
        tannin:0,
        acidity:0,
        alcoholrange:[10,20],

        range: [0, 10000],
        select: 'Popularity',
        options: [
          'Default',
          'Popularity',
          'Relevance',
          'Price: Low to High',
          'Price: High to Low',
        ],
        page: 1,
        breadcrums: [{
            text: 'Home',
            disabled: false,
            href: 'breadcrumbs_home',
          },
          {
            text: 'Type',
            disabled: false,
            href: 'breadcrumbs_type',
          },
          {
            text: 'Red',
            disabled: true,
            href: 'breadcrumbs_red',
          },
        ],
        min: 0,
        max: 10000,
        items: [{
            id: 2,
            name: 'Type',
            children: [{
                id: 2,
                name: 'Red'
              },
              {
                id: 3,
                name: 'White'
              },
              {
                id: 4,
                name: 'Rose'
              },
              {
                id: 5,
                name: 'Sparkling'
              },
            ],
          },

        ],
        pairings: [{
            id: 2,
            name: 'Pairing',
            children: [
              {
                id: 1,
                name: 'Cheese'
              },
              {
            
                id: 2,
                name: 'Beef'
              },
              {
                id: 3,
                name: 'Fish'
              },
              {
                id: 4,
                name: 'Lamb'
              },
              {
                id: 5,
                name: 'Vegetable'
              },
              {
                id: 6,
                name: 'Pork'
              },
              {
                id: 7,
                name: 'Western'
              },
              {
                id: 8,
                name: 'Duck'
              },
              {
                id: 9,
                name: 'Dessert'
              },
              {
                id: 10,
                name: 'Poultry'
              },
               {
                id: 11,
                name: 'Instant'
              },
              {
                id: 12,
                name: 'Etc'
              },
            ],
          },

        ],

        products: [{
            id: 1,
            name: 'Alvaro Palacios Villa de Corullon',
            type: 'Red',
            price: '18.00',
            src: require('../../../public/img/wine-bottle-grapes.jpg')
          },
        ],
        sweetlabel: [
          'Dry',
          '', '', '', '', 'Sweet'
        ],
        bodylabel: [
          'Light',
          '', '', '', '', 'Full'
        ],

        acidlabel: [
          'Low',
          '', '', '', '', 'High'
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