package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.config.Authority;
import com.sptwin.xy.config.MyException;
import com.sptwin.xy.entity.CreditMoney;
import com.sptwin.xy.entity.Fund;
import com.sptwin.xy.entity.HistoryFund;
import com.sptwin.xy.entity.OutInMoney;
import com.sptwin.xy.mapper.ClientCustomMapper;
import com.sptwin.xy.mapper.CreditMoneyMapper;
import com.sptwin.xy.mapper.FundCustomMapper;
import com.sptwin.xy.mapper.OutInMoneyMapper;
import com.sptwin.xy.pojo.OutInMoneyCustom;
import com.sptwin.xy.service.FundService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.Constants;
import com.sptwin.xy.utils.PageBean;
import com.sptwin.xy.utils.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("fundService")
public class FundServiceImpl extends BaseApiService implements FundService {
    @Autowired
    private FundCustomMapper fundCustomMapper;

    @Autowired
    private OutInMoneyMapper outInMoneyMapper;

    @Autowired
    private CreditMoneyMapper creditMoneyMapper;

    @Autowired
    private ClientCustomMapper clientCustomMapper;
    public List<String> list  = new ArrayList<>();


    @Override
    public ResponseBase queryFund(String clientNo) {
        List<Fund> funds = fundCustomMapper.queryFund(clientNo,list);
        return setResultSuccess(funds);
    }

    @Override
    @Authority
    public ResponseBase queryFundOutIn(String clientNo) {
        List<OutInMoneyCustom> outInMoneyCustoms = fundCustomMapper.queryFundOutIn(clientNo,list);
        return setResultSuccess(outInMoneyCustoms);
    }

    @Override
    public ResponseBase queryFundCredit(String clientNo) {
        List<CreditMoney> creditMonies = fundCustomMapper.queryFundCredit(clientNo,list);
        return setResultSuccess(creditMonies);
    }

    @Override
    public ResponseBase queryFundOutInHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<OutInMoneyCustom> outInMoneyCustoms = fundCustomMapper.queryFundOutInHistoryPage(startDate,endDate,clientNo,list);
        PageBean<Fund> pb = new PageBean(outInMoneyCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase queryFundCreditHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<CreditMoney> creditMonies = fundCustomMapper.queryFundCreditHistoryPage(startDate,endDate,clientNo,list);
        PageBean<Fund> pb = new PageBean(creditMonies);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase queryFundHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<HistoryFund> historyFunds = fundCustomMapper.queryFundHistoryPage(startDate,endDate,clientNo,list);
        PageBean<Fund> pb = new PageBean(historyFunds);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase addOutInMoney(OutInMoney outInMoney) {
        //判断客户编号是否存在
        int count = clientCustomMapper.queryCountByNo(outInMoney.getClientNo());
        if(count != 1){
            throw new MyException(1001,Constants.NO_CLIENT_NO);
        }
        outInMoney.setChangeTime(new Date());
        outInMoneyMapper.insertSelective(outInMoney);
        return setResultSuccess();
    }

    @Override
    public ResponseBase addCreditMoney(CreditMoney creditMoney) {
        int count = clientCustomMapper.queryCountByNo(creditMoney.getClientNo());
        if(count != 1){
            throw new MyException(1001,Constants.NO_CLIENT_NO);
        }
        creditMoney.setCreditTime(new Date());
        creditMoneyMapper.insertSelective(creditMoney);
        return setResultSuccess();
    }
}
