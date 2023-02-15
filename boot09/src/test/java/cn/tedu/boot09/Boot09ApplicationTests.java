package cn.tedu.boot09;

import cn.tedu.boot09.entity.Category;
import cn.tedu.boot09.entity.Newemp;
import cn.tedu.boot09.mapper.CategoryMapper;
import cn.tedu.boot09.mapper.NewempMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Boot09ApplicationTests {
    @Autowired(required = false)
    NewempMapper newempMapper;

    //添加一个员工
    @Test
    void contextLoads() {
        Newemp emp = new Newemp();
        emp.setName("QQQ");
        emp.setSalary(5555.0);
        emp.setJob("qq");
        newempMapper.insert(emp);
    }

    //查询所有员工
    @Test
    void t1() {
        for (Newemp emp : newempMapper.selectAll()) {
            System.out.println(emp);
        }
    }

    //通过id查询员工
    @Test
    void t2() {
        System.out.println(newempMapper.selectById(1));
    }

    //动态修改员工
    @Test
    void t3() {
        Newemp emp = new Newemp();
        emp.setName("张三");
        emp.setJob("CEO");
        emp.setId(1);
        newempMapper.update(emp);
    }

    //通过一个id删除员工
    @Test
    void t4() {
        newempMapper.deleteById(1);
    }

    //通过多个id批量删除员工
    @Test
    void t5() {
        newempMapper.deleteByIds(2, 3);
    }

    //统计员工数量
    @Test
    void t6() {
        System.out.println("员工数量：" + newempMapper.selectCount());
    }

    @Autowired(required = false)
    CategoryMapper categoryMapper;

    @Test
    void c1() {
        Category category = new Category();
        category.setName("xx");
        category.setIntro("xxxx");
        category.setCreated(new Date());
        categoryMapper.insert(category);
    }

    @Test
    void c2() {
        for (Category category : categoryMapper.selectAll()) {
            System.out.println(category);
        }
    }

    @Test
    void c3() {
        System.out.println(categoryMapper.selectById(1));
    }

    @Test
    void c4() {
        Category category = new Category();
        category.setId(1);
        category.setName("手机");
        category.setIntro("简介");
        categoryMapper.update(category);
    }

    @Test
    void c5() {
        categoryMapper.deleteById(1);
    }

    @Test
    void c6() {
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        categoryMapper.deleteByIds(ids);
    }

    @Test
    void c7() {
        System.out.println(categoryMapper.selectCount());
    }
}
