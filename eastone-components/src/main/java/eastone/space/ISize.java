/*
 * create:2015年12月5日 下午8:54:34
 * author:wangds  
 */
package eastone.space;

import eastone.common.GeneralParentObject;


/**
 * .
 * @author wangds
 *
 */
public class ISize extends GeneralParentObject implements Size<Integer> {
    /**
     * SizeImpl.java.
     * @author wangds 2015年12月5日 下午8:56:10.
     */
    private static final long serialVersionUID = -7599457617670985409L;
    /**
     * 宽.
     */
    private int width;
    /**
     * 高.
     */
    private int height;
    
    /**
     * The constructor of SizeImpl.
     * @author wangds 2015年12月5日 下午8:57:25.
     */
    public ISize() {
    }
    /**
     * The constructor of SizeImpl.
     * @author wangds 2015年12月5日 下午8:57:16.
     * @param width
     * @param height
     */
    public ISize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    /**
     * The getter method of the property width.
     * @author wangds 2015年12月5日 下午8:55:41.
     * @return the width.
     */
    public int getWidth() {
        return width;
    }
    /**
     * The setter method of the property width.
     * @param thewidth the width to set
     * @author wangds 2015年12月5日 下午8:55:30.
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * The getter method of the property height.
     * @author wangds 2015年12月5日 下午8:55:51.
     * @return the height.
     */
    public int getHeight() {
        return height;
    }
    /**
     * The setter method of the property height.
     * @param theheight the height to set
     * @author wangds 2015年12月5日 下午8:55:57.
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /*
     * @see eastone.space.Size#width(java.lang.Object)
     * @author wangds 2015年12月6日 上午12:18:32.
     */
    @Override
    public void width(Integer w) {
        this.setWidth(w);
    }
    /*
     * @see eastone.space.Size#width()
     * @author wangds 2015年12月6日 上午12:18:32.
     */
    @Override
    public Integer width() {
        return this.getWidth();
    }
    /*
     * @see eastone.space.Size#height(java.lang.Object)
     * @author wangds 2015年12月6日 上午12:18:32.
     */
    @Override
    public void height(Integer h) {
        this.setHeight(h);
    }
    /*
     * @see eastone.space.Size#height()
     * @author wangds 2015年12月6日 上午12:18:32.
     */
    @Override
    public Integer height() {
        return this.getHeight();
    }
}
