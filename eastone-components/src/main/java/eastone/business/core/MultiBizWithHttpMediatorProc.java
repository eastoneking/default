package eastone.business.core;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eastone.business.AbstractHttpInteractionBusiness;
import eastone.business.HttpInteractionBusiness;
import eastone.business.mediator.InteractionBizProcStrategyMediator;
import eastone.common.context.Environment;
import eastone.common.decorator.Decorator;

/**
 * .
 * 
 * @author wangds
 *
 * @param <I>
 *            .
 * @param <O>
 *            .
 * @param <K>
 *            .
 */
public class MultiBizWithHttpMediatorProc<I, O, K, B extends HttpInteractionBusiness<I, O>, M extends InteractionBizProcStrategyMediator<I, O, K, ? super HttpInteractionBusiness<I, O>>>
        extends AbstractHttpInteractionBusiness<I, O> implements Decorator<Collection<B>>, Environment {
    private Collection<B> comp;
    private M mediator;
    private Exception currentException;
    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;
    private I input;
    private O output;

    /**
     * The setter method of the property mediator.
     * 
     * @param themediator
     *            the mediator to set
     * @author wangds 2015年5月1日 下午9:12:42.
     */
    public void setMediator(M mediator) {
        this.mediator = mediator;
        this.mediator.setBusiness(this);
    }

    /**
     * The getter method of the property mediator.
     * 
     * @author wangds 2015年5月1日 下午9:12:48.
     * @return the mediator.
     */
    public M getMediator() {
        return mediator;
    }

    /*
     * @see eastone.common.decorator.Decorator#getComponent()
     * 
     * @author wangds 2015年5月1日 下午9:15:55.
     */
    @Override
    public Collection<B> getComponent() {
        return this.comp;
    }

    /*
     * @see eastone.common.decorator.Decorator#setComponent(java.lang.Object)
     * 
     * @author wangds 2015年5月1日 下午9:15:55.
     */
    @Override
    public void setComponent(Collection<B> component) {
        this.comp = component;
    }

    /*
     * @see eastone.business.AbstractHttpBusiness#getHttpRequest()
     * 
     * @author wangds 2015年5月1日 下午9:18:14.
     */
    @Override
    public HttpServletRequest getHttpRequest() {
        return this.httpRequest;
    }

    /*
     * @see
     * eastone.business.AbstractHttpBusiness#setHttpRequest(javax.servlet.http
     * .HttpServletRequest)
     * 
     * @author wangds 2015年5月1日 下午9:18:21.
     */
    @Override
    public void setHttpRequest(HttpServletRequest req) {
        this.httpRequest = req;
    }

    /*
     * @see eastone.business.AbstractHttpBusiness#getHttpServletResponse()
     * 
     * @author wangds 2015年5月1日 下午9:18:28.
     */
    @Override
    public HttpServletResponse getHttpResponse() {
        return this.httpResponse;
    }

    /*
     * @see
     * eastone.business.AbstractHttpBusiness#setHttpResponse(javax.servlet.http
     * .HttpServletResponse)
     * 
     * @author wangds 2015年5月1日 下午9:18:32.
     */
    @Override
    public void setHttpResponse(HttpServletResponse resp) {
        this.httpResponse = resp;
    }

    /*
     * @see eastone.business.AbstractHttpInteractionBusiness#getInput()
     * 
     * @author wangds 2015年5月1日 下午9:18:37.
     */
    @Override
    public I getInput() {
        return this.input;
    }

    /*
     * @see
     * eastone.business.AbstractHttpInteractionBusiness#setInput(java.lang.Object
     * )
     * 
     * @author wangds 2015年5月1日 下午9:18:42.
     */
    @Override
    public void setInput(I input) {
        I old = this.getInput();
        try {
            if (this.mediator != null) {
                input = this.mediator.beforeChangeInput(input, old);
            }
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        this.input = input;
        try {
            if (this.mediator != null) {
                this.mediator.onChangedInput(input, old);
            }
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        try {
            if (this.mediator != null) {
                this.mediator.afterChangedInput(input, old);
            }
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.AbstractHttpInteractionBusiness#getOutput()
     * 
     * @author wangds 2015年5月1日 下午9:18:47.
     */
    @Override
    public O getOutput() {
        return this.output;
    }

    /*
     * @see
     * eastone.business.AbstractHttpInteractionBusiness#setOutput(java.lang.
     * Object)
     * 
     * @author wangds 2015年5月1日 下午9:18:51.
     */
    @Override
    public void setOutput(O output) {
        O old = this.getOutput();
        try {
            if (this.mediator != null) {
                output = this.mediator.beforeChangeOutput(output, old);
            }
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        this.output = output;
        try {
            if (this.mediator != null) {
                this.mediator.onChangedOutput(output, old);
            }
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        try {
            if (this.mediator != null) {
                this.mediator.afterChangedOutput(output, old);
            }
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.common.processor.Processor#process()
     * 
     * @author wangds 2015年5月1日 下午9:13:00.
     */
    @Override
    public void process() throws Exception {
        this.currentException = null;
        for (B cur : this.comp) {
            cur.setInput(this.getInput());
            try {
                if (this.mediator != null) {
                    this.mediator.beforeProcess();
                }
                cur.process();
                if (this.mediator != null) {
                    this.mediator.onProcessd();
                }
                O out = cur.getOutput();
                this.setOutput(out);
            } catch (Exception e) {
                if (this.mediator != null) {
                    this.mediator.beforeThrowException(e);
                }
                this.currentException = e;
                throw e;
            } finally {
                try {
                    if (this.mediator != null) {
                        this.mediator.afterProcess();
                    }
                } catch (Exception e) {
                    this.getLogger().error(e.getLocalizedMessage(), e);
                }
                if (this.currentException != null) {
                    Exception e = this.currentException;
                    this.currentException = null;
                    this.mediator.throwedException(e);
                    this.mediator.afterThrowException(e);
                }
            }
        }
    }
}
