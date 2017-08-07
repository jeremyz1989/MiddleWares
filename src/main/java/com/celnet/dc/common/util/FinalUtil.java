package com.celnet.dc.common.util;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Splitter;

/**
 * 常量类
 * 
 * @author enSure
 *
 */
public class FinalUtil {
	public  static final  String getErrorMsg(String code) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(API_ERROR_CODE_0, API_ERROR_MSG_0); // 成功
		map.put(API_ERROR_CODE_1, API_ERROR_MSG_1); // 未知错误
		map.put(API_ERROR_CODE_1001, API_ERROR_MSG_1001); // 缺少必须参数[%s]
		map.put(API_ERROR_CODE_1002, API_ERROR_MSG_1002); // 参数类型错误[%s]
		map.put(API_ERROR_CODE_1003, API_ERROR_MSG_1003); // 不支持的请求方式
		map.put(API_ERROR_CODE_1004, API_ERROR_MSG_1004); // 请求数据格式错误
		map.put(API_ERROR_CODE_1005, API_ERROR_MSG_1005); // 系统处理失败
		map.put(API_ERROR_CODE_1006, API_ERROR_MSG_1006); // 请求数据过大
		map.put(API_ERROR_CODE_1007, API_ERROR_MSG_1007); // 请求数据缺失
		map.put(API_ERROR_CODE_1008, API_ERROR_MSG_1008); // 不支持的接口请求
		map.put(API_ERROR_CODE_1009, API_ERROR_MSG_1009); // 签名验证错误
		map.put(API_ERROR_CODE_1010, API_ERROR_MSG_1010); // 没有该接口的权限
		map.put(API_ERROR_CODE_1011, API_ERROR_MSG_1011); // 未知业务应用
		map.put(API_ERROR_CODE_1012, API_ERROR_MSG_1012); // 未查询到接口处理器
		map.put(API_ERROR_CODE_1013, API_ERROR_MSG_1013); // 接口处理器重复
		map.put(API_ERROR_CODE_1014, API_ERROR_MSG_1014); // 响应返回数据格式错误
		map.put(API_ERROR_CODE_1015, API_ERROR_MSG_1015); // 初始化接口处理器错误
		map.put(API_ERROR_CODE_1016, API_ERROR_MSG_1016); // 没有操作该项目的权限
		map.put(API_ERROR_CODE_1017, API_ERROR_MSG_1017); // 无效的App
																		// Key
		map.put(API_ERROR_CODE_1018, API_ERROR_MSG_1018); // 无效的Version
		map.put(API_ERROR_CODE_1019, API_ERROR_MSG_1019); // 非法请求时间戳
		map.put(API_ERROR_CODE_1020, API_ERROR_MSG_1020); // 接口未启用
		map.put(API_ERROR_CODE_1021, API_ERROR_MSG_1021); // 未找到接口处理器
		map.put(API_ERROR_CODE_2001, API_ERROR_MSG_2001); // 客户不存在
		map.put(API_ERROR_CODE_2002, API_ERROR_MSG_2002); // 客户手机号填写错误
		map.put(API_ERROR_CODE_2003, API_ERROR_MSG_2003); // 客户证件号填写错误
		map.put(API_ERROR_CODE_2004, API_ERROR_MSG_2004); // 客户姓名填写错误
		map.put(API_ERROR_CODE_2005, API_ERROR_MSG_2005); // 存在多个客户
		map.put(API_ERROR_CODE_4001, API_ERROR_MSG_4001); // 项目不存在
		map.put(API_ERROR_CODE_4002, API_ERROR_MSG_4002); // 地块不存在
		map.put(API_ERROR_CODE_4003, API_ERROR_MSG_4003); // 分期不存在
		map.put(API_ERROR_CODE_4004, API_ERROR_MSG_4004); // 产品类型不存在
		map.put(API_ERROR_CODE_4005, API_ERROR_MSG_4005); // 装修类型不存在
		map.put(API_ERROR_CODE_4006, API_ERROR_MSG_4006); // 楼栋不存在
		map.put(API_ERROR_CODE_4007, API_ERROR_MSG_4007); // 单元不存在
		map.put(API_ERROR_CODE_4008, API_ERROR_MSG_4008); // 房源不存在
		map.put(API_ERROR_CODE_4009, API_ERROR_MSG_4009); // 绑定房源不存在
		map.put(API_ERROR_CODE_5001, API_ERROR_MSG_5001); // 业主房源绑定失败
		map.put(API_ERROR_CODE_5002, API_ERROR_MSG_5002); // 同住人绑定失败
		map.put(API_ERROR_CODE_5003, API_ERROR_MSG_5003); // 业主解除同住人失败
		map.put(API_ERROR_CODE_5004, API_ERROR_MSG_5004); // 同住人绑定确认失败
		map.put(API_ERROR_CODE_6001, API_ERROR_MSG_6001); // 消息推送失败
		map.put(API_ERROR_CODE_9001, API_ERROR_MSG_9001); // 非法身份证号码
		map.put(API_ERROR_CODE_9002, API_ERROR_MSG_9002); // 非法手机号码
		map.put(API_ERROR_CODE_9003, API_ERROR_MSG_9003); // 不能同时为空
		map.put(API_ERROR_CODE_9004, API_ERROR_MSG_9004); // 不能同时为多个
		map.put(API_ERROR_CODE_9005, API_ERROR_MSG_9005); // 房源不存在合同
		map.put(API_ERROR_CODE_9006, API_ERROR_MSG_9006); // 业主同住人绑定失败
		
