package com.neusoft.emanage.kaiyao.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.emanage.util.gen.entity.KaiyaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.SysRoleBean;
import com.neusoft.emanage.util.gen.entity.ZhenduanBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface KaiyaoDao extends BaseDao<KaiyaoBean> {

	public List<KaiyaoBean> getInfoById(Integer id);
	public List<KaiyaoBean> getByTypeCode(String typeCode);
	public List<KaiyaoBean> list(Map<String, Object> paramMap);
	public int findCount(Map<String, Object> paramMaps);
	public List<KaiyaoBean> getCount(KaiyaoBean kaiyaoBean);
	public List<KeshiBean> listForQuery(Map<String, Object> paramMap);
	public Integer findCountForQuery(Map<String, Object> paramMap);
}
