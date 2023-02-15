package tk.uodrad.boot061.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.uodrad.boot061.entity.Product;
import tk.uodrad.boot061.mapper.ProductMapper;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/8
 **/
@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody Product product) {
        mapper.insert(product);
    }

    @RequestMapping("/select")
    public List<Product> select() {
        return mapper.select();
    }

    @RequestMapping("/update")
    public void update(@RequestBody Product product) {
        mapper.update(product);
    }

    @RequestMapping("/delete")
    public void delete(int id) {
        mapper.delete(id);
    }

    @RequestMapping("/selectById")
    public Product selectById(int id) {
        return mapper.selectById(id);
    }
}
