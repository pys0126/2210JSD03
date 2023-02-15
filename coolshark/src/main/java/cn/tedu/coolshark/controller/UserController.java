package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.UserMapper;
import cn.tedu.coolshark.pojo.dto.UserLoginDto;
import cn.tedu.coolshark.pojo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/13
 **/
@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
        UserVo userVo = mapper.selectByUsername(userLoginDto.getUsername());
        if (userVo != null) {
            if (userLoginDto.getPassword().equals(userVo.getPassword())) {
                session.setAttribute("user", userVo);
                return 1;
            }
            return 2;
        }
        return 3;
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
