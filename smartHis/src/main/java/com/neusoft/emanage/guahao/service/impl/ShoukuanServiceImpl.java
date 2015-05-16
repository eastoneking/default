package com.neusoft.emanage.guahao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.guahao.persist.ShoukuanDao;
import com.neusoft.emanage.guahao.service.IShoukuanService;
import com.neusoft.emanage.guahao.vo.ShoukuanQueryBean;
import com.neusoft.emanage.kaiyao.persist.ZhenduanDao;
import com.neusoft.emanage.util.gen.entity.ShoukuanBean;
import com.neusoft.emanage.util.gen.entity.ZhenduanBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Service("shoukuanService")
public class ShoukuanServiceImpl implements IShoukuanService {
	@Autowired
	private ShoukuanDao shoukuanDao;
	@Autowired
	private ZhenduanDao zhenduanDao;
	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public  Map<String, Object>  queryList(ShoukuanQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<ShoukuanBean> list = shoukuanDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, shoukuanDao.findCount(paramMap));

	}

	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<ShoukuanBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<ShoukuanBean> list = shoukuanDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(ShoukuanBean bean) {
		ZhenduanBean zhenduanBean = new ZhenduanBean();
		Integer zdid = new Integer(bean.getGhsf_zdid());
		zhenduanBean.setId(zdid);
		zhenduanBean.setZd_status("1"); //已诊断
		zhenduanBean.setZd_fystatus("0"); //未付药
		zhenduanBean.setZd_version_old(bean.getZd_version());
		Integer oldVersion = new Integer(bean.getZd_version());
		Integer newVersion = oldVersion+1;
		zhenduanBean.setZd_version(newVersion.toString());
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			
			int count = zhenduanDao.update(zhenduanBean);
			if(count==0){
				return "error";
			}
			shoukuanDao.save(bean);
		} else {
			shoukuanDao.update(bean);
		}
		return "success";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public ShoukuanBean getParameterById(Integer id) {
		return shoukuanDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		shoukuanDao.delete(id);
	}
}
