package com.winism.winism.service.review;

import java.util.List;

import com.winism.winism.dao.review.ReviewDAO;
import com.winism.winism.model.review.ReviewEntity;
import com.winism.winism.util.WinismDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewDAO reviewdao;

    
    WinismDate winismdate = new WinismDate();

    public List<ReviewEntity> findAllByUserid(String userid){
        return reviewdao.findAllByUserid(userid);
    }

    public List<ReviewEntity> findAll(){
        return reviewdao.findAll();
    }

    public List<ReviewEntity> findAllByWid(int wid){
        return reviewdao.findAllByWid(wid);
    }

    public void register(ReviewEntity entity){
        entity.setDate(winismdate.getToday());
        reviewdao.save(entity);
    }

    public void delete(int rid){        
        reviewdao.delete(reviewdao.findByRid(rid));
    }
    
}
