package com.neusoft.emanage.kaiyao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.kaiyao.persist.KaiyaoDao;
import com.neusoft.emanage.kaiyao.service.IKaiyaoService;
import com.neusoft.emanage.kaiyao.vo.KaiyaoQueryBean;
import com.neusoft.emanage.util.gen.entity.KaiyaoBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Service("kaiyaoService")
public class KaiyaoServiceImpl implements IKaiyaoService {
	@Autowired
	private KaiyaoDao kaiyaoDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public  Map<String, Object>  queryList(KaiyaoQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<KaiyaoBean> list = kaiyaoDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, kaiyaoDao.findCount(paramMap));

	}

	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<KaiyaoBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<KaiyaoBean> list = kaiyaoDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(KaiyaoBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			kaiyaoDao.save(bean);
		} else {
			kaiyaoDao.update(bean);
		}
		return "success";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public KaiyaoBean getParameterById(Integer id) {
		return kaiyaoDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		kaiyaoDao.delete(id);
	}

	@Override
	public String getCount(String zdid) {
		KaiyaoBean bean = new KaiyaoBean();
		Integer i = new Integer(zdid);
		bean.setZdyp_zdid(i);
		List<KaiyaoBean> list =  kaiyaoDao.getCount(bean);
		Float count = 0f;
		for(KaiyaoBean kaiyaoBean:list){
			Float col = Float.valueOf(kaiyaoBean.getZdyp_danxiangjine());
			count = count + col;
		}
		return count.toString();
	}
}
