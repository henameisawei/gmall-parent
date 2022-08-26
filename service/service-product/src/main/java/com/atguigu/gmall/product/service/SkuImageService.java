package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.SkuImage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Awei
* @description 针对表【sku_image(库存单元图片表)】的数据库操作Service
* @createDate 2022-08-23 17:46:45
*/
public interface SkuImageService extends IService<SkuImage> {

    List<SkuImage> getSkuImage(@Param("skuId") Long skuId);

}
