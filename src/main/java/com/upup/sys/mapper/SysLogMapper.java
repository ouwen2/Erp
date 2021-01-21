package com.upup.sys.mapper;

import com.upup.sys.model.SysLog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysLogMapper {

    int deleteByPrimaryKey(Integer uuid);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    List<Map<String,Object>> getListPage(SysLog sysLog);

}