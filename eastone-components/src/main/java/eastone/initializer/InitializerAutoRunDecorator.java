/*
 * create:2014年10月12日 下午6:53:44
 * author:wangds  
 */
package eastone.initializer;

import eastone.common.decorator.AbstractDecorator;

/**
 * .
 * @author wangds
 *
 */
public class InitializerAutoRunDecorator<C extends Initializer> extends AbstractDecorator<C> {

    /*
     * @see eastone.common.decorator.AbstractDecorator#setComponent(eastone.common.Component)
     * @author wangds 2014年10月12日 下午6:54:23.
     */
    public void setComponent(C theComponent) {
        if(theComponent==null){
            return;
        }
        try {
            theComponent.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }
}
