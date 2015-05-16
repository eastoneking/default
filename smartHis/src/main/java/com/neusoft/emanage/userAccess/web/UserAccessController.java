package com.neusoft.emanage.userAccess.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.neusoft.emanage.userAccess.service.IUserAccessService;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.emanage.util.gen.entity.UserAccessBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;
import com.neusoft.sframe.util.GlobalVal;
import com.neusoft.sframe.util.SysUtil;

@Controller
@RequestMapping(value = "userAccess")
public class UserAccessController {
	
	@Autowired
	IUserAccessService userAccessService;
	
	@RequestMapping(value = "getUserAccessById")
	@ResponseBody
	public UserAccessBean getUserAccessById(HttpServletRequest request){
		//取登录信息
		HttpSession session = request.getSession();
		SysUserBean userbean = (SysUserBean) session.getAttribute(GlobalVal.USER_SESSION);
		//根据用户id取用户帐户信息
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("userId", userbean.getId());
		UserAccessBean user = userAccessService.getAccessByElement(param);
		if(user==null){
			return user;
		}
		user.setGSCS(SysUtil.formatNum(user.getGSC()));
		user.setRMBS(SysUtil.formatNum(user.getRMB()));
		return user;
	}
	@RequestMapping(value = "getAccessByElement")
	@ResponseBody
	public UserAccessBean getAccessByElement(HttpServletRequest request,UserAccessBean userAccessBean){
		//bean转map，
		Map<String, Object> param = EasyUIQueryUtil.beanToMapNotNull(userAccessBean);
		//根据用户id取用户帐户信息
		return userAccessService.getAccessByElement(param);
	}
	@RequestMapping(value = "getNowUserAccessByElement")
	@ResponseBody
	public UserAccessBean getNowUserAccessByElement(HttpServletRequest request){
		//取登录信息
		HttpSession session = request.getSession();
		SysUserBean userbean = (SysUserBean) session.getAttribute(GlobalVal.USER_SESSION);
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("userId", userbean.getId());
		//根据用户id取用户帐户信息
		return userAccessService.getAccessByElement(param);
	}
	
	
}
