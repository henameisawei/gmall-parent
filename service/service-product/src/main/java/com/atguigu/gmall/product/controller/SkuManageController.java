package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.*;
import com.atguigu.gmall.product.service.BaseSaleAttrService;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.atguigu.gmall.product.service.SpuImageService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author he
 * @date2022/8/24
 * @apiNote
 */
@RequestMapping("/admin/product")
@RestController
public class SkuManageController {

    @Autowired
    private SkuInfoService skuInfoService;
    @Autowired
    private BaseSaleAttrService baseSaleAttrService;

    //sku 新增时属性选择
    @GetMapping("baseSaleAttrList")
    public Result baseSaleAttrList(){
        // 查询所有的销售属性集合
        List<BaseSaleAttr> baseSaleAttrList = baseSaleAttrService.getBaseSaleAttrList();

        return Result.ok(baseSaleAttrList);
    }
    @PostMapping("saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo) {
        // 调用服务层
        skuInfoService.saveSkuInfo(skuInfo);
        return Result.ok();
    }
}
