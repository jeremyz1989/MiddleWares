package com.celnet.dc.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.celnet.dc.common.exception.ErrorMessage;
import com.celnet.dc.common.util.FinalUtil;
import com.celnet.dc.domain.SystemParamter;
import com.celnet.dc.domain.api.response.ResponseJson;
//import com.celnet.dc.service.SystemParamterService;
import com.celnet.dc.service.SystemParamterService;

/**
 * 系统参数-控制层
 *
 * Created by ensure 2017-06-17.
 */
@RestController
@RequestMapping(value = "/param")
@Api("系统参数-相关api") // 用在类上，说明该类的作用
public class SystemParamterController extends ApiServiceController {
	// 创建线程安全的Map
	static Map<String, SystemParamter> systemParamters = Collections
			.synchronizedMap(new HashMap<String, SystemParamter>());

	@Autowired
	private SystemParamterService systemParamterService;

	@ApiOperation(value = "获取系统参数详细信息", notes = "根据name来获取参数详细信息") // 用在方法上，说明方法的作用
	// @ApiImplicitParams({ @ApiImplicitParam(name = "method", value = "方法名",
	// required = true, dataType = "String"),
	// @ApiImplicitParam(name = "apiVersion", value = "版本", required = true,
	// dataType = "String"),
	// @ApiImplicitParam(name = "authorizedApp", value = "app_key", required =
	// true, dataType = "String")})
	@RequestMapping(value = "/getByName", method = { RequestMethod.GET, RequestMethod.POST })
	public String selectByName(@RequestBody SystemParamter systemParamter) {
		ResponseJson result = new ResponseJson();
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		// String errorCode = super.doPost(request);
		System.out.println("****************************************8");
		// if(!FinalUtil.API_ERROR_CODE_0.equals(errorCode)){
		// result.setErrcode(FinalUtil.API_ERROR_CODE_0);
		// result.setErrmsg(FinalUtil.API_ERROR_CODE_0);
		// result.setData("");
		// return result;
		// }
		String jsonHeader = request.getHeader("s0001");// APPkey

		result = new ResponseJson(FinalUtil.API_ERROR_CODE_0, FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_0));

		try {
			// SystemParamter retData= systemParamterService.selectByName("");
			System.out.println("jsonHeader:" + jsonHeader);
			// System.out.println("jsonBody:"+jsonBody);
			// if (retData == null) {
			// result = new JsonResult(FinalUtil.API_ERROR_CODE_1001,
			// FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1001));
			// } else {
			// result = new JsonResult(FinalUtil.API_ERROR_CODE_0,
			// FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_0), retData);
			// }
		} catch (Exception e) {
			// result = new ResponseJson(ReturnCode.errCode_exception,
			// ReturnCode.errMsg_exception);
		}
		return result.toString();
	}

	@ApiOperation(value = "获取参数列表", notes = "")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<SystemParamter> getAll() {
		// 处理"/users/"的GET请求，用来获取用户列表
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		List<SystemParamter> ret = new ArrayList<SystemParamter>(systemParamters.values());
		return ret;
		// List<SystemParamter> SystemParamters =
		// systemParamterService.selectAll();
		// return SystemParamters;
	}

	@ApiOperation(value = "创建系統参数", notes = "根据systemParamter对象创建systemParamter")
	// @ApiImplicitParam(name = "systemParamter", value =
	// "参数详细实体systemParamter", required = true, dataType = "SystemParamter")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	// public int insert(@RequestParam(value = "systemParamter", required =true)
	// SystemParamter systemParamter) {
	public String insert(@RequestBody SystemParamter systemParamter) {
		// 处理"/systemParamters/"的POST请求，用来创建SystemParamter
		// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
		systemParamters.put(systemParamter.getId().toString(), systemParamter);
		return "success";
		// int retCnt = systemParamterService.insert(systemParamter);
		// return retCnt;
	}

	@ApiOperation(value = "获取参数详细信息", notes = "根据url的id来获取参数详细信息")
	@ApiImplicitParam(name = "id", value = "参数ID", required = true, dataType = "Integer")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SystemParamter selectById(@PathVariable Integer id) {
		// 处理"/systemParamters/{id}"的GET请求，用来获取url中id值的SystemParamter信息
		// url中的id可通过@PathVariable绑定到函数的参数中
		return systemParamters.get(id);
	}

	@ApiOperation(value = "更新系统参数详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新参数详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "参数ID", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "systemParamter", value = "参数详细实体systemParamter", required = true, dataType = "SystemParamter") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable Long id, @ModelAttribute SystemParamter systemParamter) {
		// 处理"/users/{id}"的PUT请求，用来更新User信息
		SystemParamter pSystemParamter = systemParamters.get(id);
		pSystemParamter.setName(systemParamter.getName());
		pSystemParamter.setValueC(systemParamter.getValueC());
		pSystemParamter.setDescC(systemParamter.getDescC());
		systemParamters.put(id.toString(), pSystemParamter);
		return "success";
	}

	@ApiOperation(value = "删除参数", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "参数ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		// 处理"/deleteByPrimaryKey/{id}"的DELETE请求，用来删除SystemParamter
		systemParamters.remove(id);
		return "success";
	}

	// @RequestMapping(value = "/get", method = RequestMethod.GET)
	// public SystemParamter selectByPrimaryKey(@RequestParam(value = "id",
	// required = true) Integer id) {
	// SystemParamter systemParamter =
	// systemParamterService.selectByPrimaryKey(id);
	// return systemParamter;
	// }
	//
	// @RequestMapping(value = "/addSel", method = RequestMethod.GET)
	// public int insertSelective(@RequestParam(value = "systemParamter",
	// required = true) SystemParamter systemParamter) {
	// int retCnt = systemParamterService.insertSelective(systemParamter);
	// return retCnt;
	// }
	//
	// @RequestMapping(value = "/update", method = RequestMethod.GET)
	// public int updateByPrimaryKey(
	// @RequestParam(value = "systemParamter", required = true) SystemParamter
	// systemParamter) {
	// int retCnt = systemParamterService.updateByPrimaryKey(systemParamter);
	// return retCnt;
	// }
	//
	// @RequestMapping(value = "/updateSel", method = RequestMethod.GET)
	// public int updateByPrimaryKeySelective(
	// @RequestParam(value = "systemParamter", required = true) SystemParamter
	// systemParamter) {
	// int retCnt =
	// systemParamterService.updateByPrimaryKeySelective(systemParamter);
	// return retCnt;
	// }
	//
	// @RequestMapping(value = "/updateSel", method = RequestMethod.GET)
	// public int deleteByPrimaryKey(@RequestParam(value = "id", required =
	// true) Integer id) {
	// int retCnt = systemParamterService.deleteByPrimaryKey(id);
	// return retCnt;
	// }

}