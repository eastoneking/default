/*
 * File:I18NMsgTestCase.java
 * Type:eastone.common.i18n.test.I18NMsgTestCase
 */
package eastone.common.i18n.test;

import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;
import eastone.common.factory.ProviderFactory;
import eastone.common.i18n.I18nMsg;

import junit.framework.TestCase;

/**
 *  国际化消息测试类.
 *
 *  <p>
 *  	<h1>备忘:</h1>
 *  	<ol>
 *  		<li>
 *  			当不设置语言区域的时候,获得的不是英文内容,依然是本机语言设置消息.
 *  			JDK为1.6.0_45.
 *  		</li>
 *  	</ol>
 *  </p>
 *
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-6 下午10:41:57</li>
 *  </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */


public class I18NMsgTestCase {

	/**
	 * 全局初始化.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@BeforeClass
	public static void init() {
		String config = "eastone/common/i18n/test/context.xml";
		BeanContext ctx = BeanContextFactory.getBeanContext();
		ctx.appendContext(new ClassPathXmlApplicationContext(config));
	}

	/**
	 * 简单测试消息.
	 */
	@Test
	public void testSimpleMsg() {
		ProviderFactory fac = new ProviderFactory();
		I18nMsg msg = fac.getInstance(I18nMsg.class);
		TestCase.assertNotNull(msg);
		msg.setId("I99999999.0");
		msg.setLocale(Locale.ENGLISH);
		String txt = msg.getMessage();
		TestCase.assertEquals(true, "test".equals(txt));

		msg.setLocale(Locale.SIMPLIFIED_CHINESE);
		txt = msg.getMessage();
		TestCase.assertEquals("测试", txt);

	}

}
