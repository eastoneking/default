/*
 * create:2015年4月19日 下午8:58:48
 * author:wangds  
 */
package eastone.business;

import eastone.common.GeneralParentObject;

/**
 * 抽象交互业务.
 * @author wangds
 *
 */
public abstract class AbstractInteractionBusiness<IN,OUT> extends GeneralParentObject implements InteractionBusiness<IN, OUT> {
    private IN input;
    private OUT output;

    /*
     * @see eastone.controller.InteractionController#setInput(java.lang.Object)
     * 
     * @author wangds 2015年4月19日 下午8:36:01.
     */
    @Override
    public void setInput(IN input) {
        this.input = input;
    }

    /*
     * @see eastone.controller.InteractionController#getInput()
     * 
     * @author wangds 2015年4月19日 下午8:36:22.
     */
    @Override
    public IN getInput() {
        return this.input;
    }

    /*
     * @see eastone.controller.InteractionController#setOutput(java.lang.Object)
     * 
     * @author wangds 2015年4月19日 下午8:36:39.
     */
    @Override
    public void setOutput(OUT output) {
        this.output = output;
    }
    /*
     * @see eastone.controller.InteractionController#getOutput()
     * @author wangds 2015年4月19日 下午8:36:58.
     */
    @Override
    public OUT getOutput() {
        return output;
    }
}
