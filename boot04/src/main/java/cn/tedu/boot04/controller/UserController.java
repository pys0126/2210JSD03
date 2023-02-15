package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.User;
import cn.tedu.boot04.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/7
 **/
@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public String reg(User user) {
        if (mapper.selectByUsername(user.getUsername()) != null) {
            return "用户已存在!";

        }
        mapper.insert(user);
        return "注册成功!";
    }

    @RequestMapping("/login")
    public String login(User user) {
        User u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                return "登录成功!";
            }
            return "密码错误!";
        }
        return "用户不存在!";
    }
}
