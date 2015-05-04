/*
 * create:2015年5月1日 下午7:18:49
 * author:wangds  
 */
package eastone.business.mediator;

import eastone.business.Business;
import eastone.business.IaBizProcedure;

/**
 * .
 * @author wangds
 *
 */
public interface InteractionMediator<I,O, B extends Business>
    extends BizMediator<B>, IaBizProcedure<I, O>{

}
