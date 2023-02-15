package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/2
 **/
public class DBUtils {
    private static DruidDataSource dds;
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "empdb";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?characterEncodeing=utf8&serverTimezone=Asia/Shanghai&useSSL=false";
    private static final int INITIAL_SIZE = 3;
    private static final int MAX_ACTIVE = 5;

    static {
        /*创建数据库连接池对象*/
        dds = new DruidDataSource();
        /*设置连接数据库的信息*/
        dds.setUrl(URL);
        dds.setUsername(USER);
        dds.setPassword(PASSWORD);
        /*设置初始连接数量*/
        dds.setInitialSize(INITIAL_SIZE);
        /*设置最大连接数量*/
        dds.setMaxActive(MAX_ACTIVE);
    }

    public static Connection getConnection() throws SQLException {
        /*从连接池中获取连接对象*/
        // Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return dds.getConnection();
    }
}
