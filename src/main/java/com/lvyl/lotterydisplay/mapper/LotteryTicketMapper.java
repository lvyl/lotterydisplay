package com.lvyl.lotterydisplay.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface LotteryTicketMapper {
    void insertData(Map map);

    String selectMaxTerm();

    Integer selectByTerm(String term);
}
