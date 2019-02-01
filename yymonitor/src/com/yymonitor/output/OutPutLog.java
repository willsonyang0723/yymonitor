package com.yymonitor.output;

import com.alibaba.fastjson.JSONObject;
import com.yymonitor.model.MoniInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月7日 下午5:47:22
 * @description TODO 日志输出打印
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
@Slf4j
public class OutPutLog extends OutPut {

	@Override
	public void doOutput(MoniInfo ...info) {
		log.info(JSONObject.toJSONString(info));
	}

	@Override
	public void doException(Exception e,MoniInfo...infos) {
		e.printStackTrace();
	}


}
