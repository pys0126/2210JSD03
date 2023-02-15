package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.WeiboIndexVo;
import cn.tedu.weibo.pojo.vo.WeiboDetailVo;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/10
 **/
public interface WeiboMapper {
    void insert(Weibo weibo);

    List<WeiboIndexVo> select();

    WeiboDetailVo selectById(int id);
}
