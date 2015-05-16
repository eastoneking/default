package com.neusoft.emanage.system.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.system.service.ISysUserService;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.sframe.util.GlobalVal;

@Controller
public class LoginController {
	private static Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	protected ISysUserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(SysUserBean bean, HttpServletRequest request) {
		Map<String, Object> res = new HashMap<String, Object>();
		String result = userService.login(bean);
		request.getSession().setAttribute("user_name", bean.getUser_name());	
		if ("success".equals(result)) {
			// 将登录用户相关信息的VO保存到session中
			HttpSession session = request.getSession();
			session.setAttribute(GlobalVal.USER_SESSION, bean);
			// 返回SessionID给前端
			res.put("success", session.getId());
		} else {
			// 登录失败，将错误代号返回给前端。100--用户名密码错   200--没有对应角色
			res.put("error", result);
		}
		return res;
	}

	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(GlobalVal.USER_SESSION);
		return "redirect:/login.html";
	}

	@RequestMapping(value = "/getUser",method = RequestMethod.POST)
	@ResponseBody
	public SysUserBean login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (SysUserBean) session.getAttribute(GlobalVal.USER_SESSION);
	}
}