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
  <v-container class="pt-5">
  <div style="margin-top:10px">
    
  </div>
   <v-tabs
      v-model="tab"
      background-color=#750049
      color="white"
      grow
    >
      <v-tab
        
      >
        For Beginner
      </v-tab>
      <v-tab
        
      >
        For Pro
      </v-tab>
       <v-tab-item
      >
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
      </v-tab-item>
    <v-tab-item
      >
        <v-card flat>
         
          <v-timeline
    align-top
    :dense="$vuetify.breakpoint.smAndDown"
  >
    <v-timeline-item
      v-for="(item, i) in items"
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
      </v-tab-item>
    </v-tabs>
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
        tab: null,
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
          title:'Choose your Wine Type',
          content:'와인과 곁들일 음식 종류를 선택하세요. 음식 종류에 따라 어울리는 와인이 달라집니다.'
        },
        {
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
          title:'Choose your Wine Type',
          content:'가격대를 정하세요. 자신의 예산에 맞추어 그에 맞는 와인을 선택하세요.'
        },
        {
          color: 'indigo',
          icon: 'mdi-buffer',
          title:'Choose your Wine Type',
          content:'먼저 자신이 화이트, 로제, 레드, 스파클링 중 어떤 와인을 원하는지 정하세요.'
        },
      ],
      beginners: [
        {
          color: 'red lighten-2',
          icon: 'mdi-star',
          title:'딜콤한 화이트 와인',
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
          color: 'violet',
          icon: 'mdi-food-variant',
          title:'타닌 맛이 강한 와인',
          content:'프랑스 보르도 와인이나 까베르네 소비뇽과 같은 포도 품종이 많이 사용된 와인들을 접해보세요. 이런 종류의 와인에 익숙해지게 된다면 you are not beginner anymore'
        },
      ],
      }
  }
};
</script>
<style scoped>

</style>
