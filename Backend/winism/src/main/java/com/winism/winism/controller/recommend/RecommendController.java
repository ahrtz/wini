package com.winism.winism.controller.recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" },maxAge = 6000)

@RestController
public class RecommendController {
    @PostMapping("/recommend/contents")
    public ResponseEntity<ArrayList<String>> recommendbycontents(String userid){

        ArrayList<String> arr = new ArrayList<String>();
        
        try{
            Process process = Runtime.getRuntime().exec("python C:\\Users\\git\\ssafy_project3\\s03p31a208\\Backend\\winism\\test2.py TheLittlePrince 50");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));
            // BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(),"MS949"));

            
            
            String s = "";
            while((s= stdInput.readLine()) != null) {
                arr.add(s);
            }
            
            stdInput.close();
        }
        catch(Exception e){

        }
        return new ResponseEntity<>(arr, HttpStatus.OK);
    }
}
