package com.sptwin.xy.service;

import com.sptwin.xy.entity.SelfTrade;

import java.util.List;

public interface TradeService {
    void importTrade(List<SelfTrade> list);
}
