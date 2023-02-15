package cn.tedu.boot05.mapper;

import cn.tedu.boot05.entity.User;
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
    @Insert("INSERT INTO user VALUES(NULL, #{username}, #{password}, #{nickname})")
    void insert(User user);

    @Select("SELECT password FROM user WHERE username=#{username}")
    User selectByUsername(String username);
}
