/*
 * create:2015年5月11日 下午2:48:55
 * author:wangds  
 */
package eastone.endpoint.fac;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import eastone.business.HttpInteractionBusiness;
import eastone.controller.Controller;
import eastone.controller.core.HttpIaBizController;
import eastone.endpoint.HttpEndPoint;
import eastone.endpoint.HttpJsonInteractionControllerEndPoint;
import eastone.endpoint.WithControllerEndPoint;

/**
 * .
 * @author wangds
 *
 */
public class HttpJsonIaEpFactory<E extends WithControllerEndPoint<Controller>&HttpEndPoint>
    implements FactoryBean<E>, InitializingBean, ApplicationListener<ApplicationEvent> {

    private HttpInteractionBusiness<Object, Object> business;
    
    /**
     * The setter method of the property business.
     * @param thebusiness the business to set
     * @author wangds 2015年5月11日 下午2:58:30.
     */
    public void setBusiness(HttpInteractionBusiness<Object, Object> business) {
        this.business = business;
    }
    
    /**
     * The getter method of the property business.
     * @author wangds 2015年5月11日 下午2:58:34.
     * @return the business.
     */
    public HttpInteractionBusiness<Object, Object> getBusiness() {
        return business;
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
        HttpJsonInteractionControllerEndPoint<Object, Object> res = new HttpJsonInteractionControllerEndPoint<Object, Object>();
        HttpIaBizController<Object, Object, HttpInteractionBusiness<Object, Object>> ctrl = new HttpIaBizController<Object, Object, HttpInteractionBusiness<Object, Object>>();
        ctrl.setBusiness(business);
        res.setController(ctrl);
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
