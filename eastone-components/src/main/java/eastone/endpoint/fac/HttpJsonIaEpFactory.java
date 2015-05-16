/*
 * create:2015年5月11日 下午2:48:55
 * author:wangds  
 */
package eastone.endpoint.fac;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import eastone.controller.HttpInteractionController;
import eastone.endpoint.HttpEndPoint;
import eastone.endpoint.HttpJsonInteractionControllerEndPoint;
import eastone.endpoint.WithControllerEndPoint;

/**
 * .
 * @author wangds
 *
 */
public class HttpJsonIaEpFactory<I, O, E extends WithControllerEndPoint<HttpInteractionController<I,O>>&HttpEndPoint>
    implements FactoryBean<E>, InitializingBean, ApplicationListener<ApplicationEvent> {

    private HttpInteractionController<I, O> controller;
    
    /**
     * The setter method of the property controller.
     * @param thecontroller the controller to set
     * @author wangds 2015年5月16日 下午2:25:14.
     */
    public void setController(HttpInteractionController<I, O> controller) {
        this.controller = controller;
    }
    
    /**
     * The getter method of the property controller.
     * @author wangds 2015年5月16日 下午2:25:18.
     * @return the controller.
     */
    public HttpInteractionController<I, O> getController() {
        return controller;
    }
    
    /*
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     * @author wangds 2015年5月11日 下午2:53:31.
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
    }

    /*
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     * @author wangds 2015年5月11日 下午2:53:31.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     * @author wangds 2015年5月11日 下午2:53:31.
     */
    @SuppressWarnings("unchecked")
    @Override
    public E getObject() throws Exception {
        HttpJsonInteractionControllerEndPoint<I, O> res = new HttpJsonInteractionControllerEndPoint<I, O>();
        res.setController(this.getController());
        return (E)res;
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     * @author wangds 2015年5月11日 下午2:53:31.
     */
    @Override
    public Class<?> getObjectType() {
        return HttpJsonInteractionControllerEndPoint.class;
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     * @author wangds 2015年5月11日 下午2:53:31.
     */
    @Override
    public boolean isSingleton() {
        return false;
    }


}
