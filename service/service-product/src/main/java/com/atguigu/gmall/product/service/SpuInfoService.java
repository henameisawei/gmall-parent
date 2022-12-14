package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.SpuInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Awei
* @description 针对表【spu_info(商品表)】的数据库操作Service
* @createDate 2022-08-23 17:46:44
*/
public interface SpuInfoService extends IService<SpuInfo> {

    IPage<SpuInfo> getSpuInfoPage(Page<SpuInfo> spuInfoPage, SpuInfo spuInfo);

    void saveSpuInfo(SpuInfo spuInfo);
}
