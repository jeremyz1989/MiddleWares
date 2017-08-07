package com.celnet.dc.controller;

import com.alibaba.fastjson.JSONObject;
import com.celnet.dc.common.util.FinalUtil;
import com.celnet.dc.common.util.SHA1EncodingUtil;
import com.celnet.dc.domain.AccountSource;
import com.celnet.dc.domain.api.response.ResponseJson;
import com.celnet.dc.service.AccountSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by HONGYI_ZHENG on 2017/8/3.
 */
@RestController
@RequestMapping(value = "/")
@Api("club登录注册异步验证api")
public class ClubRegisterCheckController extends ApiServiceController{

    @Autowired
    private AccountSourceService accountSourceService;

    /**
     * club用户注册异步校验接口
     * @param jsonObject 请求的Json对象 包含用户注册时输入的用户名
     * @return 返回响应responseJson
     */
    @ApiOperation(value = "club注册校验")
    @RequestMapping(value = "/get/registerCheck",method = RequestMethod.POST)
    public ResponseJson registerCheck(@RequestBody JSONObject jsonObject){
        //响应json
        ResponseJson responseJson;
        //TODO 请求校验
        //获取businessId和businessType
        String businessId = jsonObject.getString("businessId");
        String businessType = jsonObject.getString("businessType");
        //验证请求参数
        if (!businessId.equals("club")||!businessType.equals("04")) {
            //验证不通过，返回 请求参数错误
            responseJson = new ResponseJson(FinalUtil.API_ERROR_CODE_1022,
                    FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1022));
            return responseJson;
        }
        //取得请求参数username
        String userName = jsonObject.getString("UserName");
        //判断sf数据库是否存在相同用户名
        boolean flag = accountSourceService.getAccountByParam(userName);
        if (flag) {
            //如果存在，返回 该用户已存在
            responseJson = new ResponseJson(FinalUtil.API_ERROR_CODE_2006,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_2006));
        }else {
            //不存在，返回 用户名可以使用
            responseJson = new ResponseJson(FinalUtil.API_ERROR_CODE_2007,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_2007));
        }
        return responseJson;
    }

    /**
     * club登录校验，登录成功时返回用户信息
     * @param jsonObject data ：username password
     * @return
     */
    @ApiOperation(value = "club登录校验")
    @RequestMapping(value = "/get/loginCheck",method = RequestMethod.POST)
    public ResponseJson loginCheck(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        //响应的json
        ResponseJson responseJson;
        //TODO 请求校验
        //从请求中获取用户名及密码
        String username = jsonObject.getString("UserName");
        String password = jsonObject.getString("Password");
        //根据用户名匹配账户
        List<AccountSource> accs = accountSourceService.queryAccountByUserName(username);

        if (accs.size()<1) {
            //该用户不存在，提示手机号输入错误
            responseJson = new ResponseJson(FinalUtil.API_ERROR_CODE_2008,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_2008));
        }else if (!SHA1EncodingUtil.getSha1(password).equals(accs.get(0).getClubpasswordC())){
            //密码不匹配，提示密码错误，请重新输入
            responseJson = new ResponseJson(FinalUtil.API_ERROR_CODE_2009,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_2009));
        }else {
            //登录成功，返回用户信息
            //TODO 关联两个新表  wechatFollower__c wechatAccount__c
            responseJson = new ResponseJson();
        }
        return responseJson;

    }

    public ResponseJson getPassword(){
        return new ResponseJson();
    }

}
