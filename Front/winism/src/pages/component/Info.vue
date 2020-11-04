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
        포도 품종
      </v-tab>
      <v-tab
        
      >
        How to read label
      </v-tab>
       <v-tab-item
      >
<v-row>
      <v-col cols="6">
       <v-col
        class="d-flex"
        cols="12"
        sm="6"
      >
        <v-select
          :items="select"
          label="Solo field"
          solo
        ></v-select>
      </v-col>
 <v-menu offset-y :close-on-content-click="false">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="#750049"
          v-bind="attrs"
          v-on="on"
          dark
        >
          Red Wine
        </v-btn>
      </template>
        <v-tabs vertical >
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

          <v-card-text>
            <v-card-text>
            <p>
              떫음, 농도감 있음
            </p>
            <p>
              와인을 만들 때 가장 많이 사용하는 포도 품종이 바로 까르베네 소비뇽입니다. 까르베네 쇼비뇽 품종은 숙성 정도와 원산지에 따라서 맛이 천차만별이기 때문에 어떻다!라고 말씀드릴 수는 없습니다. 그러나 초심자의 입장에서 너무 드라이하거나 떫지 않고 또 너무 묽지도 않은 우리가 생각하는 스탠더드를 찾고자 한다면 까르베네 쇼비뇽을 선택하시면 그 확률이 높아집니다.
            </p>
            <p>
            실제로도 모든 레드와인 중에서 가장 많은 생산량을 차지하고 있습니다. 어떠한 기후에서도 잘 견디는 특징 때문에 전 세계 어디에서나 재배되면서 다양한 맛을 보여주고 가장 많은 사랑을 받는 와인입니다.

