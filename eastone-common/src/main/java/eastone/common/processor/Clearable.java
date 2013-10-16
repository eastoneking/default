package eastone.common.processor;

/**
 * 可清理接口.
 * <p>可清理意味着对象可以重用.</p>
 * <p>
 * 	修改记录:
 * 	<ol>
 * 		<li>建立初始版本,by wangds@gmail.com, 2013-10-13 22:42.</li>
 * 	</ol>
 * </p>
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Clearable {
	
	/**
	 * 清理方法.
	 */
	public void clear();
	
}