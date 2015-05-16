package com.neusoft.emanage.yaoju.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.ChukuBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKRKBean;
import com.neusoft.emanage.util.gen.entity.YaopinLirunBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface ChukuDao extends BaseDao<ChukuBean> {

	public List<ChukuBean> getByTypeCode(String typeCode);

	public List<ChukuBean> list(Map<String, Object> paramMap);

	public List<ChukuBean> listinfo(Map<String, Object> paramMap);

	public Integer findCountlistinfo(Map<String, Object> paramMap);

	public List<YaopinLirunBean> queryLrlist(Map<String, Object> paramMap);

	public Integer findCountqueryLrlist(Map<String, Object> paramMap);

	public List<ChukuBean> queryLrinfolist(Map<String, Object> paramMap);

	public Integer findCountqueryLrinfolist(Map<String, Object> paramMap);
}
