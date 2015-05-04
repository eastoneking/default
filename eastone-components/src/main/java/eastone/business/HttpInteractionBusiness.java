/*
 * create:2015年4月19日 下午8:55:38
 * author:wangds  
 */
package eastone.business;

import eastone.common.context.Environment;

/**
 * .
 * @author wangds
 *
 */
public interface HttpInteractionBusiness<IN,OUT> extends HttpBusiness, InteractionBusiness<IN, OUT>, Environment {

}
