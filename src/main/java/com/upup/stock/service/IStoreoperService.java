package com.upup.stock.service;

import com.upup.base.util.PageBean;
import com.upup.stock.model.Storeoper;
import com.upup.stock.vo.StoreoperVo;

import java.util.List;
import java.util.Map;

public interface IStoreoperService {


    List<Map<String,Object>> queryStoredetailPager(StoreoperVo storeoperVo, PageBean pageBean);

}