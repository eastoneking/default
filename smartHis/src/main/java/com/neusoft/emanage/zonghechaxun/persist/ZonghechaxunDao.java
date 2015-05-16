package com.neusoft.emanage.zonghechaxun.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.SysRoleBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface ZonghechaxunDao extends BaseDao<KeshiBean> {

	public List<KeshiBean> getByTypeCode(String typeCode);
	public List<KeshiBean> list(Map<String, Object> paramMap);
	public int findCount(Map<String, Object> paramMaps);
}
