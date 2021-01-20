package com.upup.sale.mapper;
import com.upup.sale.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    //查询全部
    List<Map<String,Object>> querygoodall();

    //根据名字查询单个
    Goods selectSinglegood(String goodname);

}