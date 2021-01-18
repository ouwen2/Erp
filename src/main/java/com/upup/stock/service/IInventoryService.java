package com.upup.stock.service;

import com.upup.base.util.PageBean;
import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;

import java.util.List;
import java.util.Map;

public interface IInventoryService {


    List<Map<String,Object>> queryInventoryPage(Inventory inventory, PageBean pageBean);

    int insert(Inventory record);

    List<Map<String,Object>> queryInventoryshPage(Inventory inventory, PageBean pageBean);

    int updateByPrimaryKey(Inventory record);

    Storedetail querykc(Inventory inventory);



}