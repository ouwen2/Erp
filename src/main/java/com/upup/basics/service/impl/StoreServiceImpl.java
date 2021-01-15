package com.upup.basics.service.impl;

import com.upup.base.util.PageBean;
import com.upup.basics.mapper.StoreMapper;
import com.upup.basics.model.Store;
import com.upup.basics.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    public StoreMapper storeMapper;

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return storeMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(Store record) {
        return storeMapper.insert(record);
    }

    @Override
    public int insertSelective(Store record) {
        return 0;
    }

    @Override
    public Store selectByPrimaryKey(Integer uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Store record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Store record) {
        return 0;
    }

    @Override
    public List<Store> queryAllStore(Store store) {
        return null;
    }

    @Override
    public List<Store> queryStorePager(Store store, PageBean pageBean) {
        return null;
    }
}
