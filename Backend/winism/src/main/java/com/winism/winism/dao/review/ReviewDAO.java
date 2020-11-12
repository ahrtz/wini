package com.winism.winism.dao.review;

import java.util.List;

import com.winism.winism.model.review.ReviewEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<ReviewEntity, Long>{
    
    public List<ReviewEntity> findAllByUserid(String userid);
    public List<ReviewEntity> findAllByWid(int wid);
    public ReviewEntity findByRid(int rid);


}
