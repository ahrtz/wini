<template>
    <div class="page-header clear-filter">
      <parallax
        class="page-header-image"
        style="background-image:url('img/wine-grapes-drink.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="content-center brand">
          <img class="n-logo" src="img/winelogo.png" alt="" />


          <h3>간단한 테스트로 와인 취향을 알아보자!</h3>
          <v-btn class="white--text" @click="gettingStarted()" outlined>Get start</v-btn>
        </div>
       
      </div>
    </div>
</template>
<script>
export default {
  name: "StarterTestStart",
  bodyClass: "index-page",
  components: {},
  data() {
    return {
      //wine list slider data
      current: 0,
      show: false,
      tab: null,
      expand: false,
      isStart: true,
    };
  },
  methods: {
    gettingStarted() {
      this.$emit('changeCurrent', 1)
    }
  }
};
</script>
<style scoped>
/* line 271, app/assets/stylesheets/home/theme.scss */
.background-pale-green {
  background-color: #e6f3e6;
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
  background-color: #f1f3f5;
  color: #212529;
  border: none;
  border-radius: 6px;
  text-decoration: none;
  padding: 1.45rem 2.6rem;
  display: inline-block;
}

/* line 127, app/assets/stylesheets/home/home.scss */
.home-main-section .home-buttons .home-button:hover {
  background-color: #e9ecef;
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
  background-color: #fbf7f2;
}

/* line 196, app/assets/stylesheets/home/home.scss */
#home-main-section-top #home-main-top {
  width: 1024px;
  height: 760px;
  margin: 0 auto;
  position: relative;
  background-color: #fbf7f2;
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
  background: #fbf7f2
    url(/assets/home/main/3x/image-top-4eb6b8642f61c5c012136597a25a7b72c705d6c6479a7270f3fb23726fddf585.png)
    no-repeat;
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