이 포도 품종의 가장 큰 특징은 바로 껍질이 두껍고 씨앗이 많다는 것입니다. 우리가 그냥 포도를 먹는다면 이건 별로 좋지 않은 포도입니다. 그러나 포도주를 만들 때는 아주 큰 장점이 되기도 합니다. 두꺼운 껍질이 포도가 빨리 썩지 않게 만들어서 오랜 기간 동안 숙성과 발효를 거칠 수 있게 만듭니다. 
            </p>
            <p>
            그래서 까르베네 소비뇽 품종은 오크통에 아주 오랫동안 숙성시킬 수 있는 포도입니다. 두꺼운 껍질과 많은 포도씨는 탄닌을 포함하고 있어서 떫은맛을 낼 수도 있는데요 그러나 오랫동안 숙성할수록 이러한 떫은맛들이 부드러워지고 색상에서는 다양한 과일의 맛과 향을 낼 수 있는 향기로운 와인이 될 수 있습니다. 
            </p>
          </v-card-text>

          
          </v-card-text>
  
      </v-tab-item>
      <v-tab-item >
        <v-card flat>
          <v-card-text>
            <p>
             떫고 진하고 풍부한 맛
            </p>

         
           
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            <p>
              적당한 농도감과 부드러움
            </p>

            
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
       <v-card flat>
          <v-card-text>
            <p>
              떫지 않고 부드러움
            </p>

            <p >
             그다음으로 레드와인에서 많이 보이는 포도 품종은 바로 멜롯입니다. 자극적인 와인을 좋아하는 제가 그다지 선호하지 않는 품종이기는 하나 와인 초심자로서 가볍고 부드러운 와인을 추구하신다면 멜롯 품종 와인 추천드립니다.
            </p>
            <p>
            까르베네 소비뇽과 비교해 봤을 때는 포도 과육이 더 많은데 껍질은 얇습니다. 수분과 당분이 훨씬 많아서 씨앗도 별로 없습니다. 그러다 보니 떫은맛이 덜합니다. 보통 오랜 숙성을 거치기보다는 짧게 숙성하여도 맛있는 와인이 됩니다. 와인의 유통기한도 짧기 때문에 빨리 마셔야 한다는 단점이 있습니다. 만약 와인의 떫은맛이 싫으신 분들이라면 멜롯와인을 강력 추천드립니다. 
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
          <v-tab-item>
       <v-card flat>
          <v-card-text>
            <p>
              호주가 주 품종. 칠레프랑스도 있음. 달지 않고 떫은정도는 상품별로 다름. 살짝 떫은 느낌 있음 스파이시한 향신료 항이 있음
            </p>

            <p >
             쉬라즈라고 불리는 이 품종은 까르베네 소비뇽보다 더 두꺼운 껍질과 더 많은 포도씨를 갖고 있습니다. 강렬한 탄닌의 맛을 즐기고 싶다면, 혹은 저처럼 자극적이고 진한 와인을 좋아하신다면 쉬라 품종의 와인을 추천드립니다. 알코올 함량도 높은 편이라서 드라이하다고도 불립니다. 보통 산도가 낮이라서 신맛은 덜합니다. 매콤하다고도 사람들이 부를 만큼 자극적인 맛인데 동시에 과일향을 풍기기도 합니다. 산지마다 조금씩 맛이 달라지기도 합니다. 프랑스에서는 스모크 한 냄새와 허브향이 있다고 하는데 호주의 쉬라는 더 부드럽고 감칠맛이 있다고 합니다. 가장 많이 생산하는 국가는 호주이며 저렴하지만 퀄리티가 뛰어난 와인을 대량 생산하고 있습니다. 
            </p>
            
          </v-card-text>
        </v-card>
      </v-tab-item>
         <v-tab-item>
       <v-card flat>
          <v-card-text>
            <p>
              와인 중에 가장 가볍고 떫지않은 품종. 멜롯이랑 비슷한데 더 가벼움
            </p>

            <p >
             비싼 와인이라고 한다면 피노누아를 많이 생각합니다. 피노누아 품종이 비싼 이유는 이 포도 품종이 아무데서나 잘 적응하지 못하기 때문입니다. 주로 서늘한 기후에서 잘 재배되는데 프랑스의 부르고뉴 지방의 피노누아를 최고로 쳐주고는 합니다. 피노누아는 껍질이 얇고 포도 줄기가 적어서 탄닌이 적습니다.
            </p>
            <p>
            그만큼 떫은맛은 없어지는데 또 이 맛의 깊이는 라이트 하지 않습니다. 피노 누아의 Noir는 검은색을 뜻할 만큼 검은색에 가까운 붉은색을 띠고 있습니다. 이 포도 품종에서는 정말 다양한 과일과 꽃향기, 그리고 짙은 버섯과 흙의 냄새까지 난다고 합니다. 부드럽지만 다양한 향과 맛을 즐기고 싶으신 분들께 피노누아 품종의 와인 추천드립니다. 혹은 어딘가 귀중한 분께 혹은 특별한 자리를 빛낼 때 피노누아를 갖고 간다거나 특히 와인을 즐겨 드시는 분들께 피노누아를 선물한다면 럭셔리한 선물이 될 것입니다. 
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
       <v-tab-item>
       <v-card flat>
          <v-card-text>
            <p>
              단맛 없고 떫지 않고 피노누아랑 거의 비슷. 과실향이 정말 풍부하며, 목넘김이 부드러움
            </p>

            <p >
             비싼 와인이라고 한다면 피노누아를 많이 생각합니다. 피노누아 품종이 비싼 이유는 이 포도 품종이 아무데서나 잘 적응하지 못하기 때문입니다. 주로 서늘한 기후에서 잘 재배되는데 프랑스의 부르고뉴 지방의 피노누아를 최고로 쳐주고는 합니다. 피노누아는 껍질이 얇고 포도 줄기가 적어서 탄닌이 적습니다.
            </p>
            <p>
            그만큼 떫은맛은 없어지는데 또 이 맛의 깊이는 라이트 하지 않습니다. 피노 누아의 Noir는 검은색을 뜻할 만큼 검은색에 가까운 붉은색을 띠고 있습니다. 이 포도 품종에서는 정말 다양한 과일과 꽃향기, 그리고 짙은 버섯과 흙의 냄새까지 난다고 합니다. 부드럽지만 다양한 향과 맛을 즐기고 싶으신 분들께 피노누아 품종의 와인 추천드립니다. 혹은 어딘가 귀중한 분께 혹은 특별한 자리를 빛낼 때 피노누아를 갖고 간다거나 특히 와인을 즐겨 드시는 분들께 피노누아를 선물한다면 럭셔리한 선물이 될 것입니다. 
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
       <v-tab-item>
       <v-card flat>
          <v-card-text>
            <p>
              정말 조금 떫음
            </p>

            <p >
             스페인 하면 바로 처음 떠오르는 와인 포도 품종이 바로 템프라니요입니다.. 이 중에서 Tempranilo 템프라니요라는 품종을 볼 수 있을 겁니다. 이 템프라니요도 굉장히 강하고 진한 와인의 맛을 냅니다. 포도 품종의 껍질이 두껍고 색상이 진한 반면에 알코올 함량은 높지 않은 편입니다. 진한 암적색의 색깔에 산딸기와 커피 등의 풍미가 느껴지는 맛입니다. 탄닌이 다소 떫을 수 있으나 숙성 정도에 따라서 또 좋은 맛이 납니다. 요즘 저는 저렴한 와인을 마시기 때문에 저렴하지만 강렬한 맛을 원하실 때 저는 템프라니요 품종 와인을 추천드립니다. 
            </p>
           
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs>
    </v-menu>
      </v-col>
       <v-col cols="6">
