package cn.tedu.boot04.mapper;

import cn.tedu.boot04.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/7
 **/
@Mapper
public interface UserMapper {
    @Select("SELECT password FROM user WHERE username=#{username}")
    User selectByUsername(String username);

    @Insert("INSERT INTO user(username, password, nickname) VALUES(#{username}, #{password}, #{nickname})")
    void insert(User user);
}
