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
        int i = depMapper.selectByDepName(record.getName());
        int i1=0;
        if(i==1) {
            i1 = depMapper.insertSelective(record);
        }
        return i1;
    }

    @Override
    public int updateByPrimaryKeySelective(Dep record) {
        return depMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int selectByDepName(String name) {
        return depMapper.selectByDepName(name);
    }


    @Override
    public List<Dep> selectByPager(Dep dep, PageBean pageBean) {
        return depMapper.selectByPager(dep);
    }
}
