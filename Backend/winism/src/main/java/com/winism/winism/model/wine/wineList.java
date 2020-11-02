package com.winism.winism.model.wine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="wine2")
public class wineList{

    @Id
    @Column(name="wid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int wid;

    @Column(name = "KONAME")
    private String KONAME;
    @Column(name = "ENNAME")
    private String ENNAME;
    @Column(name = "KOMAKER")
    private String KOMAKER;
    @Column(name = "ENMAKER")
    private String ENMAKER;
    @Column(name = "LOCAL")
    private String LOCAL;
}