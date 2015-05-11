/*
 * create:2015年5月11日 下午2:41:20
 * author:wangds  
 */
package eastone.controller.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eastone.business.HttpInteractionBusiness;
import eastone.controller.HttpInteractionController;

/**
 * .
 * @author wangds
 *
 */
public class HttpIaBizController<I, O, B extends HttpInteractionBusiness<I, O>> extends IaBizController<I,O,B> implements HttpInteractionController<I, O>{

    /*
     * @see eastone.controller.HttpController#setHttpRequest(javax.servlet.http.HttpServletRequest)
     * @author wangds 2015年5月11日 下午2:42:21.
     */
    @Override
    public void setHttpRequest(HttpServletRequest req) {
        this.getBusiness().setHttpRequest(req);
    }

    /*
     * @see eastone.controller.HttpController#getHttpRequest()
     * @author wangds 2015年5月11日 下午2:42:21.
     */
    @Override
    public HttpServletRequest getHttpRequest() {
        return this.getBusiness().getHttpRequest();
    }

    /*
     * @see eastone.controller.HttpController#setHttpResponse(javax.servlet.http.HttpServletResponse)
     * @author wangds 2015年5月11日 下午2:42:21.
     */
    @Override
    public void setHttpResponse(HttpServletResponse resp) {
        this.getBusiness().setHttpResponse(resp);
    }

    /*
     * @see eastone.controller.HttpController#getHttpServletResponse()
     * @author wangds 2015年5月11日 下午2:42:21.
     */
    @Override
    public HttpServletResponse getHttpServletResponse() {
        return this.getBusiness().getHttpResponse();
    }

}
