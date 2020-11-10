package com.winism.winism.controller.favoritelist;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.winism.winism.dao.search.SearchDAO;
import com.winism.winism.model.favoritelist.FavoritelistEntity;
import com.winism.winism.model.wine.wineList;
import com.winism.winism.service.favoritelist.FavoritelistService;
import com.winism.winism.service.wine.WineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" },maxAge = 6000)

@RestController
public class FavoritelistController {
    @Autowired
    FavoritelistService flservice;

    @Autowired
    WineService wineservice;

  

    @PostMapping("/favorite/add")
    public ResponseEntity<String> add(FavoritelistEntity fl){

        List<FavoritelistEntity> list =  flservice.findByUid(fl.getUid());



        boolean flag = false;

        if(!list.isEmpty()){
            for(FavoritelistEntity arunit : list){
                if(arunit.getWid() == fl.getWid()){

                    flservice.remove(arunit);
                    flag = true;
                    break;

                }
            }
            if(flag){
                return new ResponseEntity<>("success", HttpStatus.OK);
            }
            else{
                flservice.add(fl);
                return new ResponseEntity<>("success", HttpStatus.OK);
            }
        }
        else{
            flservice.add(fl);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
    }


    @PostMapping("/favorite/check")
    public ResponseEntity<Boolean> check(String uid,int wid){

        List<FavoritelistEntity> ar =  flservice.findByUid(uid);
        for(FavoritelistEntity arunit : ar){
            if(arunit.getWid() == wid){
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(false, HttpStatus.OK);
    }


    @PostMapping("/favorite/remove")
    public ResponseEntity<String> remove(FavoritelistEntity fl){
        flservice.remove(fl);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    
    
    @PostMapping("/favorite/getbyid")
    public ResponseEntity<HashMap<String,Object>  > getbyid(String uid){
        
        HashMap<String,Object> hm = new HashMap<>();
        List<FavoritelistEntity> flar = flservice.findByUid(uid);
        ArrayList<wineList> ar = new ArrayList<>();
        for(FavoritelistEntity ff: flar){
            ar.add(wineservice.getbyid(ff.getWid()));
        }
        hm.put("list", ar);
        hm.put("size",ar.size());
        

        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    





}
