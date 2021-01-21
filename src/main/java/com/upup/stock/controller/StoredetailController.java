package com.upup.stock.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.basics.model.Store;
import com.upup.sale.model.Goods;
import com.upup.stock.service.IStoredetailService;
import com.upup.stock.vo.StoredetailVo;
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
    private IStoredetailService storedetailService;







    @RequestMapping("/Page")
    @ResponseBody
    public JsonResponseBody Page(StoredetailVo storeoperVo, PageBean pageBean){
        List<Map<String, Object>> maps = storedetailService.queryStoredetailPage(storeoperVo,pageBean);
        String msg="查询失败";
            if(null!=msg){
                int total = pageBean.getTotal();
                return new JsonResponseBody(maps,total);
            }else{
                return new JsonResponseBody(ResponseStatus.STATUS_202);
            }
    }


    /**
     * 查询仓库字段
     * @param
     * @return
     */
    @RequestMapping("/Store")
    @ResponseBody
    public JsonResponseBody Store(){
        List<Store> stores = storedetailService.selectStores();
        String msg="查询";
        if(null!=msg){
            return new JsonResponseBody(stores);
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_202);
        }
    }

    /**
     * 查询商品字段
     * @param
     * @return
     */
    @RequestMapping("/Goods")
    @ResponseBody
    public JsonResponseBody Goods(){
        List<Goods> goods = storedetailService.selectGoods();
        String msg="查询";
        if(null!=msg){
            return new JsonResponseBody(goods);
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_202);
        }
    }

    @RequestMapping("/xlkck")
    @ResponseBody
    public JsonResponseBody xlkck(Integer goodsuuid){
        String xlkck = storedetailService.xlkck(goodsuuid);
        System.out.println(goodsuuid);
        String msg="查询";
        if(null!=msg){
            return new JsonResponseBody(xlkck);
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_202);
        }
    }


    @RequestMapping("/yjPage")
    @ResponseBody
    public JsonResponseBody yjPage(StoredetailVo storeoperVo, PageBean pageBean){
        List<Map<String, Object>> maps = storedetailService.queryYjPage(storeoperVo, pageBean);
        String msg="查询失败";
        if(null!=msg){
            int total = pageBean.getTotal();
            return new JsonResponseBody(maps,total);
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_202);
        }
    }






}
