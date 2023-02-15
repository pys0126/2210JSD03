package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.CommentMapper;
import cn.tedu.weibo.pojo.dto.CommentDto;
import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/11
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired(required = false)
    CommentMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        comment.setCreated(new Date());
        mapper.insert(comment);
    }

    @RequestMapping("/selectByW_id")
    public List<CommentVo> selectByW_id(int w_id) {
        return mapper.selectByW_id(w_id);
    }
}
