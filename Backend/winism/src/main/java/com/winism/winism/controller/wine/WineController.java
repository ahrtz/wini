package com.winism.winism.controller.wine;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.winism.winism.model.wine.wineList;
import com.winism.winism.service.wine.WineService;
import com.winism.winism.util.UnicodeHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
public class WineController {

    @Autowired
    WineService wineservice;

    @Autowired
    UnicodeHandler uh;

    @PostMapping("/search/detail")
    public ResponseEntity<wineList> remove(int wid){
        return new ResponseEntity<>(wineservice.getbyid(wid), HttpStatus.OK);
    }

    @GetMapping("/search/auto")
    public ResponseEntity<List<wineList>> auto(@RequestParam(required = false)String keyword){
        System.out.println(keyword);
        List<wineList> result = new ArrayList<>();
        if (keyword.charAt(0)>='ㄱ' && keyword.charAt(0)<='힣'){
            keyword = uh.splitHangeulToConsonant(keyword).replace(" ", ".") + "%";
            System.out.println(keyword);
            result = wineservice.findTop10BySPLITNAMELike(keyword);
        }
        else{
            result = wineservice.findTop10ByEnnameLike(keyword+"%");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/search/test")
    public void test(){//split 하기
        List<wineList> list = wineservice.findall();

        int i = 0;
        for(wineList wine : list){
            
            wine.setSPLITNAME(uh.splitHangeulToConsonant(wine.getKONAME()).replaceAll(" ", ""));
            wineservice.update(wine);
            i++;

            if(i%100 == 0){
                System.out.println(i);
            }
        }
    }

    @PostMapping("/search/test1")
    public void test1(){//split 하기
        List<wineList> list = wineservice.findall();

        int i = 0;
        for(wineList wine : list){
            
            
            String recommend = wine.getRECOMMANDATION();

            if(recommend.contains("육류") | recommend.contains("고기") | recommend.contains("소시지") | recommend.contains("살코기") | recommend.contains("프로슈토") | recommend.contains("토끼") |  recommend.contains("하몽") |  recommend.contains("육포") |  recommend.contains("햄") |  recommend.contains("미트볼")){
                recommend = "fork";
            }
            else if(recommend.contains("제육") |  recommend.contains("포크") |  recommend.contains("폭립")  |  recommend.contains("돼지") |  recommend.contains("바베큐") |  recommend.contains("바비큐") |  recommend.contains("삼겹살") |  recommend.contains("수육"))
            {
                recommend = "fork";
            }
            else if(recommend.contains("소고기") |  recommend.contains("스테이크") |  recommend.contains("소꼬리") |  recommend.contains("갈비") |  recommend.contains("한우") |  recommend.contains("곱창") |  recommend.contains("송아지") |  recommend.contains("안심") |  recommend.contains("등심"))
            {
                recommend = "beef";
            }
            else if(recommend.contains("닭") |  recommend.contains("치킨") |  recommend.contains("가금류") |  recommend.contains("거위") |  recommend.contains("조류"))
            {
                recommend = "poultry";
            }
            else if(recommend.contains("양"))
            {
                recommend = "lamb";
            }
            else if(recommend.contains("오리") |  recommend.contains("칠면조"))
            {
                recommend = "duck";
            }
            else if(recommend.contains("참치")  | recommend.contains("복어") | recommend.contains("생선") | recommend.contains("해산물") | recommend.contains("해물") | recommend.contains("연어") | recommend.contains("가자미") | recommend.contains("오징어") | recommend.contains("어류") | recommend.contains("스시") | recommend.contains("씨푸드") | recommend.contains("회"))
            {
                recommend = "fish";
            }
            else if(recommend.contains("조개") | recommend.contains("관자") | recommend.contains("가리비"))
            {
                recommend = "fish";
            }
            else if(recommend.contains("게") | recommend.contains("갑각류") | recommend.contains("랍스터") | recommend.contains("새우") | recommend.contains("가재") | recommend.contains("크랩"))
            {
                recommend = "fish";
            }
            else if(recommend.contains("피자") | recommend.contains("햄버거") | recommend.contains("버거"))
            {
                recommend = "instant";
            }
            else if(recommend.contains("디져트") | recommend.contains("디저트") | recommend.contains("타르트") | recommend.contains("케익") | recommend.contains("핑거푸드") | recommend.contains("츄러스") | recommend.contains("초콜릿") | recommend.contains("초콜렛") | recommend.contains("쿠키") | recommend.contains("아이스크림") | recommend.contains("티라미슈") | recommend.contains("케이크") | recommend.contains("비스켓"))
            {
                recommend = "dessert";
            }
            else if(recommend.contains("치즈"))
            {
                recommend = "cheese";
            }
            else if(recommend.contains("과일") | recommend.contains("오렌지") | recommend.contains("복숭아") | recommend.contains("딸기") | recommend.contains("과일") | recommend.contains("아보카도") | recommend.contains("크랜베리"))
            {
                recommend = "dessert";
            }

            else if(recommend.contains("파스타") | recommend.contains("리조또") | recommend.contains("스파게티") | recommend.contains("스프") | recommend.contains("라자냐") | recommend.contains("케밥") | recommend.contains("푸아그라"))
            {
                recommend = "western";
            }
            else if(recommend.contains("버섯") | recommend.contains("샐러드") | recommend.contains("너츠") | recommend.contains("올리브") | recommend.contains("야채") | recommend.contains("채소") | recommend.contains("견과"))
            {
                recommend = "vegetable";
            }

            else if(recommend.contains("베이글") | recommend.contains("빵") | recommend.contains("밀가루") | recommend.contains("파이"))
            {
                recommend = "dessert";
            }
            else{
                recommend = "etc";
            }

            wine.setRECOMMANDATION(recommend);
            
            wineservice.update(wine);
            i++;

            if(i%100 == 0){
                System.out.println(i);
            }
            
        }
    }

    @PostMapping("/search/test2")
    public void test2(){//split 하기
        int i = 1;

        try{
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/wine2.csv"), "MS949"));
            
            fw.write("wid,");
            fw.write("SWEETNESS,");
            fw.write("ACIDITY,");
            fw.write("BODY,");
            fw.write("TANNIN,");
            fw.write("LAESTDEGREE,");
            fw.write("USE,");
            fw.write("RECOMMANDATION,");
            fw.write("GRAPE,");
            fw.write("TEMPERATURE,");
            fw.write("CAPACITY,");
            fw.write("GRADE,");
            fw.write("TYPE,");
            fw.write("COST,");
            fw.write("KOMAKER,");
            fw.write("YEAR,");
            fw.write("ENMAKER,");
            fw.write("LOCAL,");
            fw.write("KONAME,");
            fw.write("ENNAME,");
            fw.newLine();



            List<wineList> list = wineservice.findall();

            for(wineList wine : list){
                fw.write(i+",");

                if(wine.getSWEETNESS().contains("None")){
                    fw.write("0"+",");
                }
                else{
                    fw.write(Integer.parseInt(wine.getSWEETNESS())+",");
                }

                if(wine.getACIDITY().contains("None")){
                    fw.write("0"+",");
                }
                else{
                    fw.write(Integer.parseInt(wine.getACIDITY())+",");
                }

                if(wine.getBODY().contains("None")){
                    fw.write("0"+",");
                }
                else{
                    fw.write(Integer.parseInt(wine.getBODY())+",");
                }

                if(wine.getTANNIN().contains("None")){
                    fw.write("0"+",");
                }
                else{
                    fw.write(Integer.parseInt(wine.getTANNIN())+",");
                }

                if(wine.getLAESTDEGREE().contains("None")){
                    fw.write("0"+",");
                }
                else{
                    fw.write(wine.getLAESTDEGREE()+",");
                }

                
                fw.write(wine.getUSE()+",");
                fw.write(wine.getRECOMMANDATION()+",");
                fw.write(wine.getGRAPE()+",");
                fw.write(wine.getTEMPERATURE()+",");
                fw.write(wine.getCAPACITY()+",");
                fw.write(wine.getGRADE()+",");
                fw.write(wine.getTYPE()+",");
                fw.write(wine.getCOST()+",");
                fw.write(wine.getKOMAKER()+",");
                fw.write(wine.getYEAR()+",");
                fw.write(wine.getENMAKER()+",");
                fw.write(wine.getLOCAL()+",");
                fw.write(wine.getKONAME()+",");
                fw.write(wine.getENNAME());
                fw.newLine();
                i = i+1;
                    
            }

            fw.close();
        }
        
        catch(Exception e){

        }
        

            

    }



}
