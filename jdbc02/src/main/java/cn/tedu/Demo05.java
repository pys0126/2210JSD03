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
public class Demo05 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConnection();) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM car");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                System.out.println("id: " + id + " title: " + title + " type: " + type + " price: " + price);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
