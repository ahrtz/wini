<template>

    <v-app>
      <v-container class="pt-5">
        <v-row style='margin-top:60px'>
          <v-col cols="12">
            
            <v-autocomplete
            :search-input.sync="input"
            :items="namelist"
            @click:append-outer="submit" label="Search Wine" append-outer-icon="mdi-magnify" 
            dense
    
          ></v-autocomplete>

          </v-col>
        </v-row>
        <div class="row">
          <div class="col-md-4 col-sm-4 col-xs-12" id="app">
            <v-card outlined>
              <v-card-title>Filters</v-card-title>
              <v-divider></v-divider>
            
              <v-list flat>
   
           <v-list-group >
              <template v-slot:activator>
                <v-list-item-title>Type</v-list-item-title>
              </template>
 <v-list-item-group v-model="type" color="primary">
              <v-list-item v-for="item in items" :key="item.id" >
                <v-list-item-content>
            <v-list-item-title v-text="item"></v-list-item-title>
          </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
 </v-list-group>
          </v-list>
               
           
              <v-divider></v-divider>
                <v-list flat>
   
           <v-list-group >
              <template v-slot:activator>
                <v-list-item-title>Pairing</v-list-item-title>
              </template>
 <v-list-item-group v-model="pairing" color="primary">
              <v-list-item v-for="item in pairings" :key="item.id" >
                <v-list-item-content>
            <v-list-item-title v-text="item"></v-list-item-title>
          </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
 </v-list-group>
          </v-list>
               
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
         
              <v-col cols="12" sm="4">
                <v-select class="pa-0" v-model="select" :items="options" style="margin-bottom: -20px;" outlined dense>
                </v-select>
              </v-col>
            </v-row>

            <v-divider></v-divider>

<div class="row text-center">
              <div class="col-12" :key="pro.id" v-for="pro in winelist">
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
                      <div class="headline">{{pro.ename}}</div>
                      <div>{{pro.koname}}</div>
                      <div>{{pro.type}}</div>
                      <div>{{pro.year}}</div>
                      <div>{{pro.grape}}</div>
                      <div>{{pro.temperature}}</div>
                      <div v-if="pro.cost!=='가격정보없음'">{{pro.cost}}</div>
                    </div>
                  </v-card-title>
                </v-flex>
                <v-flex xs4>
                  <v-card-text>
                    <div>
                    <template>sweetness
                    <n-progress :value="parseInt(pro.sweetness)" type="primary" :height="15" show-value>{{pro.sweetness}}</n-progress>
                  </template>
                  <template>
                    acidity<n-progress :value="parseInt(pro.acidity)" type="primary" :height="15" show-value>{{pro.acidity}}</n-progress>
                  </template>
                  <template>
                    tannin<n-progress :value="parseInt(pro.tannin)" type="primary" :height="15" show-value>{{pro.tannin}}</n-progress>
                  </template>
                  <template>
                    body<n-progress :value="parseInt(pro.body)" type="primary" :height="15" show-value>{{pro.body}}</n-progress>
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
                          <v-btn v-if="hover"  @click="$router.push({name:'product',params:{wid:pro.wid}})" class="" outlined>VIEW</v-btn>
                        </div>

                      </v-expand-transition>

</v-card>
                </v-hover>
              </div>
</div>
            <div class="text-center mt-12">
              <v-pagination v-model="page" :length="10" :total-visible="7"></v-pagination>
            </div>
          </div>
        </div>
      </v-container>


    </v-app>


</template>
<script>
  import {
    Slider
  } from '@/components'
