package cn.tedu.boot01.controller;

import cn.tedu.boot01.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/3
 **/
@Controller
public class ParamController {
    @RequestMapping("/p1")
    @ResponseBody
    public String p1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return name + ": " + age;
    }

    @RequestMapping("/p2")
    @ResponseBody
    public String p2(String name, int age) {
        return name + ": " + age;
    }

    @RequestMapping("/p3")
    @ResponseBody
    public String p3(Emp emp) {
        return emp.toString();
    }
}
