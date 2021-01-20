package com.upup.stock.mapper;

import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InventoryMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);

    List<Map<String,Object>> queryInventoryPage(Inventory inventory);

    List<Map<String,Object>> queryInventoryshPage(Inventory inventory);

    Storedetail querykc(Inventory inventory);

//    update inventory
//    set GOODSUUID = #{goodsuuid,jdbcType=INTEGER},
//    STOREUUID = #{storeuuid,jdbcType=INTEGER},
//    NUM = #{num,jdbcType=INTEGER},
//    TYPE = #{type,jdbcType=CHAR},
//    CREATETIME = #{createtime,jdbcType=DATE},
//    CHECKTIME = #{checktime,jdbcType=DATE},
//    CREATER = #{creater,jdbcType=INTEGER},
//    CHECKER = #{checker,jdbcType=INTEGER},
//    STATE = #{state,jdbcType=CHAR},
//    REMARK = #{remark,jdbcType=VARCHAR}
//    where UUID = #{uuid,jdbcType=INTEGER}



}