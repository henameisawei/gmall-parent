package com.atguigu.gmall.activity.controller;

import com.atguigu.gmall.activity.service.ActivityInfoService;
import com.atguigu.gmall.activity.service.ActivityRuleService;
import com.atguigu.gmall.activity.service.CouponInfoService;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.activity.ActivityInfo;
import com.atguigu.gmall.model.activity.ActivityRule;
import com.atguigu.gmall.model.activity.ActivityRuleVo;
import com.atguigu.gmall.model.activity.CouponInfo;
import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.applet.Main;

import java.time.Instant;
import java.util.Date;
import java.util.List;

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

    @Autowired
    ActivityRuleService activityRuleService;


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

    /**
     * 新增活动
     * /admin/activity/activityInfo/save
     */
    @PostMapping("activityInfo/save")
    public Result save(@RequestBody ActivityInfo activityInfo) {
        activityInfo.setCreateTime(Date.from(Instant.now()));
        activityInfoService.save(activityInfo);
        return Result.ok();
    }

    /**
     * 修改活动
     * /admin/activity/activityInfo/update
     */
    @PutMapping("activityInfo/update")
    public Result update(@RequestBody ActivityInfo activityInfo) {
        activityInfo.setCreateTime(Date.from(Instant.now()));
        activityInfoService.updateById(activityInfo);
        return Result.ok();
    }


    /**
     * 根据活动id回显活动的信息
     * /admin/activity/activityInfo/get/9
     */
    @GetMapping("activityInfo/get/{id}")
    public Result getById(@PathVariable long id) {
        ActivityInfo activityInfo = activityInfoService.getById(id);
        return Result.ok(activityInfo);
    }

    /**
     * 根据活动id删除
     * /admin/activity/activityInfo/remove/1
     */
    @DeleteMapping("activityInfo/remove/{id}")
    public Result remove(@PathVariable long id) {
        activityInfoService.removeById(id);
        return Result.ok();
    }

    /**
     * 批量删除
     * /admin/activity/activityInfo/batchRemove
     */
    @DeleteMapping("activityInfo/batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids) {
        activityInfoService.batchRemove(ids);
        return Result.ok();
    }

    /**
     * 获取对应活动的活动规则
     * /admin/activity/activityInfo/findActivityRuleList/10
     */
    @GetMapping("activityInfo/findActivityRuleList/{id}")
    public Result findActivityRuleList(@PathVariable long id) {
        List<ActivityRule> list = activityRuleService.findActivityRuleList(id);
        return Result.ok(list);
    }
//http://192.168.6.1/admin/activity/activityInfo/findSkuInfoByKeyword/1
    //关键词查询


    @ApiOperation(value = "保存活动规则")
    @PostMapping("saveActivityRule")
    public Result saveActivityRule(@RequestBody ActivityRuleVo activityRuleVo) {
        activityInfoService.saveActivityRule(activityRuleVo);
        return Result.ok();
    }
}
