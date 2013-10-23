package eastone.common.bridge;

/**
 * 桥接接口.
 * <p>
 * 桥接接口,定义桥接类.桥接类用于在桥接模式中实现目标功能,是用于描述抽象功能的接口.
 * 桥接类中的方法{@link #getImplementor()}用于获得功能实现类的对象引用.
 * </p>
 * 
 * @param <T> 桥接接口实现类型,必须实现接口{@link BridgeImplementor}.
 * 
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 * @see eastone.common.bridge.BridgeImplementor
 */
public interface BridgeAbstraction <T extends BridgeImplementor> {
	/**
	 * 获得实现对象.
	 * @return 桥接对象.
	 */
	T getImplementor();
	/**
	 * 设置实现对象.
	 * @param implementor 桥接对象.
	 */
	void setImplementor(T implementor);
}
