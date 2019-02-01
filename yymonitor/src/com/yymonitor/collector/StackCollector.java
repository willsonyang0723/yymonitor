package com.yymonitor.collector;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import com.yymonitor.common.MathCUtil;
import com.yymonitor.model.MoniInfoStack;

public class StackCollector {
	private static StackCollector collector = new StackCollector();
	
	private StackCollector() {}
	
	public static StackCollector getInstance() {
		return collector;
	}
	
	public void collectThreads() {
		MoniInfoStack stack = new MoniInfoStack();
		ThreadMXBean  threadMXBean = ManagementFactory.getThreadMXBean();
		stack.setMonitorDeadlockedThreads(threadMXBean.findMonitorDeadlockedThreads());//正在等待其他线程释放的
		long[] lockedThreads=threadMXBean.findDeadlockedThreads();//正在等待其他线程释放的+锁住对象的
		//取差集
		stack.setLockedThreads(MathCUtil.diff(lockedThreads, threadMXBean.findMonitorDeadlockedThreads()));
		stack.setHistoryMaxActiveThread(threadMXBean.getPeakThreadCount());//返回自从 Java 虚拟机启动或峰值重置以来峰值活动线程计数
		stack.setCurrentTotalThread(threadMXBean.getThreadCount());//当前总线程数
		
		
	}
}
