package com.neusoft.emanage.yaoju.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKRKBean;
import com.neusoft.emanage.util.gen.entity.YaopinLirunBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface YaopinkucunDao extends BaseDao<YaopinCKBean> {

	public List<YaopinCKBean> getByTypeCode(String typeCode);

	public List<YaopinCKBean> list(Map<String, Object> paramMap);


}
