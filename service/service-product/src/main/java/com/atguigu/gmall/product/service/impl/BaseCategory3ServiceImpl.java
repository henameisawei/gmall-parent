package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.gmall.product.service.BaseCategory3Service;
import com.atguigu.gmall.product.mapper.BaseCategory3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Awei
 * @description 针对表【base_category3(三级分类表)】的数据库操作Service实现
 * @createDate 2022-08-22 21:40:24
 */
@Service
public class BaseCategory3ServiceImpl extends ServiceImpl<BaseCategory3Mapper, BaseCategory3>
        implements BaseCategory3Service {
    @Autowired
    BaseCategory3Mapper baseCategory3Mapper;

    @Override
    public List<BaseCategory3> getCategory2Child(Long c2Id) {

        //select * from base_category3 where category2_id=?

        QueryWrapper<BaseCategory3> wrapper = new QueryWrapper<>();
        wrapper.eq("category2_id",c2Id);


        List<BaseCategory3> list = baseCategory3Mapper.selectList(wrapper);
        return list;
    }
}




