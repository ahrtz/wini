<template>
<div>

<v-app>
  <v-container class="pt-5">
  <div style="margin-top:100px">
    
  </div>
   <v-tabs
      v-model="tab"
      background-color=#750049
      color="white"
      grow
    >
      <v-tab
        
      >
        가성비 PICK
      </v-tab>
      <v-tab
        
      >
        How to read label
      </v-tab>
       <v-tab-item
      >
    
     <v-row>
     <p>이마트 2만원대 레드와인</p>
     <v-col cols="12">
     

     <v-card>
      <v-container
        fluid
        grid-list-lg
      >
        <v-layout row wrap>
        <v-flex xs12>
          
              <v-layout>
                <v-flex xs2>
                  <v-img
                    src="../../../public/img/pngegg.png"
                    height="200px"
                    contain
                  ></v-img>
                </v-flex>
                <v-flex xs5>
                  <v-card-title primary-title>
                    <div>
                      <div class="headline">Alvaro Palacios Villa de Corullon</div>
                      <div>꿀레레레레레레레레레레</div>
                      <div>(Red)</div>
                    </div>
                  </v-card-title>
                </v-flex>
                <v-flex xs4>
                  <v-card-text>
                    <div>
                    <template>
                    sweetness<n-progress :value="sweetness" type="primary" :height="15" show-value>{{sweetness}}</n-progress>
                  </template>
                  <template>
                    acidity<n-progress :value="acidity" type="primary" :height="15" show-value>{{acidity}}</n-progress>
                  </template>
                  <template>
                    tannin<n-progress :value="tannin" type="primary" :height="15" show-value>{{tannin}}</n-progress>
                  </template>
                  <template>
                    body<n-progress :value="body" type="primary" :height="15" show-value>{{body}}</n-progress>
                  </template>
                      
                      
                    </div>
                  </v-card-text>
                </v-flex>

              </v-layout>

             
           
          </v-flex>

        </v-layout>
      </v-container>


</v-card>
   </v-col>
     </v-row>
  
      </v-tab-item>
    <v-tab-item
      >
        <v-hover v-slot="{ hover }">
    <v-card
      class="mx-auto"
      color="grey lighten-4"
      max-width="600"
    >
      <v-img
        :aspect-ratio="16/9"
        src="https://cdn.vuetifyjs.com/images/cards/kitchen.png"
      >
        <v-expand-transition>
          <div
            v-if="hover"
            class="d-flex transition-fast-in-fast-out orange darken-2 v-card--reveal display-3 white--text"
            style="height: 100%;"
          >
            $14.99
          </div>
        </v-expand-transition>
      </v-img>
      <v-card-text
        class="pt-6"
        style="position: relative;"
      >
        <v-btn
          absolute
          color="orange"
          class="white--text"
          fab
          large
          right
          top
        >
          <v-icon>mdi-cart</v-icon>
        </v-btn>
        <div class="font-weight-light grey--text title mb-2">
          For the perfect meal
        </div>
        <h3 class="display-1 font-weight-light orange--text mb-2">
          QW cooking utensils
        </h3>
        <div class="font-weight-light title mb-2">
          Our Vintage kitchen utensils delight any chef.<br>
          Made of bamboo by hand
        </div>
      </v-card-text>
    </v-card>
  </v-hover>
      </v-tab-item>
    </v-tabs>
    </v-container>

 
  </v-app>
  </div>

</template>
<script>

export default {
  name: 'Info',
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
.v-card--reveal {
  align-items: center;
  bottom: 0;
  justify-content: center;
  opacity: .5;
  position: absolute;
  width: 100%;
}
</style>
