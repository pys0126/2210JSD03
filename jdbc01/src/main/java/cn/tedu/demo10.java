package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/2
 **/
public class demo10 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT name, age FROM hero;");
            while (rs.next()) {
                String name = rs.getString("name");
                String age = rs.getString("age");
                System.out.println(name + ": " + age);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
