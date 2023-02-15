package cn.tedu.boot09.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/9
 **/
@Configuration
@MapperScan("cn.tedu.boot09.mapper")
public class MapperConfig {
}
