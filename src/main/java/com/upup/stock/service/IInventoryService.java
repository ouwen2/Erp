package com.upup.stock.service;

import com.upup.base.util.PageBean;
import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;
import com.upup.stock.vo.InventoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IInventoryService {


    List<Map<String,Object>> queryInventoryPage(InventoryVo inventoryVo, PageBean pageBean);

    int insert(Inventory record);

    List<Map<String,Object>> queryInventoryshPage(Inventory inventory, PageBean pageBean);

    int updateByPrimaryKey(Inventory record);

    Storedetail querykc(int inventory);

    Integer getList(String name);

    int queryGoodId(String goodsuuid);

    int queryStoreId(String storeuuid);

    void updateSP(Inventory inventory);

}