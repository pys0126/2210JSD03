package cn.tedu.boot03.mapper;

import cn.tedu.boot03.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/6
 **/
@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO product(title, price, num) VALUES(#{title}, #{price}, #{num})")
    void insert(Product product);

    @Select("SELECT * FROM product")
    List<Product> select();

    @Delete("DELETE FROM product WHERE id=#{id}")
    void deleteById(Integer id);

    @Update("UPDATE product SET title=#{title}, price=#{price}, num=#{num} WHERE id=#{id}")
    void update(Product product);

    @Select("SELECT * FROM product WHERE id=#{id}")
    Product updateById(Integer id);
}
