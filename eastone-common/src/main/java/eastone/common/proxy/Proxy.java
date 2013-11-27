/*
 * File:Proxy.java Type:eastone.common.proxy.Proxy
 */
package eastone.common.proxy;

/**
 * 代理模式.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午9:38:54</li>
 * </ol>
 * </p>
 * @param <Subject> 被代理的对象类型.
 *          <p>
 *          在使用时本接口的实现类必须继承<code>Subject</code>类型.
 *          </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Proxy<Subject> {
  /**
   * 获得被代理对象.
   * @return 被代理对象.
   */
  Subject getSubject();

  /**
   * 设置被代理对象.
   * @param subject 被代理对象.
   */
  void setSubject(Subject subject);
}
