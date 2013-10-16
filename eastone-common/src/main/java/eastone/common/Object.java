package eastone.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 基础对象类.
 * <p>该类是对{@link java.lang.Object}的扩展.目前扩展的功能只有日志接口.</p>
 * <p>修改列表:
 * <ol><li> 补充注释. wangds@gmail.com 2013-10-13 00:10</li></ol>
 * </p>
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1 
 * @since 0.1
 */
public class Object{
	/**
	 * 通用日志对象.
	 * <p>因为要给子类使用，所以定义成了保护级别.</p>
	 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获得静态块或方法中能够使用的日志对象.
     * @param c 调用日志的类的类型.
     * @return 日志对象.
     */
    protected final static Logger staticLogger(Class<?> c){
    	if(c==null){
    		c = eastone.common.Object.class;
    	}
    	Logger res = LoggerFactory.getLogger(c);
    	assert res!=null;
    	return res;
    }
    

}
