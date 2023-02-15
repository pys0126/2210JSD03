package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.WeiboMapper;
import cn.tedu.weibo.pojo.dto.WeiboDto;
import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.UserVo;
import cn.tedu.weibo.pojo.vo.WeiboIndexVo;
import cn.tedu.weibo.pojo.vo.WeiboDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/10
 **/
@RestController
public class WeiboController {
    @Autowired(required = false)
    WeiboMapper mapper;

    @RequestMapping("/weibo/insert")
    public int insert(@RequestBody WeiboDto weiboDto, MultipartFile picFile, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo == null) {
            return 2; //未登录
        }
        Weibo weibo = new Weibo();
        BeanUtils.copyProperties(weiboDto, weibo);
        weibo.setCreated(new Date());
        weibo.setUserId(userVo.getId());
        mapper.insert(weibo);
        return 1; //登录成功
    }

    @RequestMapping("/weibo/select")
    public List<WeiboIndexVo> select() {
        return mapper.select();
    }

    @RequestMapping("/weibo/selectById")
    public WeiboDetailVo selectById(int id) {
        return mapper.selectById(id);
    }
}
