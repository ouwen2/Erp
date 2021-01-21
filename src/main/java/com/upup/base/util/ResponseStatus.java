package com.upup.base.util;

/**
 * 用于数据接口返回的状态码枚举
 */
public enum ResponseStatus {

    STATUS_200(200,"OK"),
    STATUS_201(201,"保存数据失败！"),
    STATUS_202(202,"查无数据！"),
    STATUS_203(203,"删除数据失败！"),
    STATUS_204(204,"查询数据失败！"),
    STATUS_205(205,"登录身份过期，请重新登录！"),
    STATUS_206(206,"Token令牌失效或已过期！"),
    STATUS_207(207,"权限不足，当前请求无效！"),
    STATUS_208(208,"盈利盈亏登记成功"),
    STATUS_209(209,"库存预警成功"),
    UNKNOWN_ERROR(999, "未知错误")
    ;

    private Integer status;
    private String msg;

    ResponseStatus(Integer status, String msg) {
        this.status=status;
        this.msg=msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
