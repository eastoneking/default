package com.neusoft.emanage.yaoju.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.emanage.keshi.persist.KeshiweihuDao;
import com.neusoft.emanage.keshi.service.IKeshiweihuService;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.system.persist.SysParameterDao;
import com.neusoft.emanage.system.vo.SysParameterQueryBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKRKBean;
import com.neusoft.emanage.yaoju.persist.YaopinkucunDao;
import com.neusoft.emanage.yaoju.persist.YaopinrukuDao;
import com.neusoft.emanage.yaoju.service.IYaopinrukuService;
import com.neusoft.emanage.yaoju.vo.YaopinCKRKQueryBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;
import com.neusoft.sframe.util.SysUtil;

@Service("yaopinrukuService")
public class YaopinrukuServiceImpl implements IYaopinrukuService {
	@Autowired
	private YaopinrukuDao yaopinrukuDao;
	@Autowired
	private YaopinkucunDao yaopinkucunDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public  Map<String, Object>   queryList(YaopinCKRKQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<YaopinCKRKBean> list = yaopinrukuDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, yaopinrukuDao.findCount(paramMap));
		
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//
//		// 添加查询条件
//		paramMap.put("kc_ypbmnumber", queryBean.getKc_ypbmnumber());
//		paramMap.put("kc_ypname", queryBean.getKc_ypname());
////		paramMap.put("string_property", queryBean.getString_property());
//
//		// 添加查询条件
////		SysUtil.putInMapWhenExists(paramMap, "type", queryBean.getType(), true);
////	   SysUtil.putInMapWhenExists(paramMap, "typeCode", queryBean.getTypeCode(), true);
//
//		
//		// 添加分页查询条件
//		paramMap.put("sortname", queryBean.getSortname());
//		paramMap.put("sortorder", queryBean.getSortorder());
//
//		// 执行分页查询
//		List<YaopinCKRKBean> list = yaopinrukuDao.list(paramMap);
		// 构建前台需要数据结构
//		GridDataBean<Map<String, Object>> bean = new GridDataBean<Map<String, Object>>(queryBean.getPage(),
//				parameterDao.findCount(paramMap), list);
//		return list;
	}

	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<YaopinCKRKBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<YaopinCKRKBean> list = yaopinrukuDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	@Transactional
	public String save(YaopinCKRKBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			YaopinCKBean ckBean = getYaopinCKBean(bean);
			 yaopinkucunDao.save(ckBean);
			bean.setKc_id(ckBean.getId());
			yaopinrukuDao.save(bean);
		} else {
			yaopinrukuDao.update(bean);
		}
		return "success";
	}

	private YaopinCKBean getYaopinCKBean(YaopinCKRKBean bean) {
		YaopinCKBean ckBean = new YaopinCKBean();
		ckBean.setKc_cbjiage(bean.getKc_cbjiage());
		ckBean.setKc_laiyuan(bean.getKc_laiyuan());
		ckBean.setKc_rkriqi(bean.getKc_rkriqi());
		ckBean.setKc_scpici(bean.getKc_scpici());
		ckBean.setKc_scriqi(bean.getKc_scriqi());
		ckBean.setKc_status(bean.getKc_status());
		ckBean.setKc_ypbmid(bean.getKc_ypbmid());
		ckBean.setKc_ypbmnumber(bean.getKc_ypbmnumber());
		ckBean.setKc_ypleibie(bean.getKc_ypleibie());
		ckBean.setKc_ypname(bean.getKc_ypname());
		ckBean.setKc_yppihao(bean.getKc_yppihao());
		ckBean.setKc_yxriqi(bean.getKc_yxriqi());
		ckBean.setKc_zdjiage(bean.getKc_zdjiage());
		ckBean.setKc_shengchanshang(bean.getKc_shengchanshang());
		ckBean.setKc_danwei(bean.getKc_danwei());
		ckBean.setKc_lsjiage(bean.getKc_lsjiage());
		ckBean.setKc_shuliang(bean.getKc_shuliang());
		return ckBean;
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public YaopinCKRKBean getParameterById(Integer id) {
		return yaopinrukuDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		yaopinrukuDao.delete(id);
	}
}
