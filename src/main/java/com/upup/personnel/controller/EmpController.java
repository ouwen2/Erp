package com.upup.personnel.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.PasswordHelper;
import com.upup.base.util.ResponseStatus;
import com.upup.personnel.model.Dep;
import com.upup.personnel.service.IDepService;
import com.upup.sys.model.SysEmp;
import com.upup.sys.model.SysRole;
import com.upup.sys.servce.ISysEmpServce;
import com.upup.sys.vo.SysEmpDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Emp")
public class EmpController {

    @Autowired
    private ISysEmpServce iSysEmpServce;

    @Autowired
    private IDepService iDepService;

    @RequestMapping("/selectPage")
    @ResponseBody
    public JsonResponseBody selectPage(SysEmpDate sysEmpDate, HttpServletRequest request){
        System.out.println("sysEmpDate:"+sysEmpDate);
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        pageBean.setRows(5);
        System.out.println(sysEmpDate.toString());
        List<Map<String,Object>> sysEmps = iSysEmpServce.selectByEmpPage(sysEmpDate,pageBean );
        for(Map<String,Object> sysEmp:sysEmps) {
            if(sysEmp.get("gender")!=null)
            if(sysEmp.get("gender").equals(0)){
                sysEmp.put("gender","男");
            }else{
                sysEmp.put("gender","女");
            }
        }
        return new JsonResponseBody(ResponseStatus.STATUS_200,sysEmps);
    }

    @RequestMapping("/addEmp")
    @ResponseBody
    public JsonResponseBody addEmp(SysEmp sysEmp){
        String salt = PasswordHelper.createSalt();
        sysEmp.setSalt(salt);
        sysEmp.setPwd(PasswordHelper.createCredentials("88888888",salt));
        int insert =iSysEmpServce.insertSelective(sysEmp);
        if(insert==1){
            return new JsonResponseBody(ResponseStatus.STATUS_200,"添加成功");
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_201,"添加数据失败！");
        }
    }

    @RequestMapping("/updataEmp")
    @ResponseBody
    public JsonResponseBody updataEmp(SysEmp sysEmp){
        if(sysEmp.getUuid()==1){
            return new JsonResponseBody(ResponseStatus.UNKNOWN_ERROR, "不能修改超级管理员");
        }else {
            int i = iSysEmpServce.updateByPrimaryKeySelective(sysEmp);
            if (i == 1) {
                return new JsonResponseBody(ResponseStatus.STATUS_200, "修改成功");
            } else {
                return new JsonResponseBody(ResponseStatus.STATUS_201, "修改数据失败");
            }
        }
    }

    @RequestMapping("/deleteEmp")
    @ResponseBody
    public JsonResponseBody deleteEmp(SysEmp sysEmp){
        if(sysEmp.getUuid()==1){
            return new JsonResponseBody(ResponseStatus.UNKNOWN_ERROR, "不能干掉超级管理员哦");
        }else {
         int i = iSysEmpServce.updateByPrimaryKey(sysEmp);
            if (i == 1) {
                return new JsonResponseBody(ResponseStatus.STATUS_200, "删除成功");
            } else {
                return new JsonResponseBody(ResponseStatus.STATUS_203, "删除数据失败！");
            }
        }
    }

    @RequestMapping("/selectxia")
    @ResponseBody
    public JsonResponseBody selectxia(){
        List<Dep> deps = iDepService.selectByUUid();
        return new JsonResponseBody(ResponseStatus.STATUS_200, deps);
    }
}
