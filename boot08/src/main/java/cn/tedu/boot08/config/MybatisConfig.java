package cn.tedu.boot08.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/9
 **/
/*设置当前类为配置类 工程启动时会自动加载*/
@Configuration
@MapperScan("cn.tedu.boot08.mapper")
public class MybatisConfig {
}
