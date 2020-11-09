package com.winism.winism.controller.recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    public ResponseEntity<List<wineList>> recommendbycontents(String userid){

        List<wineList> result = new ArrayList<wineList>();
        System.out.println(1);
        
        try{
            // Process process = Runtime.getRuntime().exec("python C:\\Users\\git\\ssafy_project3\\s03p31a208\\Backend\\winism\\test2.py TheLittlePrince 50");
            Process process = Runtime.getRuntime().exec("python /home/ubuntu/s03p31a208/Backend/winism/test2.py");

            

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(),"MS949"));

            
            
            String s = "";
            

            while((s= stdInput.readLine()) != null) {
                System.out.println(s);
            }

            s = s.replaceAll("(", "").replaceAll(")", "").replaceAll(",","");
            System.out.println("s : "+s);  
            String[] wines = s.split(" ");
            

            for(String wine :wines){
                System.out.println(wine);
                result.add(wineservice.getbyid(Integer.parseInt(wine)));
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
