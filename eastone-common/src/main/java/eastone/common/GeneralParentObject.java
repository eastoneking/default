package eastone.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础对象类.
 * <p>
 * 该类是对{@link java.lang.Object}的扩展.目前扩展的功能只有日志接口.
 * </p>
 * <p>
 * 修改列表:
 * <ol>
 * <li>补充注释. wangdongshi@neusoft.com 2013-10-13 00:10</li>
 * <li>根据Check Style提示更改类名, by wangdongshi@neusoft.com 2013-10-13 00:10</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class GeneralParentObject {

  /**
   * 获得日志对象.
   * @return 日志对象.
   */
  protected final Logger getLogger() {
    final Class<? extends GeneralParentObject> clz = this.getClass();
    return LoggerFactory.getLogger(clz);
  }

  /**
   * 获得静态块或方法中能够使用的日志对象.
   * @param clz 调用日志的类的类型.
   * @return 日志对象.
   */
  public static final Logger staticLogger(final Class<?> clz) {
    Class<?> cls = null;
    if (clz == null) {
      cls = eastone.common.GeneralParentObject.class;
    } else {
      cls = clz;
    }
    return LoggerFactory.getLogger(cls);
  }

}
