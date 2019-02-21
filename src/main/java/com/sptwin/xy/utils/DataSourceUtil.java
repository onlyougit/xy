package com.sptwin.xy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Administrator 定义获取和关闭数据源的方法
 */
public class DataSourceUtil {
    public static final String URL = "jdbc:mysql://116.62.130.69:3306/xy?useUnicode=true&characterEncoding=utf8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Gcb199107230513?";

    /**
     * 注册数据库驱动
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据源
     *
     * @throws SQLException
     */
    public static Connection getConnection(String url, String user,
                                           String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭数据源
     *
     * @throws SQLException
     */
    public static void closeConnection(Connection conn) throws SQLException {
        if (null != conn) {
            conn.close();
        }
    }
}
