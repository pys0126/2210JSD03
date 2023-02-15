package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/3
 **/
public class Demo01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入注册的用户名: ");
        String username = scan.nextLine();
        System.out.print("请输入注册的密码: ");
        String password = scan.nextLine();
        /*
        * CREATE TABLE user(id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(50), password VARCHAR(50));
        * */
        try (Connection conn = DBUtils.getConnection()) {
            Statement s = conn.createStatement();
            s.executeUpdate("INSERT INTO user VALUES(NULL, '" + username + "', '" + password + "')");
            System.out.println("注册成功!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
