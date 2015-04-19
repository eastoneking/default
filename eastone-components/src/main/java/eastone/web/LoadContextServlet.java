/*
 * create:2015年4月17日 上午11:50:56
 * author:wangds  
 */
package eastone.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang3.StringUtils;

import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;

/**
 * .
 * @author wangds
 *
 */
public class LoadContextServlet extends HttpServlet {

    /**
     * LoadContextServlet.java.
     * @author wangds 2015年4月17日 下午1:32:22.
     */
    private static final String CONF_SEPERATOR = ",";
    /**
     * LoadContextServlet.java.
     * @author wangds 2015年4月17日 上午11:51:04.
     */
    private static final long serialVersionUID = -8840118642270918871L;
    /**
     * servlet配置中初始化参数的名称.
     */
    private static final String CONF = "conf";

    /*
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     * @author wangds 2015年4月17日 上午11:53:07.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        String confNameString = config.getInitParameter(CONF);
        if(StringUtils.isBlank(confNameString)){
            return;
        }
        String[] confNames = confNameString.split(CONF_SEPERATOR);
        
        BeanContext<String> ctx = BeanContextFactory.getBeanContext();
        
        for(String cur:confNames){
            if(StringUtils.isBlank(cur)){
                continue;
            }
            ctx.appendContext(cur);
        }
    }
}
