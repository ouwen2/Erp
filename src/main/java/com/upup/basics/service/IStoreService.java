package com.upup.basics.service;

import com.upup.base.util.PageBean;
import com.upup.basics.model.Store;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IStoreService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    //查询
    List<Store> queryAllStore(Store store);

    //分页查询
    List<Store> queryStorePager(Store store, PageBean pageBean);
}