package com.upup.stock.mapper;

import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;
import com.upup.stock.vo.InventoryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InventoryMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);

    List<Map<String,Object>> queryInventoryPage(InventoryVo inventoryVo);

    List<Map<String,Object>> queryInventoryshPage(Inventory inventory);

    Storedetail querykc(int inventory);

    Integer getList(@Param("name") String name);

    int queryGoodId(@Param("goodsuuid") String goodsuuid);

    int queryStoreId(@Param("storeuuid") String storeuuid);




}