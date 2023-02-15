package cn.tedu.boot08.mapper;

import cn.tedu.boot08.entity.Product;
import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/9
 **/
public interface ProductMapper {
    void insert(Product product);

    List<Product> select();

    void deleteById(int id);

    void update(Product product);

    Product selectById(int id);

    void deleteByIds1(Integer[] ids);

    void deleteByIds2(Integer... ids);

    void deleteByIds3(List<Integer> ids);

    void dynamicUpdate(Product p);

    int selectCount();
}
