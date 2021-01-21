package com.upup.basics.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.basics.model.Store;
import com.upup.sys.model.SysEmp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface IStoreService {
    //删除
    int deleteByPrimaryKey(Integer uuid);

    //添加
    int insert(Store record);

    //单个查询
    Store selectByPrimaryKey(Integer uuid);

    //修改
    int updateByPrimaryKey(Store record);

    //查询
    List<Store> queryAllStore(Store store);

    //分页查询仓库
    JsonResponseBody<?> queryStorerPage(Store store, PageBean pageBean);

    //管理员查询
    List<Map<String,Object>> queryAllSysEmp(SysEmp sysEmp);
}