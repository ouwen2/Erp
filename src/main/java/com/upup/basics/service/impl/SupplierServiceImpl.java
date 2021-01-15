package com.upup.basics.service.impl;

import com.upup.base.util.PageBean;
import com.upup.basics.mapper.SupplierMapper;
import com.upup.basics.model.Supplier;
import com.upup.basics.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    public SupplierMapper supplierMapper;



    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return supplierMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(Supplier record) {
        return supplierMapper.insert(record);
    }

    @Override
    public int insertSelective(Supplier record) {
        return 0;
    }

    @Override
    public Supplier selectByPrimaryKey(Integer uuid) {
        return supplierMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Supplier record) {
        return supplierMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Supplier record) {
        return 0;
    }

    @Override
    public List<Supplier> queryAllSupplier(Supplier supplier) {
        return supplierMapper.queryAllSupplier(supplier);
    }

    @Override
    public List<Supplier> querySupplierPager(Supplier supplier, PageBean pageBean) {
        return supplierMapper.querySupplierPager(supplier);
    }

}
