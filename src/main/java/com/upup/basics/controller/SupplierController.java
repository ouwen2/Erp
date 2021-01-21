package com.upup.basics.controller;

import com.upup.base.exception.BusinessException;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.basics.model.Supplier;
import com.upup.basics.service.ISupplierService;
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
@RequestMapping("Supplier")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;



    //查询
    @RequiresPermissions(value ="Supplier/querySupplierAll")
    @RequestMapping("/querySupplierAll")
    @ResponseBody
    public Map<String,Object> querySupplierAll(Supplier supplier){
        List<Supplier> list = supplierService.queryAllSupplier(supplier);


        return toJson("ok",true,list);
    }

    //添加供应商
    @RequiresPermissions(value ="Supplier/addSupplier")
    @RequestMapping("/addSupplier")
    @ResponseBody
    public int insert(Supplier supplier){

        System.out.println(supplier);
//        try {
            supplier.setType("0");
            return supplierService.insert(supplier);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new BusinessException(ResponseStatus.STATUS_201);
//        }
    }

    //添加客户
    @RequiresPermissions(value ="Supplier/addSupplier2")
    @RequestMapping("/addSupplier2")
    @ResponseBody
    public int insert2(Supplier supplier){

        System.out.println(supplier);
//        try {
            supplier.setType("1");
            return supplierService.insert2(supplier);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new BusinessException(ResponseStatus.STATUS_201);
//        }
    }



    //删除
    @RequiresPermissions(value ="Supplier/delSupplier")
    @RequestMapping("/delSupplier")
    @ResponseBody
    public Map<String,Object> delSupplier(Supplier supplier){
        supplierService.deleteByPrimaryKey(supplier.getUuid());
        return toJson("删除供应商成功",true,null);
    }

    //修改
    @RequiresPermissions(value ="Supplier/updSupplier")
    @RequestMapping("/updSupplier")
    @ResponseBody
    public Map<String,Object> updSupplier(Supplier supplier){

        supplierService.updateByPrimaryKey(supplier);
        return toJson("修改供应商成功",true,null);
    }


    /**
     * 分页查询供应商
     * @param supplier
     * @param req
     * @return
     */
    @RequiresPermissions(value ="Supplier/querySupplierPage")
    @RequestMapping("/querySupplierPage")
    @ResponseBody
    public JsonResponseBody querySupplierPage(Supplier supplier, HttpServletRequest req){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
//        try{
            return new JsonResponseBody(supplierService.querySupplierPage(supplier,null));
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new BusinessException(ResponseStatus.STATUS_209);
//        }
    }

    /**
     * 分页查询客户
     * @param supplier
     * @return
     */
    @RequiresPermissions(value ="Supplier/queryCustomerPager")
    @RequestMapping("/queryCustomerPager")
    @ResponseBody
    public JsonResponseBody queryCustomerPager(Supplier supplier, HttpServletRequest req){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
//        try {
            return supplierService.queryCustomerPage(supplier, null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new BusinessException(ResponseStatus.STATUS_209);
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
