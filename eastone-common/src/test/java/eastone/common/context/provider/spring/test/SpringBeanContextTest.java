package eastone.common.context.provider.spring.test;

import java.util.Iterator;
import java.util.ServiceLoader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import eastone.common.context.BeanContext;
import eastone.common.context.provider.spring.SpringBeanContextProvider;

/**
 * Unit test for simple App.
 */
public class SpringBeanContextTest extends TestCase {

    /**
     * Create the test case.
     *
     *@param testName
     *            name of the test case
     */
    public SpringBeanContextTest(final String testName) {
        super(testName);
        }

    /**
     *@return the suite of tests being tested
    */
    public static Test suite() {
        return new TestSuite(SpringBeanContextTest.class);
    }

    /**
     * 测试provider是否正常.
     */
    @SuppressWarnings("rawtypes")
    public void testProviderLoad() {
        ServiceLoader<BeanContext> loader
            = ServiceLoader.load(BeanContext.class);
        Iterator<BeanContext> it = loader.iterator();
        BeanContext cur = null;
        boolean res = false;
        while (it.hasNext()) {
            cur = it.next();
            res |= (cur instanceof SpringBeanContextProvider);
        }
        assertTrue(res);
    }

    /**
     * 测试方法.
     */
    public void testGetBean() {
        SpringBeanContextProvider ctx = new SpringBeanContextProvider();
        ctx.appendContext(
          "eastone/common/context/provider/spring/test/test.context.xml"
        );
        String testmsg = (String) ctx.getBean("test.msg");
        assertEquals(testmsg, "Hello World");
    }

    /**
     * 测试获得bean对象.
     */
    public void testGetBean2() {
        SpringBeanContextProvider ctx = new SpringBeanContextProvider();
        ctx.appendContext(
          "eastone/common/context/provider/spring/test/test.context.xml"
        );
        String testmsg = (String) ctx.getBean("test.msg");
        assertEquals(testmsg, "Hello World");
        ctx.appendContext(
          "eastone/common/context/provider/spring/test/test1.context.xml"
        );
        String testmsgr = (String) ctx.getBean("test.msg");
        String testmsg1 = (String) ctx.getBean("test.msg1");
        assertEquals(testmsg, testmsgr);
        assertTrue(testmsg == testmsgr);
        assertEquals(testmsg, testmsg1);
        assertFalse(testmsg == testmsg1);
    }

}
