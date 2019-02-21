package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.config.Authority;
import com.sptwin.xy.mapper.TransMapper;
import com.sptwin.xy.pojo.HoldCustom;
import com.sptwin.xy.pojo.MatchCustom;
import com.sptwin.xy.pojo.OrderCustom;
import com.sptwin.xy.service.TransService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.PageBean;
import com.sptwin.xy.utils.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("transService")
public class TransServiceImpl extends BaseApiService implements TransService {
    @Autowired
    private TransMapper transMapper;
    public List<String> list  = new ArrayList<>();

    @Override
    @Authority
    public ResponseBase queryOrder(String clientNo) {
        List<OrderCustom> orderCustoms = transMapper.queryOrder(clientNo,list);
        return setResultSuccess(orderCustoms);
    }

    @Override
    @Authority
    public ResponseBase queryOrderHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<OrderCustom> orderCustoms = transMapper.queryOrderHistoryPage(startDate,endDate,clientNo,list);
        PageBean<OrderCustom> pb = new PageBean(orderCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    @Authority
    public ResponseBase queryMatch(String clientNo) {
        List<MatchCustom> matchCustoms = transMapper.queryMatch(clientNo,list);
        return setResultSuccess(matchCustoms);
    }

    @Override
    @Authority
    public ResponseBase queryMatchHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<MatchCustom> matchCustoms = transMapper.queryMatchHistoryPage(startDate,endDate,clientNo,list);
        PageBean<MatchCustom> pb = new PageBean(matchCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    @Authority
    public ResponseBase queryHold(String clientNo) {
        List<HoldCustom> holdCustoms = transMapper.queryHold(clientNo,list);
        return setResultSuccess(holdCustoms);
    }

    @Override
    @Authority
    public ResponseBase queryHoldHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<HoldCustom> holdCustoms = transMapper.queryHoldHistoryPage(startDate,endDate,clientNo,list);
        PageBean<HoldCustom> pb = new PageBean(holdCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }
}
