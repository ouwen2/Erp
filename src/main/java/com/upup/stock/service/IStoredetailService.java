package com.upup.stock.service;

import com.upup.base.util.PageBean;
import com.upup.model.Storedetail;
import com.upup.stock.vo.StoredetailVo;

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

    List<Map<String,Object>> queryStoredetailPager(StoredetailVo storedetailVo, PageBean pageBean);

}