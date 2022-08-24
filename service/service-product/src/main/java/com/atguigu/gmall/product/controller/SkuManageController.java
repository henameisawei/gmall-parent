package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
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

    //http://api.gmall.com/admin/product/{page}/{limit}?category3Id=61
    @GetMapping("{page}/{size}")
    public Result getSpuInfoPage(@PathVariable Long page,
                                 @PathVariable Long size,
                                 SpuInfo spuInfo){
        // 创建一个Page 对象
        Page<SpuInfo> spuInfoPage = new Page<>(page,size);
        // 获取数据
        IPage<SpuInfo> spuInfoPageList = skuInfoService.getSpuInfoPage(spuInfoPage, spuInfo);
        // 将获取到的数据返回即可！
        return Result.ok(spuInfoPageList);
    }

    //http://api.gmall.com/admin/product/saveSpuInfo
    //sku 新增保存
    @PostMapping("/saveSpuInfo")
    public  Result SaveSpuInfo (@RequestBody SpuInfo spuInfo){
        skuInfoService.saveSpuInfo(spuInfo);
        return Result.ok();
    }
}
