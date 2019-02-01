package com.yymonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project yymonitor
 * @author yy
 * @date 2019年1月8日 上午10:13:46
 * @description TODO cpu 信息
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoniInfoCPU extends MoniInfo {

	private String used;//已使用的cpu
}
