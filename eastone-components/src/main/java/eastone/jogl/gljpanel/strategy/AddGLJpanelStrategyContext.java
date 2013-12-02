/*
 * create time: 2013年12月1日 下午11:12:33
 * path: AddGLJpanelStrategyContext.java
 * type: eastone.jogl.gljpanel.strategy.AddGLJpanelStrategyContext
 */
package eastone.jogl.gljpanel.strategy;

import java.util.Map;

import eastone.common.GeneralParentObject;
import eastone.common.strategy.Strategy;
import eastone.common.strategy.StrategyContext;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月1日 下午11:12:33
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class AddGLJpanelStrategyContext 
  extends GeneralParentObject 
  implements StrategyContext<String> {

  
  /**
   * .
   */
  public AddGLJpanelStrategyContext() {
  }

  @Override
  public void clear() {
  }

  @Override
  public void disregister(String arg0) {
  }

  @Override
  public <S extends Strategy> S findStrategy(String arg0) {
    return null;
  }

  @Override
  public Map<String, Strategy> getStrategyMap() {
    return null;
  }

  @Override
  public <S extends Strategy> void registerStrategy(String arg0, S arg1) {
  }

}
