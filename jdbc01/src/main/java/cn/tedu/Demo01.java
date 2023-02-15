package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/2
 **/
public class Demo01 {
    public static void main(String[] args) throws SQLException {
        /*1.获取数据库连接对象*/
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncodeing=utf8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "123456");
        System.out.println(conn);
        /*2.获取执行SQL语句的对象*/
        Statement s = conn.createStatement();
        /*3.执行SQL语句*/
        String sql = "CREATE TABLE jdbct1(name VARCHAR(10), age INT)";
        s.execute(sql);
        System.out.println("执行完成!");
        /*4.关闭资源*/
        conn.close();
    }
}
