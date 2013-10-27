/*
 * File:SimpleHttpClientComponentBridgeAbstractionImpl.java
 * Type:
 * eastone.component.http.simple.SimpleHttpClientComponentBridgeAbstractionImpl
 */
package eastone.component.http.simple;

import java.net.URL;
import java.util.Map;

import eastone.component.http.HttpException;

/**
 * HTTP客户端简单版桥接抽象接口实现类.
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-21 下午12:51:28</li>
 *    <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:47</li>
 *  </ol>
 * </p>
 * @param <T> 桥接实现类.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class SimpleHttpClientComponentBridgeAbstractionImpl
<T extends SimpleHttpClientComponentBridgeImplementor>
implements SimpleHttpClientComponentBridgeAbstraction<T> {

	@Override
	public String post(URL url) throws HttpException {
		return null;
	}

	@Override
	public String get(URL url) throws HttpException {
		return null;
	}

	@Override
	public String post(URL url, Map<String, String> form) throws HttpException {
		return null;
	}

	@Override
	public String get(URL url, Map<String, String> form) throws HttpException {
		return null;
	}

	@Override
	public void process() {

	}

	@Override
	public void close() {

	}

	@Override
	public T getImplementor() {
		return null;
	}

	@Override
	public void setImplementor(T arg0) {

	}

}
