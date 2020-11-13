<template>
<div>
 <div class="page-header clear-filter">
      <parallax
        class="page-header-image"
        style="background-image:url('img/wine-bottle-grapes.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="content-center brand">

          <h3>Guide for Wine Choice</h3>
        </div>
       
      </div>
    </div>
<v-app>

  <v-container>
  <div style="margin-top:10px">
  <v-row>
  <v-col cols="6">
  <v-img src="../../../public/img/purple-grapes-553462_1920.jpg">
  </v-img>
 
  
  </v-col>
    <v-col cols="6">
   <h3 style="font-weight:bold; ">01 와인 타입을 선택하세요</h3>
   <h5 class="text-m">
      레드, 화이트, 로제, 스파클링 중 그날의 컨디션이나 같이 곁들이는 안주를 고려해서 와인 타입을 정해보세요.
      <br><br>
    <v-btn
      rounded
      color="#750049"
      dark
    >
      와알못을 위한 와인 단계별...경험?
    </v-btn>
      </h5>
            <div class="text-center mt-2">
              <v-btn  href="/info" text>포도 품종이 궁금하다면? Go <v-icon>mdi-arrow-right</v-icon></v-btn>
            </div>
  </v-col>
  
  
  </v-row> 
  <v-row style="background-color:#FFDCFF">
  <v-col cols="6">
  
  <h2>포도 품종을 골라보세요</h2>
   <h5 class="text-m">
       포도 품종에 따라 wine type이 달라집니다!
      </h5>
            <div class="text-center mt-2">
              <v-btn  href="/info" text>포도 품종이 궁금하다면? Go <v-icon>mdi-arrow-right</v-icon></v-btn>
            </div>
  
  </v-col>
    <v-col cols="6">
    <v-img src="../../../public/img/purple-grapes-553462_1920.jpg">
  </v-img>
  
  </v-col>
  
  
  </v-row>


  </div>
   <v-card flat>
         
          <v-timeline
    align-top
    :dense="$vuetify.breakpoint.smAndDown"
  >
    <v-timeline-item
      v-for="(item, i) in beginners"
      :key="i"
      :color="item.color"
      :icon="item.icon"
      fill-dot
    >
      <v-card
        :color="item.color"
        dark
      >
        <v-card-title class="title">
          {{item.title}}
        </v-card-title>
        <v-card-text class="white text--primary">
          <p>{{item.content}}</p>
          
        </v-card-text>
      </v-card>
    </v-timeline-item>
  </v-timeline>
        </v-card>
   
    </v-container>

 
  </v-app>
  </div>

</template>
<script>

export default {
  name: 'Guide',
  bodyClass: 'index-page',
  components: {

  },
  data(){
      return{
        //wine list slider data
        show: false,
        tab: null,
        expand: false,
        items: [
        {
          color: 'red lighten-2',
          icon: 'mdi-star',
          title:'Choose your Wine Type',
          content:'먼저 자신이 화이트, 로제, 레드, 스파클링 중 어떤 와인을 원하는지 정하세요.'
        },
        {
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
          title:'Choose your Pairing',
          content:'와인과 곁들일 음식 종류를 선택하세요. 음식 종류에 따라 어울리는 와인이 달라집니다.'
        },
        {
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
          title:'Choose your Price',
          content:'가격대를 정하세요. 자신의 예산에 맞추어 그에 맞는 와인을 선택하세요.'
        },
        
      ],
      beginners: [
        {
          color: 'red lighten-2',
          icon: 'mdi-star',
          title:'달콤한 화이트 와인',
          content:'독일 모젤지방의 리슬링 와인종류와 같은 달콤한 화이트 와인을 먼저 도전해보세요. 향기로운 과일 향에 매료되면서 맛있다고 생각하게 될 것입니다.'
        },
        {
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
          title:'약간 드라이한 화이트 와인',
          content:'캘리포니아산 샤도네 혹은 호주산 샤도네를 즐겨보세요. 단맛을 싫어한다면 이 와인부터 시작해도 좋습니다.'
        },
        {
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
          title:'떫지 않은 가벼운 레드 와인',
          content:'프랑스 버건디 지역 특히 보졸레 지방에서 생산되는 와인들이나 이태리 와인들이 좋스비다.'
        },
        {
          color: 'indigo',
          icon: 'mdi-buffer',
          title:'부드럽고 약간 진하면서도 과일향이 풍부한 레드 와인',
          content:'호주산 쉬라즈나 까베르네 소비뇽, 미국산 진판델이나 멜로종류 혹은 멜로 포도품종이 많이 들어간 프랑스의 쌩떼밀리용지역에서 생산되는 와인을 시도해보세요.'
        },
         {
          color: 'pink',
          icon: 'mdi-glass-tulip',
          title:'타닌 맛이 강한 와인',
          content:'프랑스 보르도 와인이나 까베르네 소비뇽과 같은 포도 품종이 많이 사용된 와인들을 접해보세요. 이런 종류의 와인에 익숙해지게 된다면 you are not beginner anymore'
        },
      ],
      }
  }
};
</script>
<style scoped>


