package com.neusoft.emanage.userAccess.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.userAccess.persist.UserAccessDao;
import com.neusoft.emanage.userAccess.service.IUserAccessService;
import com.neusoft.emanage.util.gen.entity.UserAccessBean;

@Service("userAccessServiceImpl")
public class UserAccessServiceImpl implements IUserAccessService {

	@Autowired
	UserAccessDao userAccessDao;
	
	/**
	 * 根据id获取用户帐户
	 */
	public UserAccessBean getUserAccessById(Integer id) {
		return userAccessDao.getAccessById(id);
	}
	
	/**
	 * 根据条件获取用户帐户
	 */
	public UserAccessBean getAccessByElement(Map<String, Object> param) {
		return userAccessDao.getAccessByElement(param);
		  
	}
	
	
}
