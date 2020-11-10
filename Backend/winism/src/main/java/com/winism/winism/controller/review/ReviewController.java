package com.winism.winism.controller.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.winism.winism.model.review.ReviewEntity;
import com.winism.winism.service.review.ReviewService;
import com.winism.winism.util.FileCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" },maxAge = 6000)

@RestController
public class ReviewController {
    
    @Autowired
    ReviewService reviewservice;

    @PostMapping("/review/getbyid")
    public ResponseEntity<List<Object>> getbyid(String userid){

        List<ReviewEntity> list = reviewservice.findAllByUserid(userid);

        List<Object> result = new ArrayList<>();
        FileCheck fc = new FileCheck();
        for(ReviewEntity re : list){
            HashMap<String,Object> hm = new HashMap<>();
            hm.put("review", re);
            hm.put("image", fc.checkImage(re.getWinename()));
            result.add(hm);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PostMapping("/review/getbywine")
    public ResponseEntity<List<Object>> getbywine(int wid){

        

        List<ReviewEntity> list = reviewservice.findAllByWid(wid);

        List<Object> result = new ArrayList<>();
        FileCheck fc = new FileCheck();
        for(ReviewEntity re : list){
            HashMap<String,Object> hm = new HashMap<>();
            hm.put("review", re);
            hm.put("image", fc.checkImage(re.getWinename()));
            result.add(hm);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/review/register")
    public ResponseEntity<Object> register(ReviewEntity entity){
        reviewservice.register(entity);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/review/update")
    public ResponseEntity<Object> update(ReviewEntity entity){
        reviewservice.register(entity);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/review/delete")
    public ResponseEntity<Object> delete(int rid){
        reviewservice.delete(rid);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }



}
