package com.sptwin.xy.service;

import com.sptwin.xy.entity.Contract;
import com.sptwin.xy.utils.ResponseBase;

import java.util.List;

public interface ContractService {

    ResponseBase queryContractPage(Integer type, Integer pageIndex, Integer pageSize);

    ResponseBase addContract(Contract contract);

    ResponseBase updateContract(Contract contract);

    ResponseBase deleteContract(Long id);

    ResponseBase queryContract(Contract contract);

    ResponseBase addMainContract(List<Long> idList);

    ResponseBase deleteMainContract(Long id);

    ResponseBase updateQueryContract(Long id);
}
