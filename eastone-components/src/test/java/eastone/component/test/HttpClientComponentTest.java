package eastone.component.test;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import eastone.common.processor.io.InputStream2BytesProcessor;

/**
 * 测试用例.
 *
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-27 下午5:00:08</li>
 *  </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class HttpClientComponentTest extends TestCase {

	/**
	 *
	 */
	private static final int DEFAULT_PORT = 8080;

	/**
	 * 测试方法.
	 * @throws IOException 异常
	 */
	public void testTech() throws IOException {
		HttpClient client = HttpClients.createDefault();
		HttpRequest get = new HttpGet("/qm");
		HttpHost host = new HttpHost("localhost", DEFAULT_PORT);
		HttpResponse resp = client.execute(host, get);
		HttpEntity entity = resp.getEntity();

		Header encoding_header = entity.getContentEncoding();
		String encoding = "UTF8";
		if (encoding_header != null) {
			encoding = encoding_header.getValue();
		}
		InputStream is = entity.getContent();
		byte[] data = new InputStream2BytesProcessor().convert(is);
		System.out.println(new String(data, encoding));

	}
}
