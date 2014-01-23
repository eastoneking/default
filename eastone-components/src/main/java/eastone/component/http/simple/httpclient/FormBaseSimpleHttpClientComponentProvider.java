/*
 * File:FormBaseSimpleHttpClientComponent.java
 * Type:eastone.component.http.simple.httpclient.
 * FormBaseSimpleHttpClientComponentProvider
 */
package eastone.component.http.simple.httpclient;

import java.net.URL;
import java.util.Map;

import eastone.component.http.HttpException;
import eastone.component.http.simple.HttpMethodEnum;
import eastone.component.http.simple
        .SimpleHttpClientComponentBridgeAbstractionImpl;

/**
 * HttpClient桥接接口实现类.
 * <p>
 * <ol>
 * <li>初始版本,wangdongshi@neusoft.com,2013-10-27 下午5:42:22</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class FormBaseSimpleHttpClientComponentProvider
    extends
    SimpleHttpClientComponentBridgeAbstractionImpl
    <Map<String, String>, SimpleHttpClientFormBaseImpl> {

  /**
   * 构造函数.
   */
  public FormBaseSimpleHttpClientComponentProvider() {
    this(new SimpleHttpClientFormBaseImpl());
  }

  /**
   * 构造函数.
   * @param impl 桥接实现类.
   */
  public FormBaseSimpleHttpClientComponentProvider(
      final SimpleHttpClientFormBaseImpl impl) {
    this.setImplementor(impl);
  }

  @Override
  public String post(final URL url) throws HttpException {
    return fillImple(HttpMethodEnum.POST, url, null).request();
  }

  @Override
  public String get(final URL url) throws HttpException {
    return fillImple(HttpMethodEnum.GET, url, null).request();
  }

  @Override
  public String post(final URL url, final Map<String, String> form)
      throws HttpException {
    return fillImple(HttpMethodEnum.POST, url, form).request();
  }

  @Override
  public String get(final URL url, final Map<String, String> form)
      throws HttpException {
    return fillImple(HttpMethodEnum.GET, url, form).request();
  }

  @Override
  public void close() {
  }

  /**
   * 设置桥接类状态.
   * @param method http方法.
   * @param url 目标URL.
   * @param parameters 参数.
   * @return 应答体.
   */
  private SimpleHttpClientFormBaseImpl fillImple(final HttpMethodEnum method,
      final URL url, final Map<String, String> parameters) {
    SimpleHttpClientFormBaseImpl impl = this.getImplementor();
    impl.setMethod(method);
    impl.setUrl(url);
    impl.setParameters(parameters);
    return impl;
  }

}
