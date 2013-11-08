/*
 * File:DesUtil.java
 * Type:eastone.common.utils.DesUtil
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
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import eastone.common.GeneralParentObject;

/**
 * AES算法加密工具.
 * <p>192位密钥.</p>
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午8:49:10</li>
 * </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public final class AesUtil extends GeneralParentObject {

	/**
	 * IV大小.
	 */
	private static final int IV_SIZE = 16;

	/**
	 * BC包中AES算法名.
	 */
	public static final String ALGORITHM_LONG_NAME = "AES/CBC/PKCS7Padding";

	/**
	 * BC包中AES算法名.
	 */
	public static final String ALGORITHM_SHORT_NAME = "AES";

	/**
	 * BC Provider名称.
	 */
	public static final String PROVIDER_NAME = "BC";



	static {
		//加载BouncyCastle的Provider.
		try {
			Class.forName("eastone.common.utils.BouncyCastleProviderDriver");
		} catch (ClassNotFoundException e) {
			GeneralParentObject.staticLogger(AesUtil.class)
			.warn(e.getMessage(), e);
		}
	}



	/**
	 * 构造函数.
	 */
	private AesUtil() {

	}

	/**
	 * 生成加密解密用的Sipher.
	 * @param mode 加密或解密模式.
	 * @param key 密钥.
	 * @param iv 初始矩阵.
	 * @return Cipher.
	 * @throws NoSuchAlgorithmException 异常.
	 * @throws NoSuchProviderException 异常.
	 * @throws NoSuchPaddingException 异常.
	 * @throws InvalidKeyException 异常.
	 * @throws InvalidAlgorithmParameterException 异常.
	 */
	private static Cipher generateCipher(int mode, byte[] key, byte[] iv)
			throws
				NoSuchAlgorithmException,
				NoSuchProviderException,
				NoSuchPaddingException,
				InvalidKeyException,
				InvalidAlgorithmParameterException {
		Cipher res = null;
		SecretKey secret_key = null;
		IvParameterSpec iv_parameter = null;

			secret_key = new SecretKeySpec(key, ALGORITHM_SHORT_NAME);
			iv_parameter = new IvParameterSpec(iv);
			res = Cipher.getInstance(ALGORITHM_LONG_NAME, PROVIDER_NAME);
			res.init(mode, secret_key, iv_parameter);

		return res;
	}

	/**
	 * 处理加密解密过程.
	 * @param input 输入.
	 * @param cipher cipher.
	 * @return 结果.
	 */
	private static byte[] process(byte[] input, Cipher cipher) {

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
		byte[] res = null;
		KeyGenerator keyGen = null;
		SecretKey key = null;
		try {
			keyGen = KeyGenerator.getInstance(
				ALGORITHM_SHORT_NAME,
				PROVIDER_NAME
			);
			keyGen.init(new SecureRandom());
			key = keyGen.generateKey();
			res = key.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			staticLogger(AesUtil.class).error(e.getMessage(), e);
		} catch (NoSuchProviderException e) {
			staticLogger(AesUtil.class).error(e.getMessage(), e);
		}
		return res;
	}

	/**
	 * 生成初始矩阵.
	 * @return 初始矩阵.
	 */
	public static byte[] generateIvParameter() {
		byte[] t = new byte[IV_SIZE];
		new SecureRandom().nextBytes(t);
		return t;
	}

	/**
	 * 加密.
	 * @param data 加密的数据.
	 * @param key 密钥.
	 * @param iv CBC算法所需初始矩阵.
	 * @return 加密结果.
	 */
	public static byte[] encrypt(byte[] data, byte[] key, byte[] iv)  {
		byte[] res = null;
		try {
			res = process(data, generateCipher(Cipher.ENCRYPT_MODE, key, iv));
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
	 * @param iv CBC算法所需初始矩阵.
	 * @return 解密结果.
	 */
	public static byte[] decrypt(byte[] data, byte[] key,  byte[] iv)  {
		byte[] res = null;
		try {
			res = process(data, generateCipher(Cipher.DECRYPT_MODE, key, iv));
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
