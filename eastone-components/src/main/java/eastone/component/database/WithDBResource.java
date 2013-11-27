/*
 * File:WithDBResource.java Type:eastone.component.database.WithDBResource
 */
package eastone.component.database;

/**
 * 使用数据库资源接口.
 * <p>
 * DBResouce指数据源或Session等.
 * </p>
 * <p>
 * <ol>
 * <li>初始版本,wangdongshi@neusoft.com,2013-10-16 下午11:11:25</li>
 * <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:11</li>
 * </ol>
 * </p>
 * @param <T> 数据资源.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface WithDBResource<T> {

  /**
   * 获得数据资源.
   * @return 数据源.
   */
  T getDBResource();

  /**
   * 设置数据资源.
   * @param resource 数据源.
   */
  void setDBResource(T resource);

}
