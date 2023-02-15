package cn.tedu.boot09.mapper;

import cn.tedu.boot09.entity.Category;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/9
 **/
public interface CategoryMapper {
    void insert(Category category);

    List<Category> selectAll();

    Category selectById(int id);

    void update(Category category);

    void deleteById(int id);

    void deleteByIds(List<Integer> ids);

    int selectCount();
}
