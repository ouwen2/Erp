package com.upup.sale.mapper;
import com.upup.sale.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {

    int insertSelective(Goods record);

    int updateByPrimaryKey(Goods record);

    //查询全部
    List<Map<String,Object>> querygoodall();

    //根据名字查询单个
    Goods selectSinglegood(String goodname);

    //查询
    List<Map<String,Object>> queryAllGoods(Goods goods);

    //分页查询
    List<Map<String,Object>> queryGoodsPager(Goods goods);

    //删除
    int deleteByPrimaryKey(Integer uuid);

    //添加
    int insert(Goods record);

    //单个查询
    Goods selectByPrimaryKey(Integer uuid);

    //修改
    int updateByPrimaryKeySelective(Goods record);

}