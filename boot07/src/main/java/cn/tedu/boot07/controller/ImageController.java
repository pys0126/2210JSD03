package cn.tedu.boot07.controller;

import cn.tedu.boot07.entity.Image;
import cn.tedu.boot07.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/8
 **/
@RestController
public class ImageController {
    @Autowired
    ImageMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody Image image) {
        image.setCreated(new Date());
        mapper.insert(image);
    }

    @RequestMapping("/select")
    public List<Image> select() {
        return mapper.select();
    }

    @RequestMapping("/delete")
    public void delete(int id) {
        mapper.delete(id);
        String urls = mapper.selectUrlsById(id);
        for (String fileName : urls.split(",")) {
            File file = new File("D:/files/" + fileName);
            file.delete();
        }
    }
}
