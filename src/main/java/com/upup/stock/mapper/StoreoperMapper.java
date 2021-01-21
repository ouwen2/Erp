package com.upup.stock.mapper;

import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storeoper;
import com.upup.stock.vo.StoredetailVo;
import com.upup.stock.vo.StoreoperVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreoperMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insertSelective(Storeoper record);

    Storeoper selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Storeoper record);

    int updateByPrimaryKey(Storeoper record);

    List<Map<String,Object>> queryStoredetailPage(StoreoperVo storeoperVo);

    int insert(Inventory record);


}