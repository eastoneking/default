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
public class SizeImpl<T extends Number> extends GeneralParentObject implements Size<T> {
    /**
     * SizeImpl.java.
     * @author wangds 2015年12月5日 下午8:56:10.
     */
    private static final long serialVersionUID = -7599457617670985409L;
    /**
     * 宽.
     */
    private T width;
    /**
     * 高.
     */
    private T height;
    
    /**
     * The constructor of SizeImpl.
     * @author wangds 2015年12月5日 下午8:57:25.
     */
    public SizeImpl() {
    }
    /**
     * The constructor of SizeImpl.
     * @author wangds 2015年12月5日 下午8:57:16.
     * @param width
     * @param height
     */
    public SizeImpl(T width, T height) {
        this.width = width;
        this.height = height;
    }
    /**
     * The getter method of the property width.
     * @author wangds 2015年12月5日 下午8:55:41.
     * @return the width.
     */
    public T getWidth() {
        return width;
    }
    /**
     * The setter method of the property width.
     * @param thewidth the width to set
     * @author wangds 2015年12月5日 下午8:55:30.
     */
    public void setWidth(T width) {
        this.width = width;
    }
    /**
     * The getter method of the property height.
     * @author wangds 2015年12月5日 下午8:55:51.
     * @return the height.
     */
    public T getHeight() {
        return height;
    }
    /**
     * The setter method of the property height.
     * @param theheight the height to set
     * @author wangds 2015年12月5日 下午8:55:57.
     */
    public void setHeight(T height) {
        this.height = height;
    }
}
