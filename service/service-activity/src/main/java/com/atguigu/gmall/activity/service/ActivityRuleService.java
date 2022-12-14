package com.atguigu.gmall.activity.service;


import com.atguigu.gmall.model.activity.ActivityRule;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Awei
* @description 针对表【activity_rule(优惠规则)】的数据库操作Service
* @createDate 2022-08-25 20:29:56
*/
public interface ActivityRuleService extends IService<ActivityRule> {

    List<ActivityRule> findActivityRuleList(@Param("id") long id);

}
