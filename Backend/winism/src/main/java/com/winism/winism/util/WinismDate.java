package com.winism.winism.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WinismDate {
    public String getToday(){
        Date date = new Date();
        SimpleDateFormat sdp = new SimpleDateFormat("YYYY.MM.dd-HH.mm");
        return sdp.format(date);
    }
    
}
