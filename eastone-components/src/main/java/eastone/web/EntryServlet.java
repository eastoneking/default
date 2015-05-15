/*
 * create:2015年5月15日 上午1:21:50
 * author:wangds  
 */
package eastone.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import eastone.common.GeneralParentObject;
import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;
import eastone.common.proxy.Proxy;
import eastone.json.JsonInterpreter;
import eastone.json.fac.JsonInpProvFactory;

/**
 * 入口Servlet.
 * <p>
 * 接入请求，并且通过应用程序中的Bean上下文找到业务对应的Servlet，代理该Servlet的功能.<br/>
 * 注：不直接使用业务Servlet的原因是为了通过Spring配置文件对业务Servlet进行初始化。仅仅通过
 * web.xml没有办法再初始化过程中使用Spring容器中的对象，或者实现起来非常丑陋，比如：需要约定各种
 * bean的命名，导致web.xml和spring上下文偶合度极高，因而不采用这样的方案。
 * </p>
 * @author wangds@gmail.com
 */
public class EntryServlet extends GenericServlet implements Proxy<Servlet> {

    /**
     * InterestServlet.java.
     * @author wangds 2015年5月15日 上午1:21:55.
     */
    private static final long serialVersionUID = 6301138686785933708L;
    /**
     * 日志对象.
     */
    private static final Logger logger = GeneralParentObject.staticLogger(EntryServlet.class);
    /**
     * 是否支持get方式的请求.
     */
    private boolean enableGet = false;
    /**
     * 业务Servlet再Spring容器中的BeanId。
     */
    private String beanId = "";
    
    /*
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     * @author wangds 2015年5月15日 上午1:39:01.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.enableGet = BooleanUtils.toBoolean(config.getInitParameter("enableGet"));
        this.beanId = StringUtils.trim(config.getInitParameter("beanId"));
    }

    /*
     * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     * @author wangds 2015年5月15日 上午1:24:41.
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //检查请求是否为HTTP请求
        if(req instanceof HttpServletRequest){
            HttpServletRequest request = (HttpServletRequest)req;
            if("GET".equalsIgnoreCase(request.getMethod())&&!this.enableGet){
                if(logger.isInfoEnabled()){
                    BeanContext<?> ctx = BeanContextFactory.getBeanContext();
                    String msg = ctx.getMessage("EntryServlet.service.0", Locale.getDefault(), request.getRequestURI());
                    this.log(msg);
                    logger.info(msg);
                    if(res instanceof HttpServletResponse){
                        handleGetNotPass(request,(HttpServletResponse)res);
                    }
                }
                return;
            }
            try{
                this.getSubject().service(req, res);
            }catch(Exception e){
                this.log(e.getLocalizedMessage(), e);
            }
        }else{
            //非HTTP请求时记录主机和端口
            BeanContext<?> ctx = BeanContextFactory.getBeanContext();
            String msg = ctx.getMessage("EntryServlet.service.1", Locale.getDefault(), req.getRemoteAddr(), req.getRemotePort());
            log(msg);
            logger.info(msg);
        }
        
    }

    /**
     * .
     * @author wangds 2015年5月15日 下午11:04:23.
     * @param req 
     * @param res
     */
    private void handleGetNotPass(HttpServletRequest req, HttpServletResponse res) {
        BeanContext<?> ctx = BeanContextFactory.getBeanContext();
        String msg = ctx.getMessage("EntryServlet.service.0", res.getLocale(), req.getRequestURI());
        JsonInterpreter jip = new JsonInpProvFactory().getInstance();
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("msg", msg);
        msg = jip.object2Json(obj);
        res.setCharacterEncoding(req.getCharacterEncoding());
        res.setContentType("application/json");
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            os.write(msg.getBytes(res.getCharacterEncoding()));
            os.flush();
        } catch (IOException e) {
            if(logger.isErrorEnabled()){
                logger.error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.common.proxy.Proxy#getSubject()
     * @author wangds 2015年5月15日 下午10:17:33.
     */
    @Override
    public Servlet getSubject() {
        BeanContext<?> ctx = BeanContextFactory.getBeanContext();
        return ctx.getBean(this.beanId);
    }

    /*
     * @see eastone.common.proxy.Proxy#setSubject(java.lang.Object)
     * @author wangds 2015年5月15日 下午10:17:33.
     */
    @Override
    public void setSubject(Servlet servlet) {
        if(logger.isDebugEnabled()){
            BeanContext<?> ctx = BeanContextFactory.getBeanContext();
            String msg = ctx.getMessage("EntryServlet.setSubject.0", Locale.getDefault());
            logger.debug(msg);
        }
    }

}
