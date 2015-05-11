/*
 * create:2015年4月19日 下午8:53:28
 * author:wangds  
 */
package eastone.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 于HTTP相关的业务接口.
 * <p>提供获得关联的{@linkplain HttpServletRequest}和{@linkplain HttpServletResponse}对象，
 * 从而可以响应从Servlet接入的HTTP请求.</p>
 * @author wangds
 *
 */
public interface HttpBusiness extends Business {
    /**
     * 设置相关的Http请求对象.
     * @author wangds 2015年4月19日 下午8:24:43.
     * @param req .
     */
    void setHttpRequest(HttpServletRequest req);
    /**
     * 获得HttpServletRequest对象.
     * @author wangds 2015年4月19日 下午8:24:54.
     * @return HTTP请求对象.
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
    HttpServletResponse getHttpResponse();

}
