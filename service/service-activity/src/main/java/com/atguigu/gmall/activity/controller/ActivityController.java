package com.atguigu.gmall.activity.controller;

import com.atguigu.gmall.activity.service.ActivityInfoService;
import com.atguigu.gmall.activity.service.CouponInfoService;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.activity.ActivityInfo;
import com.atguigu.gmall.model.activity.CouponInfo;
import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author he
 * @date2022/8/25
 * @apiNote
 */
@RestController
@RequestMapping("/admin/activity")
public class ActivityController {

    ////http://192.168.6.1/admin/activity/activityInfo/1/10
    @Autowired
    ActivityInfoService activityInfoService;



    @GetMapping("/activityInfo/{page}/{limit}")
    public Result index(
            @PathVariable Long page,
            @PathVariable Long limit) {

        Page<ActivityInfo> pageParam = new Page<>(page, limit);
        IPage<ActivityInfo> pageModel = activityInfoService.page(pageParam);
        // skuInfoService.page(pageParam);
        return Result.ok(pageModel);
    }
    // http://192.168.6.1/admin/activity/couponInfo/1/10


}
