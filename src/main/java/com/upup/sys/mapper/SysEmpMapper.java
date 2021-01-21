package com.upup.sys.mapper;

import com.upup.sys.model.SysEmp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface SysEmpMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysEmp record);

    int insertSelective(SysEmp record);

    SysEmp selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysEmp record);

    int updateByPrimaryKey(SysEmp record);

    SysEmp selectByName(String empName);

    /**
     *     根据username查询该用户的所有角色，用于角色验证
     */
    Set<String> findRoles(String username);

    /**
     *     根据username查询他所拥有的权限信息，用于权限判断
     */
    Set<String> findPermissions(String username);

    List<Map<String,Object>> getSysEmpByUserNamePage(SysEmp sysEmp);

    int updatePassword(SysEmp sysEmp);
}