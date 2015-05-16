package com.neusoft.emanage.userAccess.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.IssueUserCreateCoinBean;
import com.neusoft.emanage.util.gen.entity.UserAccessBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface UserAccessDao extends BaseDao<UserAccessBean> {

	public UserAccessBean getAccessById(Integer id);
	public UserAccessBean getAccessByElement(Map<String, Object> param);
	
}
