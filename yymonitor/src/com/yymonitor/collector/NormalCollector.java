package com.yymonitor.collector;

import com.alibaba.fastjson.JSONObject;
import com.yymonitor.model.MoniInfo;
import com.yymonitor.model.MoniInfoMemery;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月8日 上午10:38:01
 * @description TODO 基本信息 收集
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
public class NormalCollector {

	private static NormalCollector collector = new NormalCollector();
	
	private NormalCollector() {}
	
	public static NormalCollector getInstance() {
		return collector;
	}
	/**
	 * @title collectCPU 
	 * @description 收集CPU信息
	 * @author yy
	 * @date 2019年1月8日 上午10:39:22
	 * @return
	 * @return MoniInfo
	 */
	public MoniInfo collectCPU() {
		
		
		System.out.println(JSONObject.toJSONString(System.getenv()));
		return null;
	}
	
	/**
	 * @title collectMemery 
	 * @description 收集内存信息
	 * @author yy
	 * @date 2019年1月8日 上午10:56:31
	 * @return
	 * @return MoniInfo
	 */
	public MoniInfo collectMemery() {
		MoniInfoMemery moniInfo = new MoniInfoMemery();
		moniInfo.setTime(System.currentTimeMillis());
		moniInfo.setFreeMemery(Runtime.getRuntime().freeMemory());
		moniInfo.setMaxMemery(Runtime.getRuntime().maxMemory());
		moniInfo.setTotalMemery(Runtime.getRuntime().totalMemory());
		moniInfo.setUsedMemery(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());
		return moniInfo;
	}
	
	public static void main(String[] args) {
		
		MoniInfo m = new NormalCollector().collectMemery();
		System.out.println(JSONObject.toJSONString(m));
	}
}
