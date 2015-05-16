package com.neusoft.emanage.kaiyao.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.SysRoleBean;
import com.neusoft.emanage.util.gen.entity.ZhenduanBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface ZhenduanDao extends BaseDao<ZhenduanBean> {

	public List<ZhenduanBean> getByTypeCode(String typeCode);
	public List<ZhenduanBean> list(Map<String, Object> paramMap);
	public int findCount(Map<String, Object> paramMaps);
}
