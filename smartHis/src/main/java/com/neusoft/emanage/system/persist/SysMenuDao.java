package com.neusoft.emanage.system.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.SysMenuBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface SysMenuDao extends BaseDao<SysMenuBean> {

	List<SysMenuBean> list(Map<String, Object> paramMap);

	int checkSave(SysMenuBean bean);

	List<SysMenuBean> getUserMenu(Integer user_id);
}