<template>
<div>

<v-app>
  <v-container class="pt-5">
  

  <div style="margin-top:100px">
  <v-card-title class="text-center justify-center">
      <h3 class="font-weight-bold">
        와인 상식
      </h3>
    </v-card-title>
  </div>
   <v-tabs
      v-model="tab"
      color="#750049"
      grow
    >
      <v-tab
        
      >
        포도 품종
      </v-tab>
      <v-tab
        
      >
        와인 라벨 읽는 법
      </v-tab>
        <v-tab
        
      >
        와인과 음식 조합
      </v-tab>
       <v-tab-item
      >
      <h5 class="mt-2" style="color:#882814">Red Wine</h5>
     
<v-row>

      
      <br>
      <v-col cols="6"
        md="4" xs="12">
      <v-btn  color="#750049" dark @click.native="modals.cabernet = true">
        까베르네 소비뇽(Cabernet Sauvignon)
      </v-btn>
      <modal :show.sync="modals.cabernet" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Cabernet Sauvignon</h4>
         <strong>떫고, 농도감이 있는 맛</strong>
          <p>
              와인을 만들 때 가장 많이 사용하는 포도 품종이 바로 까베르네 소비뇽이다. 
              초심자의 입장에서 너무 드라이하거나 떫지 않고 또 너무 묽지도 않은 우리가 생각하는 스탠더드를 찾고자 한다면 까베르네 소비뇽을 선택하면 된다.
            </p>
              <p>
            실제로도 모든 레드와인 중에서 가장 많은 생산량을 차지하고 있다.
             어떠한 기후에서도 잘 견디는 특징 때문에 전 세계 어디에서나 재배되면서 다양한 맛을 보여주고 가장 많은 사랑을 받는 와인이다.

이 포도 품종의 가장 큰 특징은 바로 껍질이 두껍고 씨앗이 많다는 것이다. 
우리가 그냥 포도를 먹는다면 이건 별로 좋지 않은 포도다. 
그러나 포도주를 만들 때는 아주 큰 장점이 된다. 두꺼운 껍질이 포도가 빨리 썩지 않게 만들어서 오랜 기간 동안 숙성과 발효를 거칠 수 있게 만든다. 
            </p>
            <p>
            그래서 까베르네 소비뇽 품종은 오크통에 아주 오랫동안 숙성시킬 수 있는 포도다. 
            두꺼운 껍질과 많은 포도씨는 탄닌을 포함하고 있어서 떫은맛을 낼 수도 있는데 오랫동안 숙성할수록 이러한 떫은맛들이 
            부드러워지고 색상에서는 다양한 과일의 맛과 향을 낼 수 있는 향기로운 와인이 될 수 있다. 
            </p>
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.cabernet = false">Close</v-btn>
        </template>
      </modal>
      </v-col>
    <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.malbec = true">
        말벡(Malbec)
      </v-btn>
      <modal :show.sync="modals.malbec" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Malbec</h4>
         <strong>떫고, 진하고 풍부한 맛 </strong>
          <p>
              보르도가 원산지이며 프랑스 까오르, 아르헨티나, 칠레가 주목할 만한 재배지역이다.
              1956년대 프랑스 보르도에서 수확률의 75%를 전멸시켰던 서리 피해 이후, 인기 없는 품종이 되었으며, 현재 아르헨티나 품종으로 점점 알려지게 되었다.
옅은 껍질을 가지고 있어, 까베르네 소비뇽, 멜롯의 숙성보다 더 많은 일조량이 필요하다.
블랙와인이라 불릴만큼 매우 짙은 색상과 풍부한 탄닌을 가진다.
 플럼과 같은 풍미의 보르도 클라레에 복잡함을 주기 위하여 혼합한다.
검은 베리향과 서양자두와 약간의 계피향 및 나무향이 난다.
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.malbec = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
    <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Carmenere = true">
        까르메네르(Carmenere)
      </v-btn>
      <modal :show.sync="modals.Carmenere" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Carmenere</h4>
         <strong>적당한 농도감과 부드러운 맛</strong>
          <p>
              프랑스 보르도 메독이 원산지이며, 까베르네계열의 품종이다. 필록세라 병이 유럽 거의 모든포도원을 파괴하고 난 이후, 오늘날 프랑스에서 까르메네르 품종을 발견하는 것은 거의 불가능하다.

