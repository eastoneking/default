/*
 * create:2015年5月14日 下午6:54:17
 * author:wangds  
 */
package eastone.controller.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;
import eastone.controller.HttpInteractionController;

/**
 * .
 * @author wangds
 *
 */
public class HttpIaCtrlFactoryTestCase {

    @SuppressWarnings("unchecked")
    @Test
    public void test() throws Exception {
        BeanContext<String> ctx = BeanContextFactory.getBeanContext();
        ctx.appendContext("eastone/Controller/test/context.xml");
        Object biz = ctx.getBean("ctrl");
        assertNotNull(biz);
        
        assertTrue(biz instanceof HttpInteractionController);
        HttpInteractionController<Object, Object> ib = (HttpInteractionController<Object, Object>)biz;
        ib.setInput(new HashMap<String, Object>());
        ib.process();
        Map<String, Object> out = (Map<String, Object>)ib.getOutput();
        assertNotNull(out);
        assertNotNull(out.get("checkpoint"));
        assertTrue((Boolean)out.get("checkpoint"));

    }

}
