/*
 * File:HttpClientSimpleComponentTestCase.java
 * Type:eastone.component.test.HttpClientSimpleComponentTestCase
 */
package eastone.component.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import eastone.common.factory.ProviderFactory;
import eastone.component.http.HttpException;
import eastone.component.http.SimpleHttpClientComponent;
import junit.framework.TestCase;

/**
 * 测试类.
 * <p>
 * <ol>
 * <li>初始版本,wangdongshi@neusoft.com,2013-10-27 下午6:01:40</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class HttpClientSimpleComponentTestCase extends TestCase {

  /**
   * 测试天气.
   */
  @SuppressWarnings("unchecked")
  public final void testWeather() {
    ProviderFactory factory = new ProviderFactory();

    SimpleHttpClientComponent<Map<String, String>> client = null;
    try {
      client = factory.getInstance(SimpleHttpClientComponent.class);
      String url = "http://www.weather.com.cn/data/ks/101010100.html";
      String resp = client.get(new URL(url));
      assertNotNull(resp);
    } catch (SecurityException e) {
      e.printStackTrace();
     } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (HttpException e) {
      e.printStackTrace();
    }

  }
}
