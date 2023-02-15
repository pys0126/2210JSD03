package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVo;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/11
 **/
public interface CommentMapper {
    void insert(Comment comment);

    List<CommentVo> selectByW_id(int w_id);
}
