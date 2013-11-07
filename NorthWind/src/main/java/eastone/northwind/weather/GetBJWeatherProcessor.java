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
 *
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-27 下午8:01:32</li>
 *  </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class GetBJWeatherProcessor implements Processor<RuntimeException>{

	/**
	 * 请求的URL.
	 * <p><a href="http://www.weather.com.cn/data/ks/101010100.html">北京</a>
	 * </p>
	 */
	private String url;

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	@SuppressWarnings("unchecked")
	@Override
	public void process() throws RuntimeException {
		ProviderFactory fac = new ProviderFactory();
		SimpleHttpClientComponent<Map<String, String>> client = fac.getInstance(
					SimpleHttpClientComponent.class
		);

		String weather_str = null;
		try {
			weather_str = client.get(new URL(this.url));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (HttpException e) {
			throw new RuntimeException(e);
		}

		JSONObject jobj = JSONObject.fromObject(weather_str);
		System.out.println(jobj.toString());
	}

}
