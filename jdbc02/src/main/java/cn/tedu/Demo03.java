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
public class Demo03 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            s.executeUpdate("DELETE FROM car where id=(SELECT id FROM car ORDER BY id DESC LIMIT 1)");
            System.out.println("delete done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
