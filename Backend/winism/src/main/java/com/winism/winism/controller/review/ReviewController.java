package com.winism.winism.controller.review;

import java.util.List;

import com.winism.winism.model.review.ReviewEntity;
import com.winism.winism.service.review.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" },maxAge = 6000)

@RestController
public class ReviewController {
    
    @Autowired
    ReviewService reviewservice;

    @PostMapping("/review/getbyid")
    public ResponseEntity<List<ReviewEntity>> getbyid(String userid){
        return new ResponseEntity<>(reviewservice.findAllByUserid(userid), HttpStatus.OK);
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
