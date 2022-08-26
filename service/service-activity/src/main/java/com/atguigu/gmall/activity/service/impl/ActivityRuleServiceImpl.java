package com.atguigu.gmall.activity.service.impl;

import com.atguigu.gmall.model.activity.ActivityRule;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.gmall.activity.service.ActivityRuleService;
import com.atguigu.gmall.activity.mapper.ActivityRuleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Awei
* @description 针对表【activity_rule(优惠规则)】的数据库操作Service实现
* @createDate 2022-08-25 20:29:56
*/
@Service
public class ActivityRuleServiceImpl extends ServiceImpl<ActivityRuleMapper, ActivityRule>
    implements ActivityRuleService{

    @Override
    public List<ActivityRule> findActivityRuleList(long id) {
        QueryWrapper<ActivityRule> wrapper = new QueryWrapper<>();
        wrapper.eq("activity_id", id);
        return this.list(wrapper);
    }
}




