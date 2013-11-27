/*
 * File:BouncyCastleProviderDriver.java
 * Type:eastone.common.utils.BouncyCastleProviderDriver
 */
package eastone.common.utils;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * BouncyCastle安全包Provider加载类.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-8 下午3:15:46</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class BouncyCastleProviderDriver {
  static {
    Security.addProvider(new BouncyCastleProvider());
  }
}
