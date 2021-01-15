package com.upup.basics.mapper;

import com.upup.basics.model.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsTypeMapper {
    //删除
    int deleteByPrimaryKey(Integer uuid);

    //添加
    int insert(GoodsType record);

    //根据id查询
    GoodsType selectByPrimaryKey(Integer uuid);

    //修改
    int updateByPrimaryKey(GoodsType record);

    //查询
    List<GoodsType> queryAllGoodsType(GoodsType goodsType);

    //分页查询
    List<GoodsType> queryGoodsTypePager(GoodsType goodsType);
}