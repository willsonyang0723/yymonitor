package com.yymonitor.output;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.yymonitor.common.Constant;
import com.yymonitor.model.MoniInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月7日 下午5:48:10
 * @description TODO 处理监控信息
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
public abstract class OutPut {
	
	static {
		ExecutorService es  = Executors.newFixedThreadPool(10);
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				OutPut output =new OutPutLog();
				output.doOutput(Constant.DATA.getFirst());
			}
		});
		
		
	}

	
	private void doMoniInfo(MoniInfo ...info) {
		try {
			doOutput(info);
		}catch (Exception e) {
			doException(e,info);
		}
	}
	/**
	 * @title dooutput 
	 * @description 处理监控信息
	 * @author yy
	 * @date 2019年1月7日 下午5:48:37
	 * @return void
	 */
	public abstract void doOutput(MoniInfo ...info);
	
	/**
	 * @title doException 
	 * @description 处理异常情况
	 * @author yy
	 * @date 2019年1月7日 下午5:49:34
	 * @return void
	 */
	public abstract void doException(Exception e,MoniInfo...infos);
	
	
}
