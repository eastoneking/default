/*
 * create:2015年4月19日 下午8:43:04
 * author:wangds  
 */
package eastone.endpoint;

import eastone.controller.HttpInteractionController;

/**
 * .
 * @author wangds
 *
 */
public class HttpJsonInteractionControllerEndPoint<R, A> extends AbstractJsonHttpEndPoint<R, A>
implements WithControllerEndPoint<HttpInteractionController<R,A>>{

    private HttpInteractionController<R, A> ctrl = null;
    
    /*
     * @see eastone.common.adapter.Adapter#getAdaptee()
     * @author wangds 2015年4月19日 下午8:48:48.
     */
    @Override
    public HttpInteractionController<R, A> getAdaptee() {
        return ctrl;
    }
    public void setAdaptee(HttpInteractionController<R, A> controller){
        this.ctrl=controller;
    }
    /**
     * The setter method of the property ctrl.
     * @param thectrl the ctrl to set
     * @author wangds 2015年4月19日 下午8:50:19.
     */
    public void setController(HttpInteractionController<R, A> ctrl) {
        setAdaptee(ctrl);
    }
    /**
     * The getter method of the property ctrl.
     * @author wangds 2015年4月19日 下午8:50:35.
     * @return the ctrl.
     */
    public HttpInteractionController<R, A> getController() {
        return getAdaptee();
    }
    /*
     * @see eastone.endpoint.AbstractJsonHttpEndPoint#process(java.lang.Object)
     * @author wangds 2015年4月19日 下午8:43:10.
     */
    @Override
    protected A process(R input) {
        A res = null;
        ctrl.setHttpRequest(this.getHttpRequest());
        ctrl.setHttpResponse(this.getHttpResponse());
        ctrl.setInput(input);
        try {
            ctrl.process();
            res = ctrl.getOutput();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }

}
