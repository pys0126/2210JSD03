package cn.tedu.boot03;

import cn.tedu.boot03.entity.Product;
import cn.tedu.boot03.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot03ApplicationTests {
    //通过此注解 Spring框架+MyBatis框架会生成ProductMapper接口的实现类, 并且实例化此实现类而且在实现类中, 还会实现所有的抽象方法
    @Autowired
    ProductMapper mapper;

    @Test
    void contextLoads() {
        Product p = new Product();
        p.setTitle("鼠标");
        p.setPrice(50.0);
        p.setNum(10);
        mapper.insert(p);
    }

}