<v-menu offset-y :close-on-content-click="false">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="#750049"
          v-bind="attrs"
          v-on="on"
          dark
        >
          White Wine
        </v-btn>
      </template>
        <v-tabs vertical>
      <v-tab>
        샤르도네
      </v-tab>
      <v-tab>

        리슬링
      </v-tab>
      <v-tab>
        
        쇼비뇽 블랑
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
              달지 않고, 탄산 없고 산미가 느껴짐
            </p>
            <p>
              먼저 가장 대중적인 화이트 와인으로는 샤르도네가 있습니다. 샤도네이라고도 불리지요. 보통 신선한 과일향이 좋은 품종인데 프랑스 부르고뉴와 샹파뉴 지역, 미국 캘리포니아, 호주, 그리고 남아공을 포함하여 세계 여러 지역에서 재배되는 와인 품종입니다. 
            </p>
            <p>
            샤르도네 품종에서는 주로 멜론, 복숭아, 풋사과 향들이 나며 오크 숙성된 경우에는 부드러운 맛에 바닐라와 오크향을 함께 갖기도 합니다. 샤르도네가 가장 대중적으로 사랑받는 품종인 이유에는 맛도 맛이지만 이 포도 품종이 어느 지역에서나 잘 적응하고 살아남는 이유이기도 합니다. 
            </p>
            <p>
            병충해에 강하고 기후적 응력이 높아 농가에서 선호되며 싹이 또 빨리 튼다는 장점이 있습니다. 다 익었을 시에는 숙성도가 굉장히 높은 품종 중에 하나입니다.
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            <p>
              정말 조금 달다. 신맛이 강한 편이며 도수는 보통 11도, 도수 좀 낮고 단맛이 강한 경우도 있다.
            </p>

            <p>
             리슬링은 독일을 대표하는 화이트 와인입니다. 다양한 스타일로 생산되는 것이 가능한 리슬링 와인은 부드러우면서도 복합적인 맛과 함께 향신료와 복숭아, 살구 같은 과일향, 그리고 꽃향기까지 납니다. 긴 뒷맛과 여운을 갖고 있어 가벼운 것 같으면서도 장기간 숙성이 가능하며 오래될수록 깊이가 있는 풍미가 느껴지는 신비로운 품종입니다.
            </p>

          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            <p>
              단맛은 없으나 청량감이 있어서 상큼하게 가볍게 먹기 좋다. 달지 않은 화이트 와인은 보통 산미가 느껴지는데, 뉴질랜드 쇼비뇽블랑은 산미가 없어 더 먹기가 좋다.
            </p>

            <p class="mb-0">
              소비뇽 블랑은 루아르 강 상류, 프랑스의 보르도, 뉴질랜드에서 재배되는 화이트 와인 품종입니다. 이 품종으로 만든 와인에서는 오렌지 향이 나는 것이 가장 큰 특징입니다. 보르도 지역에서는 세미용과 블렌딩 되고 가끔 오크 숙성을 시키지만 강하게 느껴지지는 않습니다. 풀향이 강하게 나고 비교적 가벼운 편이라 잘 만들면 장기 숙성도 가능합니다.
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs>
    </v-menu>
       </v-col>

  
  </v-row>
  
      </v-tab-item>
    <v-tab-item class="ma-3"
      >
        <v-hover v-slot="{ hover }">
    <v-card
      class="mx-auto"
      color="grey lighten-4"
      max-width="600"
    >
      <v-img
        :aspect-ratio="16/9"
        src="../../../public/img/winelabel_france.png"
        class="slick-slide"
      >
        
      </v-img>
      <v-expand-transition>
          <div
            v-if="hover"
            class="d-flex transition-fast-in-fast-out orange darken-2 v-card--reveal display-3 white--text"
            style="height: 100%;"
          >
            <v-list>
            <v-list-item>
            
            </v-list-item>
            </v-list>
          </div>
        </v-expand-transition>
      <v-card-text
        class="pt-6"
        style="position: relative;"
      >
        
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
 
 <div>
 <v-card
    class="mx-auto"
    max-width="300"
    tile
  >
    <v-list>
      <v-subheader>REPORTS</v-subheader>
      <v-list-item-group
        v-model="selectedItem"
        color="primary"
      >
        <v-list-item
          v-for="item in items"
          :key="item.id"
        >

          <v-list-item-content>
            <v-list-item-title v-text="item"></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>
    <span
      @mouseover="hover = true"
      @mouseleave="hover = false"
      :class="{ active: hover }"
    >
      Hover me to change the background!
    </span>
  </div>
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
        hover: false,


        selectedItem: 1,
      items: [
          "와이너리","생산지", "포도 품종", "빈티지"
      ],    
      select:[
          'Red Wine', 'White Wine'
      ]
       
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
.active {
  background: green;
}

</style>
