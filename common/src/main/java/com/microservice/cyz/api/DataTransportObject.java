package com.microservice.cyz.api;

/**
 * web层数据传输对象的抽象接口
 */
public interface DataTransportObject {

	void setTid(String tid);

	String getRetMsg();

	String getRetCode();

	void setRetMsg(String msg);

	void setRetCode(String code);
}
