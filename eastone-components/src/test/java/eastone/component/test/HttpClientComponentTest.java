package eastone.component.test;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import eastone.common.processor.io.InputStream2BytesProcessor;

public class HttpClientComponentTest extends TestCase {

	public void testTech() throws ClientProtocolException, IOException{
		HttpClient client = HttpClients.createDefault();
		HttpRequest get = new HttpGet("/qm");
		HttpHost host = new HttpHost("localhost",8080);
		HttpResponse resp = client.execute(host ,get);
		HttpEntity entity = resp.getEntity();
		
		Header encoding_header = entity.getContentEncoding();
		String encoding = "UTF8";
		if(encoding_header!=null){
			encoding= encoding_header.getValue();
		}
		InputStream is = entity.getContent();
		byte[] data = new InputStream2BytesProcessor().convert(is);
		System.out.println(new String(data,encoding));
		
	}
}