import {Progress} from '@/components'
import axios from 'axios'
  const SERVER='http://k3a208.p.ssafy.io/api/'
  export default {
    name: 'List',
    components: {
      [Slider.name]: Slider,
       [Progress.name]: Progress
    },
    data() {
      return {
        input:'',
        winelist:[],
        namelist:[],
        type:0,
        pairing:'',
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
        min: 0,
        max: 10000,
        items: ['Red','White','Rose','Sparkling'

        ],
        pairings: ['Cheese','Beef','Fish','Lamb','Vegetable','Pork','Western','Duck','Dessert','Poultry','Instant','etc'
            
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
    },
    methods:{
    submit(){
      axios.get(`${SERVER}search?keyword=${this.input}&page=${this.page}`,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
    	}
    })
      .then(res=>{
        this.winelist=res.data.content
        })
      .catch(err=>console.log(err))

    },

    
 
  },
  watch: {
    input: function () {
      axios.get(`${SERVER}search/auto?keyword=${this.input}`,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
    	}
    })
      .then(res=>{
        this.namelist=[]
        for(var i in res.data){
          var regexp =/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*/gi;
          if(!this.input.match(regexp)){
            this.namelist.push(res.data[i].koname)
          }
          else{
 this.namelist.push(res.data[i].enname)
        }
          }
         
        })
      .catch(err=>console.log(err))
    },
    range:function(){
var form = new FormData();
        form.append('keyword',this.input)
        form.append('page',this.page)
        form.append('type',this.items[this.type])
        form.append('pairing',this.pairings[this.pairing])
        form.append('price1',this.range[0])
        form.append('price2',this.range[1])
        form.append('alcohol1',this.alcoholrange[0])
        form.append('alcohol2',this.alcoholrange[1])
        form.append('rate','')
        form.append('sweetness',toString(this.sweetness))
        form.append('acidity',toString(this.acidity))
        form.append('tannin',toString(this.tannin))
        form.append('body',toString(this.body))
        console.log(form)
      axios.post(`${SERVER}search`,form,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
    	}
    })
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content
    })

    },
    sweetness:function(){
      var form = new FormData();
        form.append('keyword',this.input)
        form.append('page',this.page)
        form.append('type',this.items[this.type])
        form.append('pairing',this.pairings[this.pairing])
        form.append('price1',this.range[0])
        form.append('price2',this.range[1])
        form.append('alcohol1',this.alcoholrange[0])
        form.append('alcohol2',this.alcoholrange[1])
        form.append('rate','')
        form.append('sweetness',this.sweetness.toString())
        form.append('acidity',this.acidity)
        form.append('tannin',this.tannin)
        form.append('body',this.body)
        // for(var pair of form.entries()){
        //   console.log(pair[0]+pair[1])
        // }
      axios.post(`${SERVER}search`,{params:{keyword:this.input,page:this.page,type:this.items[this.type],sweetness:toString(this.sweetness)},headers:{
	'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
      }})
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content
    })
    .catch(err=>console.log(err))

    },
    body:function(){
var form = new FormData();
        form.append('keyword',this.input)
        form.append('page',this.page)
        form.append('type',this.items[this.type])
        form.append('pairing',this.pairings[this.pairing])
        form.append('price1',this.range[0])
        form.append('price2',this.range[1])
        form.append('alcohol1',this.alcoholrange[0])
        form.append('alcohol2',this.alcoholrange[1])
        form.append('rate','')
        form.append('sweetness',this.sweetness)
        form.append('acidity',this.acidity)
        form.append('tannin',this.tannin)
        form.append('body',this.body)
      axios.post(`${SERVER}search`,form,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
    	}
    })
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content
    })

    },
    tannin:function(){
var form = new FormData();
        form.append('keyword',this.input)
        form.append('page',this.page)
        form.append('type',this.items[this.type])
        form.append('pairing',this.pairings[this.pairing])
        form.append('price1',this.range[0])
        form.append('price2',this.range[1])
        form.append('alcohol1',this.alcoholrange[0])
        form.append('alcohol2',this.alcoholrange[1])
        form.append('rate','')
        form.append('sweetness',this.sweetness)
        form.append('acidity',this.acidity)
        form.append('tannin',this.tannin)
        form.append('body',this.body)
      axios.post(`${SERVER}search`,form,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
    	}
    })
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content
    })

    },
    acidity:function(){
      var form = new FormData();
        form.append('keyword',this.input)
        form.append('page',this.page)
        form.append('type',this.items[this.type])
        form.append('pairing',this.pairings[this.pairing])
        form.append('price1',this.range[0])
        form.append('price2',this.range[1])
        form.append('alcohol1',this.alcoholrange[0])
        form.append('alcohol2',this.alcoholrange[1])
        form.append('rate','')
        form.append('sweetness',this.sweetness)
        form.append('acidity',this.acidity)
        form.append('tannin',this.tannin)
        form.append('body',this.body)
      axios.post(`${SERVER}search`,form,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
    	}
    })
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content
    })

    },
    type:function(){
var form = new FormData();
        form.append('keyword',this.input)
        form.append('page',this.page)
        form.append('type',this.items[this.type])
        form.append('pairing',this.pairings[this.pairing])
        form.append('price1',this.range[0])
        form.append('price2',this.range[1])
        form.append('alcohol1',this.alcoholrange[0])
        form.append('alcohol2',this.alcoholrange[1])
        form.append('rate','')
        form.append('sweetness',this.sweetness)
        form.append('acidity',this.acidity)
        form.append('tannin',this.tannin)
        form.append('body',this.body)
      axios.post(`${SERVER}search`,form,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
    	}
    })
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content
    })

    },
    pairing:function(){
var form = new FormData();
        form.append('keyword',this.input)
        form.append('page',this.page)
        form.append('type',this.items[this.type])
        form.append('pairing',this.pairings[this.pairing])
        form.append('price1',this.range[0])
        form.append('price2',this.range[1])
        form.append('alcohol1',this.alcoholrange[0])
        form.append('alcohol2',this.alcoholrange[1])
        form.append('rate','')
        form.append('sweetness',this.sweetness)
        form.append('acidity',this.acidity)
        form.append('tannin',this.tannin)
        form.append('body',this.body)
      axios.post(`${SERVER}search`,form,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
    	}
    })
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content
    })

    },
    alcoholrange:function(){
var form = new FormData();
        form.append('keyword',this.input)
        form.append('page',this.page)
        form.append('type',this.items[this.type])
        form.append('pairing',this.pairings[this.pairing])
        form.append('price1',this.range[0])
        form.append('price2',this.range[1])
        form.append('alcohol1',this.alcoholrange[0])
        form.append('alcohol2',this.alcoholrange[1])
        form.append('rate','')
        form.append('sweetness',this.sweetness)
        form.append('acidity',this.acidity)
        form.append('tannin',this.tannin)
        form.append('body',this.body)
      axios.post(`${SERVER}search`,form,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
    	}
    })
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content
    })

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