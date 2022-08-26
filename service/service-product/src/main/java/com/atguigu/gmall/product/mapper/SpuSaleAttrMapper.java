package com.atguigu.gmall.product.mapper;


import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Awei
 * @description 针对表【spu_sale_attr(spu销售属性)】的数据库操作Mapper
 * @createDate 2022-08-23 17:46:44
 * @Entity com.atguigu.gmall.product.domain.SpuSaleAttr
 */
public interface SpuSaleAttrMapper extends BaseMapper<SpuSaleAttr> {
    List<SpuSaleAttr> selectSpuSaleAttrList(Long spuId);

    //高亮显示查询
    List<SpuSaleAttr> getSaleAttrAndValueMarkSku(@Param("spuId") Long spuId, @Param("skuId") Long skuId);

}




