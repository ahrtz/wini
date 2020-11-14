<template>
    <div class="wrapper" v-bind:style="{height:window.height+'px'}">
        <div id="center" class="col-xs-8 col-sm-9 col-md-7 col-lg-7" v-bind:style="{height:window.height+'px' , backgroundImage:'url(' + imageQ + ')'}">
                <div class="void" v-bind:style="{height:window.height*0.25+'px'}"></div>
                <div
                    class="textbox"
                    v-bind:style="{fontSize:window.height*0.03+'px' , height:window.height*0.2+'px'}"
                    v-html="'<br/>Q'+QCount+'. '+question"></div>
                <div class="void" v-bind:style="{height:window.height*0.05+'px'}"></div>
                <div class="selectArea">
                    <a v-on:click="clickans1()">
                        <div
                            class="selectBox1"
                            v-bind:style="{height:max*0.15+'px',width:max*0.15+'px', backgroundImage:'url(' + imageA1 + ')'}"/>
                    </a>

                    <a v-on:click="clickans2()">
                        <div
                            class="selectBox2"
                            v-bind:style="{height:max*0.15+'px',width:max*0.15+'px', backgroundImage:'url(' + imageA2 + ')'}"/>
                    </a>
            </div>
            <div class="selectArea">
                    <a v-on:click="clickans1()">
                        <div
                            class="selectBox1 seltext"
                            v-bind:style="{width:max*0.15+'px'}"
                            v-html="ans1"/>
                    </a>

                    <a v-on:click="clickans2()">
                        <div
                            class="selectBox2 seltext"
                            v-bind:style="{width:max*0.15+'px'}"
                            v-html="ans2"/>
                    </a>
            </div>

        </div>
    </div>
</template>
<script>
// import {Parallax} from '@/components'; import {FormGroupInput, Button} from
// '@/components'; import axios from 'axios'

