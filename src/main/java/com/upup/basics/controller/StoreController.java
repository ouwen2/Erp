package com.upup.basics.controller;

import com.upup.base.exception.BusinessException;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.basics.model.Store;
import com.upup.basics.service.IStoreService;
import com.upup.sys.model.SysEmp;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Store")
public class StoreController {


    @Autowired
    public IStoreService storeService;

    //查询
    @RequiresPermissions(value ="Store/queryStoreAll")
    @RequestMapping("/queryStoreAll")
    @ResponseBody
    public Map<String,Object> queryStoreAll(Store store){
        List<Store> goodss = storeService.queryAllStore(store);

        return toJson("ok",true,goodss);
    }

    //管理员查询
    @RequestMapping("/querySysEmpAll")
    @ResponseBody
    public Map<String,Object> querySysEmpAll(SysEmp sysEmp){

        System.out.println(sysEmp.getName());
        List<Map<String, Object>> maps = storeService.queryAllSysEmp(sysEmp);

        return toJson("ok",true,maps);
    }

    //添加
    @RequiresPermissions(value ="Store/addStore")
    @RequestMapping("/addStore")
    @ResponseBody
    public Map<String,Object> addStore(Store store){
//        System.out.println("goods:"+supplier);
        storeService.insert(store);
        return toJson("新增仓库成功",true,null);
    }


    //删除
    @RequiresPermissions(value ="Store/delStore")
    @RequestMapping("/delStore")
    @ResponseBody
    public Map<String,Object> delStore(Store store){
        storeService.deleteByPrimaryKey(store.getUuid());
        return  toJson("删除仓库成功",true,null);
    }

    //修改
    @RequiresPermissions(value ="Store/updStore")
    @RequestMapping("/updStore")
    @ResponseBody
    public Map<String,Object> updStore(Store store){
        storeService.updateByPrimaryKey(store);
        return  toJson("修改仓库成功",true,null);
    }

    //仓库查询
    @RequiresPermissions(value ="Store/queryStorerPager")
    @RequestMapping("/queryStorerPager")
    @ResponseBody
    public JsonResponseBody queryStorerPage(Store store, HttpServletRequest req){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
        System.out.println(store);
//        try {
            return storeService.queryStorerPage(store, null);
//        } catch (Exception e) {
//            throw new BusinessException(ResponseStatus.STATUS_202);
//        }
    }


    private Map<String,Object> toJson(String msg,boolean flag,Object data){
        Map<String,Object> json=new HashMap<>();
        json.put("msg",msg);
        json.put("success",flag);
        json.put("data",data);
        return json;
    }
}
