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
import com.neusoft.emanage.yaoju.service.IYaopinrukuService;
import com.neusoft.emanage.yaoju.vo.ChukuQueryBean;
import com.neusoft.emanage.yaoju.vo.LirunQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKRKQueryBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;
import com.neusoft.sframe.util.SysUtil;

@Service("chukuService")
public class ChukuServiceImpl implements IChukuService {
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
	public Map<String, Object> queryList(ChukuQueryBean queryBean) {
		
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<ChukuBean> list = chukuDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, chukuDao.findCount(paramMap));

	}
	/**
	 * 分页查询 出库药品明细
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public Map<String, Object> listinfo(ChukuQueryBean queryBean) {
		
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<ChukuBean> list = chukuDao.listinfo(paramMap);
		return EasyUIQueryUtil.retParam(list, chukuDao.findCountlistinfo(paramMap));

	}
	/**
	 * 分页查询  统计查询 药品销售利润统计
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public Map<String, Object> queryLrlist(LirunQueryBean queryBean) {
		
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<YaopinLirunBean> list = chukuDao.queryLrlist(paramMap);
		return EasyUIQueryUtil.retParam(list, chukuDao.findCountqueryLrlist(paramMap));

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
		List<ChukuBean> list = chukuDao.queryLrinfolist(paramMap);
		return EasyUIQueryUtil.retParam(list, chukuDao.findCountqueryLrinfolist(paramMap));

	}
	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<ChukuBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<ChukuBean> list = chukuDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	@Transactional
	public String save(ChukuBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			//获取待出库药品
			Integer zdid = bean.getZdyp_zdid();
			ZhenduanBean zhenduanBean = new ZhenduanBean();
//			ZhenduanBean zhenduanBeanTmp = new ZhenduanBean();
//			zhenduanBeanTmp = zhenduanDao.get(zdid);
//			Integer versionOld = new Integer(zhenduanBeanTmp.getZd_version());
			Integer versionOld = new Integer(bean.getZd_version());
			Integer versionNew = versionOld+1;
			zhenduanBean.setZd_version_old(versionOld.toString());
			zhenduanBean.setZd_version(versionNew.toString());
			zhenduanBean.setId(zdid);
//			zhenduanBean.setZd_status("2");
			zhenduanBean.setZd_fystatus("1");
			int updatecount = zhenduanDao.update(zhenduanBean);
			if(updatecount==0){
				return "error";
			}
			List<KaiyaoBean> kaiyaoList = kaiyaoDao.getByTypeCode(zdid.toString());
			for(KaiyaoBean kaiyaoBean:kaiyaoList){
				ChukuBean ckBean = new ChukuBean();
				ckBean = getCKBeanByKaiyaoBean(kaiyaoBean);
				chukuDao.save(ckBean);
				YaopinCKBean kcBean = new YaopinCKBean();
				kcBean.setId(kaiyaoBean.getZdyp_ypid());
				kcBean.setKc_shuliang(kaiyaoBean.getZdyp_ypshuliang());
				yaopinkucunDao.update(kcBean);
				
	
			}
//			YaopinCKBean ckBean = getYaopinCKBean(bean);
//			 yaopinkucunDao.save(bean);
//			bean.setKc_id(ckBean.getId());
//			chukuDao.save(bean);
		} else {
//			yaopinrukuDao.update(bean);
		}
		return "success";
	}

	private ChukuBean getCKBeanByKaiyaoBean(KaiyaoBean kaiyaoBean) {
		ChukuBean ckBean = new ChukuBean();
		ckBean.setZdyp_danxiangjine(kaiyaoBean.getZdyp_danxiangjine());
		ckBean.setZdyp_ghid(kaiyaoBean.getZdyp_ghid());
		ckBean.setZdyp_ghnumber(kaiyaoBean.getZdyp_ghnumber());
		ckBean.setZdyp_ypbcxsjiage(kaiyaoBean.getZdyp_ypbcxsjiage());
		ckBean.setZdyp_ypbmid(kaiyaoBean.getZdyp_ypbmid());
		ckBean.setZdyp_ypbmnumber(kaiyaoBean.getZdyp_ypbmnumber());
		ckBean.setZdyp_ypcbjiage(kaiyaoBean.getZdyp_ypcbjiage());
		ckBean.setZdyp_ypdanwei(kaiyaoBean.getZdyp_ypdanwei());
		ckBean.setZdyp_ypid(kaiyaoBean.getZdyp_ypid());
		ckBean.setZdyp_ypleibie(kaiyaoBean.getZdyp_ypleibie());
		ckBean.setZdyp_yplsjiage(kaiyaoBean.getZdyp_yplsjiage());
		ckBean.setZdyp_ypname(kaiyaoBean.getZdyp_ypname());
		ckBean.setZdyp_ypshengchanshang(kaiyaoBean.getZdyp_ypshengchanshang());
		ckBean.setZdyp_ypshuliang(kaiyaoBean.getZdyp_ypshuliang());
		ckBean.setZdyp_ypzdjiage(kaiyaoBean.getZdyp_ypzdjiage());
		ckBean.setZdyp_zdid(kaiyaoBean.getZdyp_zdid());
		return ckBean;
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
		ckBean.setKc_shuliang(bean.getKc_lsjiage());
		return ckBean;
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public ChukuBean getParameterById(Integer id) {
		return chukuDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		chukuDao.delete(id);
	}
}