/* line 271, app/assets/stylesheets/home/theme.scss */
.background-pale-green {
  background-color: #E6F3E6;
}


/* line 103, app/assets/stylesheets/home/home.scss */
.home-main-section {
  padding: 6rem 0;
}

/* line 105, app/assets/stylesheets/home/home.scss */
.home-main-section .home-main-content {
  width: 1024px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

/* line 112, app/assets/stylesheets/home/home.scss */
.home-main-section .home-main-title {
  font-size: 4rem;
  line-height: 1.35;
  margin-bottom: 2.4rem;
}

/* line 117, app/assets/stylesheets/home/home.scss */
.home-main-section .home-buttons {
  margin-top: 3.2rem;
}

/* line 119, app/assets/stylesheets/home/home.scss */
.home-main-section .home-buttons .home-button {
  background-color: #F1F3F5;
  color: #212529;
  border: none;
  border-radius: 6px;
  text-decoration: none;
  padding: 1.45rem 2.6rem;
  display: inline-block;
}

/* line 127, app/assets/stylesheets/home/home.scss */
.home-main-section .home-buttons .home-button:hover {
  background-color: #E9ECEF;
}

/* line 132, app/assets/stylesheets/home/home.scss */
.home-main-section .home-main-image {
  display: inline-block;
}

/* line 134, app/assets/stylesheets/home/home.scss */
.home-main-section .home-main-image-01 {
  background-image: url(/assets/home/main/3x/image-1-39ac203e8922f615aa3843337871cb654b81269e872494128bf08236157c5f6a.png);
  background-size: 532px 684px;
  width: 532px;
  height: 684px;
}

/* line 140, app/assets/stylesheets/home/home.scss */
.home-main-section .home-main-image-02 {
  background-image: url(/assets/home/main/3x/image-2-f286322ab98acedf914a05bf77e84c67dcb897c8ccb543e66f6afea9d366d06d.png);
  background-size: 546px 740px;
  width: 546px;
  height: 740px;
}

/* line 146, app/assets/stylesheets/home/home.scss */
.home-main-section .home-main-image-03 {
  background-image: url(/assets/home/main/3x/image-3-0c8b631ac2294ac5a3b3e7a3a5580c3e68a3303ad2aded1e84aa57a2e1442786.png);
  background-size: 526px 735px;
  width: 526px;
  height: 735px;
}

/* line 153, app/assets/stylesheets/home/home.scss */
.home-main-section .home-main-reverse {
  display: flex;
  flex-direction: row-reverse;
  align-items: center;
}

/* line 158, app/assets/stylesheets/home/home.scss */
.home-main-section .home-hot-title {
  margin-bottom: 8rem;
}

/* line 161, app/assets/stylesheets/home/home.scss */
.home-main-section .home-hot-content {
  width: 1024px;
  margin: 6rem auto 12rem auto;
}

/* line 165, app/assets/stylesheets/home/home.scss */
.home-main-section .home-story-list {
  margin-top: 4rem;
  display: flex;
  justify-content: space-between;
  list-style-type: none;
}

/* line 170, app/assets/stylesheets/home/home.scss */
.home-main-section .home-story-list .home-story-list-item {
  margin-right: 4.6rem;
}

/* line 172, app/assets/stylesheets/home/home.scss */
.home-main-section .home-story-list .home-story-list-item:last-child {
  margin-right: 0;
}

/* line 176, app/assets/stylesheets/home/home.scss */
.home-main-section .home-story-list .icon-story {
  width: 56px;
  height: 56px;
  background-size: 56px 56px;
}

/* line 180, app/assets/stylesheets/home/home.scss */
.home-main-section .home-story-list .icon-story-01 {
  background-image: url(/assets/home/main/icon-story-1-9226479b836cdc960291ffda91ace46c90a632f6cc868aa8983b3624e662a924.svg);
}

/* line 183, app/assets/stylesheets/home/home.scss */
.home-main-section .home-story-list .icon-story-02 {
  background-image: url(/assets/home/main/icon-story-2-208bb88cad31e335b40bc8ac5b7684dcf8a36d77ac50770a497a9c967a3bfc4f.svg);
}

/* line 186, app/assets/stylesheets/home/home.scss */
.home-main-section .home-story-list .icon-story-03 {
  background-image: url(/assets/home/main/icon-story-3-0a14d64c6101a7271655747d8401b9f71506578f8a4c0640608074e977bbc7c0.svg);
}

/* line 192, app/assets/stylesheets/home/home.scss */
#home-main-section-top {
  margin-top: 72px;
  padding-top: 24px;
  background-color: #FBF7F2;
}

