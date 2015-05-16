package com.neusoft.emanage.zonghechaxun.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.kaiyao.persist.KaiyaoDao;
import com.neusoft.emanage.keshi.persist.KeshiweihuDao;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.zonghechaxun.service.IZonghechaxunService;
import com.neusoft.emanage.zonghechaxun.vo.CXKaiyaoQueryBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Service("zonghechaxunService")
public class ZonghechaxunServiceImpl implements IZonghechaxunService {
	@Autowired
	private KaiyaoDao kaiyaoDao;


	@Override
	public Map<String, Object> getYishengKaiyaolist(CXKaiyaoQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<KeshiBean> list = kaiyaoDao.listForQuery(paramMap);
		return EasyUIQueryUtil.retParam(list, kaiyaoDao.findCountForQuery(paramMap));

	}

	


}
