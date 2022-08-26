package com.atguigu.gmall.activity.controller;

import com.atguigu.gmall.activity.service.ActivityRuleService;
import com.atguigu.gmall.activity.service.ActivitySkuService;
import com.atguigu.gmall.activity.service.CouponInfoService;
import com.atguigu.gmall.activity.service.CouponRangeService;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.activity.ActivityRule;
import com.atguigu.gmall.model.activity.ActivitySku;
import com.atguigu.gmall.model.activity.CouponInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author he
 * @date2022/8/25
 * @apiNote
 */
@RestController
@RequestMapping("/admin/activity")
public class CouponInfoController {

    @Autowired
    CouponInfoService couponInfoService;

    @Autowired
    CouponRangeService couponRangeService;


    @GetMapping("/couponInfo/{page}/{limit}")
    public Result index(
            @PathVariable Long page,
            @PathVariable Long limit) {

        Page<CouponInfo> pageParam = new Page<>(page, limit);
        IPage<CouponInfo> pageModel = couponInfoService.page(pageParam);
        // skuInfoService.page(pageParam);
        return Result.ok(pageModel);
    }

    // http://192.168.6.1/admin/activity/couponInfo/get/2
    //查询信息回显
    @GetMapping("/couponInfo/get/{coupId}")
    public Result getCouponInfo(@PathVariable("coupId") long coupId) {
        CouponInfo couponInfo = couponInfoService.getById(coupId);
        return Result.ok(couponInfo);
    }

    // http://192.168.6.1/admin/activity/couponInfo/update
    //保存回显信息无Id
    @PutMapping("/couponInfo/update")
    public Result putCouponInfo(@RequestBody CouponInfo couponInfo) {
        boolean b = couponInfoService.updateById(couponInfo);
        return Result.ok();
    }

    //http://192.168.6.1/admin/activity/couponInfo/findCouponRuleList/2


}
