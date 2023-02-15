package cn.tedu.weibo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/10
 **/
@Configuration
@MapperScan("cn.tedu.weibo.mapper")
public class MybatisConfig {
}
