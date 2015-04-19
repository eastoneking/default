/*
 * create:2015年4月17日 下午3:28:39
 * author:wangds  
 */
package eastone.endpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * .
 * @author wangds
 *
 */
public interface HttpEndPoint extends EndPoint {
    /**
     * .
     * @author wangds 2015年4月17日 下午3:30:40.
     * @param req http请求.
     */
    void setHttpRequest(HttpServletRequest req);
    
    /**
     * .
     * @author wangds 2015年4月17日 下午3:31:44.
     * @param resp http应答.
     */
    void setHttpResponse(HttpServletResponse resp);
    /**
     * .
     * @author wangds 2015年4月17日 下午3:33:55.
     * @return .
     */
    HttpServletRequest getHttpRequest();
    /**
     * .
     * @author wangds 2015年4月17日 下午3:34:06.
     * @return .
     */
    HttpServletResponse getHttpResponse();
    
}
