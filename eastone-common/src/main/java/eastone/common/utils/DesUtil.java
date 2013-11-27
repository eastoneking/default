/*
 * File:DesUtil.java Type:eastone.common.utils.DesUtil
 */
package eastone.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import eastone.common.GeneralParentObject;

/**
 * DES算法加密工具.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午8:49:10</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public final class DesUtil extends GeneralParentObject {

  /**
   * 密钥长度.
   */
  private static final int KEY_LENGTH = 8;

  /**
   * BC包中DES算法名.
   */
  public static final String ALGORITHM_LONG_NAME = "DES/ECB/PKCS7Padding";

  /**
   * BC包中AES算法名.
   */
  public static final String ALGORITHM_SHORT_NAME = "DES";

  /**
   * BC Provider名称.
   */
  public static final String PROVIDER_NAME = "BC";

  static {
    // 加载BouncyCastle的Provider.
    try {
      Class.forName("eastone.common.utils.BouncyCastleProviderDriver");
    } catch (ClassNotFoundException e) {
      GeneralParentObject.staticLogger(AesUtil.class).warn(e.getMessage(), e);
    }
  }

  /**
   * 构造函数.
   */
  private DesUtil() {

  }

  /**
   * 生成加密解密用的Sipher.
   * @param mode 加密或解密模式.
   * @param key 密钥.
   * @return Cipher.
   * @throws NoSuchAlgorithmException 异常.
   * @throws NoSuchProviderException 异常.
   * @throws NoSuchPaddingException 异常.
   * @throws InvalidKeyException 异常.
   * @throws InvalidAlgorithmParameterException 异常.
   */
  private static Cipher generateCipher(final int mode, final byte[] key)
      throws NoSuchAlgorithmException, NoSuchProviderException,
      NoSuchPaddingException, InvalidKeyException,
      InvalidAlgorithmParameterException {
    Cipher res = null;
    SecretKey secretKey = null;

    secretKey = new SecretKeySpec(key, ALGORITHM_SHORT_NAME);
    res = Cipher.getInstance(ALGORITHM_LONG_NAME, PROVIDER_NAME);
    res.init(mode, secretKey);

    return res;
  }

  /**
   * 处理加密解密过程.
   * @param input 输入.
   * @param cipher cipher.
   * @return 结果.
   */
  private static byte[] process(final byte[] input, final Cipher cipher) {
    byte[] res = null;
    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    CipherOutputStream cOut = new CipherOutputStream(bOut, cipher);

    try {
      cOut.write(input);
      cOut.flush();
      cOut.close();
      res = bOut.toByteArray();
    } catch (IOException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    }
    return res;
  }

  /**
   * 获得密钥.
   * @return 密钥.
   */
  public static byte[] generateKey() {
    byte[] key = null;
    SecureRandom sr = null;
    try {
      sr = new SecureRandom();
      sr.setSeed(System.currentTimeMillis());
      key = new byte[KEY_LENGTH];
      sr.nextBytes(key);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return key;

  }

  /**
   * 加密.
   * @param data 加密的数据.
   * @param key 密钥.
   * @return 加密结果.
   */
  public static byte[] encrypt(final byte[] data, final byte[] key) {
    byte[] res = null;
    try {
      res = process(data, generateCipher(Cipher.ENCRYPT_MODE, key));
    } catch (InvalidKeyException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    } catch (NoSuchAlgorithmException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    } catch (NoSuchProviderException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    } catch (NoSuchPaddingException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    } catch (InvalidAlgorithmParameterException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    }
    return res;
  }

  /**
   * 解密.
   * @param data 解密的数据.
   * @param key 密钥.
   * @return 解密结果.
   */
  public static byte[] decrypt(final byte[] data, final byte[] key) {
    byte[] res = null;
    try {
      res = process(data, generateCipher(Cipher.DECRYPT_MODE, key));
    } catch (InvalidKeyException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    } catch (NoSuchAlgorithmException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    } catch (NoSuchProviderException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    } catch (NoSuchPaddingException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    } catch (InvalidAlgorithmParameterException e) {
      staticLogger(AesUtil.class).error(e.getMessage(), e);
    }
    return res;
  }

}
