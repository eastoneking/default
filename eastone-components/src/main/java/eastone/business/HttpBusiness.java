/*
 * create:2015年4月19日 下午8:53:28
 * author:wangds  
 */
package eastone.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * .
 * @author wangds
 *
 */
public interface HttpBusiness extends Business {
    /**
     * .
     * @author wangds 2015年4月19日 下午8:24:43.
     * @param req .
     */
    void setHttpRequest(HttpServletRequest req);
    /**
     * .
     * @author wangds 2015年4月19日 下午8:24:54.
     * @return .
     */
    HttpServletRequest getHttpRequest();
    /**
     * .
     * @author wangds 2015年4月19日 下午8:25:08.
     * @param resp .
     */
    void setHttpResponse(HttpServletResponse resp);
    /**
     * .
     * @author wangds 2015年4月19日 下午8:25:19.
     * @return .
     */
    HttpServletResponse getHttpServletResponse();

}
