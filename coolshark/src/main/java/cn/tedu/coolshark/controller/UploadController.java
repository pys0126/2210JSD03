package cn.tedu.coolshark.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/14
 **/
@RestController
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile picFile) throws IOException {
        String fileName = picFile.getOriginalFilename();
        fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        SimpleDateFormat dateformat = new SimpleDateFormat("/yyy/MM/dd/"); //格式化日期
        String datePath = dateformat.format(new Date());
        File dir = new File("D:/files" + datePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        picFile.transferTo(new File(dir, fileName));
        return datePath + fileName;
    }

    @RequestMapping("/remove")
    public void remove(String url) {
        new File("D:/files" + url).delete();
    }
}
