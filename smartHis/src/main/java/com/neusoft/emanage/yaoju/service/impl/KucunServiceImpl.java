package com.neusoft.emanage.yaoju.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.emanage.kaiyao.persist.KaiyaoDao;
import com.neusoft.emanage.kaiyao.persist.ZhenduanDao;
import com.neusoft.emanage.keshi.persist.KeshiweihuDao;
import com.neusoft.emanage.keshi.service.IKeshiweihuService;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.system.persist.SysParameterDao;
import com.neusoft.emanage.system.vo.SysParameterQueryBean;
import com.neusoft.emanage.util.gen.entity.ChukuBean;
import com.neusoft.emanage.util.gen.entity.KaiyaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKRKBean;
import com.neusoft.emanage.util.gen.entity.YaopinLirunBean;
import com.neusoft.emanage.util.gen.entity.ZhenduanBean;
import com.neusoft.emanage.yaoju.persist.ChukuDao;
import com.neusoft.emanage.yaoju.persist.YaopinkucunDao;
import com.neusoft.emanage.yaoju.persist.YaopinrukuDao;
import com.neusoft.emanage.yaoju.service.IChukuService;
import com.neusoft.emanage.yaoju.service.IKucunService;
import com.neusoft.emanage.yaoju.service.IYaopinrukuService;
import com.neusoft.emanage.yaoju.vo.ChukuQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKRKQueryBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;
import com.neusoft.sframe.util.SysUtil;

@Service("kucunService")
public class KucunServiceImpl implements IKucunService {
	@Autowired
	private ChukuDao chukuDao;
	@Autowired
	private YaopinkucunDao yaopinkucunDao;
	@Autowired
	private KaiyaoDao kaiyaoDao;
	@Autowired
	private ZhenduanDao zhenduanDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public Map<String, Object> queryList(YaopinCKQueryBean queryBean) {
		
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<YaopinCKBean> list = yaopinkucunDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, yaopinkucunDao.findCount(paramMap));

	}


	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<YaopinCKBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//执行查询
		List<YaopinCKBean> list = yaopinkucunDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	@Transactional
	public String save(YaopinCKBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			//获取待出库药品
			yaopinkucunDao.save(bean);
//			YaopinCKBean ckBean = getYaopinCKBean(bean);
//			 yaopinkucunDao.save(bean);
//			bean.setKc_id(ckBean.getId());
//			chukuDao.save(bean);
		} else {
//			yaopinrukuDao.update(bean);
		}
		return "success";
	}
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public YaopinCKBean getParameterById(Integer id) {
		return yaopinkucunDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		yaopinkucunDao.delete(id);
	}
}
