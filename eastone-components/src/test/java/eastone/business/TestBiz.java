/*
 * create:2015年5月10日 上午11:03:04
 * author:wangds  
 */
package eastone.business;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * .
 * 
 * @author wangds
 *
 */
public class TestBiz extends AbstractHttpInteractionBusiness<Map<String, Object>, Map<String, Object>> {

    /*
     * @see eastone.common.processor.Processor#process()
     * 
     * @author wangds 2015年5月10日 上午11:03:15.
     */
    @Override
    public void process() throws Exception {
        Logger.getRootLogger().info("TestBiz.process() starting"); 
        System.out.println("TestBiz.process() starting");
        if (this.getInput() != null) {
            this.setOutput(new HashMap<String, Object>());
        } else {
            this.setOutput(null);
        }
        Logger.getRootLogger().info("TestBiz.prcess() ending");
        System.out.println("TestBiz.process() ending.");
    }

}
