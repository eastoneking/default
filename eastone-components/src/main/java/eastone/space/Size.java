/*
 * create:2015年12月5日 下午8:49:31
 * author:wangds  
 */
package eastone.space;

import java.io.Serializable;

/**
 * .
 * @author wangds
 *
 */
public interface Size<T> extends Serializable{

    public void width(T w);
    public T width();
    public void height(T h);
    public T height();
}
