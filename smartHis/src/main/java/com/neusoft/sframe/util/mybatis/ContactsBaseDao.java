package com.neusoft.sframe.util.mybatis;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface ContactsBaseDao<T> {
	/** 根据ID获取实体 */
	public T getContacts(Integer id);

	/** 分页查询 */
	public List<Map<String, Object>> queryContacts(Map<String, Object> parameters);

	/** 根据ID获取实体 */
	public int findCount(Map<String, Object> paramMaps);
	
	/** 保存实体，并将主键值反写回实体，返回受影响的记录数 */
	public int saveContacts(T t);
	
	/** 更新实体，返回受影响的记录数 */
	public int updateContacts(T t);
	
	/** 清楚表数据 */
	public void deleteContacts();
	
	/** 保存实体，并将主键值反写回实体，返回受影响的记录数 */
	public int saveContactsNet(T t);
	
	/** 更新实体，并将主键值反写回实体，返回受影响的记录数 */
	public int updateContactsNet(T t);
	
	/** 保存实体，并将主键值反写回实体，返回受影响的记录数 */
	public int saveContactsNative(T t);
	
	/** 更新实体，返回受影响的记录数 */
	public int updateContactsNative(T t);

}
