package com.winism.winism.controller.wine;

import com.winism.winism.model.wine.wineList;
import com.winism.winism.service.wine.WineService;

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

    @PostMapping("/search/detail")
    public ResponseEntity<wineList> remove(int wid){
        return new ResponseEntity<>(wineservice.getbyid(wid), HttpStatus.OK);
    }



}
