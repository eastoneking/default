package com.neusoft.emanage.ypsys.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.YaopinTypeBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface YaopinTypeDao extends BaseDao<YaopinTypeBean> {

	public List<YaopinTypeBean> getByTypeCode(String typeCode);

	public List<YaopinTypeBean> list(Map<String, Object> paramMap);

}
