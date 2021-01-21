package com.upup.stock.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.stock.service.IStoreoperService;
import com.upup.stock.vo.StoreoperVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Storeoper")
public class StoreoperController {

    @Autowired
    private IStoreoperService storeoperService;

    @RequiresPermissions(value = "Storeoper/Page")
    @RequestMapping("/Page")
    @ResponseBody
    public List<Map<String, Object>> Page(StoreoperVo storeoperVo, PageBean pageBean){


            List<Map<String, Object>> maps = storeoperService.queryStoredetailPage(storeoperVo, pageBean);
            String msg="查询失败";
               System.out.println("storeoperService:"+maps);
        //        if(msg!=null){
    //            int total = pageBean.getTotal();
    //            return new JsonResponseBody(maps,total);
    //        }else{
    //            return new JsonResponseBody(ResponseStatus.STATUS_202);
    //        }
            return maps;
    }


}
