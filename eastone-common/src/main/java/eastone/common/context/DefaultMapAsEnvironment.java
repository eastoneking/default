/*
 * create:2015年4月17日 下午4:18:52
 * author:wangds  
 */
package eastone.common.context;

import java.util.HashMap;
import java.util.Map;

import eastone.common.GeneralParentObject;
import eastone.common.adapter.Adapter;

/**
 * .
 * @author wangds
 *
 */
public class DefaultMapAsEnvironment extends GeneralParentObject 
    implements MapAsEnvironment, Adapter<Map<String, Object>> {
    /**
     * .
     */
    private final Map<String, Object> map = new HashMap<String, Object>();
    /*
     * @see eastone.common.context.Environment#getEnvironment(java.lang.String)
     * @author wangds 2015年4月17日 下午4:18:52.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getEnvironment(String key) {
        return (T)(map.get(key));
    }

    /*
     * @see eastone.common.context.Environment#setEnvironment(java.lang.String, java.lang.Object)
     * @author wangds 2015年4月17日 下午4:18:52.
     */
    @Override
    public <T> void setEnvironment(String key, T value) {
        this.map.put(key, value);
    }

    /*
     * @see eastone.common.context.Context#status(java.lang.Object[])
     * @author wangds 2015年4月17日 下午4:18:52.
     */
    @Override
    public <T> T status(Object... inputs) throws Exception {
        if(inputs==null){
            return null;
        }
        int len = inputs.length;
        if(len==1){
            return this.getEnvironment(inputs[0].toString());
        }else if(len == 2){
            this.setEnvironment(inputs[0].toString(), inputs[2]);
        }else if(len>2){
            Object[] arr = new Object[inputs.length-1];
            System.arraycopy(inputs, 0, arr, 0, arr.length);
            this.setEnvironment(inputs[0].toString(), arr);
        }
        return null;
    }

    /*
     * @see eastone.common.context.MapAsEnvironment#setEnvironmentMap(java.util.Map)
     * @author wangds 2015年4月17日 下午4:18:52.
     */
    @Override
    public void setEnvironmentMap(Map<String, Object> map) {
        // //TODO: Auto-generated method stub

    }

    /*
     * @see eastone.common.context.MapAsEnvironment#getEnvironmentMap()
     * @author wangds 2015年4月17日 下午4:18:52.
     */
    @Override
    public Map<String, Object> getEnvironmentMap() {
        // //TODO: Auto-generated method stub
        return null;
    }
    
    /*
     * @see eastone.common.adapter.Adapter#getAdaptee()
     * @author wangds 2015年4月18日 下午4:35:12.
     */
    @Override
    public Map<String, Object> getAdaptee() {
        return map;
    }

}
