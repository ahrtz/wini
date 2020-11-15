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
         

            <v-divider></v-divider>

<div class="row">
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
                <v-flex xs2>
                  <v-img v-if="pro.type=='레드'"
                    src="img/redwine2.gif"
                    height="125px"
                    contain
                  ></v-img>
                  <v-img v-else
                    src="img/whitewine.gif"
                    height="125px"
                    contain
                  ></v-img>
                </v-flex>
                <v-flex xs6>
                  <v-card-title class="headline">
                    
                     <h6>{{pro.koname}}</h6>
                      <h6>{{pro.enname}}</h6>
    </v-card-title>
    <v-card-text class="pb-0">
            <v-chip v-if="pro.type=='레드'" color="#882814"
      text-color="white" dark><strong>레드</strong></v-chip>
      <v-chip v-else-if="pro.type=='화이트'" color="#f9e8c0"
      text-color="black"><strong>화이트</strong></v-chip>
      <v-chip v-else-if="pro.type=='로제'" color="#d19492"
      text-color="black"><strong>로제</strong></v-chip>
      <v-chip v-else color="#f5ecc4"
      text-color="black"><strong>{{pro.type}}</strong></v-chip></v-card-text>
<v-card-title class="pb-0">
                      <h6 v-if="pro.laestdegree!=='None'">알코올 {{pro.laestdegree}}</h6></v-card-title>
                      <v-card-title>
                      <h6 v-if="pro.local.includes('칠레')">칠레(Chile)</h6>
                      <h6 v-else-if="pro.local.includes('프랑스')">프랑스(France)</h6>
                      <h6 v-else-if="pro.local.includes('미국')">미국(USA)</h6>
                      <h6 v-else-if="pro.local.includes('이탈리아')">이탈리아(Italy)</h6>
                      <h6 v-else-if="pro.local.includes('스페인')">스페인(Spain)</h6>
                      <h6 v-else-if="pro.local.includes('크로아티아')">크로아티아(Croatia)</h6>
                      <h6 v-else-if="pro.local.includes('뉴질랜드')">뉴질랜드(New Zealand)</h6>
                      </v-card-title>
            <v-card-text>
                    <v-chip v-if="pro.cost!=='0'"><strong>&#8361;{{pro.cost}}</strong></v-chip></v-card-text>

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
        pairing:0,
        //wine taste
        sweetness:0,
        body:0,
        tannin:0,
        acidity:0,
        alcoholrange:[10,20],

        range: [0, 100000],
        select: 'Popularity',
      
        page: 1,
        min: 0,
        max: 100000,
        items: ['Red','White','Rose','Sparkling'

        ],
        koreanitems:['레드','화이트','로제','스파클링'],
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
      getImg(pro){
        axios.get(`http://k3a208.p.ssafy.io/images/${pro}`,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
    	}
    })
        .then(res=>{
          if(res===null){
            return "img/pngwing.com.png"

          }
          else{
            return res.data
          }

        }
          
        )

      },
    submit(){
      axios.get(`${SERVER}search?keyword=${this.input}&page=${this.page}`,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
    	}
    })
      .then(res=>{
        console.log(res)
        this.winelist=res.data.content
        })
      .catch(err=>console.log(err))

    },
    checknull(some){
      if(some===null || some===0){
        return false
      }
      else{
        return true
      }

    },
    changeto(){
      var url=`${SERVER}search?page=${this.page}&type=${this.koreanitems[this.type]}&price1=${this.range[0]}&price2=${this.range[1]}&alcohol1=${this.alcoholrange[0]}&alcohol2=${this.alcoholrange[1]}`
      if(this.checknull(this.input)){
        url+=`&keyword=${this.input}`
      }
      if(this.checknull(this.pairing)){
        url+=`&pairing=${this.pairings[this.pairing]}`
      }
      if(this.checknull(this.sweetness)){
        url+=`&sweetness=${this.sweetness}`
      }
      if(this.checknull(this.acidity)){
        url+=`&acidity=${this.acidity}`
      }
      if(this.checknull(this.tannin)){
        url+=`&tannin=${this.tannin}`
      }
      if(this.checknull(this.body)){
        url+=`&body=${this.body}`
      }
      console.log(url)
     axios.get(url,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
    	}
    })
    .then(res=>{
      if(res.data.content.length==0){
        alert('nothing matches')
      }
      else{
this.winelist=res.data.content
      }
      
      
    })
 
    
    }
    
 
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
      this.changeto()

    },
    sweetness:function(){
    this.changeto()
    },
    body:function(){
this.changeto()

    },
    tannin:function(){
this.changeto()
    },
    acidity:function(){
    this.changeto()

    },
    type:function(){
      this.changeto()
    
    },
    pairing:function(){
this.changeto()

    },
    alcoholrange:function(){
this.changeto()
    },
    page:function(){
this.changeto()
    }

  },
   mounted(){
    axios.get(`${SERVER}search?keyword= `,{
    	headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
    	}
    })
    .then(res=>{
      console.log(res)
      this.winelist=res.data.content

    })
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