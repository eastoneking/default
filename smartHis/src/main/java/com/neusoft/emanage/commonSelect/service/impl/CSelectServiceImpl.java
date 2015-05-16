package com.neusoft.emanage.commonSelect.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.commonSelect.service.ICSelectService;
import com.neusoft.emanage.guahao.persist.GuahaoDao;
import com.neusoft.emanage.keshi.persist.KeshiweihuDao;
import com.neusoft.emanage.keshi.service.IKeshiweihuService;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.system.persist.SysParameterDao;
import com.neusoft.emanage.system.vo.SysParameterQueryBean;
import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinBianmaBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKBean;
import com.neusoft.emanage.util.gen.entity.YaopinTypeBean;
import com.neusoft.emanage.yaoju.persist.YaopinkucunDao;
import com.neusoft.emanage.ypsys.persist.YaopinBianmaDao;
import com.neusoft.emanage.ypsys.persist.YaopinTypeDao;
import com.neusoft.sframe.util.SysUtil;

@Service("cselectService")
public class CSelectServiceImpl implements ICSelectService {
	@Autowired
	private YaopinTypeDao yaopinTypeDao;
	@Autowired
	private YaopinBianmaDao yaopinBianmaDao;
	@Autowired
	private YaopinkucunDao yaopinkucunDao;
	@Autowired
	private KeshiweihuDao keshiweihuDao;
	@Autowired
	private GuahaoDao guahaoDao;
	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<YaopinTypeBean> getYaopinTypeByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//执行查询
		List<YaopinTypeBean> list = yaopinTypeDao.getByTypeCode(typeCode);
		return list;
	}
	
	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<YaopinBianmaBean> getYaopinBianMa(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<YaopinBianmaBean> list = yaopinBianmaDao.getByTypeCode(typeCode);
		
		return list;
	}
	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<YaopinCKBean> getYaopinKuCun(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//执行查询
		List<YaopinCKBean> list = yaopinkucunDao.getByTypeCode(typeCode);
		return list;
	}
	@Override
	public List<KeshiBean> getKeshilist(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<KeshiBean> list = keshiweihuDao.getByTypeCode(typeCode);
		
		return list;
	}

	@Override
	public List<GuaHaoBean> getGuaHaolist(String typeCode) {
	Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<GuaHaoBean> list = guahaoDao.getByTypeCode(typeCode);
		
		return list;
	}
}
