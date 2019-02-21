package com.sptwin.xy.service;

import com.sptwin.xy.entity.SelfTrade;

import java.util.List;

public interface ExcelService {
    //void importTrade(List<SelfTrade> selfTradeList);
    void importTrade(List<String[]> selfTradeList);
    List<SelfTrade> querySelfTrade();
}
