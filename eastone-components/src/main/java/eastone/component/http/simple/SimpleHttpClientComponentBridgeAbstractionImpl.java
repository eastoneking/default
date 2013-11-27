/*
 * File:SimpleHttpClientComponentBridgeAbstractionImpl.java Type:
 * eastone.component.http.simple.SimpleHttpClientComponentBridgeAbstractionImpl
 */
package eastone.component.http.simple;

import java.net.URL;

import eastone.component.http.HttpException;

/**
 * HTTP客户端简单版桥接抽象接口实现类.
 * <p>
 * <ol>
 * <li>初始版本,wangdongshi@neusoft.com,2013-10-21 下午12:51:28</li>
 * <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:47</li>
 * </ol>
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
  public final T getImplementor() {
    return impl;
  }

  @Override
  public final void setImplementor(final T implementor) {
    this.impl = implementor;
  }

  /**
   * 获取URL.
   * @return URL.
   */
  public final URL getUrl() {
    return url;
  }

  /**
   * 设置URL.
   * @param theUrl URL.
   */
  public final void setUrl(final URL theUrl) {
    this.url = theUrl;
  }

  /**
   * 获取参数.
   * @return 参数.
   */
  public final P getParametets() {
    return parametets;
  }

  /**
   * 设置参数.
   * @param theParametets 参数.
   */
  public final void setParametets(final P theParametets) {
    this.parametets = theParametets;
  }

  /**
   * 设置请求方法.
   * @param theMethod the method to set
   */
  public final void setMethod(final HttpMethodEnum theMethod) {
    this.method = theMethod;
  }

  /**
   * 获得请求方法.
   * @return the method
   */
  public final HttpMethodEnum getMethod() {
    return method;
  }

  @Override
  public final void process() {
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
   * @param theUrl URL.
   * @param theParameters 参数.
   * @throws HttpException 可能的异常.
   */
  private void executeRequest(final URL theUrl, final P theParameters)
      throws HttpException {
    switch (method) {
    case POST:
      this.post(theUrl, theParameters);
      break;
    case GET:
    default:
      this.get(theUrl, theParameters);
    }
  }

  /**
   * 执行请求.
   * @param theUrl URL.
   * @throws HttpException 异常
   */
  private void executeRequest(final URL theUrl) throws HttpException {
    switch (method) {
    case POST:
      this.post(theUrl);
      break;
    case GET:
    default:
      this.get(theUrl);
    }
  }

}
