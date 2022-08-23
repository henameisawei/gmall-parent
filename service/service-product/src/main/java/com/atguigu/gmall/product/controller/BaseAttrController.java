package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author he
 * @date2022/8/23
 * @apiNote
 */
@RequestMapping("/admin/product")
@RestController
public class BaseAttrController {


    @Autowired
    BaseAttrInfoService baseAttrInfoService;
    @Autowired
    BaseAttrValueService baseAttrValueService;

    @GetMapping("/attrInfoList/{c1Id}/{c2Id}/{c3Id}")
    public Result getAttrInfoList(@PathVariable("c1Id")Long c1Id,
                                  @PathVariable("c2Id")Long c2Id,
                                  @PathVariable("c3Id")Long c3Id){


        List<BaseAttrInfo> infos = baseAttrInfoService.getAttrInfoAndValueByCategoryId(c1Id,c2Id,c3Id);

        return Result.ok(infos);
    }
    //http://api.gmall.com/admin/product/saveAttrInfo
    @PostMapping("/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo info){
        baseAttrInfoService.saveAttrInfo(info);
        return Result.ok();
    }

    //http://api.gmall.com/admin/product/getAttrValueList/{attrId}
    @GetMapping("/getAttrValueList/{attrId}")
    public  Result getAttrValuelist (@PathVariable("attrId")long attrId){
        List<BaseAttrValue> values = baseAttrValueService.getAttrValueList(attrId);
        return Result.ok(values);
    }



}
