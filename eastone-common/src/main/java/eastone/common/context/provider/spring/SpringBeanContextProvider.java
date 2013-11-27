package eastone.common.context.provider.spring;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import
  org.springframework.context.support.AbstractRefreshableApplicationContext;

import eastone.common.context.BeanContext;

/**
 * 以Spring IoC容器作为基础实现的{@link BeanContext}接口的实现类.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @param <C> 参数类型 限定了Spring上下文类型必须是可以更新的上下文.
 * @version 0.1
 */
public class SpringBeanContextProvider
  <C extends AbstractRefreshableApplicationContext>
    implements BeanContext<C> {

  /**
   *
   */
  private AbstractApplicationContext context = null;

  @Override
  public final <T> T status(final Object... inputs) {
    assert inputs != null : "";
    int len = inputs.length - 1;
    Object[] args = new Object[len];
    System.arraycopy(inputs, 1, args, 0, len);
    return getBean((String) inputs[0], args);
  }

  @SuppressWarnings("unchecked")
  @Override
  public final <B> B getBean(final String beanid, final Object... args) {
    B res = null;
    if (args == null || args.length == 0) {
      res = (B) context.getBean(beanid);
    } else {
      res = (B) context.getBean(beanid, args);
    }
    return res;
  }

  @Override
  public final BeanContext<C> appendContext(final C newer) {
    if (this.context != null) {
      newer.setParent(this.context);
      newer.refresh();
    }
    this.context = newer;

    return this;
  }

  @Override
  public final String getMessage(final String code, final Locale locale,
      final Object... args) {

    String res = null;
    if (context == null) {
      res = "message initialized failrue.";
    } else {
      res = context.getMessage(code, args, "unkown infomation.", locale);
    }
    return res;
  }

}
