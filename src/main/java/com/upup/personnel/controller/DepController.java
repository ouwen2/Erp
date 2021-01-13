package com.upup.personnel.controller;

import com.upup.base.controller.BaseController;
import com.upup.base.util.JsonUtil;
import com.upup.base.util.PageBean;
import com.upup.personnel.model.Dep;
import com.upup.personnel.servce.IDepServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class DepController {
    @Autowired
    private IDepServce iDepServce;

    @RequestMapping("/AddDep")
    @ResponseBody
    public List<Dep> AddDep(@RequestParam(required = true) Dep dep){
        /*int i = iDepServce.insertSelective(Dep.builder().build());*/

        return null;
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Dep> select(@RequestParam(value = "name",required = true)String name,@RequestParam(value = "tele",required = true)String tele){
        PageBean pageBean=new PageBean();
        List<Dep> deps = iDepServce.selectByPager(name, tele, pageBean);
        /*JsonUtil jsonUtil=new JsonUtil();
        String json = jsonUtil.toJsonString(deps);*/
        return deps;
    }

}
