package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.entity.FeeTemplate;
import com.sptwin.xy.entity.FeeTemplateCommodity;
import com.sptwin.xy.mapper.ClientRateRelationCustomMapper;
import com.sptwin.xy.mapper.FeeTemplateCommodityMapper;
import com.sptwin.xy.mapper.FeeTemplateCustomMapper;
import com.sptwin.xy.mapper.FeeTemplateMapper;
import com.sptwin.xy.pojo.FeeTemplateCustom;
import com.sptwin.xy.service.FeeTemplateService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.Constants;
import com.sptwin.xy.utils.PageBean;
import com.sptwin.xy.utils.ResponseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("feeTemplateService")
public class FeeTemplateServiceImpl extends
        BaseApiService implements FeeTemplateService {
    Logger logger = LoggerFactory.getLogger(FeeTemplateServiceImpl.class);

    @Autowired
    private FeeTemplateMapper feeTemplateMapper;
    @Autowired
    private FeeTemplateCustomMapper feeTemplateCustomMapper;
    @Autowired
    private FeeTemplateCommodityMapper feeTemplateCommodityMapper;
    @Autowired
    private ClientRateRelationCustomMapper clientRateRelationCustomMapper;

    @Override
    public ResponseBase queryFeeTemplatePage(Integer type, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<FeeTemplate> feeTemplates = feeTemplateCustomMapper.queryFeeTemplatePage(type);
        PageBean<FeeTemplate> pb = new PageBean(feeTemplates);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase queryFeeTemplateCommodityPage(Integer feeTemplateId, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<FeeTemplateCommodity> feeTemplateCommodityList = feeTemplateCustomMapper.queryFeeTemplateCommodityPage(feeTemplateId);
        PageBean<FeeTemplateCommodity> pb = new PageBean(feeTemplateCommodityList);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }


    @Transactional
    @Override
    public ResponseBase addFeeTemplate(FeeTemplateCustom feeTemplateCustom) {
        List<FeeTemplateCommodity> feeTemplateCommodityList = feeTemplateCustom.getFeeTemplateCommodityList();
        //判断模版名称唯一
        String feeTemplateName = feeTemplateCustom.getFeeTemplateName();
        int result = feeTemplateCustomMapper.queryCountByNo(feeTemplateName);
        if(result > 0){
            return setResultError(Constants.NAME_EXIST);
        }
        FeeTemplate feeTemplate = new FeeTemplate();
        feeTemplate.setFeeTemplateName(feeTemplateName);
        feeTemplate.setType(feeTemplateCustom.getType());
        feeTemplate.setRemark(feeTemplateCustom.getRemark());
        feeTemplateCustomMapper.insertSelective(feeTemplate);
        Date date = new Date();
        feeTemplateCommodityList.forEach(w->{
            w.setFeeTemplateId(feeTemplate.getId());
            w.setModifyDateTime(date);
        });
        feeTemplateCustomMapper.batchInsert(feeTemplateCommodityList);
        return setResultSuccess();
    }

    @Override
    public ResponseBase updateFeeTemplate(FeeTemplateCommodity feeTemplateCommodity) {
        feeTemplateCommodity.setModifyDateTime(new Date());
        int count = feeTemplateCommodityMapper.updateByPrimaryKeySelective(feeTemplateCommodity);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.UPDATE_FAILED);
        }
    }

    @Transactional
    @Override
    public ResponseBase deleteFeeTemplate(Integer id) {
        //保证金模版若在客户费率关系表中无关联，则可以删除
        int result = clientRateRelationCustomMapper.queryCountByFeeTemplateId(id);
        if(result > 0){
            return setResultError(Constants.DELETE_FAILED);
        }
        //批量删除品种保证金模版
        feeTemplateCustomMapper.batchDeleteFeeTemplateCommodity(id);
        //删除保证金模版
        feeTemplateMapper.deleteByPrimaryKey(id);
        return setResultSuccess();
    }

    @Override
    public ResponseBase updateQueryFeeTemplate(Long id) {
        FeeTemplateCommodity feeTemplateCommodity = feeTemplateCommodityMapper.selectByPrimaryKey(id);
        return setResultSuccess(feeTemplateCommodity);
    }
}
