/*
 * create:2015年12月5日 下午3:56:41
 * author:wangds  
 */
package eastone.component.http;

import javax.servlet.http.HttpServletResponse;

import eastone.common.GeneralParentObject;
import eastone.common.processor.Processor;

/**
 * .
 * @author wangds
 *
 */
public class WriteNoCacheHeader2HttpResponseProcessor extends GeneralParentObject implements Processor {
    /**
     * 被操作的HTTP应答.
     */
    private HttpServletResponse resp;
    /**
     * The constructor of WriteNoCacheHeader2HttpResponseProcessor.
     * @author wangds 2015年12月5日 下午3:59:04.
     * @param resp HTTP应答对象.
     */
    public WriteNoCacheHeader2HttpResponseProcessor(HttpServletResponse resp) {
        assert resp!=null;
        this.resp = resp;
    }
    /*
     * @see eastone.common.processor.Processor#process()
     * @author wangds 2015年12月5日 下午3:57:19.
     */
    @Override
    public void process() {
        if(resp==null){
            return;
        }
        resp.setHeader("Cache-Control", "no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);
    }

}
