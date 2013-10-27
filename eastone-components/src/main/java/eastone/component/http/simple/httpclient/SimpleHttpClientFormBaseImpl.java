/*
 * File:SimpleHttpClientImpl.java
 * Type:eastone.component.http.simple.httpclient.SimpleHttpClientFormBaseImpl
 */
package eastone.component.http.simple.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import eastone.common.processor.AbstractProcessorWithResult;
import eastone.common.processor.ProcessorWithResult;
import eastone.common.processor.io.InputStream2BytesProcessor;
import eastone.component.http.HttpException;
import eastone.component.http.simple.HttpMethodEnum;
import eastone.component.http.simple.SimpleHttpClientComponentBridgeImplementor;

/**
 * HTTP Client实现.
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-27 下午5:14:53</li>
 *  </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class SimpleHttpClientFormBaseImpl
	extends AbstractProcessorWithResult<String, HttpException>
	implements SimpleHttpClientComponentBridgeImplementor,
	ProcessorWithResult<String, HttpException> {

	/**
	 * Http方法.
	 */
	private HttpMethodEnum method;

	/**
	 * URL.
	 */
	private URL url;

	/**
	 * 参数.
	 */
	private Map<String, String> parameters;


	/**
	 * 获得Http方法.
	 * @return Http方法.
	 */
	public HttpMethodEnum getMethod() {
		return method;
	}


	/**
	 * 设置Http方法.
	 * @param method Http方法.
	 */
	public void setMethod(HttpMethodEnum method) {
		this.method = method;
	}


	/**
	 * URL.
	 * @return URL.
	 */
	public URL getUrl() {
		return url;
	}


	/**
	 * URL.
	 * @param url URL.
	 */
	public void setUrl(URL url) {
		this.url = url;
	}


	/**
	 * 参数.
	 * @return 参数.
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}


	/**
	 * 参数.
	 * @param parameters 参数.
	 */
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}



	@Override
	protected String execute() throws HttpException {
		String res = null;

		assert this.method != null;

		switch (this.method) {
		case POST:
			res = post();
		break;
		default:
			res = get();
		}

		this.setResult(res);
		return res;
	}


	/**
	 * 执行GET请求.
	 * @return 返回body.
	 * @throws HttpException 封装的底层异常.
	 */
	private String get() throws HttpException {
		try {
			return execRequest(new HttpGet(url.toURI()));
		} catch (URISyntaxException e) {
			throw new HttpException(e);
		}
	}

	/**
	 * 执行POST请求.
	 * @return 返回body.
	 * @throws HttpException 封装的底层异常.
	 */
	private String post() throws HttpException {
		try {
			return execRequest(new HttpPost(url.toURI()));
		} catch (URISyntaxException e) {
			throw new HttpException(e);
		}
	}


	/**
	 * 执行请求.
	 * @param method 要执行的请求.
	 * @return body内容.
	 * @throws HttpException 封装的底层异常.
	 */
	private String execRequest(HttpRequest method) throws HttpException {
		String res = null;
		HttpClient client = HttpClients.createDefault();

		HttpHost host = new HttpHost(url.getHost(), url.getPort());
		HttpResponse resp = null;
		try {
			resp = client.execute(host, method);
		} catch (ClientProtocolException e) {
			throw new HttpException(e);
		} catch (IOException e) {
			throw new HttpException(e);
		}
		HttpEntity entity = resp.getEntity();

		Header encoding_header = entity.getContentEncoding();
		String encoding = "UTF8";
		if (encoding_header != null) {
			encoding = encoding_header.getValue();
		}
		InputStream is = null;
		try {
			is = entity.getContent();
			byte[] data = new InputStream2BytesProcessor().convert(is);
			res = new String(data, encoding);
		} catch (IllegalStateException e) {
			throw new HttpException(e);
		} catch (IOException e) {
			throw new HttpException(e);
		}
		return res;
	}

	/**
	 * 执行已经设置好的请求.
	 * @return 应答body.
	 * @throws HttpException 可能的异常.
	 */
	public String request() throws HttpException {
		this.process();
		return this.getResult();
	}

}
