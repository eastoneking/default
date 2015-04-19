/*
 * create:2015年4月19日 下午8:31:31
 * author:wangds  
 */
package eastone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eastone.common.GeneralParentObject;

/**
 * .
 * @author wangds
 *
 */
public abstract class AbstractHttpController extends GeneralParentObject implements HttpController {

    private HttpServletRequest req;
    private HttpServletResponse resp;

    /*
     * @see eastone.controller.HttpController#setHttpRequest(javax.servlet.http.HttpServletRequest)
     * @author wangds 2015年4月19日 下午8:31:31.
     */
    @Override
    public void setHttpRequest(HttpServletRequest req) {
        this.req = req;
    }

    /*
     * @see eastone.controller.HttpController#getHttpRequest()
     * @author wangds 2015年4月19日 下午8:31:31.
     */
    @Override
    public HttpServletRequest getHttpRequest() {
        return this.req;
    }

    /*
     * @see eastone.controller.HttpController#setHttpResponse(javax.servlet.http.HttpServletResponse)
     * @author wangds 2015年4月19日 下午8:31:31.
     */
    @Override
    public void setHttpResponse(HttpServletResponse resp) {
        this.resp = resp;
    }

    /*
     * @see eastone.controller.HttpController#getHttpServletResponse()
     * @author wangds 2015年4月19日 下午8:31:31.
     */
    @Override
    public HttpServletResponse getHttpServletResponse() {
        return this.resp;
    }

}
