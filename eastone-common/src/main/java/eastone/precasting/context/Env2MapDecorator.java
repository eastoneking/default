/*
 * create:2015年5月5日 下午3:33:41
 * author:wangds  
 */
package eastone.precasting.context;

import java.util.HashMap;
import java.util.Map;

import eastone.common.context.Environment;
import eastone.common.decorator.Decorator;
import eastone.common.strategy.AbstractStrategyContext;
import eastone.common.strategy.Strategy;
import eastone.precasting.context.strategy.MapEnv2MapStrategy;

/**
 * .
 * @author wangds
 *
 */
public class Env2MapDecorator
    extends AbstractStrategyContext<Class<?>>
    implements Decorator<Environment>, Env2Map, Env2MapStrategyContext {

    public Env2MapDecorator(){
        this(new HashMap<Class<?>, Strategy<Class<?>>>());
    }
    /**
     * The constructor of Env2MapDecorator.
     * @author wangds 2015年5月5日 下午3:51:04.
     * @param theStrategyMap
     */
    public Env2MapDecorator(Map<Class<?>, Strategy<Class<?>>> theStrategyMap) {
        super(theStrategyMap);
    }

    private Environment comp;
    private Map<String, Object> map;
    
    /*
     * @see eastone.common.decorator.Decorator#getComponent()
     * @author wangds 2015年5月5日 下午3:34:21.
     */
    @Override
    public Environment getComponent() {
        return this.comp;
    }

    /*
     * @see eastone.common.decorator.Decorator#setComponent(java.lang.Object)
     * @author wangds 2015年5月5日 下午3:34:21.
     */
    @Override
    public void setComponent(Environment component) {
        this.comp = component;
    }
    
    public Map<String, Object> toMap(){
        Map<String, Object> res = null;
        
        this.setSelectedStrategy(comp.getClass());
        this.process();
        res = this.map;
        
        return res;
    }

    /*
     * @see eastone.common.strategy.AbstractStrategyContext#proccessStrategry(eastone.common.strategy.Strategy)
     * @author wangds 2015年5月5日 下午3:50:41.
     */
    @Override
    protected <S extends Strategy<Class<?>>> void proccessStrategry(S strategy) {
        if(strategy==null){
            strategy = this.findStrategy(Environment.class);
        }
        if(strategy==null){
            NullPointerException e = new NullPointerException("not have any suitable strategry.");
            this.getLogger().error(e.getLocalizedMessage(), e);
            throw e;
        }
        strategy.setContext(this);
        ((MapEnv2MapStrategy)strategy).toMap();
    }
    /*
     * @see eastone.precasting.context.Env2MapStrategyContext#setInput(eastone.common.context.Environment)
     * @author wangds 2015年5月5日 下午4:20:03.
     */
    @Override
    public void setInput(Environment env) {
        this.comp = env;
    }
    /*
     * @see eastone.precasting.context.Env2MapStrategyContext#getInput()
     * @author wangds 2015年5月5日 下午4:20:03.
     */
    @Override
    public Environment getInput() {
        return this.comp;
    }
    /*
     * @see eastone.precasting.context.Env2MapStrategyContext#setOutput(java.util.Map)
     * @author wangds 2015年5月5日 下午4:20:03.
     */
    @Override
    public void setOutput(Map<String, Object> map) {
        this.map = map;
    }
    /*
     * @see eastone.precasting.context.Env2MapStrategyContext#getOutput()
     * @author wangds 2015年5月5日 下午4:20:03.
     */
    @Override
    public Map<String, Object> getOutput() {
        return this.map;
    }

}
