/*
 * File:I18nMsg.java Type:eastone.common.i18n.I18nMsg
 */
package eastone.common.i18n;

import java.util.Locale;

/**
 * 国际化消息.
 * <p>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-6 上午12:59:31</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface I18nMsg {

  /**
   * 设置消息在属性文件中的编号.
   * @param id 消息编号.
   */
  void setId(String id);

  /**
   * 设置消息地区.
   * @param locale 地区.
   */
  void setLocale(Locale locale);

  /**
   * 设置消息中替换参数.
   * @param arguments 参数.
   */
  void setArguments(String[] arguments);

  /**
   * 获得消息.
   * @return 消息内容.
   */
  String getMessage();
}
