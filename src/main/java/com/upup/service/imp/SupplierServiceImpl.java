package com.upup.service.imp;

import com.upup.base.util.JsonResponseBody;
import com.upup.mapper.SupplierMapper;
import com.upup.model.Supplier;
import com.upup.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return 0;
    }

    @Override
    public int insert(Supplier record) {
        return 0;
    }

    @Override
    public int insertSelective(Supplier record) {
        return 0;
    }

    @Override
    public Supplier selectByPrimaryKey(Integer uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Supplier record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Supplier record) {
        return 0;
    }

    @Override
    public JsonResponseBody<List<Supplier>> queryall() {
        List<Supplier> list = supplierMapper.queryall();
        return new JsonResponseBody<>(list);
    }
}
