package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Awei
* @description 针对表【base_attr_info(属性表)】的数据库操作Service
* @createDate 2022-08-23 17:46:46
*/
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {


    List<BaseAttrInfo> getAttrInfoAndValueByCategoryId(@Param("c1Id") Long c1Id, @Param("c2Id") Long c2Id, @Param("c3Id") Long c3Id);

    void saveAttrInfo(BaseAttrInfo info);
}
