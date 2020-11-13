<template>
    <div class="wrapper" v-bind:style="{height:window.height+'px'}">
        <div id="center" class="col-xs-8 col-sm-9 col-md-7 col-lg-7" v-bind:style="{height:window.height+'px' , backgroundImage:'url(' + imageQ + ')'}">
                <div class="void" v-bind:style="{height:window.height*0.25+'px'}"></div>
                <div
                    class="textbox"
                    v-bind:style="{fontSize:window.height*0.03+'px' , height:window.height*0.2+'px'}"
                    v-html="'Q'+QCount+'. '+question"></div>
                <div class="void" v-bind:style="{height:window.height*0.05+'px'}"></div>
                <div class="selectArea">
                    <a v-on:click="clickans1()">
                        <div
                            class="selectBox1"
                            v-bind:style="{height:max*0.15+'px',width:max*0.15+'px'}"/>
                    </a>

                    <a v-on:click="clickans2()">
                        <div
                            class="selectBox2"
                            v-bind:style="{height:max*0.15+'px',width:max*0.15+'px'}"/>
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
                this.checkscore();
                //넘기는거 여기에 넣어주세요
            } else {

                this.QNum = this.ranArr[this.mod][Math.floor(Math.random() * this.ranArr[this.mod].length)];
                this
                    .ranArr[this.mod]
                    .splice(this.ranArr[this.mod].indexOf(this.QNum), 1);

                this.question = this.qList[this.QNum];
                this.ans1 = this.ans1List[this.QNum];
                this.ans2 = this.ans2List[this.QNum];
            }

        },
        checkscore() {
            if (this.scores.sparkling == 2) {
                if (this.scores.sweet > nosweet) {
                    this.result = {
                        0: "스파클링 달달한거"
                    };
                } else {
                    this.result = {
                        1: "스파클링 안단거"
                    };
                }
            } else {
                if (this.scores.red > this.scores.white) {
                    if (this.scores.sweet > nosweet) {
                        this.result = {
                            2: "레드 달달한거"
                        }
                    } else {
                        this.result = {
                            3: "레드 안단거"
                        }
                    }
                } else if (this.scores.red < this.scores.white) {
                    if (this.scores.sweet > nosweet) {
                        this.result = {
                            4: "화이트 달달한거"
                        }
                    } else {
                        this.result = {
                            5: "화이트 안단거"
                        }
                    }
                } else {
                    if (this.scores.sweet > nosweet) {
                        this.result = {
                            6: "아무거나 달달한거"
                        }
                    } else {
                        this.result = {
                            7: "아무거나 안단거"
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
    float: left;
    margin-left: 3em;
    background-color: white;
}
.selectBox2 {
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