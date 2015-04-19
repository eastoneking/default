/*
 * create:2015年4月18日 下午11:18:49
 * author:wangds  
 */
package eastone.json;

import java.util.HashMap;

/**
 * .
 * @author wangds
 *
 * @param <T>
 */
public abstract class AbstractJsonExpression<T> implements JsonInterpreter<T>{

    /**
     * The constructor of AbstractJsonExpression.
     * @author wangds 2015年4月18日 下午11:18:49.
     */
    public AbstractJsonExpression() {
        super();
    }

    protected abstract T parseJson2Object(String strJson, Class<?> targetClass);

    @Override
    public void interpreter(JsonContext<T> ctx) {
        Class<?> targetClass = ctx.status("targetClass");
        if(targetClass==null){
            targetClass = HashMap.class;
        }
        String strJson = ctx.status("jsonString");
        T res = null;
        
        res = parseJson2Object(strJson, targetClass);
        
        ctx.status("target",res);
    }

    /*
     * @see eastone.json.JsonInterpreter#json2Object(java.lang.String, java.lang.Class)
     * @author wangds 2015年4月18日 下午11:31:19.
     */
    @Override
    @SuppressWarnings("unchecked")
    public T json2Object(String json, Class<T> clazz) {
        JsonContext<T> ctx = new JsonContext<T>();
        ctx.setJsonString(json);
        ctx.setTargetClass(clazz);
        if(clazz==null){
            clazz=(Class<T>)HashMap.class;
        }
        interpreter(ctx);
        return ctx.getTarget();
    }

}