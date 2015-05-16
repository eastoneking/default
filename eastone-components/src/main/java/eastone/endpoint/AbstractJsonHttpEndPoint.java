/*
 * create:2015年4月18日 下午10:28:43
 * author:wangds  
 */
package eastone.endpoint;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import eastone.common.factory.ProviderFactory;
import eastone.json.JsonInterpreter;

/**
 * .
 * @author wangds
 *
 */
public abstract class AbstractJsonHttpEndPoint<R,A> extends AbstractHttpEndPoint{
    private Class<R> reqClass;
    private static final int BYTE_BUFF_LEN = 524288;
    private JsonInterpreter jsonInterpreter = new ProviderFactory().getInstance(JsonInterpreter.class);
    private String charset = "UTF-8";
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
    public void setJsonInterpreter(JsonInterpreter requestJsonInterpreter) {
        this.jsonInterpreter = requestJsonInterpreter;
    }
    /**
     * The getter method of the property requestJsonInterpreter.
     * @author wangds 2015年4月19日 下午7:43:28.
     * @return the requestJsonInterpreter.
     */
    public JsonInterpreter getJsonInterpreter() {
        return jsonInterpreter;
    }
    /**
     * The setter method of the property charset.
     * @param thecharset the charset to set
     * @author wangds 2015年5月16日 上午11:16:28.
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }
    /**
     * The getter method of the property charset.
     * @author wangds 2015年5月16日 上午11:16:35.
     * @return the charset.
     */
    public String getCharset() {
        return charset;
    }
    /*
     * @see eastone.common.processor.Processor#process()
     * @author wangds 2015年4月18日 下午10:30:25.
     */
    @Override
    public void process() throws ServletException {
        HttpServletRequest req = this.getHttpRequest();
        String charset = req.getCharacterEncoding();
        if(StringUtils.isEmpty(charset)){
            charset = this.charset ;
        }
        byte[] data = loadRequestBody(req);
        
        String strReqBody = null;
        try {
            strReqBody = new String(data, charset);
        } catch (UnsupportedEncodingException e) {
            this.getLogger().error(e.getLocalizedMessage(),e);
            throw new ServletException(e.getLocalizedMessage(), e);
        }
        R requestObject = ((JsonInterpreter)(this.jsonInterpreter)).json2Object(strReqBody, this.reqClass);
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
        ServletOutputStream os = null;
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding(this.charset);
            os = resp.getOutputStream();
            os.write(output);
            os.flush();
        } catch (IOException e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        
    }
    /**
     * .
     * @author wangds 2015年4月19日 上午12:03:14.
     * @param answer
     * @return
     */
    protected byte[] handleAnswerObject(A answer) {
        HttpServletRequest req = this.getHttpRequest();
        String charset = req.getCharacterEncoding();
        if(charset==null){
            charset=this.charset;
        }
        String strJson  = null;
        if(answer!=null){
            strJson = this.jsonInterpreter.object2Json(answer);
        }else{
            strJson = this.jsonInterpreter.object2Json(new Object());
        }
        byte[] res = new byte[0];
        try {
            res = strJson.getBytes(this.charset);
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
    protected byte[] loadRequestBody(HttpServletRequest req) {
        ServletInputStream is = null;
        ByteArrayOutputStream buf = null;
        byte[] res = null;
        try {
            is = req.getInputStream();
            buf = new ByteArrayOutputStream();
            int len = 0;
            byte[] tmp = new byte[BYTE_BUFF_LEN];
            while((len=is.read(tmp))>=0){
                buf.write(tmp, 0, len);
            }
            buf.flush();
            res = buf.toByteArray();
        } catch (IOException e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }finally{
            try {
                buf.close();
            } catch (IOException e) {
                this.getLogger().error(e.getLocalizedMessage(),e);
            }
        }
        return res;
    }
}
