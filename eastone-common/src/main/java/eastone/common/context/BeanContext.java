package eastone.common.context;

import java.util.Locale;

public interface BeanContext<C> extends Context{
	
	public <B> B getBean(String beanid,Object... args);
	
	public BeanContext<C> appendContext(C context);
	
	public String getMessage(String code, Locale locale, Object ... args );
	
}
