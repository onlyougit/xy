package com.sptwin.xy.service.impl;

import com.sptwin.xy.entity.SelfTrade;
import com.sptwin.xy.mapper.SelfTradeMapper;
import com.sptwin.xy.service.TradeService;
import com.sptwin.xy.utils.BaseApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tradeService")
public class TradeServiceImpl extends BaseApiService implements TradeService {

    @Autowired
    private SelfTradeMapper selfTradeMapper;

    @Override
    @Transactional
    public void importTrade(List<SelfTrade> list) {
        selfTradeMapper.batchInsertTrade(list);
    }
}
