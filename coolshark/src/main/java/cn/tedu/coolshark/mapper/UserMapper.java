package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.vo.UserVo;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/13
 **/
public interface UserMapper {
    UserVo selectByUsername(String username);
}
