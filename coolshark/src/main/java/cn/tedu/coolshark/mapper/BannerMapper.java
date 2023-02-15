package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Banner;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/13
 **/
public interface BannerMapper {
    List<Banner> select();

    void delete(int id);

    void insert(String url);

    Banner selectById(int id);

    void update(Banner banner);
}
