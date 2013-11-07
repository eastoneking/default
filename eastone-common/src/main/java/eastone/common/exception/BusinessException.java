/*
 * File:BusinessException.java
 * Type:eastone.common.exception.BusinessException
 */
package eastone.common.exception;

import eastone.common.i18n.I18nMsg;

/**
 * 业务异常.
 *
 * <p>
 * 业务处理过程应当抛出业务异常.
 * </p>
 *
 * <p>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-6 12:52:28</li>
 *  </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public class BusinessException extends Exception {

	/**
	 * 序列化所需字段.
	 */
	private static final long serialVersionUID = 1855488935640307961L;

	/**
	 * 构造函数.
	 */
	public BusinessException() {
		super();
	}

	/**
	 * 构造函数.
	 * @param message 消息.
	 * @param cause 起因异常.
	 * @deprecated 建议通过
	 *  {@link #BusinessException(I18nMsg, Throwable)}方式调用构造函数.
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造函数.
	 * @param message 消息.
	 * @deprecated 建议通过 {@link #BusinessException(I18nMsg)}方式调用构造函数.
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * 构造函数.
	 * @param cause 起因异常.
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造函数.
	 * @param message 国际化消息.
	 */
	public BusinessException(I18nMsg message) {
		super(message.getMessage());
	}

	/**
	 * 构造函数.
	 * @param message 国际化消息.
	 * @param cause 起因异常.
	 */
	public BusinessException(I18nMsg message, Throwable cause) {
		super(message.getMessage(), cause);
	}


}
