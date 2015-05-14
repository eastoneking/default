/*
 * create:2015年5月11日 下午3:09:32
 * author:wangds  
 */
package eastone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eastone.common.GeneralParentObject;
import eastone.common.processor.Processor;
import eastone.endpoint.HttpEndPoint;

/**
 * .
 * @author wangds
 *
 */
public abstract class AbstractAboutUriDispatherServlet extends HttpServlet{


    /**
     * AbstractAboutUriDispatherServlet.java.
     * @author wangds 2015年5月11日 下午3:13:51.
     */
    private static final long serialVersionUID = -5831509130595884957L;

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
        
        Processor fn = null;
        
        fn = selectProcessor(strUri);
        
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
     * @author wangds 2015年5月11日 下午3:13:17.
     * @param strUri
     * @return
     */
    abstract protected Processor selectProcessor(String strUri);

}
