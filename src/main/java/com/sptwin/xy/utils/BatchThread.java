package com.sptwin.xy.utils;

import java.util.List;

public class BatchThread implements Runnable {

    private List<String[]> selfTradeList;
    public BatchThread(List<String[]> selfTradeList){
        this.selfTradeList = selfTradeList;
    }
    @Override
    public void run() {
        DBUtil.saveSelfTrade(selfTradeList);
    }
}
