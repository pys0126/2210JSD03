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
public class Demo07 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            s.executeUpdate("INSERT INTO hero(name, age) VALUES('孙悟空', '500岁'), ('猪八戒', '300岁')");
            System.out.println("Demo07: Done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
