package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.product.service.BaseSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author he
 * @date2022/8/25
 * @apiNote
 */

@RequestMapping("/admin/product")
@RestController
public class BaseSaleAttrController {

    @Autowired
    private BaseSaleAttrService baseSaleAttrService;

    //sku 新增时属性选择
    @GetMapping("baseSaleAttrList")
    public Result baseSaleAttrList(){
        // 查询所有的销售属性集合
        List<BaseSaleAttr> baseSaleAttrList = baseSaleAttrService.getBaseSaleAttrList();

        return Result.ok(baseSaleAttrList);
    }
}
