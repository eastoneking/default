/*
 * create:2014年10月12日 下午6:16:37
 * author:wangds  
 */
package eastone.initializer;

import eastone.common.Component;
import eastone.common.chainofresponsibility.Handler;


/**
 * .
 * @author wangds
 *
 */
public interface Initializer
    extends Handler<Initializer>, Component{

}