가장 널리 재배되고 있는 곳은 남미 칠레이며 주로 품종 와인을 생산한다.

깊은 레드 색상과 붉은 과일에서 발견되는 아로마, 방향성, 베리향을 가진다.
 탄닌은 까베르네 소비뇽보다 더 순하고 부드럽고, 와인은 미디엄 바디이다.

숙성이 잘 되었을 때 체리향과 신선한 과일향, 탄내, 향신료와 흙내음, 깊은 심홍색의 와인이 된다.

다크초콜릿, 담배, 가죽냄새를 생각나게 하는 풍미가 있다.
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Carmenere = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
    <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Merlot = true">
       멜롯(Merlot)
      </v-btn>
      <modal :show.sync="modals.Merlot" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Merlot</h4>
         <strong>떫지 않고 부드러운 맛 </strong>
          <p>
              
            와인 초심자로서 가볍고 부드러운 와인을 추구한다면 멜롯 품종 와인 추천한다.

            까베르네 소비뇽과 비교해 봤을 때는 포도 과육이 더 많은데 껍질은 얇다. 
            수분과 당분이 훨씬 많아서 씨앗도 별로 없어서 떫은맛이 덜하다.
             보통 오랜 숙성을 거치기보다는 짧게 숙성하여도 맛있는 와인이 된다. 
             와인의 유통기한도 짧기 때문에 빨리 마셔야 한다는 단점이 있다. 만약 와인의 떫은맛이 싫다면 멜롯와인을 강력 추천한다.
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Merlot = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
    <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Syrah = true">
       시라(Syrah) / 쉬라즈(Shiraz)
      </v-btn>
      <modal :show.sync="modals.Syrah" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Syrah</h4>
         <strong>살짝 떫은 맛</strong>
          <p>
             
         쉬라즈라고 불리는 이 품종은 까베르네 소비뇽보다 더 두꺼운 껍질과 더 많은 포도씨를 갖고 있다. 
         강렬한 탄닌의 맛을 즐기고 싶다면, 혹은 자극적이고 진한 와인을 좋아한다면 쉬라 품종의 와인을 추천한다. 
         알코올 함량도 높은 편이라서 드라이하다고도 불린다.
          보통 산도가 낮이라서 신맛은 덜하며 매콤하다고도 사람들이 부를 만큼 자극적인 맛인데 동시에 과일향을 풍기기도 한다. 
         프랑스에서는 스모크 한 냄새와 허브향이 있다고 하는데 호주의 쉬라는 더 부드럽고 감칠맛이 있다고 한다. 
          가장 많이 생산하는 국가는 호주이며 저렴하지만 퀄리티가 뛰어난 와인을 대량 생산하고 있다.

            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Syrah = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
     <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Pinot = true">
       피노 누아(Pinot Noir)
      </v-btn>
      <modal :show.sync="modals.Pinot" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Pinot Noir</h4>
         <strong>와인 중에 가장 가볍고 떫지않은 맛</strong>
          <p>
        비싼 와인이라고 한다면 피노 누아를 많이 생각한다. 
        피노 누아 품종이 비싼 이유는 이 포도 품종이 아무데서나 잘 적응하지 못하기 때문이다. 
        주로 서늘한 기후에서 잘 재배되는데 프랑스의 부르고뉴 지방의 피노 누아를 최고로 쳐준다. 
        피노 누아는 껍질이 얇고 포도 줄기가 적어서 탄닌이 적다. 
        그만큼 떫은맛은 없어지는데 또 이 맛의 깊이는 라이트 하지 않다. 
         피노 누아의 Noir는 검은색을 뜻할 만큼 검은색에 가까운 붉은색을 띠고 있다. 
         이 포도 품종에서는 정말 다양한 과일과 꽃향기, 그리고 짙은 버섯과 흙의 냄새까지 난다고 한다. 
          부드럽지만 다양한 향과 맛을 즐기고 싶다면 피노 누아 품종의 와인을 추천한다. 
          혹은 귀중한 사람에게 혹은 특별한 자리를 빛낼 때 피노 누아를 갖고 간다거나 특히 와인을 즐겨 먹는 사람에게 피노 누아를 선물한다면 
          럭셔리한 선물이 될 것이다.

 
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Pinot = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
    <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Sangiovese = true">
       산지오베제(Sangiovese)
      </v-btn>
      <modal :show.sync="modals.Sangiovese" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Sangiovese</h4>
         <strong>단맛 없고 떫지 않고 피노 누아랑 거의 비슷한 맛</strong>
          <p>
     주요 재배지역은 이탈리아 중부 토스카나 주이다. 쥬피터라는 뜻을 지난 이 품종은 이탈리아 최고급 와인을 만드는데 사용된다. 
