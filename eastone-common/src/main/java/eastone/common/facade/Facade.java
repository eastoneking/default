/*
 * File:Facade.java
 * Type:eastone.common.facade.Facade
 */
package eastone.common.facade;

/**
 * Facade (Compiler)模式.
 *
 * <p><h2>作用:</h2>
 * 	<ul>
 * 	<li>knows which subsystem classes are responsible for a request.</li>
 * 	<li>delegates client requests to appropriate subsystem objects.</li>
 * 	</ul>
 * </p>
 *
 * <p><h2>参考:</h2>
 * 	<ul>
 * 		<li>[GOF95]</li>
 * 	</ul>
 * </p>
 * <p><h2>修改列表:</h2>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-6 上午12:06:02</li>
 *  </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public interface Facade {

	/**
	 * 根据子系统识别标志寻找子系统引用.
	 * @param <K> 子系统识别标志类型.
	 * @param <S> 子系统类型.
	 * @param key 子系统识别标志.
	 * @return 子系统引用.
	 */
	<K, S extends SubSystem> S findSubSystem(K key);

}
