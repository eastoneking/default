/*
 * create:2015年12月5日 下午9:47:19
 * author:wangds  
 */
package eastone.image;

import org.apache.commons.codec.binary.Base64;

import eastone.common.processor.AbstractProcessorWithResult;

/**
 * .
 * @author wangds
 *
 */
public class Image2UrlStringProcessor extends AbstractProcessorWithResult<String> {

    public static final String TYPE_PNG = "image/png";
    public static final String TYPE_JPG = "image/jpg";
    public static final String TYPE_GIF = "image/gif";
    private static final String DATA_PREFIX = "data:";
    private static final String BASE64_FLAG = ";base64,";
    private static final int LENG_FIX_STRING = DATA_PREFIX.length()+BASE64_FLAG.length();
    private String type;
    private byte[] imageData;
    
    public Image2UrlStringProcessor(String type, byte[] imageData){
        this.type = type;
        this.imageData = imageData;
    }
    /*
     * @see eastone.common.processor.AbstractProcessorWithResult#execute()
     * @author wangds 2015年12月5日 下午9:48:57.
     */
    @Override
    protected String execute() throws Exception {
        String image = Base64.encodeBase64String(imageData);
        StringBuilder buf = new StringBuilder(image.length()+type.length()+LENG_FIX_STRING);
        buf.append(DATA_PREFIX).append(type).append(BASE64_FLAG).append(image);
        return buf.toString();
    }

}
