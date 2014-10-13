/*
 * create:2014年10月5日 下午1:47:57
 * author:wangds  
 */
package eastone.common.context;



import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.math3.exception.OutOfRangeException;

import eastone.common.GeneralParentObject;

/**
 * .
 * @author wangds
 *
 */
public class BeanAsContext extends GeneralParentObject implements Context {

    /*
     * @see eastone.common.context.Context#status(java.lang.Object[])
     * @author wangds 2014年10月5日 下午1:47:58.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T status(Object... inputs) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object res = null;
        int inputsLen = inputs.length;
        if(inputsLen==1){
            String propName = inputs[0].toString();
            res = BeanUtils.getProperty(this, propName);
        } else if(inputsLen>1) {
            String propName = inputs[0].toString();
            Object value = null;
            if(inputsLen==2){
                value = inputs[1];
            }else{
                value = new Object[inputsLen-1];
                System.arraycopy(inputs, 1, value, 0, inputsLen-1);
            }
            BeanUtils.setProperty(this, propName, value);
            res = value;
        } else {
            throw new OutOfRangeException(1, 0, 0);
        }
        return (T)res;
    }

}
