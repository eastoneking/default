package eastone.common.processor.io;

import java.io.IOException;
import java.io.OutputStream;

import eastone.common.GeneralParentObject;
import eastone.common.processor.Clearable;
import eastone.common.processor.Processor;

/**
 * <p>
 * 修改记录:
 * <ol>
 * <li>补充注释,by wangdongshi@neusoft.com,2013-10-13 22:58.</li>
 * <li>增加偏移量和长度的支持,by wangdongshi@neusoft.com,2013-10-13 23:08.</li>
 * <li>增加实现接口{@link Clearable}, by wangdongshi@neusoft.com,2013-10-16 08:00.
 * </li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class Bytes2OutputStreamProcessor extends GeneralParentObject implements
    Processor<IOException>, Clearable {

  /**
   * 用于数据的输出流.
   */
  private OutputStream outputStream;

  /**
   * 设置用于输出的输出流.
   * @param theOutputStream 输出流.
   *          <p>
   *          输出流应该未被关闭.
   *          </p>
   */
  public void setOutputStream(final OutputStream theOutputStream) {
    this.outputStream = theOutputStream;
  }

  /**
   * 获得用于输出的输出流.
   * @return 输出流.
   */
  public OutputStream getOutputStream() {
    return outputStream;
  }

  /**
   * 输出数据.
   */
  private byte[] data;

  /**
   * 设置输出数据.
   * @param theData 输出数据.
   */
  public void setData(final byte[] theData) {
    this.data = theData;
  }

  /**
   * 获得输出数据.
   * @return 输出数据.
   */
  public byte[] getData() {
    return data;
  }

  /**
   * 输出数据的开始偏移量,默认值为"0".
   */
  private int offset = 0;

  /**
   * 设置输出数据的开始偏移量.
   * @param theOffset 输出数的开始偏移量.
   *          <p>
   *          0<=offset<=data.length.
   *          </p>
   */
  public void setOffset(final int theOffset) {
    this.offset = theOffset;
  }

  /**
   * 输出数据的长度,-1为动态计算.
   */
  private int length = -1;

  /**
   * 设置输出数据的长度.
   * @param theLength 输出长度.
   * @see #process()
   */
  public void setLength(final int theLength) {
    this.length = theLength;
  }

  /**
   * 获得输出数据的长度.
   * @return 输出数据的长度.
   * @see #process()
   */
  public int getLength() {
    return length;
  }

  /**
   * 执行输出数据.
   * <p>
   * 处理过程:<br/>
   * <pre>
   *               ●
   *               ↓
   *          ┌──┬─┴───────┐
   *          │if│test file│ any one is null.
   *          ├──┘and data ├─────────▷──────◎
   *          │ is null.   │
   *          └──────┬─────┘
   *                 ▽every is not null.
   *           ┌─────┴────┐
   *           │calculate │
   *           │the offset│
   *           │value.    │
   *           └────┬─────┘
   *                ▽
   *         ┌──────┴────────┐
   *         │calculate the  │
   *         │length value   │
   *         │with offset and│
   *         │data's length. │
   *         └──────┬────────┘
   *                ▽
   *         ┌──────┴────────┐
   *         │write the data │
   *         │special by off-│
   *         │set and length.│
   *         └──────┬────────┘
   *                ▽
   *         ┌──────┴───────┐
   *         │flush the out-│
   *         │put stream.   │
   *         └──────┬───────┘
   *                ▽
   *                ◎
   * </pre>
   * </p>
   * @throws IOException 异常.
   */
  @Override
  public void process() throws IOException {
    if (outputStream != null && this.data != null) {
      int maxLength = data.length;
      int offsizeValue = calculateOffset(maxLength);
      int len = calculateLength(offsizeValue, maxLength);
      outputStream.write(data, offsizeValue, len);
      outputStream.flush();
    }
  }

  /**
   * 计算输出长度.
   * <p>
   * 为了防止输出越界,会根据已经计算获得的偏移量和输出数据的大小,确定能够输出数 据的范围,并依据这个范围对输出长度进行计算.
   * </p>
   * <p>
   * 处理过程:
   * <pre>
   *                ●
   *                │
   *                ▽
   *       ┌────────┴────────┐
   *       │get the property │
   *       │"length"'s value │
   *       │ as result.      │
   *       └────────┬────────┘
   *                ▽
   *       ┌──┬─────┴────────┐
   *       │if│testing the   │if the result has been little than zero,
   *       ├──┘result value  │that mean the length would be calculate when
   *       │ has been little │write; if the offset add the result has been
   *       │ than zero, or   │ greate than the max length value, the result
   *       │ the offset add  │ is a wrong value
   *       │ the result is   │       ┌─────────────────┐
   *       │ greate than the ├──▷────┤set the result to│
   *       │ max length value│       │the max length   │
   *       └────────┬────────┘       │div to offset.   │
   *            else▽               └─────────┬───────┘
   *                │                         ▽
   *                └───────────────▽─────────┘
   *                          ┌─────┴──────┐
   *                          │return the  │
   *                          │ result.    │
   *                          └─────┬──────┘
   *                                ▽
   *                                │
   *                                ◎
   * </pre>
   * </p>
   * @param theOffset 已经计算过的偏移量.
   *          <p>
   *          不能为负值,不能大于数据数组的长度.
   *          </p>
   * @param theMaxLength 输出数据数组的长度.
   * @return 安全的输出长度.
   */
  private int calculateLength(final int theOffset, final int theMaxLength) {
    int res = this.length;
    if (res < 0 || theOffset + res > theMaxLength) {
      res = theMaxLength - theOffset;
    }
    return res;
  }

  /**
   * 计算偏移量.
   * <p>
   * 偏移量即实际输出数据在给定数据属性{@link #data}中开始位置的坐标.
   * </p>
   * <p>
   * 处理过程:<br/>
   * <pre>
   *               ●
   *               ↓
   *       ┌───────┴─────────┐
   *       │get the property │
   *       │"offset"'s value │
   *       │ as result.      │
   *       └───────┬─────────┘
   *               ↓
   *       ┌──┬────┴─────────┐                     ┌──────────────┐
   *       │if│testing the   │ is little than zero │set the result│
   *       ├──┘result value  ├──────→──────────────┤value to zero.│
   *       │ has been little │                     └───────┬──────┘
   *       │ than zero.      │                             ↓
   *       └───────┬─────────┘                             │
   *               ↓ is not little than zero.              │
   *       ┌──┬────┴─────────┐                             │
   *       │if│testing the   ├─────────────────────────────┘
   *       ├──┘result value  │
   *       │ has been greate │                           ┌──────────────┐
   *       │ than max length,│is greate than max length. │set the result│
   *       │ which is proper-├──────→────────────────────┤value to the  │
   *       │ty "data"'s byte │                           │max length    │
   *       │array's length.  │                           │value.        │
   *       └───────┬─────────┘                           └───────┬──────┘
   *               └─────→──────────────┬───────────────────←────┘
   *        is not great than max length↓
   *                                    ◎
   * </pre>
   * </p>
   * @param maxLength 偏移量最大值.
   *          <p>
   *          最大值为属性{@link #data}的byte数组的长度.
   *          </p>
   * @return 实际输出时的偏移量.
   */
  private int calculateOffset(final int maxLength) {
    int res = this.offset;
    if (res < 0) {
      res = 0;
    }
    if (res > maxLength) {
      res = maxLength;
    }
    return res;
  }

  /**
   * 清理现有状态.
   * <p>
   * 方法{@link #clear()}不会关闭{@link #outputStream}.<br/>
   * 清理后的属性状态:
   * <table>
   * <tr>
   * <th>属性</th>
   * <th>默认值</th>
   * </tr>
   * <tr>
   * <th>{@link #data}</th>
   * <td>byte[0]</td>
   * </tr>
   * <tr>
   * <th>{@link #offset}</th>
   * <td>0</td>
   * </tr>
   * <tr>
   * <th>{@link #length}</th>
   * <td>-1</td>
   * </tr>
   * <tr>
   * <th>{@link #outputStream}</th>
   * <td>null</td>
   * </tr>
   * </table>
   * .
   * </p>
   */
  @Override
  public void clear() {
    this.data = new byte[0];
    this.offset = 0;
    this.length = -1;
    this.outputStream = null;
  }
}
