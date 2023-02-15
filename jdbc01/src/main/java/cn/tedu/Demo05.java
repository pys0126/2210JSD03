package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/2
 **/
public class Demo05 {
    public static void main(String[] args) throws SQLException {
        /*创建数据库连接池对象*/
        DruidDataSource dds = new DruidDataSource();
        /*设置连接数据库的信息*/
        dds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncodeing=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
        dds.setUsername("root");
        dds.setPassword("123456");
        /*设置初始连接数量*/
        dds.setInitialSize(3);
        /*设置最大连接数量*/
        dds.setMaxActive(5);
        Connection conn = dds.getConnection();
        System.out.println(conn);
    }
}
