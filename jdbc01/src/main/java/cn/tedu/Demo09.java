package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/2
 **/
public class Demo09 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            s.executeUpdate("UPDATE hero SET name='齐天大圣' WHERE name='孙悟空'");
            System.out.println("Demo09: Done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
