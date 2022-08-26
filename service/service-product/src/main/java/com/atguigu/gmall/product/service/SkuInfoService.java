package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.model.to.SkuDetailTo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
* @author Awei
* @description 针对表【sku_info(库存单元表)】的数据库操作Service
* @createDate 2022-08-23 17:46:45
*/
public interface SkuInfoService extends IService<SkuInfo> {


    void saveSkuInfo(SkuInfo skuInfo);

    IPage<SkuInfo> getPage(Page<SkuInfo> pageParam);

    void onSale(@Param("skuId") Long skuId);

    void cancelSale(@Param("skuId") Long skuId);

    SkuDetailTo getSkuDetail(@Param("skuId") Long skuId);

}
