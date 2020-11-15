<template>
  <div>

    <div class="page-header clear-filter">
      <parallax
        class="page-header-image"
        style="background-image:url('img/bg_profile.png')"
      >
      </parallax>
      <div class="container">
        
        <h3 class="title">{{userid}}</h3>
        
        <div class="content">
          <div class="social-description">
            <h2>{{reviews.length}}</h2>
            <p>리뷰개수</p>
          </div>
          <div class="social-description">
            <h2>{{wishes.length}}</h2>
            <p>찜개수</p>
          </div>

        </div>
      </div>
    </div>
      <div class="container">
        
        <div class="row">
          <div class="col-md-6 ml-auto mr-auto">
            <h4 class="title text-center">My Wine Cellar</h4>
          </div>
           
          <tabs
            pills
            class="nav-align-center ml-auto mr-auto row"
            tab-nav-classes="nav-pills-just-icons"
            type="primary"
            tabContentClasses="tab-subcategories"
        centered 
          >
      <v-app>
            <tab-pane title="Home" v-if="reviews.length > 0">
              <i slot="label" class="mdi mdi-cloud"></i>
              <h5 class="title text-center">Review List</h5>
              <v-row>
        <v-col
          v-for="card in reviews"
          :key="card.id"
          cols="6"
        >
          <v-card>
            <v-img
              src="img/redwine2.gif"
              height="300px"
            >
             
            </v-img>

               <v-card-text>
                        <h5 style="font-weight:bold">{{card.review.winename}}</h5>
                        <br>
                        {{card.review.content}}
                        <br>
                        {{card.review.rating}}
                      </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
               <v-dialog v-model="dialog" persistent>
             <template v-slot:activator="{on,attrs}">
                                <v-btn  color="#750049" dark v-bind="attrs" v-on="on" > 수정</v-btn>
                                  </template>
                                  <v-card class="mx-auto">
                                <v-card-title>
                                  <v-text-field label="제목"  hide-details="auto" v-model="card.review.title"></v-text-field>
                                </v-card-title>
                                <v-divider></v-divider>
                                <v-card-actions> 
                                  <v-spacer></v-spacer>
                                  <v-rating v-model="card.review.rating"></v-rating> 
                                </v-card-actions>
                                <v-card-text>
                                  <v-textarea label="내용" v-model="card.review.content" 
                                  no-resize
                                  height="140"
                                  ></v-textarea>
                                </v-card-text>
                                <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn
                                  primary
                                  outlined tile
                                  @click="dialog = false;updateReview(card)"
                                >
                                  리뷰 수정
                                </v-btn>
                                <v-btn
                                  
                                  outlined tile
                                  @click="dialog = false"
                                >
                                  삭제
                                </v-btn>

                              </v-card-actions>
                              </v-card>

                              </v-dialog>
                                <v-btn color="#750049" dark @click="deleteReview(card)"> 삭제 </v-btn>
                            
            </v-card-actions>
            
          </v-card>
        </v-col>
      </v-row>
            </tab-pane>

<tab-pane title="Home" v-if="wishes.length > 0">
              <i slot="label" class="mdi mdi-heart"></i>
              <h5 class="title text-center">Wish List</h5>
<v-row dense>
        <v-col
          v-for="card in wishes"
          :key="card.id"
          cols="6"
        >
          <v-card>
            <v-img
              src="img/whitewine.gif"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="300px"
            >
              <v-card-title>{{card.wine.koname}}</v-card-title>
            </v-img>

            <v-card-actions>
              <v-spacer></v-spacer>

             <v-btn color="#750049" dark @click="$router.push({name:'product',params:{wid:card.wine.wid}})">Go Detail</v-btn>
              <v-btn color="#750049" dark @click="removeWish(card)">위시리스트에서 삭제</v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
            
              <!-- 호버 먹이기 위랑 아래 둘다  -->
             
            </tab-pane>
            
            <tab-pane title="Home" >
              <i slot="label" class="mdi mdi-glass-flute"></i>
              <h5 class="title text-center">You might also like</h5>
              <v-row dense>
        <v-col
          v-for="card in recommends"
          :key="card.id"
          cols="6"
        >
          <v-card>
            <v-img
              src="img/redwine.gif"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="300px"
            >
              <v-card-title>{{card.wine.koname}}</v-card-title>
            </v-img>

            <v-card-actions>
              <v-spacer></v-spacer>

             <v-btn color="#750049" dark @click="$router.push({name:'product',params:{wid:card.wine.wid}})">Go Detail</v-btn>

            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
              
            </tab-pane>
