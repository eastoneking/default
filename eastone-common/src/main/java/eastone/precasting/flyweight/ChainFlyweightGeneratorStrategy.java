/*
 * create time: 2013年12月7日 上午8:21:59
 * path: ChainFlyweightStrategy.java
 * type: eastone.precasting.flyweight.ChainFlyweightStrategy
 */
package eastone.precasting.flyweight;

import eastone.common.adapter.Adapter;
import eastone.common.chainofresponsibility.Handler;
import eastone.common.flyweight.Flyweight;
import eastone.common.strategy.StrategyRuntimeException;

/**
 * 享元生成策略责任链.
 * <p>
 * 在较为复杂的情况下，享元工厂 {@link eastone.common.flyweight.FlyweightFactory}
 * 中生成享元的策略需要组合应用，在优先策略无法生成享元对象时，更换下一个生成策略。
 * </p>
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月7日 上午8:21:59
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <K> 享元识别编号类型.
 * @param <F> 享元类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class ChainFlyweightGeneratorStrategy<K, F extends Flyweight>
  extends AbstractFlyweightGenerateStrategy<K, F>
  implements
    Handler<StrategyRuntimeException, ChainFlyweightGeneratorStrategy<K, F>>,
    Adapter<AbstractFlyweightGenerateStrategy<K, F>> {

  /**
   * 责任链中当前策略实例.
   */
  private AbstractFlyweightGenerateStrategy<K, F> innerStrategy;

  /**
   * 下一个责任链节点.
   */
  private ChainFlyweightGeneratorStrategy<K, F> next;

  /**
   * 执行结果.
   */
  private F result;

  /**
   * 构造函数.
   * @param initFactoriesContext 生成时的上下文,调用时生效.
   */
  public ChainFlyweightGeneratorStrategy(
      final DefaultFlyweightFactory<K, F> initFactoriesContext) {
    super(initFactoriesContext);
  }

  @Override
  public void setNext(final ChainFlyweightGeneratorStrategy<K, F> newNext) {
    this.next = newNext;
  }

  @Override
  public ChainFlyweightGeneratorStrategy<K, F> getNext() {
    return this.next;
  }

  /**
   * 设置result属性值.
   * @param theResult result属性的新值。
   */
  public void setResult(final F theResult) {
    this.result = theResult;
  }

  /**
   * 获得result属性值.
   * @return result属性现值。
   */
  public F getResult() {
    return result;
  }

  @Override
  public boolean handle() throws StrategyRuntimeException {
    K theKey = this.getKey();
    this.innerStrategy.setFactoriesContext(this.getFactoriesContext());
    this.innerStrategy.setKey(theKey);
    this.result = this.innerStrategy.generateInstance(theKey);
    return this.result == null;
  }

  @Override
  public void process() throws StrategyRuntimeException {
    //递归
    if (this.handle() && this.next != null) {
      this.next.process();
      this.result = this.next.getResult();
    }
  }

  @Override
  protected F generateInstanceByKey(final K key)
      throws StrategyRuntimeException {
    this.process();
    return this.result;
  }

  /**
   * 向责任链尾部添加一个策略.
   * @param inner 内部策略.
   */
  public void appendStrategy(
      final AbstractFlyweightGenerateStrategy<K, F> inner
  ) {
    //递归添加后续节点
    if (this.innerStrategy == null) {
      this.innerStrategy = inner;
    } else {
      if (this.next == null) {
        this.next
          = new ChainFlyweightGeneratorStrategy<K, F>(
              this.getFactoriesContext()
          );
      }
      this.next.appendStrategy(inner);
    }
  }

  @Override
  public AbstractFlyweightGenerateStrategy<K, F> getAdaptee() {
    return this.innerStrategy;
  }


}
