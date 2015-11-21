/*
 * create:2015年4月17日 下午1:36:09
 * author:wangds  
 */
package eastone.web;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;

import eastone.common.GeneralParentObject;
import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;
import eastone.common.processor.Processor;
import eastone.endpoint.EndPoint;

/**
 * .
 * 
 * @author wangds
 *
 */
public class UriDispatcherServlet extends AbstractAboutUriDispatherServlet {

    /**
     * UriDispatcherServlet.java.
     * 
     * @author wangds 2015年4月17日 下午1:36:28.
     */
    private static final long serialVersionUID = 4546101595483323617L;

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
        int iSepIdx = path.lastIndexOf("/");
        String res = path.substring(iSepIdx+1);
        return res;
    }

    /*
     * @see eastone.web.AbstractAboutUriDispatherServlet#selectProcessor(java.lang.String)
     * @author wangds 2015年5月11日 下午3:14:02.
     */
    @Override
    protected Processor selectProcessor(String contextpath, String strUri) {

        String fnName = null;
        try {
            fnName = parseFnName(strUri);
        } catch (ServletException e) {
            GeneralParentObject.staticLogger(this.getClass()).error(e.getLocalizedMessage(), e);
        }

        BeanContext<?> ctx = BeanContextFactory.getBeanContext();
        if (ctx == null) {
            throw new NullPointerException();
        }
        Processor fn = (EndPoint) ctx.getBean(fnName);
        return fn;
    }

}
