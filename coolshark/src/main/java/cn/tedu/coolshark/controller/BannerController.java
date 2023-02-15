package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.BannerMapper;
import cn.tedu.coolshark.pojo.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/13
 **/
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired(required = false)
    BannerMapper mapper;

    @RequestMapping("/select")
    public List<Banner> select() {
        return mapper.select();
    }

    @RequestMapping("/delete")
    public void delete(int id) {
        deleteImage(id);
        mapper.delete(id);
    }

    @RequestMapping("/insert")
    public void insert(String url) {
        mapper.insert(url);
    }

    @RequestMapping("/selectById")
    public Banner selectById(int id) {
        return mapper.selectById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Banner banner) {
        deleteImage(banner.getId());
        mapper.update(banner);
    }

    public void deleteImage(int id) {
        Banner banner = mapper.selectById(id);
        new File("D:/files" + banner.getUrl()).delete();
    }
}
