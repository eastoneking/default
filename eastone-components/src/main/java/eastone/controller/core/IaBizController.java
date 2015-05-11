/*
 * create:2015年5月11日 下午2:36:52
 * author:wangds  
 */
package eastone.controller.core;

import eastone.business.InteractionBusiness;
import eastone.controller.InteractionController;

/**
 * .
 * @author wangds
 *
 */
public class IaBizController<I, O, B extends InteractionBusiness<I, O>> extends BizController<B> implements InteractionController<I, O> {

    /*
     * @see eastone.controller.InteractionController#setInput(java.lang.Object)
     * @author wangds 2015年5月11日 下午2:39:21.
     */
    @Override
    public void setInput(I input) {
        this.getBusiness().setInput(input);
    }

    /*
     * @see eastone.controller.InteractionController#getInput()
     * @author wangds 2015年5月11日 下午2:39:21.
     */
    @Override
    public I getInput() {
        return this.getBusiness().getInput();
    }

    /*
     * @see eastone.controller.InteractionController#setOutput(java.lang.Object)
     * @author wangds 2015年5月11日 下午2:39:21.
     */
    @Override
    public void setOutput(O output) {
        this.getBusiness().setOutput(output);
    }

    /*
     * @see eastone.controller.InteractionController#getOutput()
     * @author wangds 2015年5月11日 下午2:39:21.
     */
    @Override
    public O getOutput() {
        return this.getBusiness().getOutput();
    }

}
