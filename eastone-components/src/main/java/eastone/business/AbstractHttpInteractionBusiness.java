/*
 * create:2015年4月19日 下午9:02:01
 * author:wangds  
 */
package eastone.business;

import eastone.common.context.DefaultMapAsEnvironment;
import eastone.common.context.Environment;

/**
 * 抽象Http交互业务.
 * @author wangds
 *
 */
public abstract class AbstractHttpInteractionBusiness<IN,OUT> extends AbstractHttpBusiness implements HttpInteractionBusiness<IN, OUT> {


    private Environment ctx = new DefaultMapAsEnvironment();
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
    

    /*
     * @see eastone.common.context.Context#status(java.lang.Object[])
     * @author wangds 2015年5月1日 下午10:27:22.
     */
    @Override
    public <T> T status(Object... args) throws Exception {
        return this.ctx.status(args);
    }
    /*
     * @see eastone.common.context.Environment#getEnvironment(java.lang.String)
     * @author wangds 2015年5月1日 下午10:31:11.
     */
    @Override
    public <T> T getEnvironment(String key) {
        return ctx.getEnvironment(key);
    }
    /*
     * @see eastone.common.context.Environment#setEnvironment(java.lang.String, java.lang.Object)
     * @author wangds 2015年5月1日 下午10:31:11.
     */
    @Override
    public <T> void setEnvironment(String key, T value) {
        this.ctx.setEnvironment(key, value);
    }


}
