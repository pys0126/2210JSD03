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
public class Demo04 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT name FROM emp");
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
