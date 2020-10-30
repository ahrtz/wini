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
      <p>와인 종류에 따른 포도 품종을 선택해보세요!</p>
      <v-row>
      <v-col cols="12">
      <v-card
    class="mx-auto"
    max-width="344"
  >


 <v-menu transition="scroll-x-transition">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="#750049"
          class="ma-2"
          v-bind="attrs"
          v-on="on"
        >
          Red Wine
        </v-btn>
      </template>
        <v-tabs vertical>
      <v-tab>
        까베르네 쇼비뇽
      </v-tab>
      <v-tab>

        말벡
      </v-tab>
      <v-tab>
        
        까르미네르
      </v-tab>
 <v-tab>
        
        멜롯
      </v-tab>
       <v-tab>
        
        쉬라즈
      </v-tab>
       <v-tab>
        
        피노누아
      </v-tab>
       <v-tab>
        
        산지오베제
      </v-tab>
       <v-tab>
        
        템쁘라니요
      </v-tab>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            <p>
              Sed aliquam ultrices mauris. Donec posuere vulputate arcu. Morbi ac felis. Etiam feugiat lorem non metus. Sed a libero.
            </p>

            <p>
              Nam ipsum risus, rutrum vitae, vestibulum eu, molestie vel, lacus. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Aliquam lobortis. Aliquam lobortis. Suspendisse non nisl sit amet velit hendrerit rutrum.
            </p>

            <p class="mb-0">
              Phasellus dolor. Fusce neque. Fusce fermentum odio nec arcu. Pellentesque libero tortor, tincidunt et, tincidunt eget, semper nec, quam. Phasellus blandit leo ut odio.
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            <p>
              Morbi nec metus. Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus, vitae iaculis lacus elit id tortor. Sed mollis, eros et ultrices tempus, mauris ipsum aliquam libero, non adipiscing dolor urna a orci. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Nunc sed turpis.
            </p>

            <p>
              Suspendisse feugiat. Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus, vitae iaculis lacus elit id tortor. Proin viverra, ligula sit amet ultrices semper, ligula arcu tristique sapien, a accumsan nisi mauris ac eros. In hac habitasse platea dictumst. Fusce ac felis sit amet ligula pharetra condimentum.
            </p>

            <p>
              Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Nam commodo suscipit quam. In consectetuer turpis ut velit. Sed cursus turpis vitae tortor. Aliquam eu nunc.
            </p>

            <p>
              Etiam ut purus mattis mauris sodales aliquam. Ut varius tincidunt libero. Aenean viverra rhoncus pede. Duis leo. Fusce fermentum odio nec arcu.
            </p>

            <p class="mb-0">
              Donec venenatis vulputate lorem. Aenean viverra rhoncus pede. In dui magna, posuere eget, vestibulum et, tempor auctor, justo. Fusce commodo aliquam arcu. Suspendisse enim turpis, dictum sed, iaculis a, condimentum nec, nisi.
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            <p>
              Fusce a quam. Phasellus nec sem in justo pellentesque facilisis. Nam eget dui. Proin viverra, ligula sit amet ultrices semper, ligula arcu tristique sapien, a accumsan nisi mauris ac eros. In dui magna, posuere eget, vestibulum et, tempor auctor, justo.
            </p>

            <p class="mb-0">
              Cras sagittis. Phasellus nec sem in justo pellentesque facilisis. Proin sapien ipsum, porta a, auctor quis, euismod ut, mi. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nam at tortor in tellus interdum sagittis.
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs>
    </v-menu>

  
  </v-card>
  </v-col>
   <v-col cols="12" sm="6">
      <v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      src="../../../public/img/pngwing.com (1).png"

    ></v-img>
 <v-card-actions>
   

      <v-spacer></v-spacer>
    <v-card-title>
      White Wine
    </v-card-title>

    

   

      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
         
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
  </v-col>
  </v-row>
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
        show: false,
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
          title:'Choose your Pairing',
          content:'와인과 곁들일 음식 종류를 선택하세요. 음식 종류에 따라 어울리는 와인이 달라집니다.'
        },
        {
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
          title:'Choose your Price',
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

</style>
