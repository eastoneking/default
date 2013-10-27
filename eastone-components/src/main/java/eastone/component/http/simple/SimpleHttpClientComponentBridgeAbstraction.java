/*
 * File:SimpleHttpClientComponentBridgeAbstraction.java
 * Type:eastone.component.http.simple.SimpleHttpClientComponentBridgeAbstraction
 */
package eastone.component.http.simple;

import eastone.common.bridge.BridgeAbstraction;
import eastone.common.bridge.BridgeImplementor;
import eastone.component.http.SimpleHttpClientComponent;

/**
 * HTTP客户端简单版的桥接抽象接口.
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-21 下午12:45:53</li>
 *    <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:12</li>
 *  </ol>
 * </p>
 * @param <T>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface SimpleHttpClientComponentBridgeAbstraction
	<T extends BridgeImplementor>
	extends SimpleHttpClientComponent, BridgeAbstraction<T> {

}