적색 루비의 색상을 가지고 있으며, 탄닌은 적당하고, 높은 산도를 가지고 있다. 미디어 바디에서 풀 바디에 이르는 다양한 와인을 만드는데 사용된다. 

어린 산지오베제는 신선한 딸기 같은 과일향과 약간의 스파이스향이 난다. 배럴에 숙성시켰을 때에는 타르 질과 오크향을 쉽게 느낄 수 있다. 
산지오베제 포도나무는 일반적으로 매우 활발하고 병에 대한 저항력이 강하지만 열매들을 쉽게 썩게 하는 경향이 있다. 
체리, 자두향이 대표적이며, 각종 파스타, 피자, 바비큐, 삼겹살, 스테이크 등과 잘 어울린다. 
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Sangiovese = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
     <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Tempranillo = true">
       템프라니요(Tempranillo)
      </v-btn>
      <modal :show.sync="modals.Tempranillo" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Tempranillo</h4>
         <strong>정말 조금 떫은 맛</strong>
          <p>
    스페인 하면 바로 처음 떠오르는 와인 포도 품종이 바로 템프라니요다. 
템프라니요도 굉장히 강하고 진한 와인의 맛을 낸다. 
포도 품종의 껍질이 두껍고 색상이 진한 반면에 알코올 함량은 높지 않은 편이다.
진한 암적색의 색깔에 산딸기와 커피 등의 풍미가 느껴지는 맛이다. 
탄닌이 다소 떫을 수 있으나 숙성 정도에 따라서 또 좋은 맛이 난다. 
 저렴하지만 강렬한 맛을 원한다면 템프라니요 품종 와인을 추천한다.
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Tempranillo = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
<v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Grenache = true">
       그르나슈(Grenache)
      </v-btn>
      <modal :show.sync="modals.Grenache" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Grenache</h4>
         <strong>바디감이 풍부한 맛</strong>
          <p>
    스페인이 원산지이며, 일반적으로 향신료향과 베리향이 나며 입안에서 매우 부드러운 느낌을 준다. 
껍질이 얇고 탄닌 성분은 풍부하지 못하나 알코올 함유량이 높아 풀바디 스타일을 가진다. 
그르나슈는 산, 탄닌, 색상이 모자란 경향이 있어 일반적으로 시라, 까리냥, 생소와 같은 품종들과 혼합한다. 
높은 당분 레벨은 루시용의 천연감미와인을 포함한 주정 강화 와인을 만드는 데 사용된다. 
오리고기, 소고기, 치즈, 미트소스 스파게티, 토마토 스파게티 등과 잘 어울린다. 
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Grenache = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
<v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Zinfandel = true">
       진판델(Zinfandel)
      </v-btn>
      <modal :show.sync="modals.Zinfandel" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Zinfandel</h4>
         <strong>달고 농도감 있는 맛</strong>
          <p>
    이탈리아 남부 풀리아 주와 캘리포니아가 주요 지역이며, 캘리포니아에서는 1830년대에 포도원에서 재배된다. 
풍부한 과일향과 싱싱한 구조, 자연스러운 신맛, 그리고 높은 알코올 함량으로 알려진 인기 있는 캐릴포니아 와인을 만드는데 사용된다. 
와인 양조자들은 감미로운 화이트 진판델, 보졸레 누보를 생각나게 하는 라이트 바디, 풀바디 드라이 레드, 렝트 하비스트 스위트 디저트 와인, 그리고 포트 와인 스타일을 포함한 광범위한 와인 스타일을 위하여 진판델을 사용한다. 
 체리, 베리 계열, 가죽향이 대표적이고, 칠면조, 스테이크, 파스타, 햄, 소시지 등과 잘 어울린다. 
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Zinfandel = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
<v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Nebbiolo = true">
       네비올로(Nebbiolo)
      </v-btn>
      <modal :show.sync="modals.Nebbiolo" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Nebbiolo</h4>
         <strong>과일향과 탄닌이 강한 맛</strong>
          <p>
   이탈리아 북서 피에몬테 지역에서 가장 중요한 와인을 생산하는 품종이다. 