/* line 196, app/assets/stylesheets/home/home.scss */
#home-main-section-top #home-main-top {
  width: 1024px;
  height: 760px;
  margin: 0 auto;
  position: relative;
  background-color: #FBF7F2;
}

/* line 203, app/assets/stylesheets/home/home.scss */
#home-main-section-top .home-main-title {
  font-size: 4.8rem;
  line-height: 1.3;
  padding-top: 27rem;
  margin-bottom: 3.2rem;
  letter-spacing: -0.4px;
}

/* line 210, app/assets/stylesheets/home/home.scss */
#home-main-section-top .home-main-image-top {
  position: absolute;
  right: -84px;
  bottom: 0;
  width: 804px;
  height: 685px;
  background: #FBF7F2 url(/assets/home/main/3x/image-top-4eb6b8642f61c5c012136597a25a7b72c705d6c6479a7270f3fb23726fddf585.png) no-repeat;
  background-size: 804px 685px;
}

/* line 220, app/assets/stylesheets/home/home.scss */
.home-keywords-content {
  width: 1024px;
  margin: 4rem auto;
}

/* line 223, app/assets/stylesheets/home/home.scss */
.home-keywords-content .home-main-title {
  display: inline-block;
  vertical-align: middle;
}

/* line 227, app/assets/stylesheets/home/home.scss */
.home-keywords-content .top-keywords-list {
  display: inline-block;
  list-style-type: none;
  vertical-align: middle;
  margin-left: 4rem;
}

/* line 232, app/assets/stylesheets/home/home.scss */
.home-keywords-content .top-keywords-list .keyword-item {
  display: inline-block;
  vertical-align: middle;
  margin-right: 3.2rem;
}

/* line 236, app/assets/stylesheets/home/home.scss */
.home-keywords-content .top-keywords-list .keyword-item .keyword-link {
  text-decoration: none;
  color: #212529;
}

/* line 240, app/assets/stylesheets/home/home.scss */
.home-keywords-content .top-keywords-list .keyword-item:last-child {
  margin-right: 0;
}

/* line 243, app/assets/stylesheets/home/home.scss */
.home-keywords-content .top-keywords-list .keyword-item:hover {
  text-decoration: underline;
}

</style>
