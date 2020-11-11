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
<v-row>
<v-col cols="12">
<h4>가성비가 좋은 와인</h4>

<v-container fluid>
      <v-row dense>
        <v-col
          v-for="card in pick"
          :key="card.title"
          cols="12"
          sm="6"
          md="3"
        >
          <v-card max-width="374">
            <v-img
              :src="card.src"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="400px"
            >
              <v-card-title v-text="card.title"></v-card-title>
            </v-img>

            <v-card-text>
      <v-chip-group
        column
      >
         <v-chip v-if="card.type='red'" color="red"
      text-color="white">Red</v-chip>
      <v-chip v-else color="white"
      text-color="black">White</v-chip>

         <v-chip v-if="card.store='emart'" color="yellow"
      text-color="black">emart</v-chip>
      <v-chip v-else-if="card.store='gs25'" color="blue"
      text-color="black">GS25</v-chip>

        <v-chip>{{card.price}}</v-chip>
      </v-chip-group>
    </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  
<v-card

    class="mx-auto my-12"
  
  >
    <v-img
      src="../../../public/img/AlbertBichotBourgognePassetoutgrain.png"
    ></v-img>
  </v-card>
<Map/>
</v-col>


</v-row>
  </div>
    </v-container>

 
  </v-app>
  </div>

</template>
<script>
import {Progress} from '@/components'
import Map from './Map.vue'
export default {
  name: 'Recommend',
  bodyClass: 'index-page',
  components: {
      [Progress.name]: Progress,
      Map

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
        pick:[
          {title:'알베르 비쇼 부르고뉴 파스투그랭 2018',
          src:'../../../public/img/AlbertBichotBourgognePassetoutgrain.png',
          price:'20,000',
          store:'emart',
          type:'red'
          },
          {title:'미켈레 키아를로 바르베라 다스티레 오르메 2016',
          src:'../../../public/img/michele.jpg',
          price:'20,000',
          store:'emart',
          type:'red'
          },
          {title:'핀카 엘 오리헨 말벡 그랑 리제르바 2016',
          src:'../../../public/img/finca.jpg',
          price:'20,000',
          store:'emart',
          type:'red'
          },
          {title:'샤또 뿌피유 2013',
          src:'../../../public/img/poupille.jpg',
          price:'25,800',
          store:'emart',
          type:'red'
          },
          {title:'하디스 빈 619 카베르네 소비뇽 2019',
          src:'../../../public/img/poupille.jpg',
          price:'25,800',
          store:'emart',
          type:'red'
          },
        ]
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
