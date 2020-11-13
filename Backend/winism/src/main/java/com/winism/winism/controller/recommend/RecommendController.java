package com.winism.winism.controller.recommend;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.google.gson.Gson;
import com.winism.winism.model.favoritelist.FavoritelistEntity;
import com.winism.winism.model.review.ReviewEntity;
import com.winism.winism.model.wine.wineList;
import com.winism.winism.service.favoritelist.FavoritelistService;
import com.winism.winism.service.review.ReviewService;
import com.winism.winism.service.wine.WineService;
import com.winism.winism.util.FileCheck;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" },maxAge = 6000)

@RestController
public class RecommendController {


    @Autowired
    WineService wineservice;

    @Autowired
    ReviewService reviewservice;

    @Autowired
    FavoritelistService fvservice;

    @GetMapping("/recommend/bywine")
    public ResponseEntity<List<Object>> recommendbywine(@RequestParam(required = false)int wid){


        List<FavoritelistEntity> fvlist =  fvservice.findall();
        
        HashMap<String,HashSet<Integer>> hmm = new HashMap<>();
        try{
            for(FavoritelistEntity fl : fvlist){
                HashSet<Integer> hs = new HashSet<>(); 
    
                if(hmm.get(fl.getUid()) != null){
                    hs = hmm.get(fl.getUid());        
                }
                else{
                    hs = new HashSet<>();
                }
                hs.add(fl.getWid());
                hmm.put(fl.getUid(), hs);
               
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        List<ReviewEntity> rlist = reviewservice.findAll();

        try{
            for(ReviewEntity fl : rlist){
                HashSet<Integer> hs = new HashSet<>(); 
    
                if(hmm.get(fl.getUserid()) != null){
                    hs = hmm.get(fl.getUserid());        
                }
                else{
                    hs = new HashSet<>();
                }
                hs.add(fl.getWid());
                hmm.put(fl.getUserid(), hs);
               
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        HashMap<Integer,Integer> resultHm = new HashMap<>();

        for(String key : hmm.keySet()){
            HashSet<Integer> hs = hmm.get(key);
            if(hs.contains(wid)){

                for(int i : hs){
                    if(i != wid){
                        if(resultHm.get(i) == null){
                           resultHm.put(i, 1) ;
                        }
                        else{
                            resultHm.put(i, resultHm.get(i)+1) ;
                        }
                    }
                }
            }
        }

        // System.out.println(resultHm);
        
        List<Integer> keySetList = new ArrayList<>(resultHm.keySet());

        Collections.sort(keySetList, (o1, o2) -> (resultHm.get(o2).compareTo(resultHm.get(o1))));
        
        String arg = "";
        int k = 0;
        for(int i : keySetList){
            // System.out.println("key : "+i+" value : "+resultHm.get(i)); // 리뷰 찜 통계 찍거보기
            if(k == 5){
                break;
            }
            else{
                arg += i+",";
                k++;
            }
        }
        if(arg.equals("")){
            arg = "null";
        }
        

        List<Object> result = new ArrayList<Object>();

        try{
            wineList wl = wineservice.getbyid(wid);

            JSONObject obj = new JSONObject();
            // obj.put("\"suger\"","\""+wl.getSWEETNESS()+"\"");   
            // obj.put("\"acid\"","\""+wl.getACIDITY()+"\"");   
            // obj.put("\"body\"","\""+wl.getBODY()+"\"");   
            // obj.put("\"tanin\"","\""+wl.getTANNIN()+"\"");   
            // obj.put("\"price\"","\""+wl.getCOST()+"\"");   
            // obj.put("\"food\"","\""+wl.getRECOMMANDATION()+"\"");   
            // obj.put("\"alcoo\"","\""+wl.getLAESTDEGREE()+"\""); 
            
            obj.put("suger",wl.getSWEETNESS());   
            obj.put("acid",wl.getACIDITY());   
            obj.put("body",wl.getBODY());   
            obj.put("tanin",wl.getTANNIN());   
            obj.put("price",wl.getCOST());   
            obj.put("food",wl.getRECOMMANDATION());   
            obj.put("alcoo",wl.getLAESTDEGREE());  

            
            // Process process = Runtime.getRuntime().exec("python C:\\Users\\git\\ssafy_project3\\s03p31a208\\Backend\\winism\\productRecommend.py "+obj+" "+arg);
            Process process = Runtime.getRuntime().exec("python /home/ubuntu/s03p31a208/Backend/winism/productRecommend.py "+obj+" "+arg);

            

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(),"MS949"));

            
            
            String s = "";
            String sre = "";
            String[] wines = new String[5];

            while((s= stdInput.readLine()) != null) {
                System.out.println(s);
                sre = s;
            }

            while((s= stdError.readLine()) != null) {
                System.out.println(s);
            }

            sre = sre.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",","");
            wines = sre.split(" ");


            FileCheck fc = new FileCheck();

            for(String wine :wines){
                HashMap<String,Object> hm = new HashMap<>();
                
                wineList winel = wineservice.getbyid(Integer.parseInt(wine));
                hm.put("wine", winel);
                hm.put("image",fc.checkImage(winel.getENNAME()));

                result.add(hm);
            }


            
            stdInput.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/recommend/byfavoandreview")
    public ResponseEntity<List<Object>> recommendbyfavoandreview(@RequestParam(required = false)String userid){

        List<FavoritelistEntity> fvlist =  fvservice.findByUid(userid);
        
        HashSet<Integer> hs = new HashSet<>(); 

        try{    
            for(FavoritelistEntity fl : fvlist){
                    hs.add(fl.getWid());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        List<ReviewEntity> rlist = reviewservice.findAllByUserid(userid);

        try{
            for(ReviewEntity fl : rlist){
                    hs.add(fl.getWid());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        
        HashMap<String,Integer> SWEETNESS = new HashMap<>();
        HashMap<String,Integer> ACIDITY = new HashMap<>();
        HashMap<String,Integer> BODY = new HashMap<>();
        HashMap<String,Integer> TANNIN = new HashMap<>();
        HashMap<String,Integer> COST = new HashMap<>();
        HashMap<String,Integer> RECOMMANDATION = new HashMap<>();
        HashMap<String,Integer> LAESTDEGREE = new HashMap<>();

        

        for(int i : hs){
            wineList wl = wineservice.getbyid(i);

            if(SWEETNESS.get(wl.getSWEETNESS()+"") == null){
                SWEETNESS.put(wl.getSWEETNESS()+"", 1);
            }
            else{
                SWEETNESS.put(wl.getSWEETNESS()+"", SWEETNESS.get(wl.getSWEETNESS()) + 1);
            }

            if(ACIDITY.get(wl.getACIDITY()+"") == null){
                ACIDITY.put(wl.getACIDITY()+"", 1);
            }
            else{
                ACIDITY.put(wl.getACIDITY()+"", ACIDITY.get(wl.getACIDITY()) + 1);
            }

            if(BODY.get(wl.getBODY()+"") == null){
                BODY.put(wl.getBODY()+"", 1);
            }
            else{
                BODY.put(wl.getBODY()+"", BODY.get(wl.getBODY()) + 1);
            }

            if(TANNIN.get(wl.getTANNIN()+"") == null){
                TANNIN.put(wl.getTANNIN()+"", 1);
            }
            else{
                TANNIN.put(wl.getTANNIN()+"", TANNIN.get(wl.getTANNIN()) + 1);
            }


            if(!wl.getCOST().equals("가격정보없음")){
                if(COST.get(wl.getCOST()+"") == null){
                    COST.put(wl.getCOST()+"", 1);
                }
                else{
                    COST.put(wl.getCOST()+"", COST.get(wl.getCOST()) + 1);
                }
            }
            
            if(!wl.getRECOMMANDATION().equals("etc")){
                if(RECOMMANDATION.get(wl.getRECOMMANDATION()+"") == null){
                    RECOMMANDATION.put(wl.getRECOMMANDATION()+"", 1);
                }
                else{
                    RECOMMANDATION.put(wl.getRECOMMANDATION()+"", RECOMMANDATION.get(wl.getRECOMMANDATION()) + 1);
                }
            }

            if(LAESTDEGREE.get(wl.getLAESTDEGREE()+"") == null){
                LAESTDEGREE.put(wl.getLAESTDEGREE()+"", 1);
            }
            else{
                LAESTDEGREE.put(wl.getLAESTDEGREE()+"", LAESTDEGREE.get(wl.getLAESTDEGREE()) + 1);
            }
        }
        
        System.out.println(SWEETNESS);
        System.out.println();
        System.out.println(ACIDITY);
        System.out.println();
        System.out.println(BODY);
        System.out.println();
        System.out.println(TANNIN);
        System.out.println();
        System.out.println(COST);
        System.out.println();
        System.out.println(RECOMMANDATION);
        System.out.println();
        System.out.println(LAESTDEGREE);
        System.out.println();

        

        JSONObject obj = new JSONObject();
        obj.put("\"suger\"","\""+maxValue(SWEETNESS)+"\"");   
        obj.put("\"acid\"","\""+maxValue(ACIDITY)+"\"");   
        obj.put("\"body\"","\""+maxValue(BODY)+"\"");   
        obj.put("\"tanin\"","\""+maxValue(TANNIN)+"\"");
        obj.put("\"price\"","\""+maxValue(COST)+"\"");   
        obj.put("\"food\"","\""+maxValue(RECOMMANDATION)+"\"");   
        obj.put("\"alcoo\"","\""+maxValue(LAESTDEGREE)+"\"");   
        

        List<Object> result = new ArrayList<Object>();
        String arg = "null";

        try{
   

            
            // Process process = Runtime.getRuntime().exec("python C:\\Users\\git\\ssafy_project3\\s03p31a208\\Backend\\winism\\productRecommend.py "+obj+" "+arg);
            Process process = Runtime.getRuntime().exec("python /home/ubuntu/s03p31a208/Backend/winism/productRecommend.py "+obj+" "+arg);

            

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(),"MS949"));

            
            
            String s = "";
            String sre = "";
            String[] wines = new String[5];

            while((s= stdInput.readLine()) != null) {
                System.out.println(s);
                sre = s;
            }

            while((s= stdError.readLine()) != null) {
                System.out.println(s);
            }

            sre = sre.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",","");
            wines = sre.split(" ");


            FileCheck fc = new FileCheck();

            for(String wine :wines){
                HashMap<String,Object> hm = new HashMap<>();
                
                wineList winel = wineservice.getbyid(Integer.parseInt(wine));
                hm.put("wine", winel);
                hm.put("image",fc.checkImage(winel.getENNAME()));

                result.add(hm);
            }


            
            stdInput.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    public String maxValue(HashMap<String,Integer> hm){
        String max = "";

        List<String> keySetList = new ArrayList<>(hm.keySet());

        Collections.sort(keySetList, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));

        for(String key : keySetList){
            max = key;
            break;
        }

        return max;
        
    }
}
