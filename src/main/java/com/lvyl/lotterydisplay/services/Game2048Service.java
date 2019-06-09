package com.lvyl.lotterydisplay.services;

import com.lvyl.lotterydisplay.mapper.LotteryTicketMapper;
import com.lvyl.lotterydisplay.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @auth yllv
 * @date 2019-06-09  15:49
 */

@Service("Game2048Service")
public class Game2048Service {
    @Autowired
    private LotteryTicketMapper lotteryTicketMapper;
    @Autowired
    private Utils utils;
    public String getMaxCount(){
        Map result =  lotteryTicketMapper.getMaxCount();
        return utils.objectToJson(result);
    }
}
