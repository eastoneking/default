package com.neusoft.emanage.liruntongji.service.impl;

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
import com.neusoft.emanage.liruntongji.persist.LirunDao;
import com.neusoft.emanage.liruntongji.service.ILirunService;
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
import com.neusoft.emanage.yaoju.service.IYaopinrukuService;
import com.neusoft.emanage.yaoju.vo.ChukuQueryBean;
import com.neusoft.emanage.yaoju.vo.LirunQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKRKQueryBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;
import com.neusoft.sframe.util.SysUtil;

@Service("lirunService")
public class LirunServiceImpl implements ILirunService {
	@Autowired
	private LirunDao lirunDao;
	/**
	 * 分页查询  统计查询 药品销售利润统计
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public Map<String, Object> queryLrlist(LirunQueryBean queryBean) {
		
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<YaopinLirunBean> list = lirunDao.queryLrlist(paramMap);
		return EasyUIQueryUtil.retParam(list, lirunDao.findCountqueryLrlist(paramMap));

	}
	/**
	 * 分页查询  统计查询 药品销售利润明细
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public Map<String, Object> queryLrinfolist(ChukuQueryBean queryBean) {
		
		
		
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<ChukuBean> list = lirunDao.queryLrinfolist(paramMap);
		return EasyUIQueryUtil.retParam(list, lirunDao.findCountqueryLrinfolist(paramMap));

	}

}
