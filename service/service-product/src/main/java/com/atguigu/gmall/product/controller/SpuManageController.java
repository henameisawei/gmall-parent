package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.product.service.*;
import com.atguigu.gmall.product.service.impl.SpuInfoServiceImpl;
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
public class SpuManageController {
    @Autowired
    SpuImageService spuImageService;
    @Autowired
    SpuSaleAttrService spuSaleAttrService;

    @GetMapping("spuImageList/{spuId}")
    public Result<List<SpuImage>> getSpuImageList(@PathVariable("spuId") Long spuId) {
        List<SpuImage> spuImageList = spuImageService.getSpuImageList(spuId);
        return Result.ok(spuImageList);
    }
    //http://api.gmall.com/admin/product/spuSaleAttrList/{spuId}
    @GetMapping("spuSaleAttrList/{spuId}")
    public Result<List<SpuSaleAttr>> getSpuSaleAttrList(@PathVariable("spuId") Long spuId) {
        List<SpuSaleAttr> spuSaleAttrList = spuSaleAttrService.getSpuSaleAttrList(spuId);
        return Result.ok(spuSaleAttrList);
    }

}
