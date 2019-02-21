package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Contract;
import com.sptwin.xy.pojo.ContractCustom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ContractCustomMapper {

    @Select("select count(1) from t_contract where commodity_no = #{commodityNo}")
    int queryCountByCommodityNo(String commodityNo);

    List<ContractCustom> queryContractPage(Integer type);

    @Select("select count(1) from t_contract where contract_no = #{contractNo}")
    int queryByNo(String contractNo);

    List<ContractCustom> queryContract(Contract contract);

    void batchUpdateContract(List<Long> ids);

    List<Contract> batchQueryContract(List<Long> list);

    ContractCustom queryById(Long id);

    @Select("select count(1) from t_contract where contract_no = #{contractNo} and commodity_no = #{commodityNo}")
    int queryByNoAndCommodityNo(@Param("contractNo") String contractNo, @Param("commodityNo") String commodityNo);
}