/*
 * create:2015年4月17日 下午4:12:45
 * author:wangds  
 */
package eastone.common.context;

/**
 * 环境接口.
 * @author wangds
 *
 */
public interface Environment extends Context {
    <T> T getEnvironment(String key);
    <T> void setEnvironment(String key, T value);
}
