package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.User;
import cn.tedu.boot02.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/3
 **/
@Controller
public class UserController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user) {
        try (Connection conn = DBUtils.getConnection()) {
            String sql = "SELECT password FROM user WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(user.getPassword())) {
                    return "登录成功!";
                }
                return "密码错误!";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "用户不存在!";
    }

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user) {
        try (Connection conn = DBUtils.getConnection()) {
            String sql = "SELECT id FROM user WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "用户名已存在!";
            }
            String regSql = "INSERT INTO user VALUES(NULL, ?, ?, ?)";
            PreparedStatement regPs = conn.prepareStatement(regSql);
            regPs.setString(1, user.getUsername());
            regPs.setString(2, user.getPassword());
            regPs.setString(3, user.getNickname());
            regPs.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "注册成功!";
    }
}
