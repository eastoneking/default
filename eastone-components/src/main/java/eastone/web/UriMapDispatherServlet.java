/*
 * create:2015年5月11日 下午3:08:44
 * author:wangds  
 */
package eastone.web;

import java.util.Map;

import org.slf4j.Logger;

import eastone.common.GeneralParentObject;
import eastone.common.context.BeanContextFactory;
import eastone.common.processor.Processor;

/**
 * .
 * @author wangds
 *
 */
public class UriMapDispatherServlet extends AbstractAboutUriDispatherServlet{
    /**
     * UriMapDispatherServlet.java.
     * @author wangds 2015年5月11日 下午3:16:58.
     */
    private static final long serialVersionUID = 4531864805291086856L;
    
    private static Logger logger = GeneralParentObject.staticLogger(UriMapDispatherServlet.class);
    
    private Map<String, String> processorMap = null;
    

    /*
     * @see eastone.web.AbstractAboutUriDispatherServlet#selectProcessor(java.lang.String)
     * @author wangds 2015年5月11日 下午3:16:53.
     */
    @Override
    protected Processor selectProcessor(String strUri) {
        Processor res = null;
        String beanid = this.processorMap.get(strUri);
        if(logger.isDebugEnabled()){
            StringBuffer sb = new StringBuffer(12+strUri.length()+(beanid==null?4:beanid.length()));
            sb.append("URI:")
                .append(strUri)
                .append(";beanId:")
                .append(beanid);
            logger.debug(sb.toString());
        }
        res = (Processor)BeanContextFactory.getBeanContext().getBean(beanid);
        return res;
    }

}
