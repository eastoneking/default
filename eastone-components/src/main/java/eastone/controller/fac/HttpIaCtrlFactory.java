/*
 * create:2015年5月13日 下午10:15:57
 * author:wangds  
 */
package eastone.controller.fac;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import eastone.business.HttpInteractionBusiness;
import eastone.controller.HttpInteractionController;
import eastone.controller.core.HttpIaBizController;

/**
 * 与HTTP相关，有请求应答交互的控制器工厂.
 * @author wangds
 *
 */
public class HttpIaCtrlFactory<I, O> implements FactoryBean<HttpInteractionController<I, O>>, InitializingBean, ApplicationListener<ApplicationEvent> {

    private HttpInteractionBusiness<I, O> business;
    /**
     * The setter method of the property business.
     * @param thebusiness the business to set
     * @author wangds 2015年5月14日 下午4:01:32.
     */
    public void setBusiness(HttpInteractionBusiness<I, O> business) {
        this.business = business;
    }
    /**
     * The getter method of the property business.
     * @author wangds 2015年5月14日 下午4:01:34.
     * @return the business.
     */
    public HttpInteractionBusiness<I, O> getBusiness() {
        return business;
    }

    /*
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     * @author wangds 2015年5月13日 下午10:16:52.
     */
    @Override
    public void onApplicationEvent(ApplicationEvent arg0) {
    }

    /*
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     * @author wangds 2015年5月13日 下午10:16:52.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     * @author wangds 2015年5月13日 下午10:16:52.
     */
    @Override
    public HttpInteractionController<I, O> getObject() throws Exception {
        HttpIaBizController<I, O, HttpInteractionBusiness<I,O>> res = null;
        res = new HttpIaBizController<I, O, HttpInteractionBusiness<I,O>>();
        res.setBusiness(this.business);
        return res ;
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     * @author wangds 2015年5月13日 下午10:16:52.
     */
    @Override
    public Class<?> getObjectType() {
        return HttpIaBizController.class;
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     * @author wangds 2015年5月13日 下午10:16:52.
     */
    @Override
    public boolean isSingleton() {
        return false;
    }


}
