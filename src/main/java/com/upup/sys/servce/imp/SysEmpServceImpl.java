package com.upup.sys.servce.imp;

import com.upup.sys.model.SysEmp;
import com.upup.sys.servce.ISysEmpServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysEmpServceImpl implements ISysEmpServce {

    @Autowired
    private ISysEmpServce iSysEmpServce;


    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return iSysEmpServce.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(SysEmp record) {
        return iSysEmpServce.insert(record);
    }

    @Override
    public int insertSelective(SysEmp record) {
        return iSysEmpServce.insertSelective(record);
    }

    @Override
    public SysEmp selectByPrimaryKey(Integer uuid) {
        return iSysEmpServce.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(SysEmp record) {
        return iSysEmpServce.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysEmp record) {
        return iSysEmpServce.updateByPrimaryKey(record);
    }

    @Override
    public SysEmp selectByName(String empName) {
        return iSysEmpServce.selectByName(empName);
    }
}
