package cn.tedu.weibo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/8
 **/
@RestController
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile picFile) throws IOException {
        String fileName = picFile.getOriginalFilename();
        System.out.println("文件名：" + fileName);
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
        fileName = UUID.randomUUID() + suffix;
        System.out.println(fileName);
        String dirPath = "D:/files";
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String filePath = dirPath + "/" + fileName;
        picFile.transferTo(new File(filePath));
        System.out.println("保存完成！");
        return fileName;
    }

    @RequestMapping("/remove")
    public void remove(String fileName) {
        new File("D:/files/" + fileName).delete();
    }

//    @RequestMapping("/upload-1")
//    public String upload_1(MultipartFile picFile) throws IOException {
//        String fileName = picFile.getOriginalFilename();
//        fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
//        File dirPath = new File("D:/files");
//        if (!dirPath.exists()) {
//            dirPath.mkdirs();
//        }
//        picFile.transferTo(new File(dirPath, fileName));
//        return fileName;
//    }
}
