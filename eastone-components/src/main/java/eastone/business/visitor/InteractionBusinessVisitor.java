/*
 * create:2015年4月25日 下午7:10:42
 * author:wangds  
 */
package eastone.business.visitor;

import eastone.business.IaBizProcedure;
import eastone.common.context.Context;

/**
 * .
 * @author wangds
 *
 * @param <IN>
 * @param <OUT>
 */
public interface InteractionBusinessVisitor<IN,OUT, C extends Context> extends BizVisitor<C>, IaBizProcedure<IN, OUT>{

}
