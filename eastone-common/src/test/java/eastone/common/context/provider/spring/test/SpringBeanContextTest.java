package eastone.common.context.provider.spring.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eastone.common.context.BeanContext;
import eastone.common.context.provider.spring.SpringBeanContextProvider;

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
	
	public void testGetBean(){
		SpringBeanContextProvider ctx = new SpringBeanContextProvider();
		ctx.appendContext(new ClassPathXmlApplicationContext("eastone/common/context/provider/spring/test/test.context.xml"));
		String test_msg = (String) ctx.getBean("test.msg");
		assertEquals(test_msg, "Hello World");
	}
	
	public void testGetBean2(){
		SpringBeanContextProvider ctx = new SpringBeanContextProvider();
		ctx.appendContext(new ClassPathXmlApplicationContext("eastone/common/context/provider/spring/test/test.context.xml"));
		String test_msg = (String) ctx.getBean("test.msg");
		assertEquals(test_msg, "Hello World");
		ctx.appendContext(new ClassPathXmlApplicationContext("eastone/common/context/provider/spring/test/test1.context.xml"));
		String test_msg_r = (String) ctx.getBean("test.msg");
		String test_msg_1 = (String) ctx.getBean("test.msg1");
		assertEquals(test_msg,test_msg_r);
		assertTrue(test_msg==test_msg_r);
		assertEquals(test_msg,test_msg_1);
		assertFalse(test_msg==test_msg_1);
	}
	
}
