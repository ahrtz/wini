<template>
  <div>
    <div class="page-header clear-filter" filter-color="orange">
      <parallax
        class="page-header-image"
        style="background-image:url('img/bg_profile.png')"
      >
      </parallax>
      <div class="container">
        
        <h3 class="title">이메일 혹은 닉네임</h3>
        <p class="category">등급 개인정보?</p>
        <div class="content">
          <div class="social-description">
            <h2>26</h2>
            <p>리뷰개수</p>
          </div>
          <div class="social-description">
            <h2>26</h2>
            <p>찜개수</p>
          </div>
          <div class="social-description">
            <h2>48</h2>
            <p>Bookmarks 뭔가 넣을게 없나?</p>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        
        <div class="row">
          <div class="col-md-6 ml-auto mr-auto">
            <h4 class="title text-center">My Wine Cellar</h4>
          </div>
          <tabs
            pills
            class="nav-align-center"
            tab-content-classes="gallery"
            tab-nav-classes="nav-pills-just-icons"
            type="primary"
          >
            <tab-pane title="Profile">
              <i slot="label" class="now-ui-icons design_image"></i>
              <h5 class="title text-center">리뷰리스트</h5>
              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">

                  <div class="col-md-4" v-for="item in reviews" :key="item.id">
                    <img src="img/bg6.jpg" class="img-raised" />
                    <v-card
                      title="Card Title"
                      img-src="img/bg6.jpg"
                      img-alt="Image"
                      img-top
                      tag="article"
                      style="max-width: 20rem;"
                      class="img-raised"
                    >
                      <v-card-text>
                        <h5>{{item.review.title}}</h5>
                        <br>
                        {{item.review.content}}
                      </v-card-text>
                    </v-card>
                    <!-- <img src="img/bg11.jpg" alt="" class="img-raised" /> -->
                  </div>
                  <!-- <div class="col-md-6">
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                  </div> -->
                </div>
              </div>
            </tab-pane>

            <tab-pane title="Home">
              <i slot="label" class="now-ui-icons location_world"></i>
              <h5 class="title text-center">위시리스트</h5>
              <!-- 호버 먹이기 위랑 아래 둘다  -->
              <div class="col-md-10 ml-auto mr-auto" >
                <div class="row collections">
                  <div class="col-md-6" v-for="item in wishes" :key="item.id">
                    <img src="img/bg1.jpg" alt="" class="img-raised" @click="$router.push({name:'product',params:{wid:item.wine.wid}})"/>
                    
                    {{item.wine.koname}}
                  </div>
                  
                </div>
              </div>
            </tab-pane>

            <tab-pane title="Messages">
              <i slot="label" class="now-ui-icons sport_user-run"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img src="img/bg3.jpg" alt="" class="img-raised" />
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                  </div>
                  <div class="col-md-6">
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
                    <img src="img/bg6.jpg" class="img-raised" />
                  </div>
                </div>
              </div>
            </tab-pane>
          </tabs>
        </div>
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
    }
  },
  async created(){
    // this.userid = this.$store.state.userid
    this.userid='bonobono'
    var form = new FormData()
    form.append('userid',this.userid)

    //리뷰 받아 오기 
    axios.post(`${SERVER}/review/getbyid`,form,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
      }}).then(res=>{
      console.log(res.data)
      this.reviews=res.data
      })
    // 찜 받아오기 
    

    axios.post(`${SERVER}/favorite/getbyid`,form,{headers: {
    		'Access-Control-Allow-Origin': '*',
    		'Content-Type': 'multipart/form-data; charset = utf-8'
      }}).then(res=>{
        this.wishes=res.data
      })
        
  }
};
</script>
<style></style>
