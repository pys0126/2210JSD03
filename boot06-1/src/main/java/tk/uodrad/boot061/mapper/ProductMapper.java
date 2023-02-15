package tk.uodrad.boot061.mapper;

import org.apache.ibatis.annotations.*;
import tk.uodrad.boot061.entity.Product;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/8
 **/
@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO product VALUES(NULL, #{title}, #{price}, #{num})")
    void insert(Product product);

    @Select("SELECT * FROM product")
    List<Product> select();

    @Update("UPDATE product SET title=#{title}, price=#{price}, num=#{num} WHERE id=#{id}")
    void update(Product product);

    @Delete("DELETE FROM product WHERE id=#{id}")
    void delete(int id);

    @Select("SELECT * FROM product WHERE id=#{id}")
    Product selectById(int id);
}
