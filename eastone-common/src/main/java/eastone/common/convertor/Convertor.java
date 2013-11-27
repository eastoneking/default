package eastone.common.convertor;

/**
 * 转换器接口.
 * <p>
 * 把一种类型的对象转换为另一种类型的对象.一般来说，是通过现有对象的属性，生成一个 新的对象，新对象的一些属性与原有对象有一定的映射关系.
 * </p>
 * <p>
 * 修改列表:
 * <ol>
 * <li>2013-10-12 23:55 补充注释</li>
 * </ol>
 * </p>
 * @param <S> 输入源类型.
 * @param <T> 输出目标类型.
 * @param <E> 转换时可能抛出的异常.
 * @version 0.1.1
 * @since 0.1
 * @author 王东石 <wangdongshi@neusoft.com>
 */
public interface Convertor<S, T, E extends Exception> {

  /**
   * 转换功能.
   * @param src 输入参数
   * @return 输出对象
   * @throws E 可能的异常
   */
  T convert(S src) throws E;

}
