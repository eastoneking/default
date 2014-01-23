/*
 * File:HttpException.java Type:eastone.component.http.HttpException
 */
package eastone.component.http;

/**
 * HTTP异常.
 * <p>
 * <ol>
 * <li>初始版本,wangdongshi@neusoft.com,2013-10-21 下午12:24:18</li>
 * <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:48</li>
 * </ol>
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
  public HttpException(final String msg) {
    this(msg, null, null);
  }

  /**
   * 构造函数.
   * @param cause 根异常.
   */
  public HttpException(final Throwable cause) {
    this("", cause, null);
  }

  /**
   * 构造函数.
   * @param theStatus HTTP状态.
   */
  public HttpException(final HttpStatusEnum theStatus) {
    super();
    this.status = theStatus;
  }

  /**
   * 构造函数.
   * @param msg 异常信息.
   * @param theStatus HTTP状态.
   */
  public HttpException(final String msg, final HttpStatusEnum theStatus) {
    this(msg, null, theStatus);
  }

  /**
   * 构造函数.
   * @param msg 异常信息.
   * @param cause 根异常.
   */
  public HttpException(final String msg, final Throwable cause) {
    this(msg, cause, null);
  }

  /**
   * 构造函数.
   * @param cause 根异常.
   * @param theStatus HTTP状态.
   */
  public HttpException(final Throwable cause, final HttpStatusEnum theStatus) {
    this("", cause, theStatus);
  }

  /**
   * 构造函数.
   * @param msg 异常信息.
   * @param cause 根异常.
   * @param theStatus HTTP状态.
   */
  public HttpException(
      final String msg, final Throwable cause, final HttpStatusEnum theStatus) {
    super(msg, cause);
    this.status = theStatus;
  }

  /**
   * @param theStatus the status to set
   */
  public void setStatus(final HttpStatusEnum theStatus) {
    this.status = theStatus;
  }

  /**
   * @return the status
   */
  public HttpStatusEnum getStatus() {
    return status;
  }
}
