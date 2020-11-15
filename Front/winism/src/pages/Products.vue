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
                :src="imagesrc"
                v-if="imagesrc!=''"
              >
              </v-carousel-item>
              <v-carousel-item
              v-if="wineData.wine.type=='로제'||wineData.wine.type=='레드'"
                src="img/pngwing.com.png"
              >
              </v-carousel-item>
              <v-carousel-item
              v-if="wineData.wine.type=='화이트'||wineData.wine.type=='스파클링'"
                src="img/pngwing.comm.png"
              >
              </v-carousel-item>
              




          </v-carousel>
        </div>
        <div class="col-md-7 col-sm-12 col-xs-12">
          <div class="pl-6 ">
            <h2 style="font-weight:bold" class="mb-0">{{wineData.wine.koname}} </h2>
            <h3>({{wineData.wine.enname}})</h3>  <h5> Year {{wineData.wine.year}}</h5>
            <v-card-actions class="pa-0">
              <v-spacer></v-spacer>
                <v-btn
      fab
      dark
      small
      color="#750049"
      @click="CopyUrlToClipboard"
    >
      <v-icon dark>
        mdi-share-variant
      </v-icon></v-btn>
              <!-- <v-rating v-model="rating" class="" background-color="warning lighten-3"
                        color="warning" dense></v-rating> -->
              <span class="body-2	font-weight-thin " style="display: inline-block; width: 95%; text-align: right;"> <v-rating v-model="wineData.wine.rating"></v-rating>  {{reviews.length}}  REVIEWS</span>
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
            <v-tab >설명</v-tab>
            <v-tab >추천 음식</v-tab>
            <v-tab>리뷰</v-tab>
            <v-tab-item>
            <h5 class="pt-3">{{wineData.wine.description}}</h5>
            <h5 style="font-weight:bold">원산지</h5>
            <p>{{wineData.wine.local}}</p>
            <h5 style="font-weight:bold">추천 음용 온도</h5>
            <p>{{wineData.wine.temperature}}</p>
             
                <br>
                  <template>sweetness
                    <n-progress :value="parseInt(wineData.wine.sweetness)" type="primary" :height="15" show-value>{{wineData.wine.sweetness}}</n-progress>
                  </template>
                  <template>acidity
                    <n-progress :value="parseInt(wineData.wine.acidity)" type="primary" :height="15" show-value>{{wineData.wine.acidity}}</n-progress>
                  </template>
                  <template>tannin
                    <n-progress :value="parseInt(wineData.wine.tannin)" type="primary" :height="15" show-value>{{wineData.wine.tannin}}</n-progress>
                  </template>
                  <template>body
                    <n-progress :value="parseInt(wineData.wine.body)" type="primary" :height="15" show-value>{{wineData.wine.body}}</n-progress>
                  </template>
            </v-tab-item>
            <v-tab-item>
              <h5 class="pt-3">
               {{korean[wineData.wine.recommandation]}} 
              </h5>
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
                      
                      src="img/redwine.gif"
                      
                      
                    >
                    </v-img>
                    <div class="col-md-12 col-xs-12">
                      <h6 class="py-0 ">{{item.wine.koname}} </h6>
                    <v-card-text class="text--primary text-center">
                      <div>{{item.wine.type}} 와인</div>
                      <template>sweetness
                        <n-progress :value="parseInt(item.wine.sweetness)" type="primary" :height="15" show-value>{{item.wine.sweetness}}</n-progress>
                      </template>
                      <template>acidity
                        <n-progress :value="parseInt(item.wine.acidity)" type="primary" :height="15" show-value>{{item.wine.acidity}}</n-progress>
                      </template>
                      <template>tannin
                        <n-progress :value="parseInt(item.wine.tannin)" type="primary" :height="15" show-value>{{item.wine.tannin}}</n-progress>
                      </template>
                      <template>body
                        <n-progress :value="parseInt(item.wine.body)" type="primary" :height="15" show-value>{{item.wine.body}}</n-progress>
                      </template>
                    </v-card-text>
                    </div>
                    <div class="text-center col-12">
                      <v-btn
                        class="ma-2"
                        outlined
                        color="info"
                        @click="gotorecommend(item)"
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
  Button,Progress

} from '@/components';


export default {
    name:'Product',
    bodyClass: 'product-page',
    components: {
    [Button.name]: Button,
    [Progress.name]: Progress
    
  },
    data(){
        return {
          key:0,
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
        korean:{
          'pork':'돼지고기',
          'cheese':'치즈',
          'etc':'모든 음식',
          'dessert':'디저트',
          'lamb':'양',
          'fish':'생선',
          'poultry':'닭고기',
          'beef':'소고기',
          'vegetable':'채소',
          'instant':'인스턴트 식품',
          'duck':'오리고기',
          'western':'양식'

        }
        }
    },
    methods:{
      gotorecommend(item){
        this.$router.push({name:'product',params:{wid:item.wine.wid}})
        this.key = this.key+1
        this.$forceUpdate()

      },

      async addWishlist(){
        if (this.islogin==true){
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
      })  }else{
        alert('로그인 해야 할수 있슴다')
      }
      },
      //위시리스트 추가 끝

      addReviewData(){
        
        if (this.islogin==true){
          var form = new FormData();
          form.append('title',this.reviewData.title)
          form.append('content',this.reviewData.content)
          form.append('rating',this.reviewData.rating)
          form.append('userid',this.uid)// uid 는 회원 완성되면 vuex 에서
          form.append('winename',this.wineData.wine.koname)
          form.append('wid',this.wineData.wine.wid)
          axios.post(`${SERVER}review/register`,form,{headers: {
          'Access-Control-Allow-Origin': '*',
          'Content-Type': 'multipart/form-data; charset = utf-8'
        }}).then(res=>
        console.log(res)
        )}
        else{
          alert('로그인해주세요')
        }


      }
      //리뷰데이터 넣기
,
      //공유하기 버튼
      CopyUrlToClipboard() {
      const tmpInput = document.createElement('textarea');
      document.body.appendChild(tmpInput);
      tmpInput.value = window.document.location.href;
      tmpInput.select();
      document.execCommand('copy');
      document.body.removeChild(tmpInput);
      alert("URL이 클립보드에 복사되었습니다")
    },
    },
    computed:{
    islogin(){
      return  this.$store.getters.getlogin
    },
    imagesrc(){
      if (this.wineData.image != null){
        return this.wineData.image.replace(/ /gi,"%20")}
  
      else{
      //   if(this.wineData.wine.type=="레드"||this.wineData.wine.type=="로제"){
      //    return "img/pngwing.com.png"
      //   }
      //   else{
      //     return "img/pngwing.comm.png"
      // }
          return ""
      }
      } 
    },

    
    
    
    

    async created(){
      this.wineData={}
      this.uid = this.$store.state.userid
      
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
      var form = new FormData();
      form.append("wid",this.wineid)

    await axios.get(`${SERVER}recommend/bywine?wid=${this.wineid}`,{
      headers:{
        'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
        }
      }).then(res =>{
        console.log(res.data)
        this.recommend=res.data
      })

}}
</script>

<style scoped>



</style>
