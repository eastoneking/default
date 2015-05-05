/*
 * create:2015年5月4日 上午10:21:53
 * author:wangds  
 */
package eastone.precasting.context;

import eastone.common.context.DefaultMapAsEnvironment;
import eastone.common.context.InterimContext;

/**
 * .
 * @author wangds
 *
 */
public class InterimMapContext extends DefaultMapAsEnvironment implements InterimContext{

    /*
     * @see eastone.common.Clearable#clear()
     * @author wangds 2015年5月4日 上午10:23:03.
     */
    @Override
    public void clear() {
        this.getAdaptee().clear();
    }

}
