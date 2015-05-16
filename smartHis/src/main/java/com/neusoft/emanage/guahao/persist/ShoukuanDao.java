package com.neusoft.emanage.guahao.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.ShoukuanBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.SysRoleBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface ShoukuanDao extends BaseDao<ShoukuanBean> {

	public List<ShoukuanBean> getByTypeCode(String typeCode);
	public List<ShoukuanBean> list(Map<String, Object> paramMap);
	public int findCount(Map<String, Object> paramMaps);
}
