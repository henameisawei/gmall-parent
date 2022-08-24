package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.*;
import com.atguigu.gmall.product.mapper.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.gmall.product.service.SkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Awei
* @description 针对表【sku_info(库存单元表)】的数据库操作Service实现
* @createDate 2022-08-23 17:46:45
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService{
    @Autowired
    private SpuInfoMapper spuInfoMapper;
    @Autowired
    private SpuImageMapper spuImageMapper;
    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Override
    public IPage<SpuInfo> getSpuInfoPage(Page<SpuInfo> pageParam, SpuInfo spuInfo) {
        QueryWrapper<SpuInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category3_id", spuInfo.getCategory3Id());
        queryWrapper.orderByDesc("id");
        return spuInfoMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSpuInfo(SpuInfo spuInfo) {
//        spuInfo 商品表
        spuInfoMapper.insert(spuInfo);
//        spuImage 商品图片表
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if (spuImageList != null && spuImageList.size() > 0) {
            for (SpuImage spuImage : spuImageList) {
                spuImage.setSpuId(spuInfo.getId());
                spuImageMapper.insert(spuImage);
            }
        }
//        spuSaleAttr 销售属性表
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if (spuSaleAttrList != null && spuSaleAttrList.size() > 0) {
            for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {
                spuSaleAttr.setSpuId(spuInfo.getId());
                spuSaleAttrMapper.insert(spuSaleAttr);

                //        spuSaleAttrValue 销售属性值表
                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                if (spuSaleAttrValueList != null && spuSaleAttrValueList.size() > 0) {
                    for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList) {
                        spuSaleAttrValue.setSpuId(spuInfo.getId());
                        spuSaleAttrValue.setSaleAttrName(spuSaleAttr.getSaleAttrName());
                        spuSaleAttrValueMapper.insert(spuSaleAttrValue);
                    }
                }
            }
        }
    }
}




