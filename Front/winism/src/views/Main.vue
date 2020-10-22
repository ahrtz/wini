<template>
<div>
<div class="main-food-area">
<img src="@/assets/logo/wine-grapes-drink.jpg"/>
 <v-row
      align="center"
      justify="center"
      class="myInput"
    >
      <v-col
        class="text-center"
        cols="12"
      >
          <v-text-field
            solo
            label="Wine"
            append-icon="mdi-magnify"
          ></v-text-field>
        <h4 class="subheading">
          WINISM과 함께 와인을 즐겨보세요
        </h4>
      </v-col>
    </v-row>

</div>
<v-row>
<v-col cols="12">
 <v-card
    class="mx-auto"
    max-width="500px"
  >
    <v-card-text>

      <p class="display-1 text--primary">
        GUIDE
      </p>
      <p>adjective</p>
      <div class="text--primary">
        와인 초보자를 위한 가이드
      </div>
    </v-card-text>
    <v-card-actions>
    <i class="mdi mdi-arrow-right"></i>
      <v-btn
        right
        rounded
        small
        to="/guide"
      >Go To Guide

      </v-btn>

    </v-card-actions>
  </v-card>
  </v-col>
  <v-col cols="12">
<v-card
    class="mx-auto"
    max-width="500"
  >
    <v-card-text>
      <p class="display-1 text--primary">
        RECOMMEND
      </p>
      <p>adjective</p>
      <div class="text--primary">
        나만을 위한 와인 추천 받기
      </div>
    </v-card-text>
    <v-card-actions>
      <v-btn
        text
        color="deep-purple accent-4"
      >
        Learn More
      </v-btn>
    </v-card-actions>
  </v-card>
</v-col>
<v-col cols="12">
  <v-card
    class="mx-auto"
    max-width="500"
  >
    <v-card-text>
      <p class="display-1 text--primary">
        INFO
      </p>
      <p>adjective</p>
      <div class="text--primary">
        와인 정보
      </div>
    </v-card-text>
    <v-card-actions>
      <v-btn
        text
        color="deep-purple accent-4"
      >
        Learn More
      </v-btn>
    </v-card-actions>
  </v-card>
</v-col>

<v-col cols="12">
  <v-card
    class="mx-auto"
    max-width="500"
  >
    <v-card-text>
      <p class="display-1 text--primary">
        MYPAGE
      </p>
      <p>adjective</p>
      <div class="text--primary">
       마이페이지
      </div>
    </v-card-text>
    <v-card-actions>
      <v-btn
        text
        color="deep-purple accent-4"
      >
        Learn More
      </v-btn>
    </v-card-actions>
  </v-card>
  </v-col>
  </v-row>
</div>

</template>

<script>


export default {
  name: 'Main',
  components: {

  }
}
</script>
