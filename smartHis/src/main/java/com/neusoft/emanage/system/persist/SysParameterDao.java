package com.neusoft.emanage.system.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface SysParameterDao extends BaseDao<SysParameterBean> {

	public List<SysParameterBean> getByTypeCode(String typeCode);

	public List<SysParameterBean> list(Map<String, Object> paramMap);

}
