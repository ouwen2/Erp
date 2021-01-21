package com.upup.sys.service;

import com.upup.sys.model.SysLog;

import java.util.List;
import java.util.Map;

public interface ISysLogService {
    int deleteByPrimaryKey(Integer uuid);

    //我用了这个
    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    List<Map<String,Object>> getListPage(SysLog sysLog);

}