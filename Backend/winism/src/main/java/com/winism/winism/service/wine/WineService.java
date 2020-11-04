package com.winism.winism.service.wine;

import com.winism.winism.dao.wine.WineDAO;
import com.winism.winism.model.wine.wineList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineService {
    @Autowired
    WineDAO winedao;

    public wineList getbyid(int wid){
        return winedao.findByWid(wid);
    }
}
