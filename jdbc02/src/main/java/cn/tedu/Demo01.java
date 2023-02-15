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
public class Demo01 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE car(id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(24), type VARCHAR(24), price DOUBLE)");
            System.out.println("create done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
