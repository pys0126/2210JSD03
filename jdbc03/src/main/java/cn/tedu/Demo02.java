package cn.tedu;

import java.sql.*;
import java.util.Scanner;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/3
 **/
public class Demo02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String username = scan.nextLine();
        System.out.print("请输入密码: ");
        String password = scan.nextLine();
        try (Connection conn = DBUtils.getConnection()) {
            // Statement s = conn.createStatement();
            // ResultSet rs = s.executeQuery("SELECT count(*) FROM user WHERE username='" + username + "' AND password='" + password + "'");
            /*通过PreparedStatement执行SQL语句*/
            String sql = "SELECT COUNT(*) FROM user WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("登录成功!");
            } else {
                System.out.println("用户名或密码错误!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
