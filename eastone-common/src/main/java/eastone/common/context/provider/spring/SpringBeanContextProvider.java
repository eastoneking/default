package eastone.common.context.provider.spring;

import java.util.ServiceLoader;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import eastone.common.context.BeanContext;

public class SpringBeanContextProvider<C extends AbstractApplicationContext> implements BeanContext<C> {

	private AbstractApplicationContext context = new GenericApplicationContext();
	
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
		context.setParent(this.context);
		this.context=context;
		return this;
	}


}
