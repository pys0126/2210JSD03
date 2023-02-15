package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.Product;
import cn.tedu.boot02.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/6
 **/
@Controller
public class ProductController {
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Product product) {
        try (Connection conn = DBUtils.getConnection()) {
            String sql = "INSERT INTO product(title, price, num) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getNum());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "添加完成!";
    }

    @RequestMapping("/select")
    @ResponseBody
    public String select(Product product) {
        ArrayList<Product> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection()) {
            String sql = "SELECT * FROM product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product1 = new Product();
                product1.setId(rs.getInt("id"));
                product1.setTitle(rs.getString("title"));
                product1.setPrice(rs.getDouble("price"));
                product1.setNum(rs.getInt("num"));
                list.add(product1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<table border='1'>" +
                "<caption>商品列表</caption>" +
                "<tr><th>id</th><th>标题</th><th>价格</><th>库存</th><th>删除</th></tr>";
        for (Product p : list) {
            html += "<tr>";
            html += "<td>" + p.getId() + "</td>";
            html += "<td>" + p.getTitle() + "</td>";
            html += "<td>" + p.getPrice() + "</td>";
            html += "<td>" + p.getNum() + "</td>";
            html += "<td><a href='/delete?id=" + p.getId() + "'>删除</a></td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id) {
        try (Connection conn = DBUtils.getConnection()) {
            String sql = "DELETE FROM product WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "删除完成!<a href='/select'>返回列表页面</a>";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Product product) {
        try (Connection conn = DBUtils.getConnection()) {
            String sql = "UPDATE product SET title=?, price=?, num=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getNum());
            ps.setInt(4, product.getId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "修改完成!<a href='/select'>返回列表页面</a>";
    }
}
