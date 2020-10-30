package com.winism.winism.service.review;

import java.util.List;

import com.winism.winism.dao.review.ReviewDAO;
import com.winism.winism.model.review.ReviewEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewDAO reviewdao;

    public List<ReviewEntity> findAllByUserid(String userid){
        return reviewdao.findAllByUserid(userid);
    }

    public void register(ReviewEntity entity){
        reviewdao.save(entity);
    }

    public void delete(int rid){        
        reviewdao.delete(reviewdao.findByRid(rid));
    }
    
}
