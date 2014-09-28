/*
 * File:SimpleHttpClientComponent.java
 * Type:eastone.component.http.SimpleHttpClientComponent
 */
package eastone.component.http;

import java.net.URL;



import eastone.common.processor.Closeable;
import eastone.common.processor.Processor;

/**
 * 发起请求并返回应答.
 * <p>
 * 发送请求并获得应答内容.
 * </p>
 * <p>
 * <ol>
 * <li>初始版本,wangdongshi@gmail.com,2013-10-18 下午1:42:32</li>
 * <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:59</li>
 * <li>方法{@link #get(URL, Object)}和{@link #post(URL, Object)}的类型改为泛型 参数&lt;P&gt;
 * </li>
 * </ol>
 * </p>
 * @param <P> 请求参数类型.
 * @author 王东石 <wangdongshi@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */

public interface SimpleHttpClientComponent<P> extends
    Processor<RuntimeException>, Closeable {

  /**
   * 发起不传递任何参数的POST请求到指定的URL.
   * @param url 要访问的URL.
   * @return 返回响应的Body的内容.
   * @throws HttpException 可能发生的异常.
   */
  String post(URL url) throws HttpException;

  /**
   * 发起不传递任何参数的GET请求到指定的URL.
   * @param url 要访问的URL.
   * @return 返回响应的Body的内容.
   * @throws HttpException 可能发生的异常.
   */
  String get(URL url) throws HttpException;

  /**
   * 发起通过form方式传递参数的POST请求到指定的URL.
   * @param url 要访问的URL.
   * @param form 请求参数.
   * @return 返回响应的Body的内容.
   * @throws HttpException 可能发生的异常.
   */
  String post(URL url, P form) throws HttpException;

  /**
   * 发起通过form方式传递参数的GET请求到指定的URL.
   * @param url 要访问的URL.
   * @param form 请求参数.
   * @return 返回响应的Body的内容.
   * @throws HttpException 可能发生的异常.
   */
  String get(URL url, P form) throws HttpException;

}
