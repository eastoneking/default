package eastone.common.context.provider.spring;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;

import eastone.common.context.BeanContext;
/**
 * 以Spring IoC容器作为基础实现的{@link BeanContext}接口的实现类.
 * @author 王东石 <wangds@gmail.com>
 * @param <C> 参数类型 限定了Spring上下文类型必须是可以更新的上下文.
 * 
 * @version 0.1
 * @modifyList
 * <ol>
 * 	<li>2013-10-12 22:53 确认版本,补充注释.</li>
 * </ol>
 */
public class SpringBeanContextProvider<C extends AbstractRefreshableApplicationContext> implements BeanContext<C> {
	
	/**
	 * 
	 */
	private AbstractApplicationContext context = null;
	
	@Override
	public <T> T status(Object... inputs) {
		assert inputs!=null:"";
		int args_length = inputs.length-1;
		Object[] args = new Object[args_length];
		System.arraycopy(inputs, 1, args, 0, args_length);
		return getBean((String)inputs[0],args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <B> B getBean(String beanid,Object... args) {
		B res = null;
		if(args==null||args.length==0){
			res = (B)context.getBean(beanid);
		}else{
			res = (B)context.getBean(beanid,args);
		}
		return res ;
	}

	@Override
	public BeanContext<C> appendContext(C context) {
		if(this.context!=null){
			context.setParent(this.context);
			context.refresh();
		}
		this.context=context;
		
		return this;
	}
	
	public String getMessage(String code, Locale locale, Object ... args ){
		String res=null;
		if(context==null){
			res = "message initialized failrue.";
		}else{
			res = context.getMessage(code, args, "unkown infomation." , locale);
		}
		return res;
	}

	
}
