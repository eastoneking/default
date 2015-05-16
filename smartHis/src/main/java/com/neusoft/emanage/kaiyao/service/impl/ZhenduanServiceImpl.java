package com.neusoft.emanage.kaiyao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.kaiyao.persist.ZhenduanDao;
import com.neusoft.emanage.kaiyao.service.IZhenduanService;
import com.neusoft.emanage.kaiyao.vo.ZhenduanQueryBean;
import com.neusoft.emanage.util.gen.entity.ZhenduanBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Service("zhenduanService")
public class ZhenduanServiceImpl implements IZhenduanService {
	@Autowired
	private ZhenduanDao zhenduanDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public  Map<String, Object>  queryList(ZhenduanQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<ZhenduanBean> list = zhenduanDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, zhenduanDao.findCount(paramMap));

	}

	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<ZhenduanBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<ZhenduanBean> list = zhenduanDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(ZhenduanBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			zhenduanDao.save(bean);
		} else {
			zhenduanDao.update(bean);
		}
		return "success";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public ZhenduanBean getParameterById(Integer id) {
		return zhenduanDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		zhenduanDao.delete(id);
	}
}