네비올로란 뜻은 이탈리아어로 안개란 뜻이며, 껍질이 두껍고 탄닌과 알코올이 풍부하여 와인의 단단한 구조와 남성적인 묵직함을 주며, 장기 숙성이 가능하다. 
노균병에 약한 편이고, 품종이 아주 섬세하기 때문에 양조시 항상 주의 깊게 살펴야 한다. 
바롤로, 바르바레스코와 같은 최고의 와인을 만드는 데 사용된다. 
엷은 색상의 레드 와인들은 흥미를 자아내는 타르와 장미향과 함께 젊음의 힘찬 탄닌을 얻을 수 있다. 
와인들이 숙성되면, 복잡한 향과 매우 독특하고 과일, 꽃향, 스파이시한 특징을 느낄 수 있다. 
이들 와인들의 탄닌이 유순하게 되려면 수년간의 숙성이 소요된다. 
훈제연어, 소고기, 양고기 등과 잘 어울리며, 특히 훈제, 숯불요리와 매우 좋은 궁합이다. 

 
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Nebbiolo = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
    <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Barbera = true">
       바르베라(Barbera)
      </v-btn>
      <modal :show.sync="modals.Barbera" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Barbera</h4>
         <strong>미디엄 바디에 과일 풍미가 풍부한 맛</strong>
          <p>
   13세기부터 이탈리아에 알려져있으며, 북서 이탈리아는 바르베라를 위하여 가장 중요한 지역이다. 이탈리아에서 가장 많이 혹은 두 번째로 많이 재배되는 품종이다. 
바르베라의 산도는 와인의 신선함을 주기 위하여 다른 품종들과 혼합한다. 
수확량이 좋고, 깊은 색상, 낮은 탄닌과 따뜻한 기후의 레드 품종과는 다르게 높은 레벨의 산도를 준다. 
오랜 숙성을 거친 와인은 과일향이 강렬하고, 탄닌의 함유량을 향상시켜 매우 감칠맛이 난다. 
많은 생산자들이 구운 오크통의 향을 첨가하며, 전통적으로 슬로베니아산 오크통에서 몇 년간 숙성되고 있으나, 최근에는 가격이 비싼 프랑스산 오크통에서 숙성시키는 경향이 있다.

바르베라품종은 이탈리아의 다른 많은 DOC 와인들을 만드는 데 허가된 품종이다. 

따뜻한 기후를 좋아하고, 많은 수확량을 가져다주는 품종이다. 
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Barbera = false">Close</v-btn>
        </template>
      </modal>
    </v-col>

  
  </v-row>
<h5 class="mt-2" style="color:#eccd13">White Wine</h5>
  <v-row>
   <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Chardonnay = true">
       샤르도네(Chardonnay)
      </v-btn>
      <modal :show.sync="modals.Chardonnay" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Chardonnay</h4>
         <strong>달지 않고 탄산 없고 산미가 느껴지는 맛</strong>
          <p>
 샤도네이라고도 불리며, 보통 신선한 과일향이 좋은 품종인데 프랑스 부르고뉴와 샹파뉴 지역, 미국 캘리포니아, 호주, 그리고 남아공을 포함하여 세계 여러 지역에서 재배되는 와인 품종이다. 
샤르도네 품종에서는 주로 멜론, 복숭아, 풋사과 향들이 나며 오크 숙성된 경우에는 부드러운 맛에 바닐라와 오크향을 함께 갖기도 한다. 
샤르도네가 가장 대중적으로 사랑받는 품종인 이유에는 맛도 맛이지만 이 포도 품종이 어느 지역에서나 잘 적응하고 살아남는 이유이기도 하다. 
병충해에 강하고 기후적 응력이 높아 농가에서 선호되며 싹이 또 빨리 튼다는 장점이 있다. 다 익었을 시에는 숙성도가 굉장히 높은 품종 중에 하나다.
다양한 샐러드, 생선요리, 오래 숙성되지 않은 각종 치즈 등과 잘 어울린다. 

            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Chardonnay = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
  <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Riesling = true">
       리슬링(Riesling)
      </v-btn>
      <modal :show.sync="modals.Riesling" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Riesling</h4>
         <strong>정말 조금 단 맛</strong>
          <p>
