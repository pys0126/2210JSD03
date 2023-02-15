package cn.tedu.boot08;

import cn.tedu.boot08.entity.Product;
import cn.tedu.boot08.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Boot08ApplicationTests {
    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.select());
    }

    @Test
    void t1() {
        Product p = new Product();
        p.setTitle("永久牌自行车");
        p.setPrice(100.0);
        p.setNum(50);
        mapper.insert(p);
    }

    @Test
    void t2() {
        Product p = new Product();
        p.setId(23);
        p.setTitle("凤凰牌自行车");
        p.setPrice(100.0);
        p.setNum(50);
        mapper.update(p);
    }

    @Test
    void t3() {
        System.out.println(mapper.selectById(23));
    }

    @Test
    void t4() {
        mapper.deleteById(1);
    }

    @Test
    void t5() {
        mapper.deleteByIds1(new Integer[]{24, 25});
    }

    @Test
    void t6() {
        mapper.deleteByIds2(26, 27);
    }

    @Test
    void t7() {
        List<Integer> list = new ArrayList<>();
        list.add(28);
        list.add(29);
        mapper.deleteByIds3(list);
    }

    @Test
    void t8() {
        Product p = new Product();
        p.setId(24);
        p.setTitle("凤凰牌");
        mapper.dynamicUpdate(p);
    }

    @Test
    void t9() {
        int count = mapper.selectCount();
        System.out.println(count);
    }
}
