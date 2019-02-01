package com.yymonitor.model;

import lombok.Data;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月8日 上午10:15:56
 * @description TODO 堆栈信息
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
@Data
public class MoniInfoStack extends MoniInfo {

private long[] monitorDeadlockedThreads;//正在等待其他线程释放锁的线程
private Long[] lockedThreads;//正在锁住对象的线程
private long historyMaxActiveThread;//最大活动线程数
private long currentTotalThread;//当前总线程数

}