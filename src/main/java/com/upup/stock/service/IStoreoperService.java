package com.upup.stock.service;

import com.upup.base.util.PageBean;
import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storeoper;
import com.upup.stock.vo.StoreoperVo;

import java.util.List;
import java.util.Map;

public interface IStoreoperService {


    List<Map<String,Object>> queryStoredetailPage(StoreoperVo storeoperVo, PageBean pageBean);


//    int insert(Storeoper record);


    int insert(Inventory record);












}