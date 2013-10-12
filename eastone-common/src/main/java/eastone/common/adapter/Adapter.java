package eastone.common.adapter;

/**
 * Adapter接口是设计模式中适配器模式的接口定义.
 * <p>
 * </p>
 * @author 王东石 <wangds@gmail.com>
 *
 * @param <T> 被适配的类型.
 * <p>
 * </p>
 */
public interface Adapter<T> {
	
	/**
	 * 获得实现功能的内部对象.
	 * @return 被适配的对象.
	 */
	public T getInner();
	
}
