package com.upup.stock.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;
import com.upup.stock.service.IInventoryService;
import com.upup.stock.service.IStoredetailService;
import com.upup.stock.service.IStoreoperService;
import com.upup.stock.vo.InventoryVo;
import com.upup.stock.vo.StoredetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Inventory")
public class InventoryController {

    @Resource(name = "mailSender")
    JavaMailSenderImpl mailSender;

    @Autowired
    private IInventoryService iInventoryService;

    @Autowired
    private IStoredetailService storedetailService;

    @Autowired
    private IStoreoperService storeoperService;



    @ResponseBody
    @RequestMapping("/Page")
    public JsonResponseBody Page(InventoryVo inventoryVo,PageBean pageBean){
        System.out.println("11111111111111111111111111111111");
        System.out.println(inventoryVo.getMin());
        System.out.println(inventoryVo.getMax());
        List<Map<String, Object>> maps = iInventoryService.queryInventoryPage(inventoryVo, pageBean);
        String msg="查询";
        if(msg!=null){
            int total = pageBean.getTotal();
           return new JsonResponseBody(maps,total);
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_202);
        }
    }

    @ResponseBody
    @RequestMapping("/ShPage")
    public JsonResponseBody ShPage(Inventory inventory, PageBean pageBean){
        System.out.println(inventory.getStoreuuid());
        System.out.println(inventory.getGoodsuuid());
        System.out.println(inventory.getState());
        List<Map<String, Object>> maps = iInventoryService.queryInventoryshPage(inventory, pageBean);
        String msg="查询";
        if(msg!=null){
            int total = pageBean.getTotal();
            return new JsonResponseBody(maps,total);
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_202);
        }
    }


//    @RequestMapping("/Add")
//    public void Add(Inventory inventory){
//        inventory.setState("1");
//        inventory.setCreater(2);
//        inventory.setCreatetime(new Date());
//        int insert = iInventoryService.insert(inventory);
//    }


    @RequestMapping("/Add")
    @ResponseBody
    public JsonResponseBody Add(Inventory inventory){
        inventory.setState("1");
        inventory.setCreater(2);
        inventory.setCreatetime(new Date());
        Integer storeuuid = iInventoryService.getList(inventory.getStoreuuid());
        inventory.setStoreuuid(storeuuid+"");
        System.out.println(inventory);
        int insert = iInventoryService.insert(inventory);

        return new JsonResponseBody(ResponseStatus.STATUS_208);
    }

    @RequestMapping("/Update")
    @ResponseBody
    public JsonResponseBody Update(Inventory inventory){

        iInventoryService.updateSP(inventory);

        return new JsonResponseBody(ResponseStatus.STATUS_209);
    }


    @RequestMapping("/sendword")
    public void handle(StoredetailVo storedetail, PageBean pageBean) {
        List<Map<String, Object>> maps = storedetailService.queryYjPage(storedetail, pageBean);

        String name="";
        String sum="";
        String num="";

        String str2 = "\n";
        for (Map<String, Object> s:maps) {
            String str = "";
            str += "商品名：";
            str+=s.get("GOODSUUID");
            str+=",";

            str+="库存数量为：";
            str+=s.get("sum");
            str+=",";

            str+="代发货数量为:";
            str+=s.get("NUM");
            str+="。"+"\n";

            str2 += str;
        }
        System.out.println("nameeeeeeeeeeeeeeeeeee"+name);
        System.out.println("summmmmmmmmmmmmmmmmmmm"+sum);
        System.out.println("nummmmmmmmmmmmmmmmmmmm"+num);

        System.out.println("1111111111111"+maps);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("3142251263@qq.com");
        mailMessage.setFrom("2782587567@qq.com");//一定要写，501 mail from address must be same as authorization user的错误
        mailMessage.setSubject("库存预警");
        mailMessage.setText("库存告急:"+str2);
        mailSender.send(mailMessage);
    }





    }
