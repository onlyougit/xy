package com.sptwin.xy.mapper;

import com.sptwin.xy.pojo.HoldCustom;
import com.sptwin.xy.pojo.MatchCustom;
import com.sptwin.xy.pojo.OrderCustom;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TransMapper {
    List<OrderCustom> queryOrder(@Param("clientNo") String clientNo,
                                 @Param("list")List<String> list);

    List<OrderCustom> queryOrderHistoryPage(@Param("startDate") Date startDate,
                                            @Param("endDate")Date endDate,
                                            @Param("clientNo")String clientNo,
                                            @Param("list")List<String> list);

    List<MatchCustom> queryMatch(@Param("clientNo") String clientNo,
                                 @Param("list")List<String> list);

    List<MatchCustom> queryMatchHistoryPage(@Param("startDate") Date startDate,
                                            @Param("endDate")Date endDate,
                                            @Param("clientNo")String clientNo,
                                            @Param("list")List<String> list);

    List<HoldCustom> queryHold(@Param("clientNo") String clientNo,
                               @Param("list")List<String> list);

    List<HoldCustom> queryHoldHistoryPage(@Param("startDate") Date startDate,
                                          @Param("endDate")Date endDate,
                                          @Param("clientNo")String clientNo,
                                          @Param("list")List<String> list);
}