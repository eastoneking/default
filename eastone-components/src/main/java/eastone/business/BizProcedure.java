/*
 * create:2015年4月25日 下午7:06:19
 * author:wangds  
 */
package eastone.business;

import eastone.common.bridge.BridgeImplementor;

/**
 * .
 * @author wangds
 *
 */
public interface BizProcedure extends BridgeImplementor {
    void beforeProcess();
    void onProcessd();
    void afterProcess();
    <E> void beforeThrowException(E exception);
    <E> void throwedException(E exception);
    <E> void afterThrowException(E exception);

}
