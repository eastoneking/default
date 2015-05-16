package com.neusoft.emanage.yaoju.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKRKBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface YaopinrukuDao extends BaseDao<YaopinCKRKBean> {

	public List<YaopinCKRKBean> getByTypeCode(String typeCode);

	public List<YaopinCKRKBean> list(Map<String, Object> paramMap);

}
