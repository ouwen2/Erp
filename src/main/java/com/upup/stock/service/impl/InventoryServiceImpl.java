package com.upup.stock.service.impl;

import com.upup.base.util.PageBean;
import com.upup.stock.mapper.InventoryMapper;
import com.upup.stock.mapper.StoredetailMapper;
import com.upup.stock.mapper.StoreoperMapper;
import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;
import com.upup.stock.service.IInventoryService;
import com.upup.stock.vo.InventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements IInventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private StoreoperMapper storeoperMapper;

    @Autowired
    private StoredetailMapper storedetailMapper;

    @Override
    public List<Map<String, Object>> queryInventoryPage(InventoryVo inventoryVo,PageBean pageBean) {
        return inventoryMapper.queryInventoryPage(inventoryVo);
    }

    @Override
    public int insert(Inventory record) {
        return inventoryMapper.insert(record);
    }

    @Override
    public List<Map<String, Object>> queryInventoryshPage(Inventory inventory,PageBean pageBean) {
        return inventoryMapper.queryInventoryshPage(inventory);
    }

    @Override
    public int updateByPrimaryKey(Inventory record) {
        return inventoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public Storedetail querykc(int inventory) {

        return inventoryMapper.querykc(inventory);
    }

    @Override
    public Integer getList(String name) {
        return inventoryMapper.getList(name);
    }

    @Override
    public int queryGoodId(String goodsuuid) {
        return inventoryMapper.queryGoodId(goodsuuid);
    }

    @Override
    public int queryStoreId(String storeuuid) {
        return inventoryMapper.queryStoreId(storeuuid);
    }

    @Transactional
    @Override
    public void updateSP(Inventory inventory) {
        //设置时间
        inventory.setChecktime(new Date());
        //设置审核人
        inventory.setCreater(1);
        inventory.setChecker(1);
        //1.将审核表中的状态改为已审核
        int i =inventoryMapper.updateByPrimaryKey(inventory);
        //2.根据盘盈盘亏对库存表中是数据对应相加减
        //根据前端传过来的Goodsuuid查到Id
        int i1 =  inventoryMapper.queryGoodId(inventory.getGoodsuuid());
        //根据id查询到库存表对象
        Storedetail kc=inventoryMapper.querykc(i1);
        System.out.println("inventory:"+inventory);

        if(inventory.getType().equals("2")){
            Integer num  = inventory.getNum();
            Integer num1 = kc.getNum();
            Integer num2 = num1-num;
            kc.setNum(num2);
            storedetailMapper.updateByPrimaryKey(kc);
        }
        if(inventory.getType().equals("1")){
            Integer num = inventory.getNum();
            Integer num1 = kc.getNum();
            Integer num2=num1+num;
            kc.setNum(num2);
            storedetailMapper.updateByPrimaryKey(kc);
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa"+inventory);

        //添加库存变动表

        //查询到storeuuid的Id
        int i2=  inventoryMapper.queryStoreId(inventory.getStoreuuid());

        String storeuuid = String.valueOf(i2);
        inventory.setStoreuuid(storeuuid);
        String goooduuid=String.valueOf(i1);
        inventory.setGoodsuuid(goooduuid);
//        inventory.setUuid(0);
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+inventory);
        inventory.setUuid(null);

        storeoperMapper.insert(inventory);





    }
}
