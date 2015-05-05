/*
 * create:2015年5月4日 上午9:56:25
 * author:wangds  
 */
package eastone.common;

/**
 * 可关闭.
 * @author wangds
 *
 */
public interface Closeable extends java.io.Closeable{

    /**
     * 关闭方法.
     */
    void close();

}
