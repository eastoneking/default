/*
 * create:2015年12月5日 下午10:37:42
 * author:wangds  
 */
package eastone.component.jcaptcha;

import java.awt.image.BufferedImage;

import eastone.space.Size;

/**
 * .
 * @author wangds
 *
 */
public interface ImageCodeEngine {

    /**
     * 获得上一次获得的图片中的验证码文本.
     * <p>获得图片之后再使用.</p>
     * @author wangds 2015年12月5日 下午8:28:57.
     * @return the code.
     */
    String getCode();

    BufferedImage fetchNewImage();

    Size<Integer> fetchSize();

}