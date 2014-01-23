package eastone.common.context.provider.spring;

import java.io.File;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import eastone.common.context.BeanContext;

/**
 * 以Spring IoC容器作为基础实现的{@link BeanContext}接口的实现类.
 * <p>
 * </p>
 *  <ol>
 *    <li>2014-1-11 16:14, wangdongshi:<br/>
 *      更改 {@link #appendContext(String)}方法参数类型,原有方式无法处理Spring Context之间
 *      的继承关系.为了能够指定parent context,而不需要refresh,必须在构造新的context的时候，通过
 *      构造函数设置parent context。而又不希望提供从外部获得 {@link #context}对象的接口<sub>
 *      &lt;注1&gt;</sub>,因此只能在{@link #appendContext(String)}方法内部构造新的Spring
 *       Context。<br/>
 *     <b>注1:</b>因为开发者使用此接口的时候是通过工厂方法获得的{@link BeanContext}对象,因而无法
 *     正常调用这些接口.
 *    </li>
 *  </ol>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1
 */
public class SpringBeanContextProvider implements BeanContext<String> {

  /**
   *
   */
  private AbstractApplicationContext context = null;

  @Override
  public <T> T status(final Object... inputs) {
    assert inputs != null : "";
    int len = inputs.length - 1;
    Object[] args = new Object[len];
    System.arraycopy(inputs, 1, args, 0, len);
    return getBean((String) inputs[0], args);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <B> B getBean(final String beanid, final Object... args) {
    B res = null;
    if (args == null || args.length == 0) {
      res = (B) context.getBean(beanid);
    } else {
      res = (B) context.getBean(beanid, args);
    }
    return res;
  }

  /**
   * 从XML格式配置文件加载新的容器内容添加到容器中.
   * @param newer - 新配置文件位置.
   * <p>
   *   配置文件位置通过前缀字符串识别:
   *   <ul>
   *    <li>"file:"&nbsp;-&nbsp;本地文件;</li>
   *    <li>"classpath:"&nbsp;-&nbsp;类路径;</li>
   *    <li>无前缀&nbsp;-&nbsp;将参数视为文件检测路径上是否有文件存在，如果存在则按照文件方式加载，
   *    否则按照类路径资源加载.</li>
   *   </ul>
   * </p>
   * @return 更新后的上下文.
   */
  @Override
  public BeanContext<String> appendContext(final String newer) {
    String path = StringUtils.trimToEmpty(newer);
    String[] configs = new String[] {path };
    AbstractApplicationContext ctx = null;
    if (StringUtils.startsWithIgnoreCase(path, "classpath:")
        || (!StringUtils.startsWith(path, "file:") && !new File(path).exists())
    ) {
      ctx = new ClassPathXmlApplicationContext(configs, this.context);
    } else {
      ctx = new FileSystemXmlApplicationContext(configs, this.context);
    }
    this.context = ctx;
    return this;
  }

  @Override
  public String getMessage(final String code, final Locale locale,
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
/*
 * 开发札记:
 * 2014-01-11 下午和曲迪约定了下周一去离婚.
 */
