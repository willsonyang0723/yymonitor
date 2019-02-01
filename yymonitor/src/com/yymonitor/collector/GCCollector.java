package com.yymonitor.collector;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.yymonitor.common.SystemUtil;
import com.yymonitor.model.MoniInfo;
import com.yymonitor.model.MoniInfoGC;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月8日 上午10:59:51
 * @description TODO GC信息收集
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
public class GCCollector {
	
	private static GCCollector gcCollector = new GCCollector();
	
	private GCCollector() {}
	
	public static GCCollector getInstance() {
		return gcCollector;
	}

	
	public MoniInfo collectGCInfo() throws IOException {
		
		MoniInfoGC gc = new MoniInfoGC();
		gc.setTime(System.currentTimeMillis());
		
		Process process=Runtime.getRuntime().exec("jstat -gc "+SystemUtil.getJVMThreadId());
//		BufferedReader reader= new BufferedReader();
		InputStream input = process.getInputStream();

		StringBuffer out = new StringBuffer();
		     byte[] b = new byte[4096];
		     for (int n; (n = input.read(b)) != -1;) {
		          out.append(new String(b, 0, n));
		     }
		/**
		 * points 数据
			0		1		2		3		4		5			6			7		8    9	    10	    11    12      13      14     15       16
			 S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT   
			5120.0 5120.0  0.0    0.0   32768.0   1966.5   86016.0      0.0     4480.0 770.4  384.0   75.9       0    0.000   0      0.000    0.000

		 */
		List<String> points= new ArrayList<>();
		String[] pointsA = out.toString().split(" ");
		for (int i = 0; i < pointsA.length; i++) {
			if(pointsA[i].equals(""))
				continue;
			points.add(pointsA[i]);
		}
		
		gc.setYGC(Double.valueOf(points.get(12+17)));
		gc.setYGCT(Double.valueOf(points.get(13+17)));
		gc.setFGC(Double.valueOf(points.get(14+17)));
		gc.setFGCT(Double.valueOf(points.get(15+17)));
		
		return gc;
	}
	
	public static void main(String[] args) {
		try {
			new GCCollector().collectGCInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