독일 라인가우, 모젤, 프랑스 알자스가 주요지역이다. 리슬링 와인은 프리티하고 향기로우며 그린 또는 다른 사과향, 자몽향, 복숭아향, 꿀향, 라임향, 장미꽃향 또는 푸른 풀향을 가지고 있다.
발아가 늦은 만생종이며 포도껍질이 얇아 귀부현상을 일으켜 훌륭한 스위트 와인을 만든다. 
높은 산도 때문에 파삭파삭한 맛을 내지만, 자연히 높은 산도와 풍미들은 숙성이 진행됨에 따라 부드러워진다. 
일반적으로 리슬링 와인의 드라이 타입은 5~15년, 세미 스위트 타입은 10~20년, 스위트 버전은 10~30년 동안 숙성시킬 수 있다. 
시간이 지나면 리슬링 와인은 등유, 윤활유, 고무로 설명되는 가솔린 향이 나는 경향이 있다. 

신선한 계절과일, 달콤한 푸딩, 케이크 등과 잘 어울린다.

            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Riesling = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
    <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Blanc = true">
       소비뇽 블랑(Sauvignon Blanc)
      </v-btn>
      <modal :show.sync="modals.Blanc" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Sauvignon Blanc</h4>
         <strong>단 맛은 없지만 청량감이 있음</strong>
          <p>
프랑스 보르도 지역이 원산지이며, 소비뇽 블랑 포도나무의 싹은 늦게 돋으나, 햇볕이 잘 드는 기후에서는 일찍 익는다. 
높은 열을 받기 쉬운 지역에서 포도는 너무 익게 되고, 뚜렷하지 않은 맛과 활기 없는 산도의 와인을 생산한다. 
소비뇽 블랑은 파삭파삭하고 드라이하며, 상쾌한 화이트 품종 와인을 생산한다.  
프랑스 보르도 소테른과 바르삭에서는 유명한 귀부 와인을 만드는 품종 중 하나다.
기후에 따라 다르지만 프루티한 열대과일 풍미가 있다.
뉴질랜드 생산자들에 의하여 소비뇽 블랑느 리슬링과 더불어 스크류 캡으로 병입된 최초의 와인 중 하나이다.
화이트 와인을 마시는 사람들이 샤르도네에 대한 대체와인을 찾으면서 소비뇽 블랑의 인기는 꾸준히 증가하고 잇다.
신세계 와인 메이커들이 더 많은 과일과 열대과일 풍미를 더하기 위하여 약간 더 서늘한 발효온도를 선호한다.
신선한 사과, 레몬, 라임, 청포도 등의 과일향과 아스파라거스, 풀 등의 아로마를 지닌다.
싱싱한 사시미, 갑각류, 각종 생선류, 해산물 등과 매우 잘 어울린다.
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Blanc = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
     <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Semillon = true">
       세미용(Semillon)
      </v-btn>
      <modal :show.sync="modals.Semillon" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Semillon</h4>
         <strong>부드러운 산미로 입안을 부드럽게 하는 훌륭하고 복잡한 풍미를 나타냄</strong>
          <p>
