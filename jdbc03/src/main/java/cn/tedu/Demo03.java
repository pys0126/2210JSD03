package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/3
 **/
public class Demo03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String username = scan.nextLine();
        System.out.print("请输入密码: ");
        String password = scan.nextLine();
        try (Connection conn = DBUtils.getConnection()) {
            String sql = "SELECT password FROM user WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String pwd = rs.getString("password");
                if (pwd.equals(password)) {
                    System.out.println("登录成功!");
                } else {
                    System.out.println("密码错误!");
                }
            } else {
                System.out.println("用户名不存在!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
