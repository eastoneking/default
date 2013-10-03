package eastone.common.context;

public interface BeanContext<C> extends Context{
	
	public <B> B getBean(String beanid,Object... args);
	
	public BeanContext<C> appendContext(C context);
	
}
