<template>
  <v-app-bar class="navbar-btn-container" flat app >
    <router-link class="navbar-btn-container" :to="{ name: 'Main' }">
        <span class="navbar-btn">WINISM</span>
    </router-link>
<v-spacer></v-spacer>
    <router-link class="navbar-btn-container" :to="{ name: 'Guide' }">
      <span class="navbar-btn">
        GUIDE

      </span>
    </router-link>
    <router-link class="navbar-btn-container" :to="{ name: 'Recommend' }">
      <span class="navbar-btn">
        RECOMMEND

      </span>
    </router-link>

    <router-link class="navbar-btn-container" :to="{ name: 'Info' }">
      <span class="navbar-btn">
        INFO

      </span>
    </router-link>

    <router-link class="navbar-btn-container" :to="{ name: 'My Page' }">
      <span class="navbar-btn">
        MYPAGE

      </span>
    </router-link>
  </v-app-bar>
</template>

<script>

  export default {
    name: 'Navbar',
    mounted() {
     
    },
    computed: {
     
    },
    methods: {
     
    }
  }
</script>