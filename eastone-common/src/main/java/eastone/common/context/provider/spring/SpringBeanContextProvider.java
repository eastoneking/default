package eastone.common.context.provider.spring;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;

import eastone.common.context.BeanContext;

public class SpringBeanContextProvider<C extends AbstractRefreshableApplicationContext> implements BeanContext<C> {

	private AbstractApplicationContext context = null;
	
	@Override
	public <T> T status(Object... inputs) {
		int args_length = inputs.length-1;
		Object[] args = new Object[args_length];
		System.arraycopy(inputs, 1, args, 0, args_length);
		return getBean((String)inputs[0],args);
	}

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
