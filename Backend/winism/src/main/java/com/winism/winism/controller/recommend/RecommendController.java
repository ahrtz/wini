package com.winism.winism.controller.recommend;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.google.gson.Gson;
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

        List<Object> result = new ArrayList<Object>();

        try{
            
            Gson gson = new Gson();
            String po = gson.toJson(wineservice.getbyid(wid));
            System.out.println(po);
            


            Process process = Runtime.getRuntime().exec("python C:\\Users\\git\\ssafy_project3\\s03p31a208\\Backend\\winism\\productRecommend.py ");
            // Process process = Runtime.getRuntime().exec("python /home/ubuntu/s03p31a208/Backend/winism/productRecommend.py");

            

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));
            // BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(),"MS949"));

            
            
            String s = "";
            String sre = "";
            String[] wines = new String[5];

            while((s= stdInput.readLine()) != null) {
                System.out.println(s);
                sre = s;
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
}
