/*
 * create time: 2013年12月6日 下午11:12:46
 * path: AbstractFlyweightGenerateStrategy.java
 * type: eastone.precasting.flyweight.AbstractFlyweightGenerateStrategy
 */
package eastone.precasting.flyweight;

import java.util.List;

import eastone.common.flyweight.Flyweight;
import eastone.common.strategy.AbstractStrategy;
import eastone.common.strategy.StrategyRuntimeException;
import eastone.common.visitor.DefaultVisitorController;
import eastone.common.visitor.VisitorController;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月6日 下午11:12:46
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <K> 唯一识别编号类型.
 * @param <F> 享元类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractFlyweightGenerateStrategy<K, F extends Flyweight>
  extends AbstractStrategy<K>
  implements
    VisitorController<
      FlyweightGenerateStrategyVisitor<K, F>,
      DefaultFlyweightFactory<K, F>
    > {
  /**
   * 内部访问者控制器.
   */
  private DefaultVisitorController <
    FlyweightGenerateStrategyVisitor<K, F>,
    DefaultFlyweightFactory<K, F>
    > visitorController
    = new DefaultVisitorController<
      FlyweightGenerateStrategyVisitor<K, F>,
      DefaultFlyweightFactory<K, F>
    >();

  /**
   * 原始工厂类.
   */
  private DefaultFlyweightFactory<K, F> factoriesContext;

  /**
   * .
   * @param initFactoriesContext 工厂上下文.
   */
  public AbstractFlyweightGenerateStrategy(
    final DefaultFlyweightFactory<K, F> initFactoriesContext
  ) {
    factoriesContext = initFactoriesContext;
  }

  /**
   * 设置factoriesContext属性值.
   * @param newFactoriesContext factoriesContext属性的新值。
   */
  public void setFactoriesContext(
    final DefaultFlyweightFactory<K, F> newFactoriesContext
  ) {
    this.factoriesContext = newFactoriesContext;
  }

  /**
   * 获得factoriesContext属性值.
   * @return factoriesContext属性现值。
   */
  public DefaultFlyweightFactory<K, F> getFactoriesContext() {
    return factoriesContext;
  }

  @Override
  public void clear() {
    this.visitorController.clear();
  }

  @Override
  public void disregister(final Class<DefaultFlyweightFactory<K, F>> type,
      final FlyweightGenerateStrategyVisitor<K, F> visitor) {
    this.visitorController.disregister(type, visitor);
  }

  @Override
  public void invokeVisitors(final DefaultFlyweightFactory<K, F> visitable) {
    this.visitorController.invokeVisitors(visitable);
  }

  @Override
  public void registorVisitor(final Class<DefaultFlyweightFactory<K, F>> type,
      final FlyweightGenerateStrategyVisitor<K, F> visitor) {
    this.visitorController.registorVisitor(type, visitor);
  }

  @Override
  public void clear(final Class<DefaultFlyweightFactory<K, F>> type) {
    this.clear(type);
  }

  @Override
  public List<FlyweightGenerateStrategyVisitor<K, F>> findVisitors(
      final Class<DefaultFlyweightFactory<K, F>> type) {
    return this.findVisitors(type);
  }

  /**
   * 生成享元实例方法.
   * <p>在实例生成之后，调用了访问者.</p>
   * @param key 关键字.
   * @return 实例对象.
   * @throws StrategyRuntimeException 异常.
   */
  public F generateInstance(final K key) throws StrategyRuntimeException {
    F res = null;
    res = this.generateInstanceByKey(key);
    this.invokeVisitors(this.factoriesContext);
    return res;
  }

  /**
   * 生成享元实例方法.
   * @param key 关键字.
   * @return 实例对象.
   * @throws StrategyRuntimeException 异常.
   */
  protected abstract F generateInstanceByKey(K key)
      throws StrategyRuntimeException;

}
