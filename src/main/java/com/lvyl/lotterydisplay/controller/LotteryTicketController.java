package com.lvyl.lotterydisplay.controller;

import com.lvyl.lotterydisplay.services.Game2048Service;
import com.lvyl.lotterydisplay.services.RecentTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotteryTicketController {
    @Autowired
    private RecentTerm recentTerm;
    @Autowired
    private Game2048Service game2048Service;
    @RequestMapping({"/getRecentTerm"})
    public String getRecentTerm(String callback){
        System.out.println(callback);
        return callback+recentTerm.getRecentTerm();
    }
    @RequestMapping({"/getBeginAndEnd"})
    public String getRecentTenTerm(String callback,String begin,String end){
        return callback+recentTerm.getBeginAndEnd(begin,end);
    }
    @RequestMapping({"/getProbability"})
    public String getProbability(String callback,String count){
        return callback+recentTerm.getProbability(count);
    }
    @RequestMapping({"/getMax2048"})
    public String getMax2048(String callback){
        return callback+game2048Service.getMaxCount();
    }
}
