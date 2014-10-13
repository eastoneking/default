/*
 * create:2014年10月12日 下午6:58:49
 * author:wangds  
 */
package eastone.initializer.spring;

import java.util.Collection;

import org.springframework.beans.factory.FactoryBean;

import eastone.common.factory.Factory;
import eastone.common.processor.Processor;
import eastone.initializer.Initializer;
import eastone.initializer.InitializerAutoRunDecorator;
import eastone.initializer.InitializerWrapper;

/**
 * .
 * @author wangds
 *
 */
public class InitializerBeanFactory
    implements FactoryBean<Initializer>, Factory<Initializer>{

    /**
     * 是否自动执行.
     */
    private boolean autuRun = false;
    /**
     * .
     */
    private Collection<Processor> initializeProcessors = null;
    /**
     * The setter method of the property autuRun.
     * @param theautuRun the autuRun to set
     * @author wangds 2014年10月12日 下午7:13:00.
     */
    public void setAutuRun(boolean autuRun) {
        this.autuRun = autuRun;
    }
    /**
     * The getter method of the property autuRun.
     * @author wangds 2014年10月12日 下午7:13:05.
     * @return the autuRun.
     */
    public boolean isAutuRun() {
        return autuRun;
    }
    /**
     * The setter method of the property initializeProcessors.
     * @param theinitializeProcessors the initializeProcessors to set
     * @author wangds 2014年10月12日 下午7:08:35.
     */
    public void setInitializeProcessors(Collection<Processor> initializeProcessors) {
        this.initializeProcessors = initializeProcessors;
    }
    /**
     * The getter method of the property initializeProcessors.
     * @author wangds 2014年10月12日 下午7:08:39.
     * @return the initializeProcessors.
     */
    public Collection<Processor> getInitializeProcessors() {
        return initializeProcessors;
    }
    /*
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     * @author wangds 2014年10月12日 下午7:03:48.
     */
    @Override
    public Initializer getObject() throws Exception {
        Initializer res = this.getInstance();
        if(this.autuRun){
            new InitializerAutoRunDecorator<Initializer>().setComponent(res);
        }
        return res;
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     * @author wangds 2014年10月12日 下午7:03:48.
     */
    @Override
    public Class<?> getObjectType() {
        return Initializer.class;
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     * @author wangds 2014年10月12日 下午7:03:48.
     */
    @Override
    public boolean isSingleton() {
        return false;
    }

    /*
     * @see eastone.common.factory.Factory#getInstance()
     * @author wangds 2014年10月12日 下午7:06:14.
     */
    @Override
    public Initializer getInstance() {
        Initializer res = null;
        res = new InitializerWrapper<Processor>();
        Initializer cur = res;
        if(this.initializeProcessors!=null){
            for(Processor proc:this.initializeProcessors){
                InitializerWrapper<Processor> w = new InitializerWrapper<Processor>();
                w.setAdaptee(proc);
                cur.setNext(w);
                cur=w;
            }
        }
        return res ;
    }

}
