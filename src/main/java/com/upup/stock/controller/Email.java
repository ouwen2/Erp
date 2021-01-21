package com.upup.stock.controller;

import com.upup.base.util.PageBean;
import com.upup.stock.model.Storedetail;
import com.upup.stock.service.IStoredetailService;
import com.upup.stock.service.IStoreoperService;
import com.upup.stock.vo.StoredetailVo;
import com.upup.stock.vo.StoreoperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/19.
 */
@Controller  //声明为控制器
@RequestMapping("/testemail")
public class Email {
    @Resource(name = "mailSender")
    JavaMailSenderImpl mailSender;

    @Autowired
    private IStoredetailService storedetailService;

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

    @RequestMapping(path = "/sendhtml")
    public void handle1() {
        MimeMessage mimeMsg = mailSender.createMimeMessage();
        try {
            String html = "<html><head>" +
                    "</head><body>" +
                    "<h1>Hello,this is first html!</h1>" +
                    "<span style='color:red;font-size:36px;'>hello</span>" +
                    "<img src='https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526734280537&di=0f7ac79302207a66fe4db36162486167&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201510%2F07%2F20151007101227_jkevU.jpeg'>" +
                    "</body></html>";
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
            helper.setTo("");
            helper.setFrom("2782587567@qq.com");//一定要写，501 mail from address must be same as authorization user的错误
            helper.setSubject("3142251263@qq.com");
            helper.setText(html, true);
            System.out.println("奈斯亚"+mimeMsg);
            mailSender.send(mimeMsg);
        } catch (Exception e) {
        }


    }
}
