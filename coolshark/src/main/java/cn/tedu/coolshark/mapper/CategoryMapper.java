package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Category;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/13
 **/
public interface CategoryMapper {
    List<Category> select();

    void delete(int id);

    void update(Category category);

    void insert(String name);
}
