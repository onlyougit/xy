package com.sptwin.xy.service.impl;

import com.sptwin.xy.entity.SelfTrade;
import com.sptwin.xy.mapper.SelfTradeMapper;
import com.sptwin.xy.service.ExcelService;
import com.sptwin.xy.utils.BatchThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

    private int pageSize = 10000;
    @Autowired
    private SelfTradeMapper selfTradeMapper;

    @Override
    @Transactional
    public void importTrade(List<String[]> selfTradeList) {
        /*Integer maxVersion = selfTradeMapper.queryMaxVersion();
        int version;
        if(null != maxVersion){
            version = maxVersion+1;
        }else{
            version = 1;
        }
        selfTradeList.forEach(w->{
            w.setVersion(version);
        });*/
        //先删除所有数据
        selfTradeMapper.deleteAll();
        int totalSize = selfTradeList.size(); //总记录数
        log.info("总记录数："+totalSize);
        int totalPage = totalSize / pageSize; //共N页

        if (totalSize % pageSize != 0) {
            totalPage += 1;
            if (totalSize < pageSize) {
                pageSize = selfTradeList.size();
            }
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int pageNum = 1; pageNum < totalPage + 1; pageNum++) {
            int starNum = (pageNum - 1) * pageSize;
            int endNum = pageNum * pageSize > totalSize ? (totalSize) : pageNum * pageSize;
            BatchThread batchThread = new BatchThread(selfTradeList.subList(starNum, endNum));
            executor.execute(batchThread);
        }
    }

    @Override
    public List<SelfTrade> querySelfTrade() {
        List<SelfTrade> selfTradeList = selfTradeMapper.querySelfTrade();
        return selfTradeList;
    }
}
