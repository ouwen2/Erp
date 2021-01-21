package com.upup.sys.mapper;

import com.upup.personnel.model.Dep;
import com.upup.sys.model.SysEmp;
import com.upup.sys.vo.SysEmpDate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface SysEmpMapper {
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
    List<Map<String,Object>> selectByEmpPage(SysEmpDate sysEmpDate);

    /**
     * 根据用户名查询
     * @param empName
     * @return
     */
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