package com.neusoft.emanage.userAccess.service;

import java.util.Map;

import com.neusoft.emanage.util.gen.entity.UserAccessBean;

public interface IUserAccessService {

	UserAccessBean getUserAccessById(Integer id);
	UserAccessBean getAccessByElement(Map<String, Object> param);
	
}
