/*
 * create:2015年12月5日 下午10:29:55
 * author:wangds  
 */
package eastone.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.slf4j.Logger;

import eastone.common.GeneralParentObject;
import eastone.common.processor.AbstractProcessorWithResult;
import eastone.common.utils.CloseableUtils;

/**
 * .
 * @author wangds
 *
 */
public class BufferedImage2BytesProcessor extends AbstractProcessorWithResult<byte[]>{

    public static final String TYPE_PNG = "png";
    public static final String TYPE_JPG = "jpg";
    public static final String TYPE_GIF = "gif";
    private BufferedImage image;
    private String type = "png";
    
    public BufferedImage2BytesProcessor(){
        super();
    }
    
    /**
     * The constructor of BufferedImage2BytesProcessor.
     * @author wangds 2015年12月5日 下午10:34:34.
     * @param image
     * @param type
     */
    public BufferedImage2BytesProcessor(BufferedImage image, String type) {
        super();
        this.image = image;
        this.type = type;
    }

    /**
     * The getter method of the property type.
     * @author wangds 2015年12月5日 下午10:34:10.
     * @return the type.
     */
    public String getType() {
        return type;
    }

    /**
     * The setter method of the property type.
     * @param thetype the type to set
     * @author wangds 2015年12月5日 下午10:34:10.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The getter method of the property image.
     * @author wangds 2015年12月5日 下午10:33:20.
     * @return the image.
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * The setter method of the property image.
     * @param theimage the image to set
     * @author wangds 2015年12月5日 下午10:33:20.
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /*
     * @see eastone.common.processor.AbstractProcessorWithResult#execute()
     * @author wangds 2015年12月5日 下午10:30:51.
     */
    @Override
    protected byte[] execute() throws Exception {
            byte[] res = null;
            
            ByteArrayOutputStream bas = null;
            try {
                bas = new ByteArrayOutputStream();
                ImageIO.write(image, type, bas);
                bas.flush();
                res = bas.toByteArray();
            } catch (IOException e) {
                Logger log = GeneralParentObject.staticLogger(this.getClass());
                log.error(e.getLocalizedMessage(), e);
            }finally{
                CloseableUtils.close(bas);
            }
            return res;
    }

}
