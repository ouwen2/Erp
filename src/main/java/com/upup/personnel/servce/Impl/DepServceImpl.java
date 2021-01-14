package com.upup.personnel.servce.Impl;

import com.upup.base.util.PageBean;
import com.upup.personnel.mapper.DepMapper;
import com.upup.personnel.model.Dep;
import com.upup.personnel.servce.IDepServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepServceImpl implements IDepServce {

    @Autowired
    private DepMapper depMapper;

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return depMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insertSelective(Dep record) {
        int i = 0;
        System.out.println(record.toString());
        if (depMapper.selectByDepName(record.getName()) == null) {
            i = depMapper.insertSelective(record);
        }
        return i;
    }

    @Override
    public int updateByPrimaryKeySelective(Dep record) {
        int i = 0;
        if (depMapper.selectByDepName(record.getName()) == null) {
            i = depMapper.updateByPrimaryKeySelective(record);
        }
        return i;
    }


    @Override
    public Dep selectByDepName(String name) {
        return depMapper.selectByDepName(name);
    }


    @Override
    public List<Dep> selectByPager(Dep dep, PageBean pageBean) {
        return depMapper.selectByPager(dep);
    }
}
