package cn.tedu.coolshark.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/13
 **/
@Configuration
@MapperScan("cn.tedu.coolshark.mapper")
public class MybatisConfig {
}
