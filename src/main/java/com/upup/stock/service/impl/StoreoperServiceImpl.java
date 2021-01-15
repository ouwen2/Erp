package com.upup.stock.service.impl;

import com.upup.base.util.PageBean;
import com.upup.stock.mapper.StoreoperMapper;
import com.upup.stock.service.IStoreoperService;
import com.upup.stock.vo.StoreoperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreoperServiceImpl implements IStoreoperService {

    @Autowired
    private StoreoperMapper storeoperMapper;

    @Override
    public List<Map<String, Object>> queryStoredetailPager(StoreoperVo storeoperVo, PageBean pageBean) {

        if(storeoperVo.getSysEmpUuid()==null){
            storeoperVo.setSysEmpUuid("");
        }
        if(storeoperVo.getStoreName()==null){
            storeoperVo.setStoreName("");
        }
        if(storeoperVo.getGoodsName()==null){
            storeoperVo.setGoodsName("");
        }
        System.out.println(storeoperVo);

        return storeoperMapper.queryStoredetailPager(storeoperVo);
    }
}
