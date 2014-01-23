/*
 * File:NoCacheI18nMsg.java Type:eastone.common.i18n.NoCacheI18nMsg
 */
package eastone.common.i18n;

import java.util.Locale;

import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;

/**
 * 无缓冲国际化消息.
 * <p>
 * 每次重新获取.
 * </p>
 * <p>
 * 每次重新获得.
 * </p>
 * <p>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-6 上午1:17:06</li>
 * <li>增加方法{@link #getMessage()}中的非空检查. by wangdongshi@neusoft.com, 2013-11-6
 * 23:28.</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class NoCacheI18nMsg extends AbstractI18nMsg {

  /**
   * 序列化所需字段.
   */
  private static final long serialVersionUID = 2137818718162241755L;

  @Override
  public String getMessage() {
    String res = null;
    BeanContext<?> ctx = BeanContextFactory.getBeanContext();
    String id = this.getId();
    Locale locale = this.getLocale();
    if (locale == null) {
      locale = Locale.getDefault();
    }

    String[] arguments = this.getArguments();
    if (arguments == null) {
      arguments = new String[0];
    }

    res = ctx.getMessage(id, locale, (Object[]) arguments);

    return res;
  }

}
