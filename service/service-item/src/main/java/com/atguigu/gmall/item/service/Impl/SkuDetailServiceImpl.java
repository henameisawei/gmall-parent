package com.atguigu.gmall.item.service.Impl;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.item.feign.SkuDetailFeignClient;
import com.atguigu.gmall.item.service.SkuDetailService;
import com.atguigu.gmall.model.to.SkuDetailTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author he
 * @date2022/8/26
 * @apiNote
 */
@Service
public class SkuDetailServiceImpl implements SkuDetailService {
    @Autowired
    SkuDetailFeignClient skuDetailFeignClient;
    @Override
    public SkuDetailTo getSkuDetail(Long skuId) {
        Result<SkuDetailTo> skuDetail = skuDetailFeignClient.getSkuDetail(skuId);
        return skuDetail.getData();
    }
}
