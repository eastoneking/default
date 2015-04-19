/*
 * create:2015年4月18日 下午11:31:19
 * author:wangds  
 */
package eastone.json;

import eastone.common.interpreter.Expression;

/**
 * .
 * @author wangds
 *
 * @param <T>
 */
public interface JsonInterpreter<T> extends Expression<JsonContext<T>>{

    /**
     * .
     * @author wangds 2015年4月18日 下午11:13:29.
     * @param json
     * @param clazz 目标类型.
     * <p>为空时默认为HashMap</p>
     * @return
     */
    T json2Object(String json, Class<T> clazz);
    /**
     * .
     * @author wangds 2015年4月19日 下午7:38:08.
     * @param obj
     * @return
     */
    String object2Json(T obj);

}