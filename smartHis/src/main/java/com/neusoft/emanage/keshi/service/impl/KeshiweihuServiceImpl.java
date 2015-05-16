package com.neusoft.emanage.keshi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.keshi.persist.KeshiweihuDao;
import com.neusoft.emanage.keshi.service.IKeshiweihuService;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Service("keshiweihuService")
public class KeshiweihuServiceImpl implements IKeshiweihuService {
	@Autowired
	private KeshiweihuDao keshiweihuDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public  Map<String, Object>  queryList(KeshiQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<KeshiBean> list = keshiweihuDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, keshiweihuDao.findCount(paramMap));

	}

	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<KeshiBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<KeshiBean> list = keshiweihuDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(KeshiBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			keshiweihuDao.save(bean);
		} else {
			keshiweihuDao.update(bean);
		}
		return "success";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public KeshiBean getParameterById(Integer id) {
		return keshiweihuDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		keshiweihuDao.delete(id);
	}
}
