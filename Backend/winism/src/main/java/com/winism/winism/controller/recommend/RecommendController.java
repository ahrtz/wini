package com.winism.winism.controller.recommend;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.winism.winism.model.wine.wineList;
import com.winism.winism.service.wine.WineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" },maxAge = 6000)

@RestController
public class RecommendController {


    @Autowired
    WineService wineservice;

    @PostMapping("/recommend/contents")
    public ResponseEntity<List<Object>> recommendbycontents(String userid){

        List<Object> result = new ArrayList<Object>();
        System.out.println(1);
        
        try{
            // Process process = Runtime.getRuntime().exec("python C:\\Users\\git\\ssafy_project3\\s03p31a208\\Backend\\winism\\test2.py TheLittlePrince 50");
            Process process = Runtime.getRuntime().exec("python /home/ubuntu/s03p31a208/Backend/winism/test2.py");

            

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(),"MS949"));

            
            
            String s = "";
            String sre = "";
            String[] wines = new String[5];

            System.out.println("receive python");
            while((s= stdInput.readLine()) != null) {
                System.out.println(s);
                sre = s;
                // s = s.replaceAll("(", "").replaceAll(")", "").replaceAll(",","");
                // System.out.println(s);
                // wines = s.split(" ");
            }
            System.out.println("after receive python");
            System.out.println(sre);
            sre = sre.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",","");
            wines = sre.split(" ");

            System.out.println("after pretreaatment");
            System.out.println(sre);

            for(String wine :wines){
                HashMap hm = new HashMap<>();
                
                System.out.println(wine);
                wineList winel = wineservice.getbyid(Integer.parseInt(wine));
                hm.put("wine", winel);
                File fi = new File("/home/ubuntu/data/images/"+winel.getENNAME()+".png");
                if(fi.exists()){
                    hm.put("image", "http://k3a208.p.ssafy.io/images/"+winel.getENNAME()+".png");
                }
                else{
                    hm.put("image", null);
                }
                result.add(hm);
            }


            
            stdInput.close();
            System.out.println(2);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
