/*
 * File:HttpException.java
 * Type:eastone.component.http.HttpException
 */
package eastone.component.http;

/**
 * HTTP异常.
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-21 下午12:24:18</li>
 *    <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:48</li>
 *  </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class HttpException extends Exception {

	/**
	 * 序列化所需属性.
	 */
	private static final long serialVersionUID = 6972706432151085828L;

	/**
	 * HTTP状态码.
	 */
	private HttpStatusEnum status = null;

	/**
	 * 构造函数.
	 */
	public HttpException() {
		super();
	}

	/**
	 * 构造函数.
	 * @param msg 异常信息.
	 */
	public HttpException(String msg) {
		this(msg, null, null);
	}

	/**
	 * 构造函数.
	 * @param cause 根异常.
	 */
	public HttpException(Throwable cause) {
		this("", cause, null);
	}

	/**
	 * 构造函数.
	 * @param status HTTP状态.
	 */
	public HttpException(HttpStatusEnum status) {
		super();
		this.status = status;
	}

	/**
	 * 构造函数.
	 * @param msg 异常信息.
	 * @param status HTTP状态.
	 */
	public HttpException(String msg, HttpStatusEnum status) {
		this(msg, null, status);
	}

	/**
	 * 构造函数.
	 * @param msg 异常信息.
	 * @param cause 根异常.
	 */
	public HttpException(String msg, Throwable cause) {
		this(msg, cause, null);
	}

	/**
	 * 构造函数.
	 * @param cause 根异常.
	 * @param status HTTP状态.
	 */
	public HttpException(Throwable cause, HttpStatusEnum status) {
		this("", cause, status);
	}

	/**
	 * 构造函数.
	 * @param msg 异常信息.
	 * @param cause 根异常.
	 * @param status HTTP状态.
	 */
	public HttpException(String msg, Throwable cause, HttpStatusEnum status) {
		super(msg, cause);
		this.status = status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatusEnum status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public HttpStatusEnum getStatus() {
		return status;
	}
}
