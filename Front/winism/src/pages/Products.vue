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
            <p class="display-1 mb-0">Modern Black T-Shirt</p>
            <v-card-actions class="pa-0">
              <v-spacer></v-spacer>
              <!-- <v-rating v-model="rating" class="" background-color="warning lighten-3"
                        color="warning" dense></v-rating> -->
              <span class="body-2	font-weight-thin "> 앞에 별점? 25 REVIEWS</span>
            </v-card-actions>
            <div class="row">
            <v-btn class=" col-6" outlined tile>ADD TO WISHLIST</v-btn>
            <v-app id="app" class="col-6 p-0">
              <v-dialog v-model="dialog" persistent>
                <template v-slot:activator="{on,attrs}">
                  <v-btn  v-bind="attrs" v-on="on" outlined tile dense ><v-icon>mdi-cart</v-icon> 리뷰 남기기</v-btn>
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
                    <v-text-field label="내용" v-model="reviewData.content"></v-text-field>
                  </v-card-text>
                  <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    text
                    @click="dialog = false"
                  >
                    리뷰 등록
                  </v-btn>
                  <v-btn
                    text
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
                  
                  <v-card-title>{{review.content}}</v-card-title>
                  <v-spacer></v-spacer>
                  <v-rating v-model="review.rate" readonly></v-rating>
                  
                  <v-card-text>{{review.content}}</v-card-text>
                  
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
export default {
    name:'Product',
    bodyClass: 'product-page',
    data(){
        return {
            dialog:false,
            items:'',
            item: [
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
        reviews:[
          {
            reviewid:1,
            content:"내용1 이게 길어지면 어떻게 될 것인가 낭는 정말 잘 모르겟구나 ",
            rate:3,
            
          },
          {
            reviewid:2,
            content:'내용2',
            rate:4
          },
        ],
        reviewData:{
          title:'',
          content:'',
          rating:0
        },
        }
    }

}
</script>

<style scoped>


  

</style>
