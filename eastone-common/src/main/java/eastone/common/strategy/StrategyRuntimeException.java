/*
 * create time: 2013年12月3日 上午9:19:01
 * path: StrategyRuntimeException.java
 * type: eastone.common.strategy.StrategyRuntimeException
 */
package eastone.common.strategy;

/**
 * 策略执行时抛出的异常.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月3日 上午9:19:01
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class StrategyRuntimeException extends Exception {

  /**
   * 序列化版本常量.
   */
  private static final long serialVersionUID = 9145734355355542227L;

  /**
   * 默认构造函数.
   */
  public StrategyRuntimeException() {
  }

  /**
   * 构造函数.
   * @param message 消息.
   */
  public StrategyRuntimeException(final String message) {
    super(message);
  }

  /**
   * 构造函数.
   * @param cause 起源异常.
   */
  public StrategyRuntimeException(final Throwable cause) {
    super(cause);
  }

  /**
   * 构造函数.
   * @param message 消息.
   * @param cause 起源异常.
   */
  public StrategyRuntimeException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
