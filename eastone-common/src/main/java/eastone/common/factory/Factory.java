package eastone.common.factory;
/**
 * 工厂接口.
 * <p>按照本工厂接口的定义，一个工厂接口的实现类只能作为一种类的工厂接口.</p>
 * @author 王东石 <wangds@gmail.com>
 *
 * @param <T> 生成类型.
 * @param <E> 生成过程中可能出现的异常.
 * 
 * @version 0.1.1
 * @modifyList <ol><li>2013-10-13 00:07 补充注释</li></ol>
 */
public interface Factory<T,E extends Exception> {
	/**
	 * 工厂方法
	 * @return 实例
	 * @throws E 可能的异常
	 */
	public T getInstance() throws E;
	
}