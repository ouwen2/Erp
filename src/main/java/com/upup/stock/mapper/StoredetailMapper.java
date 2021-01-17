package com.upup.stock.mapper;

import com.upup.model.Store;
import com.upup.model.Storedetail;
import com.upup.sale.model.Goods;
import com.upup.stock.vo.StoredetailVo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface StoredetailMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Storedetail record);

    int insertSelective(Storedetail record);

    Storedetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Storedetail record);

    int updateByPrimaryKey(Storedetail record);

    List<Map<String,Object>> queryStoredetailPage(StoredetailVo storedetailVo);

        List<Store> selectStores();

        List<Goods> selectGoods();

        }