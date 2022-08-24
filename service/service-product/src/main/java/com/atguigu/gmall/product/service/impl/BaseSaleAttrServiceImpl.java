package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.gmall.product.service.BaseSaleAttrService;
import com.atguigu.gmall.product.mapper.BaseSaleAttrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Awei
* @description 针对表【base_sale_attr(基本销售属性表)】的数据库操作Service实现
* @createDate 2022-08-23 17:46:46
*/
@Service
public class BaseSaleAttrServiceImpl extends ServiceImpl<BaseSaleAttrMapper, BaseSaleAttr>
    implements BaseSaleAttrService{

    @Autowired
    private BaseSaleAttrMapper baseSaleAttrMapper;

    @Override
    public List<BaseSaleAttr> getBaseSaleAttrList() {
        return baseSaleAttrMapper.selectList(null);
    }
}




