package cn.tedu.boot06.mapper;

import cn.tedu.boot06.entity.Product;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/7
 **/
@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO product VALUE(NULL, #{title}, #{price}, #{num})")
    void insert(Product product);

    @Select("SELECT * FROM product")
    List<Product> select();

    @Delete("DELETE FROM product WHERE id=#{id}")
    void deleteById(int id);

    @Update("UPDATE product SET title=#{title}, price=#{price}, num=#{num} WHERE id=#{id}")
    void update(Product product);

    @Select("SELECT * FROM product WHERE id=#{id}")
    Product selectById(int id);
}
