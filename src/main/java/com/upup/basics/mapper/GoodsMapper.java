package com.upup.basics.mapper;

import com.upup.basics.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    //删除
    int deleteByPrimaryKey(Integer uuid);

    //添加
    int insert(Goods record);

    int insertSelective(Goods record);

    //单个查询
    Goods selectByPrimaryKey(Integer uuid);

    //修改
    int updateByPrimaryKeySelective(Goods record);

    //查询
    List<Goods> queryAllGoods(Goods goods);

    //分页查询
    List<Goods> queryGoodsPager(Goods goods);

    int updateByPrimaryKey(Goods record);
}