package com.neusoft.emanage.fileUpload.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface FileManangerDao extends BaseDao {

	public int insertFile(Map<String, Object> param);
	public Map<String, Object> getMapById(Integer id);
	public List<Map<String, Object>> fileQueryByIds(List<Integer> ids);
}