프랑스와 호주에서 가장 주목할 만한 드라이 또는 스위트 와인을 만드는 데 사용되는 황금색의 껍질을 가진 포도이다. 
따뜻한 기후에서 일찍 익고, 핑크색을 띤 빛깔을 얻으며, 포도껍질이 얇기 때문에 무더운 기후에서는 타는 위험이 있다.
햇볕이 잘 드는 낮과 서늘한 밤 지역이 재배에 가장 적합하다.
보트리티스 시네리아 곰팡이균으로 인해 귀부 현상이 일어나 포도의 당도를 높여 건포도 형태로 이르게 하여 고급스러운 스위트 화이트 와인을 생산한다.​
프랑스 보르도 지역에서는 소비뇽 블랑, 무스카델, 세미용의 3가지 품종이 재배 허가를 받았다.
포도는 프랑스 보르도 소테른과 바르삭에서와 같이 스위트 와인을 위하여 기본품종으로 사용되고 있다.
프랑스에서 세미용은 소비뇽 블랑과 무스카델과 혼합하는 보르도에서 대부분 재배된다.
새우, 홍합, 치즈 및 생선류 등과 잘 어울린다. 
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Semillon = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
    <v-col cols="6"
        md="4" xs="12">
      <v-btn   color="#750049" dark @click.native="modals.Trebbiano = true">
       트레비아노(Trebbiano)
      </v-btn>
      <modal :show.sync="modals.Trebbiano" headerClasses="justify-content-center">
        <h4 slot="header" class="title title-up">Trebbiano</h4>
         <strong>신선하고 과일 같은 향이 느껴짐</strong>
          <p>
드라이하고 가벼운 트레비아노는 이탈리아 북부와 중부에서 주로 재배되며 이탈리아에서 가장 많이 재배되는 화이트 품종이다. 
 가벼운 테이블 와인에 주로 사용되고 프랑스에서는 위니 블랑으로 불리기도 한다. 
 우리가 잘 알고 있는 코냑 지방에서는 브랜디의 원료로 쓰이기도 한다.
            </p>
          
        <template slot="footer">
         
          <v-btn type="danger" @click.native="modals.Trebbiano = false">Close</v-btn>
        </template>
      </modal>
    </v-col>
  </v-row>
 
      </v-tab-item>
    <v-tab-item class="ma-3 "
      >
      <h4 style="font-weight:bold">프랑스 와인 라벨</h4>
      <v-row justify="center">
    
        <v-img
        src="../../../public/img/winelabel_france.png"
        class="slick-slide"
        max-width="800"
      max-height="600"
      >
       
      </v-img>
         </v-row>
      <v-divider></v-divider>
      <h4 style="font-weight:bold">미국 와인 라벨</h4>
       <v-row justify="center">
        <v-img
        src="../../../public/img/winelabel_america.png"
        class="slick-slide"
        max-width="600"
         max-height="800"
      >
        
      </v-img>
       </v-row>
      <v-divider></v-divider>
       <h4 style="font-weight:bold">독일 와인 라벨</h4>
       <v-row justify="center">
        <v-img
        src="../../../public/img/winelabel_german.png"
        class="slick-slide"
        max-width="800"
      >
        
      </v-img>
       </v-row>
      <v-divider></v-divider>
        <h4 style="font-weight:bold">이탈리아 와인 라벨</h4>
        <v-row justify="center">
       <v-img
        src="../../../public/img/winelabel_italy.png"
        class="slick-slide"
        max-width="800"
      >
        
      </v-img>
        </v-row>
       
 
      </v-tab-item>
      <v-tab-item>
       <v-btn
      depressed
      color="error"
    >
      Red Wine
    </v-btn>

       <v-btn
      depressed
      color="error"
    >
      The best 안주
    </v-btn>
      <h1>진한 레드 와인</h1>
      <p>쇠고기, 파스타, 등심·안심·갈비·철판구이 등 쇠고기 요리, 생등심 불고기</p>
      <h1>미디엄 레드 와인</h1>
      <p>양념 불고기, 주물럭 등 약간 단맛이 나는 쇠고기 요리</p>
      <h1>라이트 레드 와인</h1>
      <p>가금류, 양고기, 닭, 오리, 삼겹살</p>
      <h1>레드 와인의 포도 품종에 따른 와인별 매치 </h1>
<h3>시라</h3>
      <p>양념이 풍부한 고기요리</p>
      <h3>멜롯</h3>
      <p>소스가 부드러운 고기요리</p>
      <h3>카베르네 소비뇽</h3>
      <p>진한 소스를 사용한 고기요리</p>
      <v-btn
      depressed
      color="primary"
    >
      White Wine
    </v-btn>
    <h1>드라이 화이트 와인</h1>
      <p>생선회, 생선구이, 조개요리, 갑각류, 야채버섯 등 나물류</p>
       <h1>스위트 화이트 와인</h1>
      <p>떡, 과자 등 단맛이 많은 음식</p>
