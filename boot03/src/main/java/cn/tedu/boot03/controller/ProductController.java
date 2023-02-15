package cn.tedu.boot03.controller;

import cn.tedu.boot03.entity.Product;
import cn.tedu.boot03.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/6
 **/
@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public String insert(Product product) {
        mapper.insert(product);
        return "添加完成!<a href='/'>返回首页</a>";
    }

    @RequestMapping("select")
    public String select() {
        List<Product> list = mapper.select();
        String html = "<table border='1'>" +
                "<caption>商品列表</caption>" +
                "<tr><th>id</th><th>标题</th><th>价格</th><th>库存</th><th>修改商品</th><th>删除</th></tr>";
        for (Product p : list) {
            html += "<tr>";
            html += "<td>" + p.getId() + "</td>";
            html += "<td>" + p.getTitle() + "</td>";
            html += "<td>" + p.getPrice() + "</td>";
            html += "<td>" + p.getNum() + "</td>";
            html += "<td><a href='/updateById?id=" + p.getId() + "'>修改</a></td>";
            html += "<td><a href='/delete?id=" + p.getId() + "'>删除</a></td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        mapper.deleteById(id);
        return "删除成功!<a href='/'>返回首页</a>";
    }

    @RequestMapping("/update")
    public String update(Product product) {
        mapper.update(product);
        return "修改成功!<a href='/'>返回首页</a>";
    }

    @RequestMapping("/updateById")
    public String updateById(Integer id) {
        Product product = mapper.updateById(id);
        String html = "<h1>修改商品页面</h1>" +
                "<form action='/update'>" +
                "    <input type='text' name='id' value='" + id + "'disabled>" +
                "    <input type='text' name='title' placeholder='商品的标题' value='" + product.getTitle() + "'>" +
                "    <input type='text' name='price' placeholder='商品的价格' value='" + product.getPrice() + "'>" +
                "    <input type='text' name='num' placeholder='商品的库存' value='" + product.getNum() + "'>" +
                "    <input type='submit' value='修改'>" +
                "</form>";
        return html;
    }
}
