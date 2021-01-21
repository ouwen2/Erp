package com.upup.sys.service;

import com.github.pagehelper.Page;
import com.upup.base.util.PageBean;
import com.upup.personnel.model.Dep;
import com.upup.sys.model.SysEmp;
import com.upup.sys.vo.SysEmpDate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ISysEmpServce {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysEmp record);

    /**
     * 新增员工
     * @param record
     * @return
     */
    int insertSelective(SysEmp record);

    SysEmp selectByPrimaryKey(Integer uuid);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysEmp record);

    /**
     * 伪删除
     * @param record Depuuid为0
     * @return
     */
    int updateByPrimaryKey(SysEmp record);

    /**
     * 分页模糊查询
     * @param sysEmpDate
     * @return
     */
    List<Map<String,Object>> selectByEmpPage(SysEmpDate sysEmpDate, PageBean pageBean);


    /**
     * 根据用户名查询
     * @param empName
     * @return
     */
    SysEmp selectByName(String empName);

    List<Map<String,Object>> getSysEmpByUserNamePage(SysEmp sysEmp, PageBean pageBean);

    int updatePassword(SysEmp sysEmp);

}