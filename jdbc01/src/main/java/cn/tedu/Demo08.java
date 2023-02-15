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
public class Demo08 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            s.executeUpdate("DELETE FROM hero WHERE name='猪八戒'");
            System.out.println("Demo08: Done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
