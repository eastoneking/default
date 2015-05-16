/*
 * create:2015年5月11日 下午3:08:44
 * author:wangds  
 */
package eastone.web;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
    
    /**
     * The setter method of the property processorMap.
     * @param theprocessorMap the processorMap to set
     * @author wangds 2015年5月16日 上午12:12:37.
     */
    public void setProcessorMap(Map<String, String> processorMap) {
        this.processorMap = processorMap;
    }
    /**
     * The getter method of the property processorMap.
     * @author wangds 2015年5月16日 上午12:12:43.
     * @return the processorMap.
     */
    public Map<String, String> getProcessorMap() {
        return processorMap;
    }
    /*
     * @see eastone.web.AbstractAboutUriDispatherServlet#selectProcessor(java.lang.String)
     * @author wangds 2015年5月11日 下午3:16:53.
     */
    @Override
    protected Processor selectProcessor(String contentPath, String uri) {
        Processor res = null;
        if(uri.startsWith(contentPath)){
            uri = uri.substring(contentPath.length());
        }
        String beanId = this.processorMap.get(uri);
        if(logger.isDebugEnabled()){
            StringBuffer sb = new StringBuffer(12+uri.length()+(beanId==null?4:beanId.length()));
            sb.append("URI:")
                .append(uri)
                .append(";beanId:")
                .append(beanId);
            logger.debug(sb.toString());
        }
        if(StringUtils.isNotEmpty(beanId)){
            res = (Processor)BeanContextFactory.getBeanContext().getBean(beanId);
        }else{
            
        }
        return res;
    }

}
