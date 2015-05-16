/*
 * create time: 2013年12月1日 下午11:26:49
 * path: AbstractStrategyContext.java
 * type: eastone.common.strategy.AbstractStrategyContext
 */
package eastone.common.strategy;

import java.util.Collection;
import java.util.Map;

import eastone.common.GeneralParentObject;

/**
 * 策略上下文默认实现类.
 * <p>
 * <ul>
 * <li>修改列表:
 * <ol>
 * <li>
 * wangds@gmail.com, 2013年12月1日 下午11:26:49
 * <p>
 * 初始版本.
 * </p>
 * </li>
 * <li>
 * wangds@gmail.com, 2013年12月3日 上午08:48
 * <ul>
 * <li>类名从DefaultStrategyContext变更为AbstractStrategyContext;</li>
 * <li>类变更为抽象类;</li>
 * <li>
 * {@link #AbstractStrategyContext(Map)}访问修饰符改为 “protected”.</li>
 * </ul>
 * </li>
 * <li>
 * wangds@gmail.com, 2013-12-03 10:16
 * <p>
 * 添加 {@link #clear()}方法.
 * </p>
 * </li>
 * <li>
 * wangds@gmail.com, 2013-12-06 19:48
 * <p>
 * 修改关于识别标识的处理.
 * </p>
 * </li>
 * </ol>
 * </li>
 * <li>
 * 实现Composite接口。－2014-09-28 21:23 @D51
 * </li>
 * </ul>
 * </p>
 * 
 * @param <K>
 *            KEY类型.
 * @param <E>
 *            执行策略时可能抛出的异常.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractStrategyContext<K> extends GeneralParentObject implements StrategyContext<K> {

    /**
     * 策略图.
     */
    private final Map<K, Strategy<K>> contextMap;

    /**
     * 选中的策略.
     */
    private K selectedStrategy;

    /**
     * 构造函数.
     * 
     * @param theStrategyMap
     *            用于保存策略图的Map实例.
     *            <p>
     *            根据策略图的需要，选择不同该类型的{@link Map}类实例.
     *            </p>
     */
    protected AbstractStrategyContext(final Map<K, Strategy<K>> theStrategyMap) {
        this.contextMap = theStrategyMap;
    }

    /**
     * 设置selectedStrategy属性值.
     * 
     * @param theSelectedStrategy
     *            selectedStrategy属性的新值。
     */
    public void setSelectedStrategy(final K theSelectedStrategy) {
        this.selectedStrategy = theSelectedStrategy;
    }

    /**
     * 获得selectedStrategy属性值.
     * 
     * @return selectedStrategy属性现值。
     */
    public K getSelectedStrategy() {
        return selectedStrategy;
    }

    @Override
    public <S extends Strategy<K>> void registerStrategy(final S strategy) {
        strategy.setContext(this);
        this.contextMap.put(strategy.getKey(), strategy);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S extends Strategy<K>> S findStrategy(final K key) {
        return (S) this.contextMap.get(key);
    }

    @Override
    public void disregister(final K key) {
        this.contextMap.remove(key);
    }

    @Override
    public void clearStrategyMap() {
        this.contextMap.clear();
    }

    @Override
    public Map<K, Strategy<K>> getStrategyMap() {
        return this.contextMap;
    }
    
    /*
     * @see eastone.common.composite.Composite#add(eastone.common.Component)
     * @author wangds 2014年9月28日 下午9:18:10.
     */
    @Override
    public <T extends Strategy<K>> void add(T component) {
      this.registerStrategy(component);
    }
    
    /*
     * @see eastone.common.composite.Composite#getComponent(java.lang.Object)
     * @author wangds 2014年9月28日 下午9:18:29.
     */
    @Override
    public <T extends Strategy<K>> T getComponent(K identity) {
        return this.findStrategy(identity);
    }
    
    /*
     * @see eastone.common.composite.Composite#listAllComponent()
     * @author wangds 2014年9月28日 下午9:18:49.
     */
    @Override
    public Collection<Strategy<K>> listAllComponent() {
        return this.contextMap.values();
    }
    
    /*
     * @see eastone.common.composite.Composite#remove(java.lang.Object)
     * @author wangds 2014年9月28日 下午9:20:58.
     */
    @Override
    public void remove(K identity) {
        this.disregister(identity);
    }
    
    /*
     * @see eastone.common.composite.Composite#remove(eastone.common.Component)
     * @author wangds 2014年9月28日 下午9:21:46.
     */
    @Override
    public <T extends Strategy<K>> void remove(T component) {
        this.disregister(component.getKey());
    }

    @Override
    public void process() {
        if(this.selectedStrategy==null){
            this.setSelectedStrategy(this.decide().getKey());
        }
        Strategy<K> selectStrategy = this.findStrategy(selectedStrategy);
        if (selectStrategy != null) {
            selectStrategy.setContext(this);
            proccessStrategry(selectStrategy);
        }
        this.clear();
    }

    @Override
    public void clear() {
        this.selectedStrategy = null;
    }

    /**
     * 执行策略.
     * 
     * @param <S>
     *            被执行策略类型.
     * @param strategy
     *            被执行策略.
     * @throws E
     *             执行期间可能发生的异常.
     */
    protected abstract <S extends Strategy<K>> void proccessStrategry(S strategy);
    
    /*
     * @see eastone.common.strategy.StrategyContext#decide()
     * @author wangds 2015年5月2日 上午11:08:33.
     */
    @Override
    public <S extends Strategy<K>> S decide() {
        return this.findStrategy(this.selectedStrategy);
    }
}
