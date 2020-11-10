package com.winism.winism.util;

import java.io.File;

public class FileCheck {
    
    public String checkImage(String img){
        
        File fi = new File("/home/ubuntu/data/images/"+img+".png");
        
        if(fi.exists()){
            return "http://k3a208.p.ssafy.io/images/"+img+".png";
        }
        else{
            return null;
        }
    }

}
