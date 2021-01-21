package com.upup.basics.service.impl;

import com.upup.base.util.PageBean;
import com.upup.basics.mapper.GoodsTypeMapper;
import com.upup.basics.model.GoodsType;
import com.upup.basics.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;


    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return goodsTypeMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(GoodsType record) {
        return goodsTypeMapper.insert(record);
    }

    @Override
    public GoodsType selectByPrimaryKey(Integer uuid) {
        return goodsTypeMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKey(GoodsType record) {
        return goodsTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsType> queryAllGoodsType(GoodsType goodsType) {
        return goodsTypeMapper.queryAllGoodsType(goodsType);
    }

    @Override
    public List<GoodsType> queryGoodsTypePage(GoodsType goodsType, PageBean pageBean) {
        return goodsTypeMapper.queryGoodsTypePage(goodsType);
    }

    @Override
    public List<GoodsType> cxsp() {
        return goodsTypeMapper.cxsp();
    }
}
