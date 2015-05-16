/*
 * create:2015年5月10日 上午11:11:05
 * author:wangds  
 */
package eastone.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import eastone.business.core.BizWithHttpMediatorProc;
import eastone.business.mediator.InteractionBizProcStrategyMediator;
import eastone.business.mediator.MediatorAsIaBizProcStg;
import eastone.business.strategy.BizProcStrategyContext;
import eastone.business.strategy.SyncAllNoOrderStrategy;
import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;

/**
 * .
 * 
 * @author wangds
 *
 */
public class BizWithHttpMediatorProcTestCase {

    @Test
    public void testNoMediator() throws Exception {
        BizWithHttpMediatorProc<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>, InteractionBizProcStrategyMediator<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>>> biz = new BizWithHttpMediatorProc<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>, InteractionBizProcStrategyMediator<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>>>();
        Assert.assertNotNull(biz);
        TestBiz inner = new TestBiz();
        biz.setComponent(inner);
        biz.process();
    }

    @Test
    public void testMediator() throws Exception {
        BizWithHttpMediatorProc<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>, InteractionBizProcStrategyMediator<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>>> biz = new BizWithHttpMediatorProc<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>, InteractionBizProcStrategyMediator<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>>>();
        Assert.assertNotNull(biz);
        TestBiz inner = new TestBiz();
        biz.setComponent(inner);
        InteractionBizProcStrategyMediator<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>> mediator = new MediatorAsIaBizProcStg<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>>();
        biz.setMediator(mediator);
        biz.setInput(new HashMap<String, Object>());
        biz.process();
        Assert.assertNotNull(biz.getOutput());
    }

    @Test
    public void testWithStrategy() throws Exception {
        BizWithHttpMediatorProc<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>, InteractionBizProcStrategyMediator<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>>> biz = new BizWithHttpMediatorProc<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>, InteractionBizProcStrategyMediator<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>>>();
        Assert.assertNotNull(biz);
        TestBiz inner = new TestBiz();
        biz.setComponent(inner);
        InteractionBizProcStrategyMediator<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>> mediator = new MediatorAsIaBizProcStg<Map<String, Object>, Map<String, Object>, String, HttpInteractionBusiness<Map<String, Object>, Map<String, Object>>>();
        biz.setMediator(mediator);
        SyncAllNoOrderStrategy<Map<String, Object>, Map<String,Object>, String> st = new SyncAllNoOrderStrategy<Map<String, Object>, Map<String,Object>, String>();
        
        
        
        BizProcStrategyContext<String> sctx = mediator.getStrategyContext();
        sctx.registerStrategy(st);
        sctx.registorBizProcedure(new IaBizProcedure<Map<String,Object>, Map<String, Object>>() {

            @Override
            public void beforeProcess() {
                
            }

            @Override
            public void onProcessd() {
                
            }

            @Override
            public void afterProcess() {
                
            }

            @Override
            public <E extends Throwable> void beforeThrowException(E exception) {
                
            }

            @Override
            public <E extends Throwable> void throwedException(E exception) {
                
            }

            @Override
            public <E extends Throwable> void afterThrowException(E exception) {
                
            }

            @Override
            public Map<String, Object> beforeChangeInput(Map<String, Object> newValue, Map<String, Object> oldValue) {
                return newValue;
            }

            @Override
            public void onChangedInput(Map<String, Object> newValue, Map<String, Object> oldValue) {
                
            }

            @Override
            public void afterChangedInput(Map<String, Object> newValue, Map<String, Object> oldValue) {
                
            }

            @Override
            public Map<String, Object> beforeChangeOutput(Map<String, Object> newValue, Map<String, Object> oldValue) {
                newValue.put("checkpoint", true);
                return newValue;
            }

            @Override
            public void onChangedOutput(Map<String, Object> newValue, Map<String, Object> oldValue) {
                
            }

            @Override
            public void afterChangedOutput(Map<String, Object> newValue, Map<String, Object> oldValue) {
                
            }});

        
        biz.setInput(new HashMap<String, Object>());
        biz.process();
        Map<String, Object> out = biz.getOutput();
        assertNotNull(out);
        assertNotNull(out.get("checkpoint"));
        assertTrue((Boolean)out.get("checkpoint"));

    }
    @SuppressWarnings("unchecked")
    @Test
    public void testFac() throws Exception{
        BeanContext<String> ctx = BeanContextFactory.getBeanContext();
        ctx.appendContext("eastone/business/test/context.xml");
        Object biz = ctx.getBean("testBiz");
        assertNotNull(biz);
        
        assertTrue(biz instanceof InteractionBusiness);
        InteractionBusiness<Object, Object> ib = (InteractionBusiness<Object, Object>)biz;
        ib.setInput(new HashMap<String, Object>());
        ib.process();
        Map<String, Object> out = (Map<String, Object>)ib.getOutput();
        assertNotNull(out);
        assertNotNull(out.get("checkpoint"));
        assertTrue((Boolean)out.get("checkpoint"));

    }
}
