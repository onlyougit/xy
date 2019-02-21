package com.sptwin.xy.utils;


import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
public class DBUtil {
    public static void saveSelfTrade(List<String[]> selfTradeList) {
        log.info("批量插入开始--------");
        Long start = System.currentTimeMillis();
        log.info("batch num = "+selfTradeList.size());
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DataSourceUtil.getConnection(DataSourceUtil.URL,
                    DataSourceUtil.USERNAME, DataSourceUtil.PASSWORD);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into t_self_trade ");
            stringBuilder.append("(");
            stringBuilder.append("account, exchange,name, contract, buy_sell,tradeprice,orderprice,tradecount,");
            stringBuilder.append("fee, optionfee, exchangedate,exchangetime, exchangetradenumber,tradedate,tradetime,");
            stringBuilder.append("ordercontract, contracttype,tradesource, ordertype, ordernumber,tradenumber, ");
            stringBuilder.append("systemnumber, orderuser,currency, streamnumber, openclose,closeprofit,usernumber, tdata");
            stringBuilder.append(")");
            stringBuilder.append("values");
            stringBuilder.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            String sql = stringBuilder.toString();
            ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for(String[] w : selfTradeList){
                for (int i = 1; i <= w.length; i++) {
                    if(i == 6 || i == 7){
                        ps.setBigDecimal(i,new BigDecimal(w[i-1].trim()));
                    }else{
                        ps.setString(i,w[i-1].trim());
                    }
                }
                ps.addBatch();
            }
            log.info("prepare batch-------------------------");
            ps.executeBatch();
            conn.commit();
            Long end = System.currentTimeMillis();
            System.out.println("执行插入时间："+(end-start));
            log.info("批量插入结束--------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
