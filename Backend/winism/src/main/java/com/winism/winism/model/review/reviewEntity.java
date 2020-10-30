package com.winism.winism.model.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "review")
public class reviewEntity {

    @Id
    @Column(name="rid")
    int rid;

    @Column(name="title")
    String title;

    @Column(name="rating")
    String rating;
    
    @Column(name="date")
    String date;

    @Column(name="winename")
    String winename;

    @Column(name="userid")
    String userid;

    @Column(name="content")
    String content;

}
