/*
 * create:2015年5月11日 下午1:03:31
 * author:wangds  
 */
package eastone.business.fac;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import eastone.business.AbstractHttpInteractionBusiness;
import eastone.business.BizProcedure;
import eastone.business.HttpInteractionBusiness;
import eastone.business.core.BizWithHttpMediatorProc;
import eastone.business.core.MultiBizWithHttpMediatorProc;
import eastone.business.mediator.InteractionBizProcStrategyMediator;
import eastone.business.mediator.MediatorAsIaBizProcStg;
import eastone.business.strategy.BizProcStrategy;
import eastone.business.strategy.BizProcStrategyContext;
import eastone.business.strategy.SyncAllNoOrderStrategy;

/**
 * 操作HTTP请求应答的中介业务类工厂.
 * <p>
 * 可选策略、接入过程等。
 * </p>
 * @author wangds
 *
 */
public class MultiHttpIaMedBizFactory implements FactoryBean<MultiBizWithHttpMediatorProc<Object, Object, Object, HttpInteractionBusiness<Object, Object>,
    InteractionBizProcStrategyMediator<Object, Object, Object,HttpInteractionBusiness<Object, Object>>>>, InitializingBean, ApplicationListener<ApplicationEvent> {


    private Collection<HttpInteractionBusiness<Object, Object>> inner;
    private Collection<BizProcedure> procs;
    private Collection<BizProcStrategy<Object>> strategies;

    /**
     * The setter method of the property inner.
     * @param theinner the inner to set
     * @author wangds 2015年5月11日 下午2:17:02.
     */
    public void setInner(Collection<HttpInteractionBusiness<Object, Object>> inner) {
        this.inner = inner;
    }
    
    /**
     * The getter method of the property inner.
     * @author wangds 2015年5月11日 下午2:17:05.
     * @return the inner.
     */
    public Collection<HttpInteractionBusiness<Object, Object>> getInner() {
        return inner;
    }
    
    /**
     * The setter method of the property procs.
     * @param theprocs the procs to set
     * @author wangds 2015年5月11日 下午2:17:09.
     */
    public void setProcs(Collection<BizProcedure> procs) {
        this.procs = procs;
    }
    
    /**
     * The getter method of the property procs.
     * @author wangds 2015年5月11日 下午2:17:12.
     * @return the procs.
     */
    public Collection<BizProcedure> getProcs() {
        return procs;
    }
    
    /**
     * The setter method of the property strategies.
     * @param thestrategies the strategies to set
     * @author wangds 2015年5月11日 下午2:17:16.
     */
    public void setStrategies(Collection<BizProcStrategy<Object>> strategies) {
        this.strategies = strategies;
    }
    
    /**
     * The getter method of the property strategies.
     * @author wangds 2015年5月11日 下午2:17:18.
     * @return the strategies.
     */
    public Collection<BizProcStrategy<Object>> getStrategies() {
        return strategies;
    }
    /*
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     * @author wangds 2015年5月11日 下午1:05:19.
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
    }

    /*
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     * @author wangds 2015年5月11日 下午1:05:19.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if(this.strategies==null){
            this.strategies = new LinkedList<BizProcStrategy<Object>>();
            this.strategies.add(new SyncAllNoOrderStrategy<Object, Object, Object>());
        }
        if(this.procs==null){
            this.procs = new LinkedList<BizProcedure>();
        }
        if(this.inner==null){
            this.inner = new LinkedList<HttpInteractionBusiness<Object,Object>>();
        }
        if(this.inner.size()==0){
            this.inner.add(new AbstractHttpInteractionBusiness<Object, Object>(){
                @Override
                public void process() throws Exception {
                    this.getLogger().info("This Object is auto created, and process none, please check your spring configuration xml file.");
                }
            });
        }
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     * @author wangds 2015年5月11日 下午1:05:19.
     */
    @Override
    public MultiBizWithHttpMediatorProc<Object, Object, Object, HttpInteractionBusiness<Object, Object>,
    InteractionBizProcStrategyMediator<Object, Object, Object, HttpInteractionBusiness<Object, Object>>> getObject()
            throws Exception {
        MultiBizWithHttpMediatorProc<Object, Object, Object, HttpInteractionBusiness<Object, Object>,
            InteractionBizProcStrategyMediator<Object, Object, Object, HttpInteractionBusiness<Object, Object>>>
            biz = new MultiBizWithHttpMediatorProc<Object, Object, Object, HttpInteractionBusiness<Object, Object>,
                InteractionBizProcStrategyMediator<Object, Object, Object, HttpInteractionBusiness<Object, Object>>>();
        biz.setComponent(inner);
        InteractionBizProcStrategyMediator<Object, Object, Object, HttpInteractionBusiness<Object, Object>>
            mediator = new MediatorAsIaBizProcStg<Object, Object, Object, HttpInteractionBusiness<Object, Object>>();
        biz.setMediator(mediator);
        BizProcStrategyContext<Object> sctx = mediator.getStrategyContext();
        
        if(strategies!=null){
            for(BizProcStrategy<Object> st:strategies){
               sctx.registerStrategy(st);
            }
            
        }
        Collection<BizProcedure> procs = this.procs;
        if(procs!=null){
            for(BizProcedure proc :procs){
                sctx.registorBizProcedure(proc);
            }
        }
        
        return biz;
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     * @author wangds 2015年5月11日 下午1:05:19.
     */
    @Override
    public Class<?> getObjectType() {
        return BizWithHttpMediatorProc.class;
    }

    /*
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     * @author wangds 2015年5月11日 下午1:05:19.
     */
    @Override
    public boolean isSingleton() {
        return false;
    }


}
