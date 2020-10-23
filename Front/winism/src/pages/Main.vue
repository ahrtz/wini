<template>
  <div>
    <div class="page-header clear-filter">
      <parallax
        class="page-header-image"
        style="background-image:url('img/wine-grapes-drink.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="content-center brand">
          <img class="n-logo" src="img/winelogo.png" alt="" />
          <h1 class="h1-seo">Winism</h1>
   
         <fg-input
              addon-right-icon="now-ui-icons ui-1_zoom-bold"
              placeholder="Wine Search"
            >
            </fg-input>

          <h3>Wine site for wine newbie</h3>
        </div>
       
      </div>
    </div>
    <div class="main">
      <div class="section section-images">
        <div class="container">
          
    <div class="row">
      <div
       class="col-md-6 col-sm-6 col-xs-12"
      >
        <card class="card-signup" header-classes="text-center" color="orange">
          <template slot="header">
            <h3 class="card-title title-up">Guide</h3>
            
          </template>
          
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg">Info</n-button>
          </div>
        </card>
      </div>
       <div
       class="col-md-6 col-sm-6 col-xs-12"
      >
        <card class="card-signup" header-classes="text-center" color="orange">
          <template slot="header">
            <h3 class="card-title title-up">Sign Up</h3>
            
          </template>
          
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg">Get Started</n-button>
          </div>
        </card>
      </div>
 
     
    </div>
        </div>
      </div>
    </div>
    <basic-elements></basic-elements>
    <navigation></navigation>
    <tabs-section></tabs-section>
    <progress-pagination></progress-pagination>
    <notifications></notifications>
    <typography></typography>
    <javascript-components></javascript-components>
    <carousel-section></carousel-section>
    <nucleo-icons-section></nucleo-icons-section>
    <div class="section">
      <div class="container text-center">
        <div class="row justify-content-md-center">
          <div class="col-md-12 col-lg-8">
            <h2 class="title">Completed with examples</h2>
            <h5 class="description">
              The kit comes with three pre-built pages to help you get started
              faster. You can change the text and images and you're good to go.
              More importantly, looking at them will give you a picture of what
              you can built with this powerful Bootstrap 4 ui kit.
            </h5>
          </div>
        </div>
      </div>
    </div>
    <signup-form></signup-form>
    <examples-section></examples-section>
    <download-section></download-section>
  </div>
</template>
<script>
import { Parallax } from '@/components';
import BasicElements from './components/BasicElementsSection';
import Navigation from './components/Navigation';
import TabsSection from './components/Tabs';
import ProgressPagination from './components/ProgressPagination';
import Notifications from './components/Notifications';
import Typography from './components/Typography';
import JavascriptComponents from './components/JavascriptComponents';
import CarouselSection from './components/CarouselSection';
import NucleoIconsSection from './components/NucleoIconsSection';
import SignupForm from './components/SignupForm';
import ExamplesSection from './components/ExamplesSection';
import DownloadSection from './components/DownloadSection';
import { Card, FormGroupInput, Button } from '@/components';

export default {
  name: 'main',
  bodyClass: 'index-page',
  components: {
    [FormGroupInput.name]: FormGroupInput,
    Card,
    Parallax,
    BasicElements,
    Navigation,
    TabsSection,
    ProgressPagination,
    Notifications,
    Typography,
    JavascriptComponents,
    CarouselSection,
    NucleoIconsSection,
    SignupForm,
    ExamplesSection,
    DownloadSection
  }
};
</script>
<style></style>
