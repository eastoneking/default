/*
 * create:2015年4月17日 下午3:43:31
 * author:wangds  
 */
package eastone.endpoint;

import eastone.controller.Controller;

/**
 * .
 * @author wangds
 *
 */
public interface WithControllerEndPoint<C extends Controller> extends EndPoint{

    void setController(C ctrl);
    C getController();

}
