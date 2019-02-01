package com.yymonitor.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月31日 下午3:33:10
 * @description TODO 数学相关运算
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
public class MathCUtil {

	/**
	 * @title diff 
	 * @description 求两个数组的差集 ，以total 为准
	 * @author yy
	 * @date 2019年1月31日 下午5:58:56
	 * @param total
	 * @param some
	 * @return
	 * @return List<Long>
	 */
	public static Long[] diff(long[] total,long[] some) {
		List<Long> list =new ArrayList();
		boolean isTouch=false;
		for (int i = 0; i < total.length; i++) {
			isTouch=false;
			for (int j = 0; j < some.length; i++) {
				if(some[j]!=0 && total[i]==some[i]) {//碰撞
					some[j]=0;
					isTouch=true;
					break;
				}
			}
			if(!isTouch)
				list.add(total[i]);
		}
		Long[] rl= new Long[list.size()];
		list.toArray(rl);
		return rl;
		
	}
}
