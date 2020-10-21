<template>
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



 <v-card
    class="mx-auto"
    max-width="344"
  >
    <v-card-text>
      <div>Word of the Day</div>
      <p class="display-1 text--primary">
        be•nev•o•lent
      </p>
      <p>adjective</p>
      <div class="text--primary">
        well meaning and kindly.<br>
        "a benevolent smile"
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
</div>
</template>

<script>


export default {
  name: 'Main',
  components: {

  }
}
</script>
