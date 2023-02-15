package cn.tedu.boot07.mapper;

import cn.tedu.boot07.entity.Image;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/8
 **/
@Mapper
public interface ImageMapper {
    @Insert("INSERT INTO image VALUES(NULL, #{title}, #{urls}, #{created})")
    void insert(Image image);

    @Select("SELECT * FROM image")
    List<Image> select();

    @Delete("DELETE FROM image WHERE id=#{id}")
    void delete(int id);

    @Select("SELECT urls FROM image WHERE id=#{id}")
    String selectUrlsById(int id);
}
