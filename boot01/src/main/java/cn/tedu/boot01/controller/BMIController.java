package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/3
 **/
@Controller
public class BMIController {
    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(double height, double weight) {
        double value = weight / (height * height);
        System.out.println(value);
        if (value < 18.5) {
            return "偏瘦";
        } else if (18.5 < value && value < 24) {
            return "正常";
        } else if (24 < value && value < 27) {
            return "微胖";
        } else {
            return "有点胖";
        }
    }
}
