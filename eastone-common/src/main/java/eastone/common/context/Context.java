package eastone.common.context;

/**
 * 上下文接口.
 * <p>
 *上下文接口用于在不连续地调用程序时传递前后相关的内容。本接口中上下文内保存的内容
 *均被称为状态，即将上下文理解为一个状态机。给定指定输入条件时，可以从状态机中获得相
 *同的输出。
 * </p>
 * <p>修改列表:
 * <ol>
 * 	<li>补充注释. wangds@gmail.com 2013-10-12 22:00</li>
 * </ol></p>
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1 
 * 
 */
public interface Context {
	
	/**
	 * 从上下文中获得状态.
	 * @param inputs 输入条件.
	 * @return 与输入条件对应的状态.
	 */
	public <T> T status(Object ... inputs);
	
}
