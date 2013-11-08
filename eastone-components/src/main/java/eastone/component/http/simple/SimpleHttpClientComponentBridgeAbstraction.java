/*
 * File:SimpleHttpClientComponentBridgeAbstraction.java
 * Type:eastone.component.http.simple.SimpleHttpClientComponentBridgeAbstraction
 */
package eastone.component.http.simple;

import eastone.common.bridge.Bridge;
import eastone.common.bridge.BridgeImplementor;
import eastone.component.http.SimpleHttpClientComponent;

/**
 * HTTP客户端简单版的桥接抽象接口.
 * <p>
 *  <ol>
 *    <li>初始版本, by wangds@gmail.com, 2013-10-21 12:45:53</li>
 *    <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:12</li>
 *    <li>
 *    	根据父类接口变化,调整泛型参数, by wangds@gmail.com 2013-10-27 16:52
 *    </li>
 *    <li>
 *    	根据调整后的设计模式命名，实现接口重定义为 {@link Bridge},
 *    	by wangds@gmail.com, 2013-11-08 21:15.
 *    </li>
 *  </ol>
 * </p>
 * @param <T> 实现类.
 * @param <P> 请求URL时参数类型.
 * @author 王东石 <wangdongshi@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface SimpleHttpClientComponentBridgeAbstraction
	<P, T extends BridgeImplementor>
	extends SimpleHttpClientComponent<P>, Bridge<T> {

}
