package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.ProductMapper;
import cn.tedu.coolshark.pojo.dto.ProductDto;
import cn.tedu.coolshark.pojo.dto.ProductUpdateDto;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/14
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setCreated(new Date());
        mapper.insert(product);
    }

    @RequestMapping("/select")
    public List<ProductAdminVo> select() {
        return mapper.select();
    }

    @RequestMapping("/delete")
    public void delete(int id) {
        new File("D:/files" + mapper.selectUrlById(id)).delete();
        mapper.deleteById(id);
    }

    @RequestMapping("/selectById")
    public ProductUpdateVo selectById(int id) {
        return mapper.selectById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody ProductUpdateDto productDto) {
        if (mapper.selectUrlById(productDto.getId()).equals(productDto.getUrl())) {
            new File("D:/files" + mapper.selectUrlById(productDto.getId())).delete();
        }
        mapper.update(productDto);
    }

    @RequestMapping("/selectForIndex")
    public List<ProductIndexVo> selectForIndex() {
        return mapper.selectForIndex();
    }

    @RequestMapping("/selectForTop")
    public List<ProductTopVo> selectForTop() {
        return mapper.selectForTop();
    }

    @RequestMapping("/selectByCid")
    public List<ProductIndexVo> selectByCid(int id) {
        return mapper.selectByCid(id);
    }

    @RequestMapping("/selectByWd")
    public List<ProductIndexVo> selectByWd(String wd) {
        return mapper.selectByWd(wd);
    }

    @RequestMapping("/selectForDetailById")
    public ProductDetailVo selectForDetailById(int id, HttpSession session) {
        String info = (String) session.getAttribute("view" + id);
        if (info == null) {
            session.setAttribute("view" + id, "visited");
            mapper.updateViewCountById(id);
        }
        return mapper.selectForDetailById(id);
    }
}
