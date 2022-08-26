package com.atguigu.gmall.item.service;

import com.atguigu.gmall.model.to.SkuDetailTo;
import org.apache.ibatis.annotations.Param;

/**
 * @author he
 * @date2022/8/26
 * @apiNote
 */
public interface SkuDetailService {
    SkuDetailTo getSkuDetail(@Param("skuId") Long skuId);

}
