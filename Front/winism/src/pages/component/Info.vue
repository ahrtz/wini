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
  <v-hover v-slot="{ hover }">
    <v-list
      class="mx-auto"
      color="grey lighten-4"
      max-width="600"
    >
      <v-list-item
        
      >
      <p>우와</p>
        <v-expand-transition>
          <div
            v-if="hover"
            class="d-flex transition-fast-in-fast-out orange darken-2 v-card--reveal display-3 white--text"
            style="height: 100%;"
          >
            $14.99
          </div>
        </v-expand-transition>
      </v-list-item>
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
    </v-list>
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
