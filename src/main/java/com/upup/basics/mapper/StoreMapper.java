package com.upup.basics.mapper;

import com.upup.basics.model.Store;
import com.upup.sys.model.SysEmp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreMapper {
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
    List<Map<String,Object>> queryStorePage(Store store);

    //管理员查询
    List<Map<String,Object>> queryAllSysEmp(SysEmp sysEmp);


}