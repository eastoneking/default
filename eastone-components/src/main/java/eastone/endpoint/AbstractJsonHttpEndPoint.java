/*
 * create:2015年4月18日 下午10:28:43
 * author:wangds  
 */
package eastone.endpoint;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eastone.json.JsonInterpreter;

/**
 * .
 * @author wangds
 *
 */
public abstract class AbstractJsonHttpEndPoint<R,A> extends AbstractHttpEndPoint{
    private Class<R> reqClass;

    @SuppressWarnings("rawtypes")
    private JsonInterpreter requestJsonInterpreter = null;
    @SuppressWarnings("rawtypes")
    private JsonInterpreter responseJsonInterpreter = null;
    /**
     * The setter method of the property reqClass.
     * @param thereqClass the reqClass to set
     * @author wangds 2015年4月18日 下午11:57:12.
     */
    public void setReqClass(Class<R> reqClass) {
        this.reqClass = reqClass;
    }
    /**
     * The getter method of the property reqClass.
     * @author wangds 2015年4月18日 下午11:57:16.
     * @return the reqClass.
     */
    public Class<R> getReqClass() {
        return reqClass;
    }
    /**
     * The setter method of the property requestJsonInterpreter.
     * @param therequestJsonInterpreter the requestJsonInterpreter to set
     * @author wangds 2015年4月19日 下午7:43:22.
     */
    @SuppressWarnings("rawtypes")
    public void setRequestJsonInterpreter(JsonInterpreter requestJsonInterpreter) {
        this.requestJsonInterpreter = requestJsonInterpreter;
    }
    /**
     * The getter method of the property requestJsonInterpreter.
     * @author wangds 2015年4月19日 下午7:43:28.
     * @return the requestJsonInterpreter.
     */
    @SuppressWarnings("rawtypes")
    public JsonInterpreter getRequestJsonInterpreter() {
        return requestJsonInterpreter;
    }
    /*
     * @see eastone.common.processor.Processor#process()
     * @author wangds 2015年4月18日 下午10:30:25.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void process() throws ServletException {
        HttpServletRequest req = this.getHttpRequest();
        String charset = req.getCharacterEncoding();
        byte[] data = loadRequestBody(req);
        
        String strReqBody = null;
        try {
            strReqBody = new String(data, charset);
        } catch (UnsupportedEncodingException e) {
            this.getLogger().error(e.getLocalizedMessage(),e);
            throw new ServletException(e.getLocalizedMessage(), e);
        }
        R requestObject = ((JsonInterpreter<R>)(this.requestJsonInterpreter)).json2Object(strReqBody, this.reqClass);
        A answer = process(requestObject);
        byte[] output = handleAnswerObject(answer);
        HttpServletResponse resp = this.getHttpResponse();
        writeResponse(resp,output);
    }

    /**
     * .
     * @author wangds 2015年4月19日 上午12:04:57.
     * @param resp
     * @param output
     */
    protected void writeResponse(HttpServletResponse resp, byte[] output) {
        // //TODO: Auto-generated method stub
        
    }
    /**
     * .
     * @author wangds 2015年4月19日 上午12:03:14.
     * @param answer
     * @return
     */
    @SuppressWarnings("unchecked")
    protected byte[] handleAnswerObject(A answer) {
        HttpServletRequest req = this.getHttpRequest();
        String charset = req.getCharacterEncoding();
        String strJson = this.responseJsonInterpreter.object2Json(answer);
        byte[] res = new byte[0];
        try {
            res = strJson.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }
    /**
     * .
     * @author wangds 2015年4月19日 上午12:01:39.
     * @param requestObject
     * @return
     */
    protected abstract A process(R requestObject);
    /**
     * .
     * @author wangds 2015年4月18日 下午10:31:59.
     * @param httpRequest
     * @return
     */
    protected byte[] loadRequestBody(HttpServletRequest httpRequest) {
        // //TODO: Auto-generated method stub
        return null;
    }
}
