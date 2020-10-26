<template>
  <div>
  <v-container class="pt-5">
      <div class="row">
        <div
         class="col-md-3 col-sm-3 col-xs-12"
        >
          <v-card outlined>
            <v-card-title>Filters</v-card-title>
            <v-divider></v-divider>
            <template>
              <v-treeview :items="items" :open="[1]" :active="[5]" :selected-color="'#fff'" activatable open-on-click dense></v-treeview>
            </template>
            <v-divider></v-divider>
            <v-card-title>Price</v-card-title>
            <v-slider
              v-model="range"
              :max="max"
              :min="min"
              :height="10"
              class="align-center"
              dense
            ></v-slider>
            <v-row class="pa-2" dense>
              <v-col cols="12" sm="5">
                <v-text-field
                  :value="range[0]"
                  label="Min"
                  outlined
                  dense
                  @change="$set(range, 0, $event)"
                ></v-text-field>
              </v-col>
              <v-col cols="12" sm="2">
                <p class="pt-2 text-center">TO</p>
              </v-col>
              <v-col cols="12" sm="5">
                <v-text-field
                  :value="range[1]"
                  label="Max"
                  outlined
                  dense
                  @change="$set(range, 1, $event)"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-divider></v-divider>
            <v-card-title class="pb-0">Customer Rating</v-card-title>
            <v-container class="pt-0"  fluid>
              <v-checkbox append-icon="mdi-star" label="4 & above" hide-details dense></v-checkbox>
              <v-checkbox append-icon="mdi-star" label="3 & above" hide-details dense></v-checkbox>
              <v-checkbox append-icon="mdi-star" label="2 & above" hide-details dense></v-checkbox>
              <v-checkbox append-icon="mdi-star" label="1 & above" hide-details dense></v-checkbox>
            </v-container>
            <v-divider></v-divider>
            <v-card-title class="pb-0">Sweety</v-card-title>
            <v-slider
        v-model="fruits"
        :tick-labels="ticksLabels"
        :max="5"
        step="1"
        ticks="always"
        tick-size="5"
      ></v-slider>
      <v-card-title class="pb-0">Body</v-card-title>
            <v-slider
        v-model="fruits"
        :tick-labels="ticksLabels"
        :max="3"
        step="1"
        ticks="always"
        tick-size="4"
      ></v-slider>
      <v-card-title class="pb-0">Acid</v-card-title>
            <v-slider
        v-model="fruits"
        :tick-labels="ticksLabels"
        :max="3"
        step="1"
        ticks="always"
        tick-size="4"
      ></v-slider>
      <v-card-title class="pb-0">Tanin</v-card-title>
            <v-slider
        v-model="fruits"
        :tick-labels="ticksLabels"
        :max="3"
        step="1"
        ticks="always"
        tick-size="4"
      ></v-slider>
          </v-card>
        </div>
        <div
          class="col-md-9 col-sm-9 col-xs-12"
        >
          <v-row dense>
            <v-col cols="12" sm="8" class="pl-6 pt-6">
              <small>Showing 1-12 of 200 products</small>
            </v-col>
            <v-col cols="12" sm="4">
              <v-select class="pa-0" v-model="select" :items="options" style="margin-bottom: -20px;" outlined dense></v-select>
            </v-col>
          </v-row>

          <v-divider></v-divider>

          <div class="row text-center">
            <div class="col-12" :key="pro.id" v-for="pro in products">
              <v-hover v-slot:default="{ hover }">
                <v-card
                  class="mx-auto"
                  color="grey lighten-4"
                  max-width="600"
                >
                  <v-img
                    class="white--text align-end"
                    :aspect-ratio="16/9"
                    height="200px"
                    :src="pro.src"
                  >
                    <v-card-title>{{pro.type}} </v-card-title>
                    <v-expand-transition>
                      <div
                        v-if="hover"
                        class="d-flex transition-fast-in-fast-out white darken-2 v-card--reveal display-3 white--text"
                        style="height: 100%;"
                      >
                        <v-btn v-if="hover" href="/product" class="" outlined>VIEW</v-btn>
                      </div>

                    </v-expand-transition>
                  </v-img>
                    <v-slider
      v-model="ex1.val"
      :color="ex1.color"
      :label="ex1.label"
    ></v-slider>
                  <v-card-text class="text--primary">
                    <div><a href="/product" style="text-decoration: none">{{pro.name}}</a></div>
                    <div>${{pro.price}}</div>
                  </v-card-text>
                </v-card>
              </v-hover>
            </div>
          </div>
          <v-col cols="12">
           <v-card

          >
            <div class="d-flex flex-no-wrap justify-space-between">
              <div>
                <v-card-title
                  class="headline"
    
                ></v-card-title>

                <v-card-subtitle></v-card-subtitle>

                <v-card-actions>
                  <v-btn

                    class="ml-2 mt-3"
                    fab
                    icon
                    height="40px"
                    right
                    width="40px"
                  >
                    <v-icon>mdi-play</v-icon>
                  </v-btn>

         
                </v-card-actions>
              </div>

              <v-avatar
                class="ma-3"
                size="125"
                tile
              >
  
              </v-avatar>
            </div>
          </v-card>
          </v-col>
          <div class="text-center mt-12">
            <v-pagination
              v-model="page"
              :length="6"
            ></v-pagination>
          </div>
        </div>
      </div>
    </v-container>

 
  </div>
</template>
<script>
export default {
  name: 'List   ',
  components: {
 
  },
  data(){
      return{
            range: [0, 10000],
            select:'Popularity',
            options: [
                'Default',
                'Popularity',
                'Relevance',
                'Price: Low to High',
                'Price: High to Low',
            ],
            page:1,
            breadcrums: [
                {
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
            min:0,
            max:10000,
            items: [
                {
                    id: 2,
                    name: 'Type',
                    children: [
                        { id: 2, name: 'Red' },
                        { id: 3, name: 'White' },
                        { id: 4, name: 'Sparkling' },
                    ],
                },
           
            ],
              ex1: { label: 'sweety', val: 25, color: '#750049'},
            products:[
                {
                    id:1,
                    name:'BLACK TEE',
                    type:'Jackets',
                    price:'18.00',
                    src:require('../../../public/img/wine-bottle-grapes.jpg')
                },
                
               
            ],
             ticksLabels: [
          'Low',
          '',
          '',
          'High',
        ],
      }
  }
};
</script>
<style>
  .v-card--reveal {
    align-items: center;
    bottom: 0;
    justify-content: center;
    opacity: .8;
    position: absolute;
    width: 100%;
  }
</style>
