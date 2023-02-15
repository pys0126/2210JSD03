package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.dto.ProductUpdateDto;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.*;

import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/14
 **/
public interface ProductMapper {
    void insert(Product product);

    List<ProductAdminVo> select();

    String selectUrlById(int id);

    void deleteById(int id);

    ProductUpdateVo selectById(int id);

    void update(ProductUpdateDto productUpdateDto);

    List<ProductIndexVo> selectForIndex();

    List<ProductTopVo> selectForTop();

    List<ProductIndexVo> selectByCid(int id);

    List<ProductIndexVo> selectByWd(String wd);

    ProductDetailVo selectForDetailById(int id);

    void updateViewCountById(int id);
}
