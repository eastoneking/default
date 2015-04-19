/*
 * create:2015年4月18日 下午10:48:48
 * author:wangds  
 */
package eastone.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * .
 * @author wangds
 *
 */
public class GsonExpression<T> extends AbstractJsonExpression<T>  {

    /**
     * .
     * @author wangds 2015年4月18日 下午11:17:03.
     * @param strJson
     * @param targetClass
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    protected T parseJson2Object(String strJson, Class<?> targetClass) {
        T res;
        Gson gson = new GsonBuilder().create();
        res = (T)gson.fromJson(strJson, targetClass);
        return res;
    }

}