		return map.containsKey(code) ? map.get(code) : API_ERROR_MSG_NULL;
	}

	// *******date Final star***************************************
	public static final String formatDefaultTimestamp = "yyyy-MM-dd HH:mm:ss";
	public static final String format_yyyy_MM_dd_HHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String format_yyyy_MM_dd_HHmm = "yyyy-MM-dd HH:mm";
	public static final String format_yyyy_MM_dd_HH = "yyyy-MM-dd HH";
	public static final String format_yyyyMMddHHmm = "yyyyMMddHHmm";
	public static final String format_yyyyMMdd = "yyyyMMdd";
	public static final String format_yyyy = "yyyy";
	public static final String format_yyyyMM = "yyyyMM";
	public static final String format_yyyy_MM_dd = "yyyy-MM-dd";
	public static final String format_MM_dd = "MM-dd";
	public static final String format_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String format_yyyy年MM月dd日 = "yyyy年MM月dd日";
	public static final String format_yyyyMMdd_bias = "yyyy/MM/dd";
	public static final String format_yyyyMMddhhmmss_bias = "yyyy/MM/dd HH:mm:ss";
	public static final String format_yyyyMMdd_bias_mmdd = "MM/dd";
	public static final String format_HHMM = "HH:mm";
	public static final String format_HHMMSS = "HH:mm:ss";
	// *******date Final end***************************************

	// *******error系统错误码 Final star**************************************
	public static final String API_ERROR_CODE_0 = "0";
	public static final String API_ERROR_MSG_0 = "成功";

	public static final String API_ERROR_CODE_1 = "-1";
	public static final String API_ERROR_MSG_1 = "未知错误";

	public static final String API_ERROR_CODE_1001 = "1001";
	public static final String API_ERROR_MSG_1001 = "缺少必须参数[%s]";

	public static final String API_ERROR_CODE_1002 = "1002";
	public static final String API_ERROR_MSG_1002 = "参数类型错误[%s]";

	public static final String API_ERROR_CODE_1003 = "1003";
	public static final String API_ERROR_MSG_1003 = "不支持的请求方式";

	public static final String API_ERROR_CODE_1004 = "1004";
	public static final String API_ERROR_MSG_1004 = "请求数据格式错误";

	public static final String API_ERROR_CODE_1005 = "1005";
	public static final String API_ERROR_MSG_1005 = "系统处理失败";

	public static final String API_ERROR_CODE_1006 = "1006";
	public static final String API_ERROR_MSG_1006 = "请求数据过大";

	public static final String API_ERROR_CODE_1007 = "1007";
	public static final String API_ERROR_MSG_1007 = "请求数据缺失";

	public static final String API_ERROR_CODE_1008 = "1008";
	public static final String API_ERROR_MSG_1008 = "不支持的接口请求";

	public static final String API_ERROR_CODE_1009 = "1009";
	public static final String API_ERROR_MSG_1009 = "签名验证错误";

	public static final String API_ERROR_CODE_1010 = "1010";
	public static final String API_ERROR_MSG_1010 = "没有该接口的权限";

	public static final String API_ERROR_CODE_1011 = "1011";
	public static final String API_ERROR_MSG_1011 = "未知业务应用";

	public static final String API_ERROR_CODE_1012 = "1012";
	public static final String API_ERROR_MSG_1012 = "未查询到接口处理器";

	public static final String API_ERROR_CODE_1013 = "1013";
	public static final String API_ERROR_MSG_1013 = "接口处理器重复";

	public static final String API_ERROR_CODE_1014 = "1014";
	public static final String API_ERROR_MSG_1014 = "响应返回数据格式错误";

	public static final String API_ERROR_CODE_1015 = "1015";
	public static final String API_ERROR_MSG_1015 = "初始化接口处理器错误";

	public static final String API_ERROR_CODE_1016 = "1016";
	public static final String API_ERROR_MSG_1016 = "没有操作该项目的权限";

	public static final String API_ERROR_CODE_1017 = "1017";
	public static final String API_ERROR_MSG_1017 = "无效的App Key";

	public static final String API_ERROR_CODE_1018 = "1018";
	public static final String API_ERROR_MSG_1018 = "无效的Version";

	public static final String API_ERROR_CODE_1019 = "1019";
	public static final String API_ERROR_MSG_1019 = "非法请求时间戳";

	public static final String API_ERROR_CODE_1020 = "1020";
	public static final String API_ERROR_MSG_1020 = "接口未启用";

	public static final String API_ERROR_CODE_1021 = "1021";
	public static final String API_ERROR_MSG_1021 = "未找到接口处理器";
	// *******error系统错误码 Final end***************************************

	// *******error客户类错误码 Final star***************************************
	public static final String API_ERROR_CODE_2001 = "2001";
	public static final String API_ERROR_MSG_2001 = "客户不存在";

	public static final String API_ERROR_CODE_2002 = "2002";
	public static final String API_ERROR_MSG_2002 = "客户手机号填写错误";

	public static final String API_ERROR_CODE_2003 = "2003";
	public static final String API_ERROR_MSG_2003 = "客户证件号填写错误";

	public static final String API_ERROR_CODE_2004 = "2004";
	public static final String API_ERROR_MSG_2004 = "客户姓名填写错误";
	
	public static final String API_ERROR_CODE_2005 = "2005";
	public static final String API_ERROR_MSG_2005 = "存在多个客户";
	// *******error客户类错误码 Final end***************************************

	// *******error基础数据类错误码 Final star**************************************
	public static final String API_ERROR_CODE_4001 = "4001";
	public static final String API_ERROR_MSG_4001 = "项目不存在";

	public static final String API_ERROR_CODE_4002 = "4002";
	public static final String API_ERROR_MSG_4002 = "地块不存在";

	public static final String API_ERROR_CODE_4003 = "4003";
	public static final String API_ERROR_MSG_4003 = "分期不存在";

	public static final String API_ERROR_CODE_4004 = "4004";
	public static final String API_ERROR_MSG_4004 = "产品类型不存在";

	public static final String API_ERROR_CODE_4005 = "4005";
	public static final String API_ERROR_MSG_4005 = "装修类型不存在";

	public static final String API_ERROR_CODE_4006 = "4006";
	public static final String API_ERROR_MSG_4006 = "楼栋不存在";

	public static final String API_ERROR_CODE_4007 = "4007";
	public static final String API_ERROR_MSG_4007 = "单元不存在";

	public static final String API_ERROR_CODE_4008 = "4008";
	public static final String API_ERROR_MSG_4008 = "房源不存在";

	public static final String API_ERROR_CODE_4009 = "4009";
	public static final String API_ERROR_MSG_4009 = "绑定房源不存在";
	// *******error基础数据类错误码 Final end***************************************

	// *******error客户行为服务类错误码 Final star***************************************
	public static final String API_ERROR_CODE_5001 = "5001";
	public static final String API_ERROR_MSG_5001 = "业主房源绑定失败";

	public static final String API_ERROR_CODE_5002 = "5002";
	public static final String API_ERROR_MSG_5002 = "同住人绑定失败";

	public static final String API_ERROR_CODE_5003 = "5003";
	public static final String API_ERROR_MSG_5003 = "业主解除同住人失败";

	public static final String API_ERROR_CODE_5004 = "5004";
	public static final String API_ERROR_MSG_5004 = "同住人绑定确认失败";
	// *******error客户行为服务类错误码 Final end***************************************

	// *******error通知消息类错误码 Final star***************************************
	public static final String API_ERROR_CODE_6001 = "6001";
	public static final String API_ERROR_MSG_6001 = "消息推送失败";
	// *******error通知消息类错误码 Final end***************************************

	// *******error业务通用错误码 Final star**************************************
	public static final String API_ERROR_MSG_NULL = "不明确错误编码";

	public static final String API_ERROR_CODE_9001 = "9001";
	public static final String API_ERROR_MSG_9001 = "非法身份证号码";

	public static final String API_ERROR_CODE_9002 = "9002";
	public static final String API_ERROR_MSG_9002 = "非法手机号码";

	public static final String API_ERROR_CODE_9003 = "9003";
	public static final String API_ERROR_MSG_9003 = "[%s]不能同时为空";

	public static final String API_ERROR_CODE_9004 = "9004";
	public static final String API_ERROR_MSG_9004 = "[%s]不能同时为多个";

	public static final String API_ERROR_CODE_9005 = "9005";
	public static final String API_ERROR_MSG_9005 = "房源不存在合同";

	public static final String API_ERROR_CODE_9006 = "9006";
	public static final String API_ERROR_MSG_9006 = "业主绑定同住人失败";
	// *******error业务通用错误码 Final end***************************************

	// *******xxxx Final star**************************************
    public static final Splitter WAVE_LINE = Splitter.on("~").omitEmptyStrings().trimResults();
    public static final Splitter AT_SPLITER = Splitter.on("@").omitEmptyStrings().trimResults();
	// *******xxxx Final end***************************************

	// *******xxxx Final star**************************************
	// *******xxxx Final end***************************************

	// *******xxxx Final star**************************************
	// *******xxxx Final end***************************************

	// *******xxxx Final star**************************************
	// *******xxxx Final end***************************************

	// *******xxxx Final star**************************************
	// *******xxxx Final end***************************************
}
