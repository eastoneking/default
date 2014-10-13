/*
 * File:GetBJWeatherProcessor.java
 * Type:eastone.northwind.weather.GetBJWeatherProcessor
 */
package eastone.northwind.weather;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import net.sf.json.JSONObject;
import eastone.common.factory.ProviderFactory;
import eastone.common.processor.Processor;
import eastone.component.http.HttpException;
import eastone.component.http.SimpleHttpClientComponent;

/**
 * .
 * <p>
 * <ol>
 * <li>初始版本,wangds@gmail.com,2013-10-27 下午8:01:32</li>
 * </ol>
 * </p>
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */
public class GetBJWeatherProcessor implements Processor {

  /**
   * 请求的URL.
   * <p>
   * <a href="http://www.weather.com.cn/data/ks/101010100.html">北京</a>
   * </p>
   */
  private String url;

  /**
   * @param theUrl the url to set
   */
  public final void setUrl(final String theUrl) {
    this.url = theUrl;
  }

  /**
   * @return the url
   */
  public final String getUrl() {
    return url;
  }

  /**
   * 业务处理.
   */
  @SuppressWarnings("unchecked")
  public void process() {
    ProviderFactory fac = new ProviderFactory();
    SimpleHttpClientComponent<Map<String, String>> client = fac
        .getInstance(SimpleHttpClientComponent.class);

    String strWeather = null;
    try {
      strWeather = client.get(new URL(this.url));
      JSONObject jobj = JSONObject.fromObject(strWeather);
      System.out.println(jobj.toString());
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    } catch (HttpException e) {
      throw new RuntimeException(e);
    }

  }

}
