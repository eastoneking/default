/*
 * create:2015年4月18日 下午10:56:10
 * author:wangds  
 */
package eastone.json;

import eastone.common.context.BeanAsContext;

/**
 * .
 * @author wangds
 *
 */
public class JsonContext extends BeanAsContext {

    private String jsonString;
    
    private Class<?> targetClass;
    
    private Object target;
    
    /**
     * The setter method of the property jsonString.
     * @param thejsonString the jsonString to set
     * @author wangds 2015年4月18日 下午10:58:02.
     */
    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }
    
    /**
     * The getter method of the property jsonString.
     * @author wangds 2015年4月18日 下午10:58:09.
     * @return the jsonString.
     */
    public String getJsonString() {
        return jsonString;
    }
    
    /**
     * The setter method of the property target.
     * @param thetarget the target to set
     * @author wangds 2015年4月18日 下午10:58:13.
     */
    public <T> void setTarget(T target) {
        this.target = target;
    }
    
    /**
     * The getter method of the property target.
     * @author wangds 2015年4月18日 下午10:58:16.
     * @return the target.
     */
    @SuppressWarnings("unchecked")
    public <T> T getTarget() {
        return (T)target;
    }
    
    /**
     * The setter method of the property targetClass.
     * @param thetargetClass the targetClass to set
     * @author wangds 2015年4月18日 下午10:58:19.
     */
    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }
    
    /**
     * The getter method of the property targetClass.
     * @author wangds 2015年4月18日 下午10:58:22.
     * @return the targetClass.
     */
    public Class<?> getTargetClass() {
        return targetClass;
    }
    
    /*
     * @see eastone.common.context.BeanAsContext#status(java.lang.Object[])
     * @author wangds 2015年4月18日 下午11:01:27.
     */
    @Override
    public <X> X status(Object... inputs){
        try {
            return super.status(inputs);
        } catch (Exception e) {
            return null;
        }
    }
    
}
