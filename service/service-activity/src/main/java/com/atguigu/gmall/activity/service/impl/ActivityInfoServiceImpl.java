package com.atguigu.gmall.activity.service.impl;

import com.atguigu.gmall.activity.mapper.ActivityRuleMapper;
import com.atguigu.gmall.activity.mapper.ActivitySkuMapper;
import com.atguigu.gmall.activity.service.ActivityRuleService;
import com.atguigu.gmall.model.activity.ActivityInfo;
import com.atguigu.gmall.model.activity.ActivityRule;
import com.atguigu.gmall.model.activity.ActivityRuleVo;
import com.atguigu.gmall.model.activity.ActivitySku;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.gmall.activity.service.ActivityInfoService;
import com.atguigu.gmall.activity.mapper.ActivityInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Awei
* @description 针对表【activity_info(活动表)】的数据库操作Service实现
* @createDate 2022-08-25 20:29:56
*/
@Service
public class ActivityInfoServiceImpl extends ServiceImpl<ActivityInfoMapper, ActivityInfo>
    implements ActivityInfoService{

    @Autowired
    ActivityInfoMapper activityInfoMapper;
    @Autowired
    ActivityRuleMapper activityRuleMapper;
    @Autowired
    ActivitySkuMapper activitySkuMapper;

    @Override
    public void batchRemove(List<Long> ids) {

        activityInfoMapper.deleteBatchIds(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveActivityRule(ActivityRuleVo activityRuleVo) {
        activityRuleMapper.delete(new QueryWrapper<ActivityRule>().eq("activity_id",activityRuleVo.getActivityId()));
        activitySkuMapper.delete(new QueryWrapper<ActivitySku>().eq("activity_id",activityRuleVo.getActivityId()));

        List<ActivityRule> activityRuleList = activityRuleVo.getActivityRuleList();
        List<ActivitySku> activitySkuList = activityRuleVo.getActivitySkuList();
        //后续处理
        List<Long> couponIdList = activityRuleVo.getCouponIdList();

        for(ActivityRule activityRule : activityRuleList) {
            activityRule.setActivityId(activityRuleVo.getActivityId());
            activityRuleMapper.insert(activityRule);
        }

        for(ActivitySku activitySku : activitySkuList) {
            activitySku.setActivityId(activityRuleVo.getActivityId());
            activitySkuMapper.insert(activitySku);
        }

    }
}




