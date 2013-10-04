package eastone.common.context;

import java.util.Iterator;
import java.util.ServiceLoader;

import eastone.common.factory.Factory;

public class BeanContextFactory implements Factory<BeanContext, RuntimeException>{

	@Override
	public BeanContext getInstance() throws RuntimeException {
		BeanContext res = null;
		ServiceLoader<BeanContext> loader = ServiceLoader.load(BeanContext.class);
		Iterator<BeanContext> it = loader.iterator();
		while(it.hasNext()){
			res = it.next();
			if(res!=null){
				break;
			}
		}
		return res ;
	}

}
