package com.upup.personnel.servce;

import com.upup.base.util.PageBean;
import com.upup.personnel.model.Dep;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional
public interface IDepServce {
    /**
     * 删除
     * @param uuid 编号
     * @return
     */
    int deleteByPrimaryKey(Integer uuid);

    /**
     * 新增部门
     * @param record
     * @return
     */
    int insertSelective(Dep record);

    /**
     * 修改
     * @param record 
     * @return
     */
    int updateByPrimaryKeySelective(Dep record);

    /**
     * 模糊查询部门名称是否唯一，最左侧
     * @param name 要查询的部门名称
     * @return
     */
    int selectByDepName(String name);

    /**
     * 模糊查询
     * @param name 名称
     * @param tele 电话
     * @return
     */
    List<Dep> selectByPager(Dep dep, PageBean pageBean);
}