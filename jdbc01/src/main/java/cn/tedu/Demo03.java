package cn.tedu;

import java.sql.*;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/2
 **/
public class Demo03 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtils.getConnection();
        Statement s = conn.createStatement();
        // s.executeUpdate("INSERT INTO emp(name) VALUES('Tom')");
        // s.executeUpdate("UPDATE emp SET name='Jerry' WHERE name='Tom'");
        // s.execute("DELETE FROM emp WHERE name='Jerry'");
        ResultSet rs = s.executeQuery("SELECT name, sal FROM emp");
        while (rs.next()) {
            // String name = rs.getString("name");
            // double sal = rs.getDouble("sal");
            String name = rs.getString(1);
            double sal = rs.getDouble(2);
            System.out.println(name + ": " + sal);
        }
        System.out.println("执行完成!");
        conn.close();
    }
}
