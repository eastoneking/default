/*
 * create:2015年5月1日 下午7:19:04
 * author:wangds  
 */
package eastone.business.mediator;

import eastone.business.BizProcedure;
import eastone.business.Business;

/**
 * .
 * @author wangds
 *
 */
public interface BizMediator<B extends Business> extends BizProcedure{

    void setBusiness(B biz);
    B getBusiness();
    
}
