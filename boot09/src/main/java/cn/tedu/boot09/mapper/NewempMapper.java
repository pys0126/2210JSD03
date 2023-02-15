package cn.tedu.boot09.mapper;

import cn.tedu.boot09.entity.Newemp;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/9
 **/
public interface NewempMapper {
    void insert(Newemp emp);

    List<Newemp> selectAll();

    Newemp selectById(int id);

    void update(Newemp emp);

    void deleteById(int id);

    void deleteByIds(Integer... ids);

    int selectCount();
}
