package eastone.common.context;

import java.util.Iterator;
import java.util.ServiceLoader;

import eastone.common.factory.Factory;

/**
 * 通过Service-Provider方式实现的BeanContext工厂类.
 * <p>
 * 修改列表:
 * <ol>
 * <li>确定版本,补充注释. by wangdongshi@neusoft.com 2013-10-12 22:43</li>
 * <li>
 * <ul>
 * <li>一个工厂类只能产生单例的BeanContext;</li>
 * <li>添加静态工厂方法{@link #getBeanContext()}，使用此方法永远只能 获得同一单例上下文.</li>
 * </ul>
 * by wangdongshi@neusoft.com 2013-10-12 23:04</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.2
 * @see java.util.ServiceLoader
 */
@SuppressWarnings("rawtypes")
public class BeanContextFactory implements
    Factory<BeanContext> {

  /**
   * 默认工厂对象.
   */
  private static final BeanContextFactory DEFAULT_FACTORY
    = new BeanContextFactory();

  /**
   * 从默认工厂对象中获得上下文.
   * <p>
   * 如果想获得整个应用的上下文，应该使用本方法.
   * </p>
   * @return 默认工厂类的上下文对象.
   */
  public static BeanContext getBeanContext() {
    return DEFAULT_FACTORY.getInstance();
  }

  /**
   * 保持单例上下文的引用.
   */
  private BeanContext instance = null;

  /**
   * 生成实例时的锁对象.
   * <p>
   * 因为对<code>java.util.concurrent</code>不熟悉，暂时使用synchronized方式控制 同步.是否更改待议.
   * </p>
   */
  private final Object lock = new Object();

  /**
   * 获得{@linkplain BeanContext}接口的实例对象.
   * <p>
   * 通过Service-Provider方式获得接口实例.通过
   * META-INF/services/eastone.common.context.BeanContext文件定义。如果存在多份
   * 配置返回第一个配置对应的实例。
   * </p>
   * @return 上下文.
   */
  @Override
  public BeanContext getInstance() {
    BeanContext res = null;
    synchronized (lock) {
      if (instance == null) {
        instance = loadNewInstance();
      }
    }

    res = instance;
    return res;
  }

  /**
   * 完成从配置生成实例的代码.
   * <p>
   * 使用了Service-Provider方式.
   * </p>
   * @return 上下文对象.
   * @see #getInstance()
   * @see java.util.ServiceLoader
   */
  private BeanContext loadNewInstance() {
    BeanContext res = null;
    ServiceLoader<BeanContext> loader = ServiceLoader.load(BeanContext.class);
    assert loader != null : "无法生成BeanContext接口的ServiceLoader对象.";
    Iterator<BeanContext> it = loader.iterator();
    assert it != null : "";
    while (it.hasNext()) {
      res = it.next();
      if (res != null) {
        break;
      }
    }
    return res;
  }

}
