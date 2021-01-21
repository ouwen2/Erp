package com.upup.basics.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.basics.mapper.StoreMapper;
import com.upup.basics.mapper.SupplierMapper;
import com.upup.basics.model.Store;
import com.upup.basics.service.IStoreService;
import com.upup.sys.model.SysEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public Store selectByPrimaryKey(Integer uuid) {
        return storeMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKey(Store record) {
        return storeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Store> queryAllStore(Store store) {
        return storeMapper.queryAllStore(store);
    }

    @Override
    public JsonResponseBody<?> queryStorerPage(Store store, PageBean pageBean) {
        List<Map<String,Object>> list = storeMapper.queryStorePage(store);
        return new JsonResponseBody<>(list,list.size());
    }

    @Override
    public List<Map<String,Object>> queryAllSysEmp(SysEmp sysEmp) {
        return storeMapper.queryAllSysEmp(sysEmp);
    }


}
