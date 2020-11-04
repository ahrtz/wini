package com.winism.winism.controller.favoritelist;


import java.util.List;

import com.winism.winism.model.favoritelist.FavoritelistEntity;
import com.winism.winism.service.favoritelist.FavoritelistService;

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

    @PostMapping("/favorite/add")
    public ResponseEntity<String> add(FavoritelistEntity fl){
        flservice.add(fl);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/favorite/remove")
    public ResponseEntity<String> remove(FavoritelistEntity fl){
        flservice.remove(fl);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    
    
    @PostMapping("/favorite/getbyid")
    public ResponseEntity<List<FavoritelistEntity>> getbyid(String uid){
        return new ResponseEntity<>(flservice.findByUid(uid), HttpStatus.OK);
    }

    





}
