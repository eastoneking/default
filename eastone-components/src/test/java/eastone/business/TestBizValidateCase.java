/*
 * create:2015年5月10日 上午11:05:32
 * author:wangds  
 */
package eastone.business;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * .
 * @author wangds
 *
 */
public class TestBizValidateCase {

    @Test
    public void testTestBiz() throws Exception{
        HttpInteractionBusiness<Map<String, Object>, Map<String, Object>> biz = new TestBiz();
        biz.process();
        Assert.assertNull(biz.getOutput());
        biz.setInput(new HashMap<String, Object>());
        biz.process();
        Assert.assertNotNull(biz.getOutput());
    }

}
