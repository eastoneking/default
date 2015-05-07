/*
 * create:2015年5月5日 下午4:15:33
 * author:wangds  
 */
package eastone.precasting.context;

import java.util.Map;

import eastone.common.context.Environment;
import eastone.common.strategy.StrategyContext;

/**
 * .
 * @author wangds
 *
 */
public interface Env2MapStrategyContext extends StrategyContext<Class<?>>{
    void setInput(Environment env);
    Environment getInput();
    void setOutput(Map<String, Object> map);
    Map<String, Object> getOutput();
}
