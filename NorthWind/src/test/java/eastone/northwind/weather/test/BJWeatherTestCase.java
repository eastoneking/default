/*
 * File:BJWeatherTestCase.java
 * Type:eastone.northwind.weather.test.BJWeatherTestCase
 */
package eastone.northwind.weather.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;
import eastone.common.processor.Processor;
import junit.framework.TestCase;

/**
 * .
 * <p>
 * <ol>
 * <li>,wangdongshi@neusoft.com,2013-10-27 8:21:28</li>
 * </ol>
 * </p>
 * @author  <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
@SuppressWarnings("unchecked")
public class BJWeatherTestCase extends TestCase {

  static {
    @SuppressWarnings("rawtypes")
    BeanContext ctx = BeanContextFactory.getBeanContext();
    ctx.appendContext(new ClassPathXmlApplicationContext("quartz.context.xml"));
  }

  /*
   * (non-Javadoc)
   * @see junit.framework.TestCase#setUp()
   */
  @Override
  protected void setUp() throws Exception {

  }

  /**
   * 测试.
   */
  public final void test() {
    BeanContext<?> ctx = BeanContextFactory.getBeanContext();
    Processor<RuntimeException> p = ctx.getBean("Proc.Weather.BJ.Loader");
    p.process();
  }

}
