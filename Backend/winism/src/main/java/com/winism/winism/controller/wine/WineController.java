package com.winism.winism.controller.wine;

import java.util.ArrayList;
import java.util.List;

import com.winism.winism.model.wine.wineList;
import com.winism.winism.service.wine.WineService;
import com.winism.winism.util.UnicodeHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/search/auto")
    public ResponseEntity<List<wineList>> auto(String keyword){
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

    // @PostMapping("/search/test")
    // public void test1(){//전처리 하기
    //     List<wineList> list = wineservice.findall();

    //     int i = 0;
    //     for(wineList wine : list){
    //         String 
    //     }
    // }



}
