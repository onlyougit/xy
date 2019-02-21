package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.entity.Currency;
import com.sptwin.xy.mapper.CurrencyCustomMapper;
import com.sptwin.xy.mapper.CurrencyMapper;
import com.sptwin.xy.pojo.CurrencyCustom;
import com.sptwin.xy.service.CurrencyService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.Constants;
import com.sptwin.xy.utils.PageBean;
import com.sptwin.xy.utils.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("currencyService")
public class CurrencyServiceImpl extends BaseApiService implements CurrencyService {

    @Autowired
    private CurrencyCustomMapper currencyCustomMapper;
    @Autowired
    private CurrencyMapper currencyMapper;
    @Override
    public ResponseBase queryCurrencyPage(Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<CurrencyCustom> currencyCustoms = currencyCustomMapper.queryCurrencyPage();
        PageBean<CurrencyCustom> pb = new PageBean(currencyCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase addCurrency(Currency currency) {
        //判断编号唯一
        int result = currencyCustomMapper.queryByNo(currency.getCurrencyNo());
        if(result > 0){
            return setResultError(Constants.NO_EXIST);
        }
        int count = currencyMapper.insertSelective(currency);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.ADD_FAILED);
        }
    }

    @Override
    public ResponseBase updateCurrency(Currency currency) {
        currency.setModifyDateTime(new Date());
        int count = currencyMapper.updateByPrimaryKeySelective(currency);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.UPDATE_FAILED);
        }
    }

    @Override
    public ResponseBase queryCurrencyNo() {
        List<Currency> exchanges = currencyCustomMapper.queryCurrencyNo();
        return setResultSuccess(exchanges);
    }

    @Override
    public ResponseBase updateQueryCurrency(Long id) {
        Currency currency = currencyMapper.selectByPrimaryKey(id);
        return setResultSuccess(currency);
    }
}
