package com.lvyl.lotterydisplay.mapper;

import java.util.List;
import java.util.Map;

public interface LotteryTicketMapper {
    List selectRecentTerm(Map map);
    List selectTermBeginAndEnd(Map map);
}
