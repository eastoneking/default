package com.neusoft.sframe.util.mybatis;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface BaseDao<T> {
	/** 根据ID获取实体 */
	public T get(Integer id);

	/** 分页查询 */
	public List<Map<String, Object>> search(Map<String, Object> parameters);

	/** 保存实体，并将主键值反写回实体，返回受影响的记录数 */
	public int save(T t);

	/** 根据ID删除表中数据 */
	public void delete(Integer id);

	/** 更新实体，返回受影响的记录数 */
	public int update(T t);

	/** 根据ID获取实体 */
	public int findCount(Map<String, Object> paramMaps);
}
