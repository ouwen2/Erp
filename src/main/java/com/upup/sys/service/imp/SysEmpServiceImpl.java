package com.upup.sys.service.imp;

import com.upup.base.util.PageBean;
import com.upup.personnel.model.Dep;
import com.upup.sys.mapper.SysEmpMapper;
import com.upup.sys.model.SysEmp;
import com.upup.sys.vo.SysEmpDate;
import com.upup.sys.service.ISysEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysEmpServiceImpl implements ISysEmpService {

    @Autowired
    private SysEmpMapper SysEmpMapper;


    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return SysEmpMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(SysEmp record) {
        return SysEmpMapper.insert(record);
    }

    @Override
    public int insertSelective(SysEmp record) {
        int i=0;
        if(SysEmpMapper.selectByName(record.getUsername())==null){
            i=SysEmpMapper.insertSelective(record);
        }
        return i;
    }

    @Override
    public SysEmp selectByPrimaryKey(Integer uuid) {
        return SysEmpMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(SysEmp record) {
        return SysEmpMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysEmp record) {
        return SysEmpMapper.updateByPrimaryKey(record);
    }

    @Override
    public  List<Map<String,Object>> selectByEmpPage(SysEmpDate sysEmpDate, PageBean pageBean) {
        return SysEmpMapper.selectByEmpPage(sysEmpDate);
    }

    @Override
    public SysEmp selectByName(String empName) {
        return SysEmpMapper.selectByName(empName);
    }

    @Override
    public List<Map<String,Object>> getSysEmpByUserNamePage(SysEmp sysEmp, PageBean pageBean) {
        if(sysEmp.getUsername()==null)
            sysEmp.setUsername("");
        return SysEmpMapper.getSysEmpByUserNamePage(sysEmp);
    }

    @Override
    public int updatePassword(SysEmp sysEmp) {
        return SysEmpMapper.updatePassword(sysEmp);
    }


}
