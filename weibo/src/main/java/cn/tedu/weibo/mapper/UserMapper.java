package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.User;
import cn.tedu.weibo.pojo.vo.UserVo;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/10
 **/
public interface UserMapper {
    UserVo selectByUsername(String username);

    void insert(User user);
}
