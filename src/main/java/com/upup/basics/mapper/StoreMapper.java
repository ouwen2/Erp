package com.upup.basics.mapper;

import com.upup.basics.model.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    //查询
    List<Store> queryAllStore(Store store);

    //分页查询
    List<Store> queryStorePager(Store store);
}