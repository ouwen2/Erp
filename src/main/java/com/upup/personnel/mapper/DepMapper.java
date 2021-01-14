package com.upup.personnel.mapper;

import com.upup.personnel.model.Dep;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Repository
public interface DepMapper {
    /**
     * 删除
     * @param uuid 编号
     * @return
     */
    int deleteByPrimaryKey(Integer uuid);

    int insert(Dep record);

    /**
     * 新增部门
     * @param record
     * @return
     */
    int insertSelective(Dep record);

    Dep selectByPrimaryKey(Integer uuid);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dep record);

    /**
     * 修改管理员组的电话
     * @param record
     * @return
     */
    int updateByPrimaryKey(Dep record);

    /**
     * 模糊查询部门名称是否唯一，最左侧
     * @param name 要查询的部门名称
     * @return
     */
    Dep selectByDepName(String name);

    /**
     * 模糊查询
     * @param name 名称
     * @param tele 电话
     * @return
     */
    List<Dep> selectByPager(Dep dep);
}