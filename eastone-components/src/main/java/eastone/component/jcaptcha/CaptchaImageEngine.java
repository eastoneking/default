/*
 * create:2015年12月5日 下午8:23:16
 * author:wangds  
 */
package eastone.component.jcaptcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;

import com.jhlabs.image.WaterFilter;
import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.deformation.ImageDeformation;
import com.octo.captcha.component.image.deformation.ImageDeformationByFilters;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.LineTextDecorator;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.DeformedComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.ImageCaptcha;
import com.octo.captcha.image.ImageCaptchaFactory;
import com.octo.captcha.image.gimpy.GimpyFactory;

import eastone.space.Size;
import eastone.space.SizeImpl;

/**
 * .
 * 
 * @author wangds
 *
 */
public class CaptchaImageEngine extends ListImageCaptchaEngine implements ImageCodeEngine {


    /**
     * 备选字体.
     * <p>
     * Arial,Tahoma,Verdana,Helvetica,宋体,黑体,幼圆.
     * </p>
     */
    private static Font[] FONTS = new Font[] { new Font("Arial", 0, 15), new Font("Tahoma", 0, 15), new Font("Verdana", 0, 15), new Font("Helvetica", 0, 15),
            new Font("宋体", 0, 15), new Font("黑体", 0, 15), new Font("幼圆", 0, 15) };

    private String code = "";
    private ImageCaptchaFactory imageFac = null;
    private int width = 140;
    private int height = 45;
    
    /**
     * The constructor of CaptchaImageEngine.
     * @author wangds 2015年12月5日 下午8:31:59.
     */
    public CaptchaImageEngine() {
        super();
        this.imageFac = this.getImageCaptchaFactory();
    }
    
    
    /*
     * @see eastone.component.jcaptcha.ImageCodeEngine#getCode()
     * @author wangds 2015年12月5日 下午10:37:42.
     */
    @Override
    public String getCode() {
        return code;
    }
    
    /*
     * @see eastone.component.jcaptcha.ImageCodeEngine#fetchNewImage()
     * @author wangds 2015年12月5日 下午10:37:42.
     */
    @Override
    public synchronized BufferedImage fetchNewImage(){
        ImageCaptcha ic =  imageFac.getImageCaptcha();
        BufferedImage res = ic.getImageChallenge();
        return res;
    }
    
    /*
     * @see eastone.component.jcaptcha.ImageCodeEngine#fetchSize()
     * @author wangds 2015年12月5日 下午10:37:42.
     */
    @Override
    public Size<Integer> fetchSize(){
        return new SizeImpl<Integer>(width, height);
    }


    /**
     * The setter method of the property code.
     * @param thecode the code to set
     * @author wangds 2015年12月5日 下午8:28:57.
     */
    public void setCode(String code) {
        this.code = code;
    }


    protected void buildInitialFactories() {

        // build filters
        WaterFilter water = new WaterFilter();

        water.setAmplitude(3.0d);
        water.setAntialias(true);
        water.setPhase(20.0d);
        water.setWavelength(70.0d);

        ImageDeformation backDef = new ImageDeformationByFilters(new ImageFilter[] {});
        ImageDeformation textDef = new ImageDeformationByFilters(new ImageFilter[] {});
        ImageDeformation postDef = new ImageDeformationByFilters(new ImageFilter[] { water });

        WordGenerator dictionnaryWords = new RandomWordGenerator("023456789") {
            /**
             * 返回生成的随机字符.
             * @author wangds 2015年12月5日 下午6:42:25.
             */
            @Override
            public String getWord(Integer arg0) {
                String res = super.getWord(arg0);
                code = res;
                return res;
            }
        };

        RandomRangeColorGenerator colors = new RandomRangeColorGenerator(new int[] { 0, 150 }, new int[] { 0, 150 }, new int[] { 0, 150 });
        // 设置字符以及干扰线
        RandomRangeColorGenerator lineColors = new RandomRangeColorGenerator(new int[] { 150, 255 }, new int[] { 150, 255 }, new int[] { 150, 255 });
        TextPaster randomPaster = new DecoratedRandomTextPaster(new Integer(4), new Integer(6), colors, true, new TextDecorator[] { new LineTextDecorator(
                new Integer(1), lineColors) });
        BackgroundGenerator back = new UniColorBackgroundGenerator(new Integer(width), new Integer(height), Color.white);
        FontGenerator shearedFont = new RandomFontGenerator(new Integer(30), new Integer(0), FONTS);
        
        WordToImage word2image;
        word2image = new DeformedComposedWordToImage(shearedFont, back, randomPaster, backDef, textDef, postDef);

        this.addFactory(new GimpyFactory(dictionnaryWords, word2image));

    }

}
