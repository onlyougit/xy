package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.entity.Commodity;
import com.sptwin.xy.mapper.CommodityCustomMapper;
import com.sptwin.xy.mapper.CommodityMapper;
import com.sptwin.xy.mapper.ContractCustomMapper;
import com.sptwin.xy.pojo.CommodityCustom;
import com.sptwin.xy.service.CommodityService;
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

@Service("commodityService")
public class CommodityServiceImpl extends BaseApiService implements CommodityService {
    Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);
    @Autowired
    private CommodityCustomMapper commodityCustomMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private ContractCustomMapper contractCustomMapper;
    @Override
    public ResponseBase queryCommodityPage(CommodityCustom commodityCustom, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<CommodityCustom> commodityCustoms = commodityCustomMapper.queryCommodityPage(commodityCustom);
        PageBean<CommodityCustom> pb = new PageBean(commodityCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase addCommodity(Commodity commodity) {
        //判断编号唯一
        int result = commodityCustomMapper.queryCountByNo(commodity.getCommodityNo());
        if(result > 0){
            return setResultError(Constants.NO_EXIST);
        }
        int count = commodityMapper.insertSelective(commodity);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.ADD_FAILED);
        }
    }

    @Override
    public ResponseBase updateCommodity(Commodity commodity) {
        int count = commodityMapper.updateByPrimaryKeySelective(commodity);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.UPDATE_FAILED);
        }
    }

    @Override
    public ResponseBase deleteCommodity(Long id) {
        //判断合约信息表中无关联这条记录
        logger.info("deleteCommodity(id):"+id);
        //判断品种信息表中无关联这条记录
        Commodity commodity = commodityMapper.selectByPrimaryKey(id);
        if(null == commodity){
            return setResultError(Constants.DELETE_FAILED);
        }
        int result = contractCustomMapper.queryCountByCommodityNo(commodity.getCommodityNo());
        if(result == 1){
            return setResultError(Constants.DELETE_FAILED);
        }
        int count = commodityMapper.deleteByPrimaryKey(id);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.DELETE_FAILED);
        }
    }

    @Override
    public ResponseBase queryCommodity(Commodity commodity) {
        List<CommodityCustom> commodityCustoms = commodityCustomMapper.queryContract(commodity);
        return setResultSuccess(commodityCustoms);
    }

    @Override
    public ResponseBase updateQueryCommodity(Long id) {
        Commodity commodity = commodityMapper.selectByPrimaryKey(id);
        return setResultSuccess(commodity);
    }
}
