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
public class Demo04 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            s.executeUpdate("UPDATE car SET title='奔驰S500', type='轿车', price=9.9 WHERE id=1");
            System.out.println("update done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
