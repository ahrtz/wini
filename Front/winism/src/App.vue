<template>
  <div id="app">
    <router-view name="header" />
      <router-view :key="$route.fullPath"/>
  </div>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    
    //
  }),
};
</script>
