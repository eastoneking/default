package com.neusoft.emanage.guahao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.guahao.persist.GuahaoDao;
import com.neusoft.emanage.guahao.service.IGuahaoService;
import com.neusoft.emanage.guahao.vo.GuaHaoQueryBean;
import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Service("guahaoService")
public class GuahaoServiceImpl implements IGuahaoService {
	@Autowired
	private GuahaoDao guahaoDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public  Map<String, Object>  queryList(GuaHaoQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<GuaHaoBean> list = guahaoDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, guahaoDao.findCount(paramMap));

	}

	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<GuaHaoBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<GuaHaoBean> list = guahaoDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(GuaHaoBean bean) {
			// ID为空时为新增，否则为修改
		bean.setGhstatus("0");
		if (bean.getId() == null) {
			guahaoDao.save(bean);
		} else {
			guahaoDao.update(bean);
		}
		return "success";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public GuaHaoBean getParameterById(Integer id) {
		return guahaoDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		guahaoDao.delete(id);
	}
}
