package eastone.common.context.provider.spring.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.ServiceLoader;

import eastone.common.context.BeanContext;
import eastone.common.context.provider.spring.SpringBeanContextProvider;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SpringBeanContextTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public SpringBeanContextTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SpringBeanContextTest.class);
	}

	/**
	 * 测试provider是否正常
	 */
	public void testProviderLoad() throws IOException {
		ServiceLoader<BeanContext> loader = ServiceLoader.load(BeanContext.class);
		Iterator<BeanContext> it = loader.iterator();
		BeanContext cur=null;
		boolean res = false;
		while(it.hasNext()){
			cur=it.next();
			res|=(cur instanceof SpringBeanContextProvider);
		}
		assertTrue(res);
	}
	
	
	
	
	
}
