/*
 * File:DerbyTestSuite.java Type:eastone.derby.DerbyTestSuite
 */
package eastone.derby;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Derby数据库测试用例.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-8 下午9:32:13</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
@RunWith(Suite.class)
@SuiteClasses({ DerbyTestCase.class })
public class DerbyTestSuite {

}
