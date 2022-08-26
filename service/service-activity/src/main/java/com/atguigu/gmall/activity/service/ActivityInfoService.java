package com.atguigu.gmall.activity.service;


import com.atguigu.gmall.model.activity.ActivityInfo;
import com.atguigu.gmall.model.activity.ActivityRuleVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Awei
* @description 针对表【activity_info(活动表)】的数据库操作Service
* @createDate 2022-08-25 20:29:56
*/
public interface ActivityInfoService extends IService<ActivityInfo> {

    void batchRemove(@Param("ids") List<Long> ids);

    void saveActivityRule(@Param("activityRuleVo") ActivityRuleVo activityRuleVo);

}
