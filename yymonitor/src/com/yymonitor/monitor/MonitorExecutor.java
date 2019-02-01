package com.yymonitor.monitor;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月8日 上午10:20:10
 * @description TODO 执行器  从这里开始采集JVM数据
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
@Slf4j
public class MonitorExecutor {

	static {
		new MonitorExecutor().runMonitor();
	}
	
	
	
	/**
	 * @title runMonitor 
	 * @description 运行监控
	 * @author yy
	 * @date 2019年1月8日 上午10:26:56
	 * @return void
	 */
	public synchronized void runMonitor() {
		Thread yymonitorThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					
					while(true) {
						TimeUnit.SECONDS.sleep(10000);
						//采集数据
						
					}
				} catch (Exception e) {
					log.error("yymonitor采集数据出现错误",e);
				}
				
				
				
			}
		});
		
		yymonitorThread.setName("yymonitorExecutor");
		yymonitorThread.setDaemon(true);
		yymonitorThread.start();
	}
}
