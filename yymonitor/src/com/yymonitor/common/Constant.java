package com.yymonitor.common;

import java.util.concurrent.ConcurrentLinkedDeque;

import com.yymonitor.model.MoniInfo;

public class Constant {

	/**存储监控信息队列
	 * @author yy
	 * @date 2019年1月7日 下午5:46:45
	 */
	public final static ConcurrentLinkedDeque<MoniInfo> DATA = new ConcurrentLinkedDeque<>();
}
