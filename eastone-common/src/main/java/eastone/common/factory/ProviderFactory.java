/*
 * File:ProviderFactory.java Type:eastone.common.factory.ProviderFactory
 */
package eastone.common.factory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Provider的工厂类.
 * <p>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-10-27 下午6:04:31</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class ProviderFactory {

  /**
   * 获得Provider.
   * @param <T> 目标类型
   * @param interfaceclass 目标类型
   * @return 目标实例.
   */
  public <T> T getInstance(final Class<T> interfaceclass) {
    T res = null;
    try {
      ServiceLoader<T> loader = ServiceLoader.load(interfaceclass);
      Iterator<T> it = loader.iterator();
      while (it.hasNext()) {
        res = it.next();
        if (res != null) {
          break;
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return res;
  }

}
