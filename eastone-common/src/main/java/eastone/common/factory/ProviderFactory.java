/*
 * File:ProviderFactory.java
 * Type:eastone.common.factory.ProviderFactory
 */
package eastone.common.factory;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.ServiceLoader;

import eastone.common.context.provider.spring.SpringBeanContextProvider;

/**
 * Provider的工厂类.
 * <p>
 *  <ol>
 *    <li>初始版本, by wangds@gmail.com, 2013-10-27 下午6:04:31</li>
 *  </ol>
 * </p>
 * @param <T> 返回类型.
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */
public class ProviderFactory <T> implements Factory<T, RuntimeException> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public T getInstance() {
		T res = null;
		try {
			Class c = this.getClass();
			Method method = c.getMethod("getInstance", new Class[]{});
			Type[] types = method.getGenericParameterTypes();
			Class clz = Class.forName(types[0].toString());

			ServiceLoader<T> loader
            = ServiceLoader.load(clz);
	        Iterator<T> it = loader.iterator();
	        while (it.hasNext()) {
	            res = it.next();
	            if (res instanceof SpringBeanContextProvider) {
	            	break;
	            }
	        }
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return res;
	}

}
