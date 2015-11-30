/*
 * create:2015年11月30日 下午11:09:31
 * author:wangds  
 */
package eastone.json;

import java.util.HashMap;

import eastone.json.fac.JsonInpProvFactory;

/**
 * JSON操作工具.
 * @author wangds
 *
 */
public class JsonUtil {
    /**
     * 将对象转换为JSON字符串.
     * @author wangds 2015年11月30日 下午11:13:42.
     * @param obj 目标对象.
     * @return 转换后的json格式字符串.
     */
    public static String toJson(Object obj){
        JsonInterpreter ji = new JsonInpProvFactory().getInstance();
        return ji.object2Json(obj);
    }
    /**
     * 将JSON字符串转换为指定类型的对象.
     * @author wangds 2015年11月30日 下午11:14:04.
     * @param json json字符串.
     * @param clz 结果的类型.
     * @return 转换结果.
     */
    public static <T> T toObject(String json, Class<T> clz){
        JsonInterpreter ji = new JsonInpProvFactory().getInstance();
        return ji.json2Object(json, clz);
    }
    /**
     * 将JSON字符串转换为HashMap对象.
     * @author wangds 2015年11月30日 下午11:15:31.
     * @param json 要转换的JSON字符串.
     * @return 转换后的HashMap对象.
     */
    @SuppressWarnings("unchecked")
    public static HashMap<String, Object> toHashMap(String json){
        JsonInterpreter ji = new JsonInpProvFactory().getInstance();
        return (HashMap<String, Object>)ji.json2Object(json, HashMap.class);
    }

}
