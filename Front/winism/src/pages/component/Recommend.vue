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

          <h3>나에게 맞는 와인을 추천받아보세요!</h3>
        </div>
       
      </div>
    </div>
<v-app>
  <v-container class="pt-5">
  <div style="margin-top:10px">
  <h5 style='font-weight:bold;'>{{this.uid}}님의 와인 취향은 다음과 같습니다</h5>
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
                  <v-img v-if="pro['image']!=='null'"
                    :src="pro.image"
                    height="125px"
                    contain
                  ></v-img>
                  <v-img v-else
                    src="../../../public/img/AlbertBichotBourgognePassetoutgrain.png"
                    height="125px"
                    contain
                  ></v-img>
                </v-flex>
                <v-flex xs6>
                  <v-card-title class="headline">
                    
                     <h6>{{pro['wine'].koname}}</h6>
                      <h6>{{pro['wine'].enname}}</h6>
    </v-card-title>
    <v-card-text>
            <v-chip v-if="pro['wine'].type=='레드'" color="#882814"
      text-color="white" dark><strong>레드</strong></v-chip>
      <v-chip v-else-if="pro['wine'].type=='화이트'" color="#f9e8c0"
      text-color="black"><strong>화이트</strong></v-chip>
      <v-chip v-else-if="pro['wine'].type=='로제'" color="#d19492"
      text-color="black"><strong>로제</strong></v-chip>
      <v-chip v-else color="#f5ecc4"
      text-color="black"><strong>{{pro['wine'].type}}</strong></v-chip>    </v-card-text>

                      <h6 v-if="pro['wine'].laestdegree!=='None'">알코올 {{pro['wine'].laestdegree}}</h6>
                      <h6 v-if="pro['wine'].local.includes('칠레')">칠레(Chile)</h6>
                      <h6 v-else-if="pro['wine'].local.includes('프랑스')">프랑스(France)</h6>
                      <h6 v-else-if="pro['wine'].local.includes('미국')">미국(USA)</h6>
                      <h6 v-else-if="pro['wine'].local.includes('이탈리아')">이탈리아(Italy)</h6>
                      <h6 v-else-if="pro['wine'].local.includes('스페인')">스페인(Spain)</h6>
                      <h6 v-else-if="pro['wine'].local.includes('크로아티아')">크로아티아(Croatia)</h6>
                    <v-chip v-if="pro['wine'].cost!=='0'"><strong>&#8361;{{pro['wine'].cost}}</strong></v-chip>

                </v-flex>
                <v-flex xs4>
                  <v-card-text>
                    <div>
                    <template>sweetness
                    <n-progress :value="parseInt(pro['wine'].sweetness)" type="primary" :height="15" show-value>{{pro['wine'].sweetness}}</n-progress>
                  </template>
                  <template>
                    acidity<n-progress :value="parseInt(pro['wine'].acidity)" type="primary" :height="15" show-value>{{pro['wine'].acidity}}</n-progress>
                  </template>
                  <template>
                    tannin<n-progress :value="parseInt(pro['wine'].tannin)" type="primary" :height="15" show-value>{{pro['wine'].tannin}}</n-progress>
                  </template>
                  <template>
                    body<n-progress :value="parseInt(pro['wine'].body)" type="primary" :height="15" show-value>{{pro['wine'].body}}</n-progress>
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
<v-row>
<v-col cols="12">
<h4 style='font-weight:bold'>마트별 가성비가 좋은 와인</h4>
<h5>추천 목록 밑의 편의점 버튼을 누르면 내 위치 주변의 편의점이 보입니다!</h5>


<Map :store="store"/>
</v-col>

