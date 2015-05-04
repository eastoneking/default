/*
 * create:2015年4月19日 下午8:57:14
 * author:wangds  
 */
package eastone.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eastone.common.GeneralParentObject;

/**
 * 抽象HTTP业务.
 * @author wangds
 *
 */
public abstract class AbstractHttpBusiness extends GeneralParentObject implements HttpBusiness {


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
