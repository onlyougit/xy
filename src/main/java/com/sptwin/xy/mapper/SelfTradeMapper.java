package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.SelfTrade;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface SelfTradeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SelfTrade record);

    int insertSelective(SelfTrade record);

    SelfTrade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SelfTrade record);

    int updateByPrimaryKey(SelfTrade record);

    void batchInsertTrade(List<SelfTrade> list);

    List<SelfTrade> querySelfTrade();

    @Delete("delete from t_self_trade")
    void deleteAll();

    /*@Select("select max(version) from t_self_trade")
    Integer queryMaxVersion();*/
}