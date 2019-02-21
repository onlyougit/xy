package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.Contract;
import com.sptwin.xy.enums.ContractStatus;
import com.sptwin.xy.enums.ContractType;
import lombok.Data;

@Data
public class ContractCustom extends Contract {
    private ContractType contractTypeEnum;

    private ContractStatus contractStatusEnum;

}
