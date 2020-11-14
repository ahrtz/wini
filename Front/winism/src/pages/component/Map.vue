<template>
 <div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
    <ul id="category">
        <li id="CS2" data-order="0"> 
            <span class="category_bg store"></span>
            편의점
        </li>      
   
    </ul>
</div>

</template>

<script>
export default {
  name: 'Map',

  data() {
    return {
      searchKeyword: '',
      markers: [],
      container: '',
      options: '',
      map: '',
      marker: '',
      ps: '',
      coordinate: '',
      placeOverlay:'',
      contentNode:'',
      currCategory:'',
      lat:'',
      lon:'',
      locPosition:'',
      textContent:'',
      placelist:[],
      
    }
  },
  props: {
    store: {
      type: String
    }
  },
  methods: {

   initMap() {
       this.placeOverlay = new kakao.maps.CustomOverlay({zIndex:1}), 
    this.contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다 
    this.markers = [], // 마커를 담을 배열입니다
    this.currCategory = 'CS2'; // 현재 선택된 카테고리를 가지고 있을 변수입니다

      const container = document.getElementById('map')
      console.log(this.lat)
      console.log(this.lon)
    
      const mapOption = {
        center: new kakao.maps.LatLng(this.lat, this.lon),
        level: 5
      }
    
      this.map = new kakao.maps.Map(container, mapOption) //마커추가하려면 객체를 아래와 같이 하나 만든다. 
        
      this.marker = new kakao.maps.Marker({
        position: this.map.getCenter()
      })
      this.marker.setMap(this.map);
      
      this.ps = new kakao.maps.services.Places(this.map)
     kakao.maps.event.addListener(this.map, 'idle', this.searchPlaces);
   
      this.addEventHandle(this.contentNode, 'mousedown', kakao.maps.event.preventMap);
this.addEventHandle(this.contentNode, 'touchstart', kakao.maps.event.preventMap);
this.placeOverlay.setContent(this.contentNode);  
this.onClickCategory();
    },
    addEventHandle(target, type, callback) {
    if (target.addEventListener) {
        target.addEventListener(type, callback);
    } else {
        target.attachEvent('on' + type, callback);
    }
},
    // 키워드 검색을 요청하는 함수입니다
    searchPlaces() {

         if (!this.currCategory) {
        return;
    }
this.placeOverlay.setMap(null);
this.removeMarker();
this.ps.categorySearch(this.currCategory, this.placesSearchCB, {useMapBounds:true}); 
    },
    // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
    placesSearchCB(data, status, pagination) {
      if (status === kakao.maps.services.Status.OK) {
        // 정상적으로 검색이 완료됐으면 검색 목록과 마커를 표출합니다
        console.log(data)
        this.displayPlaces(data);
      } 
    //   else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    //     alert('검색 결과가 존재하지 않습니다.');
    //     return;
    //   } else if (status === kakao.maps.services.Status.ERROR) {
    //     alert('검색 결과 중 오류가 발생했습니다.');
    //     return;
    //   }
    },
    // 검색 결과 목록과 마커를 표출하는 함수입니다
    displayPlaces(places) {
        var order = document.getElementById(this.currCategory).getAttribute('data-order');
        if(this.store==='emart'){
            this.store='이마트'
        }
        this.placelist=[]
      for (var i = 0; i < places.length; i++) {
          console.log(places[i])
          console.log(this.placelist)
          
        // 마커를 생성하고 지도에 표시합니다
        if(places[i].place_name.includes(this.store)){
            this.placelist.push(places[i])
             for (var j = 0; j < this.placelist.length; j++){
                  var 
          marker = this.addMarker(new kakao.maps.LatLng(this.placelist[j].y, this.placelist[j].x),order);
            (function(marker, place,abc) {
                kakao.maps.event.addListener(marker, 'click', function() {
                    abc.displayPlaceInfo(place);
                });
            })(marker, this.placelist[j],this);
             }
        //     var 
        //   marker = this.addMarker(new kakao.maps.LatLng(places[i].y, places[i].x),order);
 
        //   // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해 LatLngBounds 객체에 좌표를 추가합니다
        //   (function(marker, place,abc) {
        //         kakao.maps.event.addListener(marker, 'click', function() {
        //             abc.displayPlaceInfo(place);
        //         });
        //     })(marker, places[i],this);

        }
        
          
        
      }

    },
    // 검색결과 항목을 Element로 반환하는 함수입니다
  displayPlaceInfo (place) {
    var content = '<div class="placeinfo">' +
                    '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';   

    if (place.road_address_name) {
        content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
                    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
    }  else {
        content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
    }                
   
    content += '    <span class="tel">' + place.phone + '</span>' + 
                '</div>' + 
                '<div class="after"></div>';

    this.contentNode.innerHTML = content;
    this.placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
    this.placeOverlay.setMap(this.map);  
},
    // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
   addMarker(position, order) {
    console.log(order)
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(46, (order*36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(this.map); // 지도 위에 마커를 표출합니다
    this.markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
},
    // 지도 위에 표시되고 있는 마커를 모두 제거합니다
    removeMarker() {
      for (var i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.markers = [];
    },

onClickCategory() {
    var category = document.getElementById('category'),
    children = category.children;
    var id = children[0].id
    if (children[0].className='') {
        children[0].className = 'on';
    } 
    else{
        children[0].className=''
    }
    console.log(children[0].className)
    this.placeOverlay.setMap(null);
        this.removeMarker();
        this.currCategory = id;
        this.searchPlaces();
    
},

 

  },
  computed: {
  },
  created() {
    

  },
  watch: {
    store: function () {
        this.initMap();
    }},
  mounted() {
      if(!("geolocation" in navigator)) {
            this.textContent = 'Geolocation is not available.';
            return;
            }
            this.textContent = 'Locating...'
            
            // get position
            navigator.geolocation.getCurrentPosition(pos => {
            this.lat = pos.coords.latitude;
            this.lon = pos.coords.longitude;
            this.textContent = 'Your location data is ' + this.lat + ', ' + this.lon
            }, err => {
            this.textContent = err.message;
            })
    if (window.kakao && window.kakao.maps) {
      setTimeout(() => {
        this.initMap()
      }, 100)
    } else {
      const script = document.createElement('script');
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=caabdd0825a33e45f0ba6cdb6c0570af';
      document.head.appendChild(script);
    }

    
  },
}
</script>

<style scoped>
.map_wrap, .map_wrap * {margin:0; padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap {position:relative;width:100%;height:350px;}
#category {position:absolute;top:10px;left:10px;border-radius: 5px; border:1px solid #909090;box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);background: #fff;overflow: hidden;z-index: 2;}
#category li {float:left;list-style: none;width:50px;border-right:1px solid #acacac;padding:6px 0;text-align: center; cursor: pointer;}
#category li.on {background: #eee;}
#category li:hover {background: #ffe6e6;border-left:1px solid #acacac;margin-left: -1px;}
#category li:last-child{margin-right:0;border-right:0;}
#category li span {display: block;margin:0 auto 3px;width:27px;height: 28px;}
#category li .category_bg {background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png) no-repeat;}
#category li .store {background-position: -10px -180px;}
#category li.on .category_bg {background-position-x:-46px;}
.placeinfo_wrap {position:absolute;bottom:28px;left:-150px;width:300px;}
.placeinfo {position:relative;width:100%;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;padding-bottom: 10px;background: #fff;}
.placeinfo:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.placeinfo_wrap .after {content:'';position:relative;margin-left:-12px;left:50%;width:22px;height:12px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.placeinfo a, .placeinfo a:hover, .placeinfo a:active{color:#fff;text-decoration: none;}
.placeinfo a, .placeinfo span {display: block;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
.placeinfo span {margin:5px 5px 0 5px;cursor: default;font-size:13px;}
.placeinfo .title {font-weight: bold; font-size:14px;border-radius: 6px 6px 0 0;margin: -1px -1px 0 -1px;padding:10px; color: #fff;background: #d95050;background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;}
.placeinfo .tel {color:#0f7833;}
.placeinfo .jibun {color:#999;font-size:11px;margin-top:0;}


</style>