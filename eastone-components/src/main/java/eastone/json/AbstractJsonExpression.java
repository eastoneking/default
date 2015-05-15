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
public abstract class AbstractJsonExpression implements JsonInterpreter{

    /**
     * The constructor of AbstractJsonExpression.
     * @author wangds 2015年4月18日 下午11:18:49.
     */
    public AbstractJsonExpression() {
        super();
    }

    protected abstract <T> T parseJson2Object(String strJson, Class<T> targetClass);

    @Override
    public void interpreter(JsonContext ctx) {
        Class<?> targetClass = ctx.status("targetClass");
        if(targetClass==null){
            targetClass = HashMap.class;
        }
        
        String strJson = ctx.status("jsonString");
        Object target = ctx.status("target");
        if(strJson!=null&&target==null){
            Object res = null;
            res = parseJson2Object(strJson, targetClass);
            ctx.status("target",res);
        }else{
            String res = "";
            res = parseObject2Json(target);
            ctx.status("jsonString",res);
        }
    }

    /**
     * .
     * @author wangds 2015年4月19日 下午7:30:52.
     * @param target
     * @return
     */
    protected abstract <T> String parseObject2Json(T target);

    /*
     * @see eastone.json.JsonInterpreter#json2Object(java.lang.String, java.lang.Class)
     * @author wangds 2015年4月18日 下午11:31:19.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T json2Object(String json, Class<T> clazz) {
        JsonContext ctx = new JsonContext();
        ctx.setJsonString(json);
        ctx.setTargetClass(clazz);
        if(clazz==null){
            clazz=(Class<T>)HashMap.class;
        }
        interpreter(ctx);
        return ctx.getTarget();
    }
    
    @SuppressWarnings("unchecked")
    public<T> String object2Json(T object){
        String res = "";
        JsonContext ctx = new JsonContext();
        ctx.setTarget(object);
        ctx.setTargetClass((Class<T>)object.getClass());
        interpreter(ctx);
        res = ctx.getJsonString();
        return res;
    }

}