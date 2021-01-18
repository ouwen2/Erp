package com.upup.personnel.controller;

import com.upup.base.aop.PageAop;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.personnel.model.Dep;
import com.upup.personnel.service.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("Per")
public class DepController {
    @Autowired
    private IDepService iDepService;

    @RequestMapping("/AddDep")
    @ResponseBody
    public JsonResponseBody AddDep(Dep dep){
        ModelAndView mv=new ModelAndView();
        String msg = "";
        int total=0;
        if(iDepService.insertSelective(dep)!=0){
            msg = "OK";
            total=1;
        }else {
            msg = "保存数据失败！";
            total=0;
        }
        return new JsonResponseBody(ResponseStatus.STATUS_200,total,msg);
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Dep> select(Dep dep){
        PageBean pageBean=new PageBean();
        List<Dep> deps = iDepService.selectByPage(dep, pageBean);
        /*JsonUtil jsonUtil=new JsonUtil();
        String json = jsonUtil.toJsonString(deps);*/
        return deps;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResponseBody delete(Integer uuid){
        String msg = "";
        int total=0;
        if(iDepService.deleteByPrimaryKey(uuid)!=0){
            msg = "OK";
            total=1;
        }else if(uuid==1) {
            msg = "不能干掉管理员组哦";
            total=0;
        }else {
            msg = "删除数据失败！";
            total=0;
        }
        return new JsonResponseBody(ResponseStatus.STATUS_200,total,msg);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResponseBody update(Dep dep){
        System.out.println(dep.toString());
        String msg = "";
        int total=0;
        if(iDepService.updateByPrimaryKeySelective(dep)!=0){
            msg = "OK";
            total=1;
        }else if(dep.getUuid()==1) {
            msg = "不能修改管理员组哦";
            total=0;
        }else {
            msg = "修改数据失败！";
            total=0;
        }
        return new JsonResponseBody(ResponseStatus.STATUS_200,total,msg);
    }

}
