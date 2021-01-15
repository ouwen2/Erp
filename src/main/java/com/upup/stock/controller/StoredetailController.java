package com.upup.stock.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.model.Storedetail;
import com.upup.stock.service.IStoredetailService;
import com.upup.stock.service.IStoreoperService;
import com.upup.stock.vo.StoredetailVo;
import com.upup.stock.vo.StoreoperVo;
import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/storedetail")
public class StoredetailController {

    @Autowired
    private IStoreoperService storeoperService;

    @RequestMapping("/Pager")
    @ResponseBody
    public JsonResponseBody Pager(StoreoperVo storeoperVo, PageBean pageBean){
        List<Map<String, Object>> maps = storeoperService.queryStoredetailPager(storeoperVo, pageBean);
        String msg="查询失败";
            if(null!=msg){
                System.out.println("storeoperService："+maps);
                int total = pageBean.getTotal();
                return new JsonResponseBody(maps,total);
            }else{
                return new JsonResponseBody(ResponseStatus.STATUS_202);
            }
    }



}
