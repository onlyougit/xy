package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.entity.Exchange;
import com.sptwin.xy.mapper.CommodityCustomMapper;
import com.sptwin.xy.mapper.ExchangeCustomMapper;
import com.sptwin.xy.mapper.ExchangeMapper;
import com.sptwin.xy.pojo.ExchangeCustom;
import com.sptwin.xy.service.ExchangeService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.Constants;
import com.sptwin.xy.utils.PageBean;
import com.sptwin.xy.utils.ResponseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("exchangeService")
public class ExchangeServiceImpl extends BaseApiService implements ExchangeService {
    Logger logger = LoggerFactory.getLogger(ExchangeServiceImpl.class);

    @Autowired
    private ExchangeCustomMapper exchangeCustomMapper;
    @Autowired
    private ExchangeMapper exchangeMapper;
    @Autowired
    private CommodityCustomMapper commodityCustomMapper;
    @Override
    public ResponseBase queryExchangePage(Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<ExchangeCustom> exchangeCustoms = exchangeCustomMapper.queryExchangePage();
        PageBean<ExchangeCustom> pb = new PageBean(exchangeCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase addExchange(Exchange exchange) {
        //判断编号唯一
        int result = exchangeCustomMapper.queryByNo(exchange.getExchangeNo());
        if(result > 0){
            return setResultError(Constants.NO_EXIST);
        }
        int count = exchangeMapper.insertSelective(exchange);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.ADD_FAILED);
        }
    }

    @Override
    public ResponseBase updateExchange(Exchange exchange) {
        int count = exchangeMapper.updateByPrimaryKeySelective(exchange);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.UPDATE_FAILED);
        }
    }

    @Override
    public ResponseBase queryExchangeNo() {
        List<Exchange> exchanges = exchangeCustomMapper.queryExchangeNo();
        return setResultSuccess(exchanges);
    }

    @Override
    public ResponseBase deleteExchange(Long id) {
        logger.info("deleteExchange(id):"+id);
        //判断品种信息表中无关联这条记录
        Exchange exchange = exchangeMapper.selectByPrimaryKey(id);
        if(null == exchange){
            return setResultError(Constants.DELETE_FAILED);
        }
        int result = commodityCustomMapper.queryCountByExchangeNo(exchange.getExchangeNo());
        if(result == 1){
            return setResultError(Constants.DELETE_FAILED);
        }
        int count = exchangeMapper.deleteByPrimaryKey(id);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.DELETE_FAILED);
        }
    }

    @Override
    public ResponseBase updateQueryExchange(Long id) {
        ExchangeCustom exchangeCustom = exchangeCustomMapper.queryById(id);
        return setResultSuccess(exchangeCustom);
    }
}
