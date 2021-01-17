package com.upup.stock.service.impl;

import com.upup.base.util.PageBean;
import com.upup.model.Store;
import com.upup.model.Storedetail;
import com.upup.sale.model.Goods;
import com.upup.stock.mapper.StoredetailMapper;
import com.upup.stock.service.IStoredetailService;
import com.upup.stock.vo.StoredetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class StoredetailServiceImpl implements IStoredetailService {

   @Autowired
    private StoredetailMapper storedetailMapper;


    @Override
    public List<Map<String,Object>> queryStoredetailPage(StoredetailVo storedetailVo, PageBean pageBean) {
        if(storedetailVo.getStoreName()==null){
            storedetailVo.setStoreName("");
        }
        if(storedetailVo.getGoodsName()==null){
            storedetailVo.setGoodsName("");
        }
        return storedetailMapper.queryStoredetailPage(storedetailVo);
    }

    @Override
    public List<Store> selectStores() {
        return storedetailMapper.selectStores();
    }

    @Override
    public List<Goods> selectGoods() {
        return storedetailMapper.selectGoods();
    }
}
