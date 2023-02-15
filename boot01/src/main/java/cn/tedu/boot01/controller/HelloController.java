package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/3
 **/
@Controller
public class HelloController {
//    @RequestMapping("/hello")
//    public void hello(HttpServletResponse response, HttpServletRequest request) throws IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter pw = response.getWriter();
//        pw.println("测试成功!");
//        pw.close();
//    }
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "测试成功!";
    }
}
