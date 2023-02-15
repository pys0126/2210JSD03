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
public class Demo06 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection()) {
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE hero(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(10), age VARCHAR(10))");
            System.out.println("Demo06: Done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
