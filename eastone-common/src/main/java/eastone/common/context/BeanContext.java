package eastone.common.context;

import java.util.Locale;
/**
 * 以java bean作为媒介存储的上下文.
 * 
 * <p>
 * 修改列表:<br/>
 * <ol>
 * 	<li>确认建立版本,并补充注释. by wangds@gmail.com 2013-10-12 22:10 </li>
 * <ol>
 * </p>
 * 
 * 
 * @param <C> 泛型参数,指定上下文中用于保存bean的容器类型.
 * 
 * @author 王东石 <wangds@gmail.com> 2013-10-12 22:00
 * 
 * @version 0.1.1
 * @since 0.1
 * 
 */
public interface BeanContext<C> extends Context{
	
	/**
	 * 获得上下文中的bean对象.
	 * @param beanid bean的唯一编号.
	 * @param args 生成对象的初始化参数.
	 * @return 参数对应的对象.
	 */
	public <B> B getBean(String beanid,Object... args);
	
	/**
	 * 添加实际存储对象的容器.
	 * <p>appendContext操作应视为对当前上下文的一种扩展。即在当前上下文的基础上，增
	 * 加更多的支持，使得容器中可以包括更多的对象。</p>
	 * <p>如果没有类似机制可以不实现此方法.</p>
	 * @param context 保存对象的容器.
	 * @return 当前对象的引用.
	 * <p>原来上下文为C，包括两种状态的B1和B2，以集合的表示方法{C|A,B}。这时，向其中
	 *添加C1上下文，{C1|B3}。添加之后，获得{C'|B1,B2,B3}。这样可能出现两种情况：
	 * <ol>
	 * 	<li>C=C',且C与C'为同一对象,这时应返回此对象;</li>
	 * 	<li>C是C'的真子集，且C={B1,B2},C'=C∪C1，即原有C和C1保持不变，生成一个包含C
	 * 和C1的新集合C'，此时应返回C'。</li>
	 * </ol>
	 * </p>
	 */
	public BeanContext<C> appendContext(C context);
	
	/**
	 * 获得以{@link java.util.ResourceBundle}为基础的消息值.
	 * <p>此接口设计受到Spring的影响.</p>
	 * @param code 消息key值.
	 * @param locale 语言地区代码.
	 * @param args 替换参数.
	 * @return
	 * @see java.util.ResourceBundle
	 * 
	 */
	public String getMessage(String code, Locale locale, Object ... args );
	
}