const SERVER = 'http://k3a208.p.ssafy.io/'
export default {
    name: 'TestQuestion',
    components: {},
    created() {
        window.addEventListener('resize', this.handleResize);
        this.handleResize();
        this.nextQuest();
    },
    destroyed() {
        window.removeEventListener('resize', this.handleResize);
    },
    data() {
        return {
            window: {
                width: 0,
                height: 0
            },
            imageQ:"'img/questIMG/Quest"+"0"+".jpg'",
            imageA1:"'img/questIMG/Quest"+"0"+".jpg'",
            imageA2:"'img/questIMG/Quest"+"0"+".jpg'",
            max:0,
            QCount: 0,
            QNum: -1,
            question: '',
            ans1: '',
            ans2: '',
            mod: 0,
            ranArr: [
                [
                    6, 7, 8, 9, 10
                ],
                [
                    0, 1, 2
                ],
                [
                    3, 4, 5
                ]
            ],

            qList: [
                '당신은 감옥에 갇혔습니다. <br/> 생존을 위해 두가지 음식중 하나를 먹어야 합니다.',
                '오늘은 불타는 금요일의 퇴근길. <br/> 지금부터 무엇을 하지?',
                '베스킨라빈스에서 아이스크림을 고르는 내 모습',
                '길에서 괴한이 아는 사람을 위협하고있다. <br/>당신의 선택은?',
                '인간이 가장 허기진다는 새벽1시. <br/>냉장고에는 과일밖에 없다. ',
                '내 어린시절 꿈. 판검사 vs 의사',
                '날씨가 너무 춥다.. <br/>무언가로 몸을 녹여야겠다.',
                '오늘은 이성친구와 데이트날이다. <br/>친구의 신발끈이 풀려있네.',
                '오랜 친구들과 간만에 소주한잔, <br/>소주 맛이',
                '여러 사람과 즐기는 팀게임에서 나는?',
                '아주 슬픈 영화를 봤다. 모두들 펑펑 울었다.'
            ],
            ans1List: [
                '밥에 오렌지주스를 비벼먹는다.',
                '집으로 돌진. 자유시간을 즐긴다',
                '저거랑 저거 주세요.',
                '괴한을 제압하고 지인을 구한다.',
                '배달앱을 켠다. 치킨을 주문한다.',
                '검사',
                '따뜻~한 커피 한잔',
                '풀린 신발끈을 묶어준다.',
                '크으.. 오늘따라 소주가 쓰네..',
                '팀을 지원하는 지원가',
                '어헣허헣헣 ㅠㅠ'
            ],
            ans2List: [
                '밥에 콜라를 비벼먹는다.',
                '폰을 켜서 연락처를 본다. 일단 친구들에게 연락.',
                '어떤 맛이 제일 잘 나가요?',
                '차분하고 냉정하게 지나간다.',
                '과일로 허기를 체운다.',
                '의사',
                '든든~한 국밥 한그릇',
                '그게뭐?',
                '크으.. 소주가 달다 달아.',
                '팀을 이끄는 리더',
                '아 눈에 먼지 들어갔어.'
            ],

            scores: {
                red: 0,
                white: 0,
                sparkling: 0,
                sweet: 0,
                nosweet: 0
            },
            result: '레드,단'
        }
    },
    methods: {
        handleResize() {
            this.window.width = window.innerWidth;
            this.window.height = window.innerHeight;
            this.max = Math.max(this.window.width,this.window.height);
        },
        clickans1() {
            if (this.mod == 0) {
                this.scores.sweet++;
            } else if (this.mod == 1) {} else {
                this.scores.red++;
            }

            this.mod++;
            this.mod %= 3;
            this.nextQuest();
        },
        clickans2() {
            if (this.mod == 0) {
                this.scores.nosweet++;
            } else if (this.mod == 1) {
                this.scores.sparkling++;
            } else {
                this.scores.white++;
            }
            this.mod++;
            this.mod %= 3;
            this.nextQuest();
        },
        nextQuest() {
            this.QCount++;
            if (this.QCount == 8) {
                console.log(this.scores)
                this.checkscore()
                setTimeout(() => {
                    this.$emit('submitResult', this.result)
                }, 100);
                //넘기는거 여기에 넣어주세요
            } else {

                this.QNum = this.ranArr[this.mod][Math.floor(Math.random() * this.ranArr[this.mod].length)];
                this
                    .ranArr[this.mod]
                    .splice(this.ranArr[this.mod].indexOf(this.QNum), 1);

                this.question = this.qList[this.QNum];
                this.ans1 = this.ans1List[this.QNum];
                this.ans2 = this.ans2List[this.QNum];
                this.imageQ = "'img/questIMG/Quest"+this.QNum+".jpg'";
                this.imageA1 = "'img/questIMG/Ans1-"+this.QNum+".jpg'";
                this.imageA2 = "'img/questIMG/Ans2-"+this.QNum+".jpg'";
            }

        },
        checkscore() {
            if (this.scores.sparkling == 2) {
                if (this.scores.sweet > this.scores.nosweet) {
                    this.result = {
                        code: 0,
                        msg: "톡톡 튀고 활동적이며 배려심이 많은 당신, 달콤한 스파클링와인이 잘 어울려요.",
                        wine: {
                            img: "img/startertest_img0.jpg",
                            name_ko: "보시오 모스카토 다스티",
                            name_en: "Bosio Moscato d'Asti",
                            description: "과실향이 듬뿍 담긴 사랑스러운 맛. 치즈, 햄, 살라미와 같은 짭조름한 안주와 함께 즐겨보세요!"
                        }
                    };
                } else {
                    this.result = {
                        code: 1,
                        msg: "혼자보다는 함께가 좋은 당신, 생각보다 담백한 매력을 갖고 계시네요. 달지않은 스파클링 와인을 즐겨보는건 어때요?",
                        wine: {
                            img: "img/startertest_img1.jpg",
                            name_ko: "산테로 피노 샤르도네 스푸만테",
                            name_en: "Santero Pinot Chardonnay Spumante",
                            description: "누구나 친해질 수 있는 캐주얼한 친화력의 맛. 어떤 음식과 즐기셔도 좋아요!"
                        }
                    };
                }
            } else {
                if (this.scores.red > this.scores.white) {
                    if (this.scores.sweet > this.scores.nosweet) {
                        this.result = {
                            code: 2,
                            msg: "열정적이고 따뜻한 마음의 소유자! 달콤한 레드와인으로 시작해보세요!",
                            wine: {
                                img: "img/startertest_img2.jpeg",
                                name_ko: "모건 데이비드 콩코드",
                                name_en: "Mogen David Concord",
                                description: "달콤한 맛과 향, 매력적인 컬러를 가진 와인. 치즈나 스테이크와 함께 즐기시면 좋아요!"
                            }
                        }
                    } else {
                        this.result = {
                            code: 3,
                            msg: "차분하지만 누구보다 뜨거운 가슴의 소유자, 달지 않은 레드와인을 추천드려요!",
                            wine: {
                                img: "img/startertest_img3.jpg",
                                name_ko: "아발론 카베르네 소비뇽",
                                name_en: "Avalon Cabernet Sauvignon",
                                description: "블랙체리, 라즈베리, 블랙베리 등 과일 잼 같은 향이 진하게 풍기는 맛. 스테이크, 파스타, 치즈 등과 함께 즐겨보세요!"
                            }
                        }
                    }
                } else if (this.scores.red < this.scores.white) {
                    if (this.scores.sweet > this.scores.nosweet) {
                        this.result = {
                            code: 4,
                            msg: "상큼하고 시원한 성격의 당신, 달콤한 화이트와인으로 시작해보세요!",
                            wine: {
                                img: "img/startertest_img4.png",
                                name_ko: "에밀리아나 에코발란스 소비뇽 블랑",
                                name_en: "Emiliana Ecobalanced Sauvignon Blanc",
                                description: "은은한 레몬향이 매력적인 와인. 해산물, 치즈와 함께 곁들여 보세요. 한식도 잘 어울려요!"
                            }
                        }
                    } else {
                        this.result = {
                            code: 5,
                            msg: "시원시원 담백한 성격의 소유자, 달지 않은 화이트와인 어때요?",
                            wine: {
                                img: "img/startertest_img5.jpeg",
                                name_ko: "그리즐리 베어 샤도네이",
                                name_en: "Grizzly Bear Chardonnay",
                                description: "풍부한 아로마향과 실키한 텍스쳐, 마음을 사로잡는 부드럽고 감미로운 맛. 생선, 닭고기와 함께 음미해보세요!"
                            }
                        }
                    }
                } else {
                    if (this.scores.sweet > this.scores.nosweet) {
                        this.result = {
                            code: 6,
                            msg: "누구보다 스윗한 감성을 가진 당신, 스위트 와인을 추천해요!",
                            wine: {
                                img: "img/startertest_img6.jpeg",
                                name_ko: "모스카토 뿔리아",
                                name_en: "Moscato Pulia",
                                description: "복숭아향의 달콤한 스파클링 와인으로 케이크, 쿠키 등의 디저트와 잘 어울려요!"
                            }
                        }
                    } else {
                        this.result = {
                            msg: "아무거나 안단거",
                            code: 7,
                            msg: "누구보다 담백한 성격의 당신, 드라이 와인으로 시작해보세요!",
                            wine: {
                                img: "img/startertest_img7.png",
                                name_ko: "브라운 브라더스 윈드밀 쉬라즈",
                                name_en: "Grizzly Bear Chardonnay",
                                description: "자두, 라즈베리와 초콜릿의 여운이 맴도는 와인. 치즈와 함께 즐겨보세요!"
                            }
                        }
                    }
                }
            }
        }
    }
};
</script>
<style>
.wrapper {
    width: 100%;
    height: 100%;
    background-color: black;
}
#center {
    background-size: 100% 100%;
    margin: auto;
    width: 100%;
}
.textbox {
    text-align: center;
    font-size: 4vw;
    margin: auto;
    width: 70%;
    align-content: center;
    color: white;
    background-color: rgba(0,0,0,0.5`);
}
.selectArea {
    margin: auto;
    width: 100%;
    overflow: hidden;
}
.selectArea:after {
    content: '';
    display: block;
    overflow: hidden;
    height: 1.5em;
    /* controls position of line vertically */
}
.void-left {
    float: left;
}
.selectBox1 {
    background-size: 100% 100%;
    float: left;
    margin-left: 3em;
    background-color: white;
}
.selectBox2 {
    background-size: 100% 100%;
    float: right;
    margin-right: 3em;
    background-color: white;
}
.seltext{
    color: white;
    text-align: center;
    background-color: transparent;
}
</style>