package cn.tedu;

import java.sql.*;
import java.util.Scanner;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/3
 **/
public class Demo04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String username = scan.nextLine();
        try (Connection conn = DBUtils.getConnection()) {
            String sql = "SELECT id FROM user WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("用户名已存在!");
                return;
            }
            System.out.print("请输入密码: ");
            String password = scan.nextLine();
            String regSql = "INSERT INTO user VALUES(NULL, ?, ?)";
            PreparedStatement regPs = conn.prepareStatement(regSql);
            regPs.setString(1, username);
            regPs.setString(2, password);
            regPs.executeUpdate();
            System.out.println("注册成功!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