<v-col cols="12">

 <v-sheet
    class="mx-auto"
    max-width="700"
  >
    <v-slide-group
      multiple
      show-arrows
    >
      <v-slide-item
        v-for="card in pick"
        :key="card.id"
        v-slot="{ active, toggle }"
      >
      
        <v-card max-width="374" @click="toggle" :input-value="active">
            <v-img
              :src="card.src"
              class="align-end"

              height="400px"
            >
              <v-card-title v-text="card.title"></v-card-title>
            </v-img>

            <v-card-text>
      <v-chip-group
        column
      >
         <v-chip v-if="card.type==='red'" color="#882814"
      text-color="white">Red</v-chip>
      <v-chip v-else color="#f9e8c0"
      text-color="black">White</v-chip>

         <v-chip v-if="card.store==='emart'" color="#FFB900"
      text-color="black" @click="changestore('emart')">emart</v-chip>
      <v-chip v-else-if="card.store==='GS25'" color="#0064FF"
      text-color="#50C2FF" @click="changestore('GS25')">GS25</v-chip>
       <v-chip v-else color="#800080"
      text-color="#64CD3C" @click="changestore('CU')">CU</v-chip>


        <v-chip>&#8361;{{card.price}}</v-chip>
      </v-chip-group>
    </v-card-text>
          </v-card>
      </v-slide-item>
    </v-slide-group>
  </v-sheet>
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
const SERVER='http://k3a208.p.ssafy.io/api/'
import axios from 'axios'
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
        winelist:[],
        uid:null,
        store:'GS25',
             model: null,

       
        pick:[
          {title:'알베르 비쇼 부르고뉴 파스투그랭 2018',
          src:require('../../../public/img/AlbertBichotBourgognePassetoutgrain.png'),
          price:'20,000',
          store:'emart',
          type:'red'
          },
          {title:'미켈레 키아를로 바르베라 다스티레 오르메 2016',
          src:require('../../../public/img/michele.jpg'),
          price:'20,000',
          store:'emart',
          type:'red'
          },
          {title:'핀카 엘 오리헨 말벡 그랑 리제르바 2016',
          src:require('../../../public/img/finca.jpg'),
          price:'20,000',
          store:'emart',
          type:'red'
          },
          {title:'샤또 뿌피유 2013',
          src:require('../../../public/img/poupille.jpg'),
          price:'25,800',
          store:'emart',
          type:'red'
          },
          {title:'하디스 빈 619 카베르네 소비뇽 2019',
          src:require('../../../public/img/hadis.jpg'),
          price:'14,900',
          store:'GS25',
          type:'red'
          },
          {title:'알파카 카베르네 메를로',
          src:require('../../../public/img/alpaca.jpg'),
          price:'11,000',
          store:'CU',
          type:'red'
          },
           {title:'칸티 모스카토 콜레지오네 디 파밀리아',
          src:require('../../../public/img/canti.jpg'),
          price:'15,000',
          store:'emart',
          type:'white'
          },
          {title:'에라주리즈, 맥스 리제르바 카베르네 소비뇽',
          src:require('../../../public/img/errazuriz.jpg'),
          price:'25,900',
          store:'GS25',
          type:'red'
          },
          {title:'카멜 로드, 몬테레이 피노누아',
          src:require('../../../public/img/camelroad.jpg'),
          price:'35,000',
          store:'GS25',
          type:'red'
          },
          {title:'네이처 사운드',
          src:require('../../../public/img/naturesound.jpg'),
          price:'9,900',
          store:'GS25',
          type:'red'
          },
          {title:'세크레토 말벡',
          src:require('../../../public/img/secreto.jpg'),
          price:'19,900',
          store:'CU',
          type:'red'
          },
           {title:'발데파블로 상그리아 레드',
          src:require('../../../public/img/sangria.jpg'),
          price:'3,700',
          store:'GS25',
          type:'red'
          },
          {title:'솔데빠냐스 비노 블랑코',
          // src:require('../../../public/img/soldepenas.jpg'),
          price:'3,700',
          store:'GS25',
          type:'red'
          },
        ]
      }
  },
  methods:{
    changestore(some){
      this.store=some
    }

  },
  mounted(){
    this.uid = this.$store.state.userid
    axios.get(`${SERVER}recommend/byfavoandreview?userid=${this.uid}`)
    .then(res=>{
      console.log(res)
      this.winelist=res.data

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
