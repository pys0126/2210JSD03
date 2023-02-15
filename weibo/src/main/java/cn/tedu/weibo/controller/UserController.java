package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.UserMapper;
import cn.tedu.weibo.pojo.dto.UserLoginDto;
import cn.tedu.weibo.pojo.dto.UserRegDto;
import cn.tedu.weibo.pojo.entity.User;
import cn.tedu.weibo.pojo.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/10
 **/
@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/reg")
    public int reg(@RequestBody UserRegDto user) {
        UserVo u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            return 2; //用户名已存在
        }
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        mapper.insert(userEntity);
        return 1; //注册成功
    }

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
        UserVo userVo = mapper.selectByUsername(userLoginDto.getUsername());
        if (userVo != null) {
            if (userVo.getPassword().equals(userLoginDto.getPassword())) {
                session.setAttribute("user", userVo);
                return 1; //登录成功
            }
            return 2; //密码错误
        }
        return 3; //用户名不存在
    }

    @RequestMapping("/currentUser")
    public UserVo currentUser(HttpSession session) {
        return (UserVo) session.getAttribute("user");
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
}
