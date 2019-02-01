package com.yymonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月8日 上午11:00:44
 * @description TODO GC信息 收集
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoniInfoGC extends MoniInfo {

	private double YGC;//yanggc次数
	private double YGCT;//yangGC时间 s
	private double FGC;//oldgc次数
	private double FGCT;//oldgc时间 s
	
}
