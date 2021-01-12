package com.upup.base.util;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.xml.ws.Response;

/**
 * 响应封装类
 * 参考：https://blog.csdn.net/StillTogether/article/details/81587627
 * @param <T>
 */
//@ApiModel(value="响应包装类")
@Data
public class JsonResponseBody<T> implements Serializable{

	private static final long serialVersionUID = 3082964332329706609L;
	
	//@ApiModelProperty(value="状态码",name="status")
	private int status;
	//@ApiModelProperty(value="数据对象",name="data")
	private T data;
	//@ApiModelProperty(value="总记录数",name="total")
	private int total;
	//@ApiModelProperty(value="消息",name="msg")
	private String msg = "OK";

	public JsonResponseBody(T data) {
		this.status=ResponseStatus.STATUS_200.getStatus();
		this.data=data;
	}

	public JsonResponseBody(T data,int total){
		this.status= ResponseStatus.STATUS_200.getStatus();
		this.data=data;
		this.total=total;
	}

	public JsonResponseBody(ResponseStatus status) {
		this.status=status.getStatus();
		this.msg=status.getMsg();
	}
	
	public JsonResponseBody(ResponseStatus status, T data) {
		this.data=data;
		this.status=status.getStatus();
		this.msg=status.getMsg();
	}
	
	public JsonResponseBody(ResponseStatus status,String msg) {
		this.msg=msg;
		this.status=status.getStatus();
	}
	
	public JsonResponseBody(int status,String msg) {
		this.msg=msg;
		this.status=status;
	}
	
	public JsonResponseBody(ResponseStatus status, T data ,String msg) {
		this.data=data;
		this.status=status.getStatus();
		this.msg=msg;
	}

	public JsonResponseBody() {
		this.data = null;
		this.status = ResponseStatus.STATUS_200.getStatus();
	}
}