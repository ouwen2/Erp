package com.upup.sys.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.sys.model.SysRole;
import com.upup.sys.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("SysRole")
public class SysRoleController {
    @Autowired
    private ISysRoleService iSysRoleServce;

    @RequestMapping("/getListPage")
    @ResponseBody
    public JsonResponseBody getListPage(SysRole sysRole, HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        System.out.println("sysRole:"+sysRole);
        List<SysRole> sysRoleByRoleNamePage = iSysRoleServce.getSysRoleByRoleNamePage(sysRole, pageBean);

        return new JsonResponseBody(ResponseStatus.STATUS_200,sysRoleByRoleNamePage);
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public JsonResponseBody addRole(SysRole sysRole){
        int insert = iSysRoleServce.insert(sysRole);
        if(insert==1){
            return new JsonResponseBody(ResponseStatus.STATUS_200,"添加成功");
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_201,"添加角色失败");
        }
    }

    @RequestMapping("/updataRole")
    @ResponseBody
    public JsonResponseBody updataRole(SysRole sysRole){
        int i = iSysRoleServce.updateByPrimaryKey(sysRole);
        if(i==1){
            return new JsonResponseBody(ResponseStatus.STATUS_200,"修改成功");
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_201,"修改角色失败");
        }
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public JsonResponseBody deleteRole(SysRole sysRole){
        int i = iSysRoleServce.deleteByPrimaryKey(sysRole.getUuid());
        if(i==1){
            return new JsonResponseBody(ResponseStatus.STATUS_200,"删除成功");
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_203,"删除失败");
        }
    }
}
