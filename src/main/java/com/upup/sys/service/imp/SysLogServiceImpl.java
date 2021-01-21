package com.upup.sys.service.imp;

import com.upup.sys.mapper.SysLogMapper;
import com.upup.sys.model.SysLog;
import com.upup.sys.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return 0;
    }

    @Override
    public SysLog selectByPrimaryKey(Integer uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(SysLog record) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> getListPage(SysLog sysLog) {
        return sysLogMapper.getListPage(sysLog);
    }

    @Override
    public int updateByPrimaryKeySelective(SysLog record) {
        return 0;
    }

    @Override
    public int insertSelective(SysLog record) {
        return 0;
    }

    @Override
    public int insert(SysLog record) {
        return sysLogMapper.insert(record);
    }
}
