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

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-4" v-for="item in dummy" :key="item.id">
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
                        {{item.content}}
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

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img src="img/bg1.jpg" alt="" class="img-raised" />
                    <img src="img/bg3.jpg" alt="" class="img-raised" />
                  </div>
                  <div class="col-md-6">
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
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

export default {
  name: 'profile',
  bodyClass: 'profile-page',
  components: {
    Tabs,
    TabPane
  },
  data(){
    return{
      dummy:[
        {
          id:1,
          content:21
        },
        {
          id:2,
          content:22
        },
        {
          id:3,
          content:23
        },
        {
          id:4,
          content:24
        },
      ]
    }
  }
};
</script>
<style></style>
