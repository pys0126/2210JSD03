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
public class Demo02 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            s.executeUpdate("INSERT INTO car(title, type, price) VALUES('奔驰', '轿车', 1000), ('宝马', '跑车', 2000), ('奥迪', 'SUV', 1500)");
            System.out.println("insert done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
