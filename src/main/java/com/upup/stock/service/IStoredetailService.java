package com.upup.stock.service;

import com.upup.base.util.PageBean;
import com.upup.model.Store;
import com.upup.sale.model.Goods;
import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;
import com.upup.stock.vo.StoredetailVo;
import com.upup.stock.vo.StoreoperVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


public interface IStoredetailService {
//    int deleteByPrimaryKey(Integer uuid);
//
//    int insert(Storedetail record);
//
//    int insertSelective(Storedetail record);
//
//    Storedetail selectByPrimaryKey(Integer uuid);
//
//    int updateByPrimaryKeySelective(Storedetail record);
//
//    int updateByPrimaryKey(Storedetail record);

    List<Map<String,Object>> queryStoredetailPage(StoredetailVo storedetailVo, PageBean pageBean);

    List<Store> selectStores();

    List<Goods> selectGoods();

    int updateByPrimaryKey(Storedetail record);

    String xlkck(Integer goodsuuid);

    List<Map<String,Object>> queryYjPage(StoredetailVo storedetailVo, PageBean pageBean);



}