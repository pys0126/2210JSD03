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
public class Demo02 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncodeing=utf8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "123456");
        Statement s = conn.createStatement();
        String sql = "DROP TABLE jdbct1";
        s.execute(sql);
        System.out.println("Done!");
        conn.close();
    }
}
