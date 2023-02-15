package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import cn.tedu.boot05.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public int reg(@RequestBody User user) {
        User u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            return 2;
        }
        mapper.insert(user);
        return 1;
    }

    @RequestMapping("/login")
    public int login(@RequestBody User user) {
        User u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                return 1;
            }
            return 2;
        }
        return 3;
    }
}
