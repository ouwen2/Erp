package com.upup.basics.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.basics.mapper.SupplierMapper;
import com.upup.basics.model.Supplier;
import com.upup.basics.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public int insert2(Supplier record) {
        return supplierMapper.insert(record);
    }

    @Override
    public Supplier selectByPrimaryKey(String supplier) {
        return supplierMapper.selectByPrimaryKey(supplier);
    }

    @Override
    public int updateByPrimaryKey(Supplier record) {
        return supplierMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Supplier> queryAllSupplier(Supplier supplier) {
        return supplierMapper.queryAllSupplier(supplier);
    }

    @Override
    public JsonResponseBody<?> querySupplierPage(Supplier supplier, PageBean pageBean) {
        List<Supplier> list = supplierMapper.querySupplierPage(supplier);
        return new JsonResponseBody<>(list,list.size());
    }

    @Override
    public JsonResponseBody<?> queryCustomerPage(Supplier supplier, PageBean pageBean) {
        List<Supplier> customer = supplierMapper.queryCustomerPage(supplier);
        return new JsonResponseBody<>(customer,customer.size());
    }


}
