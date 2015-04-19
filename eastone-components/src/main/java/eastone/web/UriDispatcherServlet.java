/*
 * create:2015年4月17日 下午1:36:09
 * author:wangds  
 */
package eastone.web;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eastone.common.GeneralParentObject;
import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;
import eastone.endpoint.EndPoint;
import eastone.endpoint.HttpEndPoint;

/**
 * .
 * 
 * @author wangds
 *
 */
public class UriDispatcherServlet extends HttpServlet {

    /**
     * UriDispatcherServlet.java.
     * 
     * @author wangds 2015年4月17日 下午1:36:28.
     */
    private static final long serialVersionUID = 4546101595483323617L;

    /*
     * @see
     * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     * 
     * @author wangds 2015年4月17日 下午1:36:41.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw new ServletException();
    }

    /*
     * @see
     * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     * 
     * @author wangds 2015年4月17日 下午2:23:33.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strUri = req.getRequestURI();
        String fnName = parseFnName(strUri);

        BeanContext<?> ctx = BeanContextFactory.getBeanContext();
        if (ctx == null) {
            throw new NullPointerException();
        }
        EndPoint fn = (EndPoint) ctx.getBean(fnName);
        if (fn != null) {
            
            if(fn instanceof HttpEndPoint){
                HttpEndPoint httpep = (HttpEndPoint) fn;
                httpep.setHttpRequest(req);
                httpep.setHttpResponse(resp);
            }
            
            try {
                fn.process();
            } catch (Exception e) {
                GeneralParentObject.staticLogger(UriDispatcherServlet.class).error("", e);
                throw new ServletException(e);
            }
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * .
     * 
     * @author wangds 2015年4月17日 下午2:42:20.
     * @param strUri
     * @return
     * @throws ServletException
     */
    private String parseFnName(String strUri) throws ServletException {
        URI uri = null;
        try {
            uri = new URI(strUri);
        } catch (URISyntaxException e) {
            GeneralParentObject.staticLogger(UriDispatcherServlet.class).error("", e);
            throw new ServletException(e);
        }
        String path = uri.getPath();
        int iSepIdx = path.indexOf("/");
        String res = path.substring(iSepIdx);
        return res;
    }

}
