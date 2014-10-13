/*
 * create:2014年10月5日 下午2:52:06
 * author:wangds  
 */
package eastone.common.context;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;


/**
 * .
 * @author wangds
 *
 */
public class BeanAsContextTestCase {

    @Test
    public void test() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        TestBeanAsContext bc = new TestBeanAsContext();
        String value = "abcdefg";
        bc.setAbc(value);
        assertEquals(value, bc.status("abc"));
        
    }

}
