/*
 * create:2015年5月5日 下午3:56:47
 * author:wangds  
 */
package eastone.precasting.context.strategy;

import java.util.Map;

import eastone.common.context.MapAsEnvironment;
import eastone.common.strategy.AbstractStrategy;
import eastone.precasting.context.Env2Map;
import eastone.precasting.context.Env2MapStrategyContext;

/**
 * .
 * @author wangds
 *
 */
public class MapEnv2MapStrategy
    extends AbstractStrategy<Class<?>>
    implements Env2Map{

    /*
     * @see eastone.precasting.context.Env2Map#toMap()
     * @author wangds 2015年5月5日 下午3:58:09.
     */
    @Override
    public Map<String, Object> toMap() {
        Env2MapStrategyContext ctx = this.getContext();
        Map<String, Object> res = null;
        MapAsEnvironment input = (MapAsEnvironment) ctx.getInput();
        res = input.getEnvironmentMap();
        return res ;
    }
    
}
