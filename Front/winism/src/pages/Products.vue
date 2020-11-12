<template>
  <div>
       <div class="page-header clear-filter" filter-color="orange">
            <parallax
                class="page-header-image"
                style="background-image:url('img/bg_profile.png')"
            >
            </parallax>
      
        </div>
        <v-container>
      <div class="row">
        <div class="col-md-5 col-sm-12 col-xs-12">
          <v-carousel
          hide-delimiter-background
          cycle
          :show-arrows="false"
          >
              <v-carousel-item
                src="img/bg7.jpg"
              >
              </v-carousel-item>
              <v-carousel-item
                src="img/bg8.jpg"
              >
              </v-carousel-item>
              <v-carousel-item
                src="img/bg6.jpg"
              >
              </v-carousel-item>
            

          </v-carousel>
        </div>
        <div class="col-md-7 col-sm-12 col-xs-12">
          <div class="pl-6 ">
            <p class="display-4 mb-0">{{wineData.wine.koname}} <br> ({{wineData.wine.enname}}) <br> {{wineData.wine.year}}</p>
            <v-card-actions class="pa-0">
              <v-spacer></v-spacer>
              <!-- <v-rating v-model="rating" class="" background-color="warning lighten-3"
                        color="warning" dense></v-rating> -->
              <span class="body-2	font-weight-thin "> 앞에 별점? 25 REVIEWS</span>
            </v-card-actions>
            
            <div class="row">
            <v-btn v-if="this.wishTF==false" class=" col-6 m-0 p-1 " color="blue" outlined tile @click="addWishlist"> <v-icon>mdi-cart</v-icon>ADD TO WISHLIST></v-btn>
            <n-button v-if="this.wishTF" class=" col-6 m-0 p-1" type='danger ' simple outlined tile @click="addWishlist"> <v-icon>mdi-cart</v-icon>remove from WISHLIST</n-button>
            <v-app id="app" class="col-6 p-0">
              <v-dialog v-model="dialog" persistent>
                <template v-slot:activator="{on,attrs}">
                  <v-btn  v-bind="attrs" v-on="on" outlined tile dense > 리뷰 남기기</v-btn>
                </template>
                <v-card class="mx-auto">
                  <v-card-title>
                    <v-text-field label="제목"  hide-details="auto" v-model="reviewData.title"></v-text-field>
                  </v-card-title>
                  <v-divider></v-divider>
                  <v-card-actions> 
                    <v-spacer></v-spacer>
                    <v-rating v-model="reviewData.rating"></v-rating> 
                  </v-card-actions>
                  <v-card-text>
                    <v-textarea label="내용" v-model="reviewData.content" 
                    no-resize
                    height="140"
                    ></v-textarea>
                  </v-card-text>
                  <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    
                    outlined tile
                    @click="dialog = false;addReviewData()"
                  >
                    리뷰 등록
                  </v-btn>
                  <v-btn
                    
                    outlined tile
                    @click="dialog = false"
                  >
                    취소
                  </v-btn>

                </v-card-actions>
                </v-card>

              </v-dialog>
            </v-app>
            </div>
          </div>

        </div>
      </div>
      
      <div class="row">
        <div class="col-sm-12 col-xs-12 col-md-12">
          <v-tabs>
            <v-tab >Description</v-tab>
            <v-tab >와이너리 설명?</v-tab>
            <v-tab>REVIEWS</v-tab>
            <v-tab-item>
              <p class="pt-10 subtitle-1 font-weight-thin">
                와인에 대한 설명 
                어울리는 음식? 
                이건 따로 아이콘이나 그림을 모아서 일단 데이터를 보고 
              </p>
            </v-tab-item>
            <v-tab-item>
              <p class="pt-10 subtitle-1 font-weight-thin">
                와이너리? 설명? 
                뭐 등등 무엇이던지
              </p>
            </v-tab-item>
            <v-tab-item>
              <v-card v-for="review in reviews" :key="review.reviewid" class="row">
                  
                  <v-card-title>{{review.review.content}}</v-card-title>
                  <v-spacer></v-spacer>
                  <v-rating v-model="review.review.rating" readonly></v-rating>
                  
                  <v-card-text>{{review.review.content}}</v-card-text>
                  
              </v-card>
              
              
            </v-tab-item>
          </v-tabs>
          <v-card-text
            class="pa-0 pt-4"
            tile
            outlined
          >
            <p class="subtitle-1 font-weight-light pt-3 text-center">YOU MIGHT ALSO LIKE</p>
            <v-divider></v-divider>
            <div class="row text-center">
              <div class="col-md-3 col-sm-6 col-xs-12 text-center" v-for="item in recommend" :key="item.itemid">
                <v-hover
                  v-slot:default="{ hover }"
                  open-delay="200"
                >
                  <v-card
                    :elevation="hover ? 16 : 2"
                    
                  >
                    <v-img
                      class="white--text align-center col-md-12 col-xs-12"
                      
                      src="img/hero-image-2.png"
                      
                      
                    >
                    </v-img>
                    <div class="col-md-12 col-xs-12">
                      <h6 class="py-0 ">{{item.itemname}} </h6>
                    <v-card-text class="text--primary text-center">
                      <div>기타등등 정보</div>
                      <div>이건 기타등등 기타 등등 기타 등등의 정보가 옵니다</div>
                    </v-card-text>
                    </div>
                    <div class="text-center col-12">
                      <v-btn
                        class="ma-2"
                        outlined
                        color="info"
                      >
                        Explore
                      </v-btn>
                    </div>
                  </v-card>
                </v-hover>
              </div>

            </div>
          </v-card-text>
        </div>
      </div>
    </v-container>
    <v-card  class="accent" >
      
    </v-card>
  </div>
