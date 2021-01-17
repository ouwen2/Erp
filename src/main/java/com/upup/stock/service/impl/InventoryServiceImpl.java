package com.upup.stock.service.impl;

import com.upup.base.util.PageBean;
import com.upup.stock.mapper.InventoryMapper;
import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;
import com.upup.stock.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements IInventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public List<Map<String, Object>> queryInventoryPage(Inventory inventory, PageBean pageBean) {
        return inventoryMapper.queryInventoryPage(inventory);
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
    public Storedetail querykc(Inventory inventory) {

        return inventoryMapper.querykc(inventory);
    }
}
