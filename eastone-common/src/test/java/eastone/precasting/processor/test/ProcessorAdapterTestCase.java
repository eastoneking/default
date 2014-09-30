/*
 * create:2014年9月28日 下午7:14:51
 * author:wangds  
 */
package eastone.precasting.processor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import eastone.common.processor.Processor;
import eastone.precasting.processor.ProcessorAdapter;

/**
 * ProcessorAdapter的测试用例.
 * 
 * @author wangds.
 *
 */
public class ProcessorAdapterTestCase {

    /**
     * 测试方法.
     * @author wangds 2014年9月28日 下午7:25:22.
     */
    @Test
    public void test() throws Exception{
        final Map<String, String> res = new HashMap<String, String>();
        ProcessorAdapter<Processor> p = new ProcessorAdapter<Processor>() {
        };
        
        p.process();//测试processor中if条件为false的分支。
        
        Processor inner = new Processor() {
            @Override
            public void process() {
                res.put("result", "result");
            }
        };
        p.setAdaptee(inner);
        p.process();
        assertEquals(res.get("result"), "result");
        assertSame(p.getAdaptee(), inner);
    }

}
