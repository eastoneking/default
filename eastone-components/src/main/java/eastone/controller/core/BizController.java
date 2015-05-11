/*
 * create:2015年5月11日 下午2:28:59
 * author:wangds  
 */
package eastone.controller.core;

import eastone.business.Business;
import eastone.controller.Controller;
import eastone.precasting.adapter.GeneralAdapter;

/**
 * .
 * @author wangds
 *
 */
public class BizController<B extends Business> extends GeneralAdapter<B> implements Controller {
    
    public void setBusiness(B biz){
        this.setAdaptee(biz);
    }
    public B getBusiness(){
        return this.getAdaptee();
    }
    /*
     * @see eastone.common.processor.Processor#process()
     * @author wangds 2015年5月11日 下午2:32:35.
     */
    @Override
    public void process() throws Exception {
        B biz = this.getBusiness();
        biz.process();
    }
    
    

}
