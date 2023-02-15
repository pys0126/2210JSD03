package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/7
 **/
@RestController
public class AxiosController {
    @RequestMapping("/helloAxios")
    public String helloAxios(String name) {
        return "服务器接收到了请求! " + name;
    }

    @RequestMapping("/postAxios")
    public String postAxios(@RequestBody User user) {
        return "post请求成功!" + user.toString();
    }

    @RequestMapping("/bmi")
    public String bmi(double h, double w) {
        double value = w / (h * h);
        if (value < 18.5) {
            return "偏瘦";
        }
        if (value < 24) {
            return "正常";
        }
        if (value < 27) {
            return "微胖";
        }
        return "极胖";
    }
}
