/*
 * File:AbstractI18nMsg.java
 * Type:eastone.common.i18n.AbstractI18nMsg
 */
package eastone.common.i18n;

import java.io.Serializable;
import java.util.Locale;

import eastone.common.GeneralParentObject;
import eastone.common.annotation.TemplateMethod;

/**
 * 抽象国际化消息.
 * <p>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-6 上午1:04:46</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractI18nMsg extends GeneralParentObject implements
    Serializable, Cloneable, I18nMsg {

  /**
   * 序列化所需字段.
   */
  private static final long serialVersionUID = 297321078559621348L;

  /**
   * 消息在国际化消息配置文件中的唯一标志.
   */
  private String id;

  /**
   * 消息适用国家/地区和语言.
   */
  private Locale locale;

  /**
   * 用于在预定位置替换的参数.
   */
  private String[] arguments;

  /**
   * 获得消息编号.
   * @return 消息编号.
   */
  public String getId() {
    return id;
  }


  @Override
  public void setId(final String theid) {
    this.id = theid;
  }

  /**
   * 获得消息适用国家/地区和语言.
   * @return 消息适用国家/地区和语言.
   */
  public Locale getLocale() {
    return locale;
  }

  @Override
  public void setLocale(final Locale thelocale) {
    this.locale = thelocale;
  }

  /**
   * 获得用于预定位置替换的参数列表.
   * @return 参数列表.
   */
  public String[] getArguments() {
    return arguments;
  }

  @Override
  public void setArguments(final String[] theArguments) {
    this.arguments = theArguments;
  }

  /**
   * 构造函数.
   */
  public AbstractI18nMsg() {
  }

  /**
   * 构造函数.
   * @param theId
   *          消息在国际化消息配置文件中的唯一标志.
   * @param theLocale
   *          消息适用国家/地区和语言.
   * @param theArguments
   *          用于在预定位置替换的参数.
   */
  public AbstractI18nMsg(
      final String theId,
      final Locale theLocale,
      final String... theArguments) {
    this.id = theId;
    this.locale = theLocale;
    this.arguments = theArguments;
  }

  /**
   * 克隆方法.
   * @param <M>
   *          克隆体对象类型.
   * @return 克隆体.
   */
  @SuppressWarnings("unchecked")
  @TemplateMethod
  public <M extends I18nMsg> M cloneMe() {
    M res = null;
    try {
      res = (M) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    return res;
  }

}
