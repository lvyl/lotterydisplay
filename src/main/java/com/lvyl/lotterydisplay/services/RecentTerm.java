package com.lvyl.lotterydisplay.services;

import com.lvyl.lotterydisplay.mapper.LotteryTicketMapper;
import com.lvyl.lotterydisplay.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("/recentTerm")
public class RecentTerm {
    @Autowired
    private LotteryTicketMapper lotteryTicketMapper;
    @Autowired
    private Utils utils;
    public String getRecentTerm(){
        Map param = new HashMap();
        param.put("begin",0);
        param.put("size",1);
        List resultMap = lotteryTicketMapper.selectRecentTerm(param);
        return utils.objectToJson(resultMap);
    }
    public String getBeginAndEnd(String begin,String end){
        int beginInt = Integer.parseInt(begin);
        int endInt = Integer.parseInt(end);
        if(beginInt==0||endInt==0){
            Map param = new HashMap();
            param.put("begin",0);
            param.put("size",10);
            List resultMap = lotteryTicketMapper.selectRecentTerm(param);
            return utils.objectToJson(resultMap);
        }

        if(beginInt<endInt){
            beginInt = beginInt^endInt;
            endInt = beginInt^endInt;
            beginInt = beginInt^endInt;
        }
        Map param = new HashMap();
        param.put("begin",beginInt);
        param.put("end",endInt);
        List resultMap = lotteryTicketMapper.selectTermBeginAndEnd(param);
        return utils.objectToJson(resultMap);
    }
    public String getProbability(String count){
        int countInt = Integer.parseInt(count);
        List resultMap ;
        if(countInt==0){
            Map param = new HashMap();
            param.put("begin",0);
            param.put("size",50);
            resultMap = lotteryTicketMapper.selectRecentTerm(param);

        }else{
            Map param = new HashMap();
            param.put("count",countInt);
            resultMap = lotteryTicketMapper.selectTermBeginAndEnd(param);
        }
        List<Map> allNum = new ArrayList();
        for(int i=0;i<7;i++){
            Map<String,Integer> map = new HashMap<>();
            for(int in=1;in<36;in++){
                map.put(in>9?"t"+in:"t0"+in,0);
            }
            allNum.add(map);
        }

        for(int i=0;i<resultMap.size();i++){
            Map map = (Map) resultMap.get(i);
            for(int in=1;in<=7;in++){
                Map<String,Integer> map1 = allNum.get(in-1);
                String ticket = null == map.get("ticket0"+in)?"":String.valueOf(map.get("ticket0"+in));
                map1.put("t"+ticket,map1.get("t"+ticket)+1);
            }
        }
        return utils.objectToJson(allNum);
    }
}
