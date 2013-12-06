/*
 * File:BJWeatherTestCase.java
 * Type:eastone.northwind.weather.test.BJWeatherTestCase
 */
package eastone.northwind.weather.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;
import eastone.common.processor.Processor;

/**
 * 测试.
 * <p>
 * <ol>
 * <li>wangdongshi@neusoft.com,2013-10-27 8:21:28</li>
 * </ol>
 * </p>
 * @author  <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
@SuppressWarnings("unchecked")
public class BJWeatherTestCase {

  /**
   * 初始化.
   */
  @SuppressWarnings("rawtypes")
  @BeforeClass
  public static void init() {
    BeanContext ctx = BeanContextFactory.getBeanContext();
    ClassPathXmlApplicationContext baseCtx = new ClassPathXmlApplicationContext(
      "eastone/northwind/weather/test/weather.context.xml"
    );
    ctx.appendContext(baseCtx);
  }


  /**
   * 测试.
   */
  @Test
  public final void test() {
    BeanContext<?> ctx = BeanContextFactory.getBeanContext();
    Processor<RuntimeException> p = ctx.getBean("Proc.Weather.BJ.Loader");
    p.process();
  }

}
