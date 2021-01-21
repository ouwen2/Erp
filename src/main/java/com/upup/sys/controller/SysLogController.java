package com.upup.sys.controller;

import com.upup.base.controller.BaseController;
import com.upup.base.util.GetDateUtil;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.sys.model.SysLog;
import com.upup.sys.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("SysLog")
public class SysLogController extends BaseController {

    @Autowired
    private ISysLogService iSysLogService;


    @RequestMapping("getListPage")
    @ResponseBody
    public JsonResponseBody getListPage(HttpServletRequest request) {
//        PageBean pageBean = new PageBean();
//        pageBean.setRequest(request);
        SysLog sysLog = new SysLog();

        List<Map<String, Object>> listPage = iSysLogService.getListPage(sysLog);

        for (Map<String, Object> map : listPage) {
            String logDateStr = map.get("log_date").toString();
            String logDateStr2 = logDateStr.substring(0,logDateStr.lastIndexOf("."));
            map.put("log_date",logDateStr2);
        }

        return new JsonResponseBody(ResponseStatus.STATUS_200, listPage);
    }


}
