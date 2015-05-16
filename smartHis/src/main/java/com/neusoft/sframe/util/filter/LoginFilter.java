package com.neusoft.sframe.util.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neusoft.sframe.util.GlobalVal;
import com.google.gson.Gson;

public class LoginFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(LoginFilter.class);
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 判断是否登录，访问系统.do必须登录后才能访问
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String url = request.getRequestURI();
		log.debug("REST CALL>>"+url);
		
		HttpSession session = request.getSession();
		Map<String, String> map = new HashMap<String, String>();
		//暂不拦截所有请求
//		 chain.doFilter(req, resp);
		// 如果是登录则不检查 login.do,也不检查修改默认密码changedefaultpasswd.do, 也不检查验证码loginclearkaptcha.do
		// authorizedStub.do的时候会根据cookie设置情况处理自动登录问题，因此此处也跳过
		// 然后判断session，没有session则出错
		// 存在session则判断权限按钮
		/*过滤没有登录的访问方式  -- 暂时注释  ---  
		Map<String, String> map = new HashMap<String, String>();

		if (url.endsWith("getMenu.do") || url.endsWith("getParentOrganList.do") 
		        || url.endsWith("changedefaultpasswd.do") || url.endsWith("getParent.do")

		chain.doFilter(req, resp);
		*/
		/*
		if (url.endsWith(".html")) {
			chain.doFilter(req, resp);
		} else if (session != null && session.getAttribute(GlobalVal.USER_SESSION) != null) {
			if ("-1".equals(request.getParameter("_filterParms"))) {
				// return empty array for ligerui grid
				Map<String, Object> tempMap = new HashMap<String, Object>();
				tempMap.put("Rows", new ArrayList<Map<String, Object>>());
				response.getWriter().print(new Gson().toJson(tempMap));
			} else {
				// 此处写权限控制逻辑
				chain.doFilter(req, resp);
			}
		} else {
			// logout or session timeout or unauthority user
			map.put("error", "100092");
			response.getWriter().print(new Gson().toJson(map));
		}*/
		if (session != null && session.getAttribute(GlobalVal.USER_SESSION) != null) {
			chain.doFilter(req, resp);
		} else if (url.indexOf("/fn/")>0||url.endsWith("login.html") || url.endsWith("login.do") || url.endsWith(".js") || url.endsWith(".css")||url.endsWith("ekp_login.html")||url.contains("images")||url.contains("icons") ) {
			chain.doFilter(req, resp);
		} else {
//			map.put("error", "100092");
//			response.getWriter().print(new Gson().toJson(map));
			 if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){  
				 response.setStatus(999);//表示session timeout  
	         } 
			response.sendRedirect(request.getContextPath() + "/login.html");
		}
	}
	
	@Override
	public void destroy() {
	}
}
