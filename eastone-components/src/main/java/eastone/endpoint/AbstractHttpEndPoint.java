/*
 * create:2015年4月17日 下午3:54:19
 * author:wangds  
 */
package eastone.endpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eastone.common.GeneralParentObject;

/**
 * .
 * @author wangds
 *
 */
public abstract class AbstractHttpEndPoint
    extends GeneralParentObject
    implements HttpEndPoint {
    
    private HttpServletRequest request;
    private HttpServletResponse response;

    /*
     * @see eastone.endpoint.HttpEndPoint#setHttpRequest(javax.servlet.http.HttpServletRequest)
     * @author wangds 2015年4月17日 下午3:54:19.
     */
    @Override
    public void setHttpRequest(HttpServletRequest req) {
        this.request = req;
    }

    /*
     * @see eastone.endpoint.HttpEndPoint#setHttpResponse(javax.servlet.http.HttpServletResponse)
     * @author wangds 2015年4月17日 下午3:54:19.
     */
    @Override
    public void setHttpResponse(HttpServletResponse resp) {
        this.response = resp;
    }

    /*
     * @see eastone.endpoint.HttpEndPoint#getHttpRequest()
     * @author wangds 2015年4月17日 下午3:54:19.
     */
    @Override
    public HttpServletRequest getHttpRequest() {
        return this.request;
    }

    /*
     * @see eastone.endpoint.HttpEndPoint#getHttpResponse()
     * @author wangds 2015年4月17日 下午3:54:19.
     */
    @Override
    public HttpServletResponse getHttpResponse() {
        return this.response;
    }
    
    

}