<h1>가벼운 화이트 와인</h1>
      <p>조개, 새우, 바닷가재</p>
      <h1>진한 화이트 와인</h1>
      <p>연어, 고등어, 닭고기</p>
<h1>화이트 와인의 포도 품종에 따른 와인별 매치 </h1>
<h3>샤르도네</h3>
      <p>생굴·조개·연어와 같은 해산물, 닭고기 요리</p>
      <h3>소비뇽 블랑</h3>
      <p>생선회, 담백한 생선요리</p>
      <h3>리슬링</h3>
      <p>크림소스나 단맛이 가미된 생선요리</p>
       <v-btn
      depressed
      color="error"
    >
      Sparkling Wine
    </v-btn>
    <h1>드라이한 맛의 스파클링 와인</h1>
    <p>굴, 캐비어, 훈제연어</p>
   <v-btn
      depressed
      color="error"
    >
      Cheese
    </v-btn>
    <h3>푸른 곰팡이 타입</h3>
      <p>치즈 속에 푸른 곰팡이를 넣어 만든 것으로서 '로크포르', '고르곤졸라', '스틸턴' 등이 있다. 
      짠맛이 풍부하고 자극성이 있어, 치즈 초보자용은 아니다. 
      이 치즈는 깊은 맛을 내는 레드 와인이나 스위트한 와인과 어울린다</p>
      <h3>흰 곰팡이 타입</h3>
      <p>치즈 표면에 흰 곰팡이를 바른 것으로서 '브리', '쿨로미에', '카망베르' 등이 있다. 
      부드럽고 냄새가 없다. 산뜻한 맛의 와인과 어울리며, 일반적으로 가장 먹기 편한 종류이다.</p>
      <h3>약간 단단한 타입</h3>
      <p>치즈를 압착해 물을 빼서 보관성을 높인 것으로서 '고다', '체다', '에담' 등이 있다. 
      쫄깃한 질감과 부드러운 맛으로 가벼운 타입의 와인이 어울린다.</p>
      <h3>단단한 타입</h3>
      <p>치즈에 수분이 적고, 숙성기간이 긴 것으로서 '그뤼예르', '파르미자노 레자노' 등이 있다. 
      잘 숙성시킨 것은 아미노산이 증가해서 감칠맛이 높다. 깊은 맛의 와인과 신맛이 있는 와인이 어울린다.</p>
      <h3>워시 타입</h3>
      <p>치즈의 표면을 소금물이나 브랜디로 씻어 내고 만든 것으로서, '퐁 레베크', '뮌스터', '에푸아스' 등이 있다. 
      강한 향이 나지만 깊고 부드러운 맛이 특징이다. 프루티한 레드 와인이 어울린다.</p>
      <h3>셰브르 타입</h3>
      <p>산양 젖으로 만든 치즈로서 '생 모르', '발랑세', '피코동' 등이 있다. 
      산양 젖 특유의 냄새가 난다. 
      숙성이 덜 된 것은 신맛과 크리미한 맛이 있고, 숙성이 진행되면 신맛이 연해지고 깊은 감칠맛이 난다. 드라이 화이트 와인과 가벼운 레드 와인이 어울린다.</p>
       <h3>프레시 타입</h3>
      <p>우유를 유산균과 효소로 굳혀 물을 빼기만 하고 숙성시키지 않은 것으로서 '크림 치즈', '모차렐라', '코타주' 등이 있다. 
      프루티한 와인과 어울린다.</p>
      </v-tab-item>
    </v-tabs>
    </v-container>

 
  </v-app>
  </div>

</template>
<script>
import {Modal} from '@/components'
import {Button} from '@/components'
export default {
  name: 'Info',
  bodyClass: 'index-page',
  components: {
   Modal,
     [Button.name]: Button
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
       ,
       modals: {
            classic: false,
            cabernet:false,
            malbec:false,
            Carmenere:false,
            Merlot:false,
            Syrah:false,
            Pinot:false,
            Sangiovese:false,
            Tempranillo:false,
            Grenache:false,
            Zinfandel:false,
            Nebbiolo:false,
            Barbera:false,
            Chardonnay:false,
            Riesling:false,
            Blanc:false,
            Semillon:false,
            Trebbiano:false,


          }
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
