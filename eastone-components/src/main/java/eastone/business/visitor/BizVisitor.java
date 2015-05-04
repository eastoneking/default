/*
 * create:2015年4月25日 下午6:46:52
 * author:wangds  
 */
package eastone.business.visitor;

import eastone.business.BizProcedure;
import eastone.common.context.Context;
import eastone.common.visitor.Visitor;

/**
 * 业务过程访问者.
 * @author wangds
 *
 */
public interface BizVisitor<C extends Context> extends Visitor, BizProcedure{
    C getContext();
    void setContext(C context);
}
