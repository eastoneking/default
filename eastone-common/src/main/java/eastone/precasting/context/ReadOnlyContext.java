/*
 * create:2015年4月29日 下午8:07:42
 * author:wangds  
 */
package eastone.precasting.context;

import eastone.common.context.Context;
import eastone.precasting.adapter.GeneralAdapter;

/**
 * .
 * @author wangds
 *
 */
public class ReadOnlyContext<C extends Context> extends GeneralAdapter<C> implements Context{
    /**
     * The constructor of ReadOnlyContext.
     * @author wangds 2015年4月29日 下午8:13:49.
     */
    public ReadOnlyContext() {
        super();
    }
    public ReadOnlyContext(C inner){
        super(inner);
    }

    /*
     * @see eastone.common.context.Context#status(java.lang.Object[])
     * @author wangds 2015年4月29日 下午8:09:26.
     */
    @Override
    public <T> T status(Object... inputs) throws Exception {
        T res = null;
        if(inputs.length>=2){
            res = this.status(new Object[]{inputs[0]});
        }else{
            res = this.getAdaptee().status(inputs);
        }
        return res;
    }

}