</template>

<script>
import axios from 'axios'
  const SERVER='http://k3a208.p.ssafy.io/api/'
  
import {
  Button,

} from '@/components';


export default {
    name:'Product',
    bodyClass: 'product-page',
    components: {
    [Button.name]: Button,
    
  },
    data(){
        return {
          uid:null,
          wishTF:null,
            wineid:null,
            dialog:false,
            items:'',
            wineData:null,
            item: [
              // 이건 사진
          {
            text: 'Admin',
            href: '#'
          },
          {
            text: 'Manage',
            href: '#'
          },
          {
            text: 'Library',
            active: true
          }
        ],
        recommend:[
          {
           itemid:1,
           itemname:'my name is pakr jin soo' 
          },
          {
           itemid:2,
           itemname:'your name is yoo se jung carbine sobinoung' 
          },
        ],
        reviews:{},
        reviewData:{
          title:'',
          content:'',
          rating:0
        },
        }
    },
    methods:{
      async addWishlist(){
        var form = new FormData();
        form.append('wid',this.wineid)
        form.append('uid',this.uid)
        //  uid 는 회원 완성되면 뷰엑스에서 받아와야 하고 이것도 if 절로 vuex 에서 처리해야함
        await axios.post(`${SERVER}favorite/add`,form,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
      }}).then(res=>{
          var form = new FormData();
          form.append("wid",this.wineid)
          form.append('uid',this.uid)
          //uid 추후 수정 필
          axios.post(`${SERVER}/favorite/check`,form,{
            headers:{
              'Access-Control-Allow-Origin': '*',
            'Content-Type': 'multipart/form-data; charset = utf-8'
            }
          }).then(res=>{
            console.log(res.data)
            this.wishTF=res.data
          })
      })  
      },
      //위시리스트 추가 끝
      addReviewData(){
        var form = new FormData();
        form.append('title',this.reviewData.title)
        form.append('content',this.reviewData.content)
        form.append('rating',this.reviewData.rating)
        form.append('userid',this.uid)// uid 는 회원 완성되면 vuex 에서
        form.append('winename',this.wineData.enname)
        form.append('wid',this.wineData.wid)
        axios.post(`${SERVER}review/register`,form,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
      }}).then(res=>
      console.log(res)
      )

      }
      //리뷰데이터 넣기
    },

    beforecreate(){
      this.uid = this.$store.state.userid
    }


    ,
    async created(){
      
      this.wineid = this.$route.params.wid;


      var form = new FormData();
      form.append("wid",this.wineid)
      console.log(this.wineid)
      // 와인데이터 받아오기
      await axios.post(`${SERVER}search/detail`,form,{
        
        headers: {
          'Access-Control-Allow-Origin': '*',
          'Content-Type': 'multipart/form-data; charset = utf-8'
        }
        }).then(res =>{
          this.wineData=res.data
        }).catch(e=>console.log(e))
      
      
      await axios.post(`${SERVER}review/getbywine`,form,{
        headers: {
          'Access-Control-Allow-Origin': '*',
          'Content-Type': 'multipart/form-data; charset = utf-8'
        }
      }).then(res=>{
        console.log(res.data)
      })
      var form = new FormData();
      form.append("wid",this.wineid)
      form.append('uid',this.uid)
      //uid 추후 수정 필
      await axios.post(`${SERVER}favorite/check`,form,{
        headers:{
          'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
        }
      }).then(res=>{
        console.log(res.data)
        this.wishTF=res.data
      })

    // 와인 id로 리뷰 데이터 받아오기 
      var form = new FormData();
      form.append("wid",this.wineid)
    await axios.post(`${SERVER}review/getbywine`,form,{
        headers:{
          'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
        }
      }).then(res=>{
        this.reviews=res.data
      })


}}
</script>

<style scoped>



</style>
