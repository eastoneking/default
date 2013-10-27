/*
 * File:SimpleHttpClientComponentBridgeAbstractionImpl.java
 * Type:
 * eastone.component.http.simple.SimpleHttpClientComponentBridgeAbstractionImpl
 */
package eastone.component.http.simple;

import java.net.URL;

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
 * @param <P> 请求参数.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class SimpleHttpClientComponentBridgeAbstractionImpl
<P, T extends SimpleHttpClientComponentBridgeImplementor>
implements SimpleHttpClientComponentBridgeAbstraction<P, T> {

	/**
	 * 桥接对象.
	 */
	private T impl;

	/**
	 * 要访问的URL.
	 */
	private URL url;

	/**
	 * 请求参数.
	 */
	private P parametets;

	/**
	 * 请求的HTTP方法.
	 */
	private HttpMethodEnum method;

	@Override
	public T getImplementor() {
		return impl;
	}

	@Override
	public void setImplementor(T implementor) {
		this.impl = implementor;
	}

	/**
	 * 获取URL.
	 * @return URL.
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * 设置URL.
	 * @param url URL.
	 */
	public void setUrl(URL url) {
		this.url = url;
	}

	/**
	 * 获取参数.
	 * @return 参数.
	 */
	public P getParametets() {
		return parametets;
	}

	/**
	 * 设置参数.
	 * @param parametets 参数.
	 */
	public void setParametets(P parametets) {
		this.parametets = parametets;
	}

	/**
	 * 设置请求方法.
	 * @param method the method to set
	 */
	public void setMethod(HttpMethodEnum method) {
		this.method = method;
	}

	/**
	 * 获得请求方法.
	 * @return the method
	 */
	public HttpMethodEnum getMethod() {
		return method;
	}

	@Override
	public void process() {
		if (this.url == null) {
			return;
		}
		try {
			if (this.parametets == null) {
				executeRequest(this.url);
			} else {
				executeRequest(this.url, this.parametets);
			}
		} catch (HttpException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 执行请求.
	 * @param url URL.
	 * @param parameters 参数.
	 * @throws HttpException 可能的异常.
	 */
	private void executeRequest(URL url, P parameters) throws HttpException {
		switch (method) {
		case POST:
			this.post(url, parameters);
			break;
		case GET:
		default:
			this.get(url, parameters);
		}
	}

	/**
	 * 执行请求.
	 * @param url URL.
	 * @throws HttpException 异常
	 */
	private void executeRequest(URL url) throws HttpException {
		switch (method) {
		case POST:
			this.post(url);
			break;
		case GET:
		default:
			this.get(url);
		}
	}

}