</v-app>
            

            
          </tabs>
        </div>
      </div>

  </div>
</template>
<script>
import { Tabs, TabPane } from '@/components';
import axios from 'axios'
import { Form } from 'element-ui';
  const SERVER='http://k3a208.p.ssafy.io/api/'
export default {
  name: 'profile',
  bodyClass: 'profile-page',
  components: {
    Tabs,
    TabPane
  },
  data(){
    return{
      userid:null,
      reviews:{},
      wishes:{},
      dialog:false,
      recommends:{}
    }
  },
  async created(){
    this.userid = this.$store.state.userid
    // this.userid='bonobono'
    var form = new FormData()
    form.append('userid',this.userid)

    //리뷰 받아 오기 
    axios.post(`${SERVER}review/getbyid`,form,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
      }}).then(res=>{
      // console.log(res.data)
      this.reviews=res.data
      })
    // 찜 받아오기 
    

    axios.post(`${SERVER}favorite/getbyid`,form,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
      }}).then(res=>{
        this.wishes=res.data
      })
    
    axios.get(`${SERVER}recommend/byfavoandreview?userid=${this.userid}`,{
      headers:{
        'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'application/json; charset = utf-8'
        }
      }).then(res=>{
        console.log(res)
        this.recommends = res.data
      })
  },
  methods:{
    updateReview(item){
      console.log(item)
       var form = new FormData();
          form.append('title',item.review.title)
          form.append('content',item.review.content)
          form.append('rating',item.review.rating)
          form.append('userid',item.review.userid)// uid 는 회원 완성되면 vuex 에서
          form.append('winename',item.review.winename)
          form.append('wid',item.review.wid)
          form.append('rid',item.review.rid)

      axios.post(`${SERVER}review/update`,form,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
      }}).then(res=>{
        // console.log(res)
        var form = new FormData()
          form.append('userid',this.userid)

          //리뷰 받아 오기 
          axios.post(`${SERVER}review/getbyid`,form,{headers: {
              'Access-Control-Allow-Origin': '*',
              'Content-Type': 'multipart/form-data; charset = utf-8'
            }}).then(res=>{
            console.log(res.data)
            this.reviews=res.data
            }).catch(e =>{console.log(e)})
      }).catch(e=>console.log(e))      
    },
    deleteReview(item){
      var form = new FormData()
      form.append('rid',item.review.rid)
      axios.post(`${SERVER}review/delete`,form,{headers: {
              'Access-Control-Allow-Origin': '*',
              'Content-Type': 'multipart/form-data; charset = utf-8'
            }}).then(res => {
              var form = new FormData()
                form.append('userid',this.userid)

                //리뷰 받아 오기 
                axios.post(`${SERVER}review/getbyid`,form,{headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Content-Type': 'multipart/form-data; charset = utf-8'
                  }}).then(res=>{
                  // console.log(res.data)
                  this.reviews=res.data
                  })
            })
    },
    async removeWish(item){
      var form = new FormData()
      
      form.append('uid',this.userid)
      form.append('wid',item.wine.wid)
      await axios.post(`${SERVER}favorite/add`,form,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
      }}).then(res=>{
        // console.log(res)
          var form = new FormData()
          form.append('userid',this.userid)

            axios.post(`${SERVER}favorite/getbyid`,form,{headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'multipart/form-data; charset = utf-8'
          }}).then(res=>{
            this.wishes=res.data
          })
      })
    }
  }
};
</script>
<style></style>
