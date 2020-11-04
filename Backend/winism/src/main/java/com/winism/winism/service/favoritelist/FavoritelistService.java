package com.winism.winism.service.favoritelist;

import java.util.List;

import com.winism.winism.dao.favoritelist.FavoritelistDAO;
import com.winism.winism.model.favoritelist.FavoritelistEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritelistService {
    @Autowired
    FavoritelistDAO favodao;

    public void add(FavoritelistEntity fl){
        favodao.save(fl);
    }

    public void remove(FavoritelistEntity fl){
        favodao.delete(fl);
    }

    public List<FavoritelistEntity> findByUid(String uid){
        return favodao.findByUid(uid);
    }

}
