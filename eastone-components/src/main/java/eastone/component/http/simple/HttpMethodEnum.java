/*
 * File:HttpMethodEnum.java Type:eastone.component.http.simple.HttpMethodEnum
 */
package eastone.component.http.simple;

/**
 * HTTP Method枚举值.
 * <p>
 * <ol>
 * <li>初始版本,wangds@gmail.com,2013-10-27 16:54:10</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public enum HttpMethodEnum {
  /**
   * 从指定的url上获取内容.
   */
  GET,

  /**
   * 提交body中的内容给服务器中指定的url中，属于非幂等的(non-idempotent)请求.
   */
  POST,

  /**
   * 从指定的url上获取header内容(类似Get方式).
   */
  HEAD,

  /**
   * Allows a programmer to see how the client's message is modified as it
   * passes through a series of proxy servers. The recipient of a TRACE method
   * echoes the HTTP request headers back to the client.
   */
  TRACE,

  /**
   * 将body上传至服务器指定url处.
   */
  PUT,

  /**
   * 在指定url处删除资源.
   */
  DELETE,

  /**
   * 获取指定url中能接收的请求方法.
   */
  OPTIONS,

  /**
   * 连接指定频段。当客户端需要通过代理服务器连接HTTPS服务器是用到.
   */
  CONNECT

}
