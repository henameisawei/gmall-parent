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

    //5.查询sku 细节信息

    //1.保存新增Sku信息
    @PostMapping("saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo) {
        // 调用服务层
        skuInfoService.saveSkuInfo(skuInfo);
        return Result.ok();
    }

    //2.sku分页展示
    @GetMapping("/list/{page}/{limit}")
    public Result index(
            @PathVariable Long page,
            @PathVariable Long limit) {

        Page<SkuInfo> pageParam = new Page<>(page, limit);
        IPage<SkuInfo> pageModel = skuInfoService.getPage(pageParam);
        // skuInfoService.page(pageParam);

        return Result.ok(pageModel);
    }

    //3.商品上架
    @GetMapping("/onSale/{skuId}")
    public Result onSale(@PathVariable("skuId") Long skuId) {
        skuInfoService.onSale(skuId);
        return Result.ok();
    }

    //4.商品下架
    @GetMapping("/cancelSale/{skuId}")
    public Result cancelSale(@PathVariable("skuId") Long skuId) {
        skuInfoService.cancelSale(skuId);


        return Result.ok();
    }
}
