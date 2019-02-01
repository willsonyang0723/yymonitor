package com.yymonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月8日 上午10:14:48
 * @description TODO 内存信息
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoniInfoMemery extends MoniInfo {

	private long freeMemery;//空闲内存
	
	private long usedMemery;//已使用内存
	
	private long totalMemery;//总内存
	
	private long maxMemery;//最大内存
	
	
}
