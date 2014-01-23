package eastone.common.processor.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import eastone.common.adapter.Adapter;
import eastone.common.convertor.Convertor;
import eastone.common.processor.AbstractProcessorWithResult;
import eastone.common.processor.Processor;

/**
 * 从文件中获取byte数组型数据的处理器.
 * <p>
 * 修改列表:
 * <ol>
 * <li>by wangdongshi@neusoft.com, 2013-10-16 08:13
 * <ul>
 * <li>补充注释.</li>
 * <li>设置属性{@link #inner}的默认值.</li>
 * <li>方法{@link #convert(File)}中添加对属性{@link #inner}的非空检 查.</li>
 * </ul>
 * </li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.3
 * @since 0.1
 */
public class File2BytesProcessor extends
    AbstractProcessorWithResult<byte[], IOException> implements
    Convertor<File, byte[], IOException>,
    Adapter<Convertor<InputStream, byte[], IOException>>,
    Processor<IOException> {
  /**
   * 要读取的文件.
   */
  private File file;

  /**
   * 设置要读取的文件.
   * @param theFile 文件
   */
  public void setFile(final File theFile) {
    this.file = theFile;
  }

  /**
   * 获得要读取的文件.
   * @return 文件
   */
  public File getFile() {
    return file;
  }

  /**
   * 用于从文件对应的数据流读取数据的转换器.
   * <p>
   * 默认值为 {@link InputStream2BytesProcessor}类型.
   * </p>
   */
  private Convertor<InputStream, byte[], IOException> inner
    = new InputStream2BytesProcessor();

  /**
   * 获得转换器.
   * @return 获得转换器.
   */
  @Override
  public Convertor<InputStream, byte[], IOException> getAdaptee() {
    return inner;
  }

  /**
   * 设置转换器.
   * @param theInner 转换器.
   */
  public void setInner(
      final Convertor<InputStream, byte[], IOException> theInner
  ) {
    this.inner = theInner;
  }

  /**
   * 从文件中读取数据的过程.
   * <p>
   * 如果文件不存在或无法读取均抛出异常.
   * </p>
   * <p>
   * 处理过程：
   * <pre>
   *                ○
   *                ↓
   *   ┌──┬─────────┴────────────┐ if the argument is null.
   *   │if│ test input argument. ├→────────────────────────⊙
   *   └──┴─────────┬────────────┘
   *                ↓ else
   *   ┌──┬─────────┴────────────┐ if property "inner" is null.
   *   │if│ test property "inner"├→────────────────────────⊙
   *   └──┴─────────┬────────────┘
   *                ↓ else
   *   ┌──┬─────────┴────────────┐ if the file is't exist.┌───────────────┐
   *   │if│ test the file.       ├→───────────────────────┤throw file not │
   *   ├──┘                      │                        │found exception│
   *   └────────────┬────────────┘                        └───────┬───────┘
   *                ↓   else                                      ⊙
   *   ┌──┬─────────┴────────────┐if  can't be read.      ┌───────────────┐
   *   │if│ test the file.       ├→───────────────────────┤throw an io    │
   *   ├──┘                      │                        │exception      │
   *   └────────────┬────────────┘                        └───────┬───────┘
   *                ↓   else                                      ⊙
   *   ┌──┬─────────┴────────────┐
   *   │if│ test the file.       │
   *   ├──┘                      │
   *   └────────────┬────────────┘
   *                ↓
   *   ┌────────────┴────────────┐
   *   │ build the file's input  │
   *   │stream object "fis".     │
   *   └────────────┬────────────┘
   *                ↓
   *   ┌────────────┴────────────┐
   *   │ invoke inner's function │
   *   │ "convert",and save the  │
   *   │ convert result as "res".│
   *   └────────────┬────────────┘
   *                ↓
   *   ┌────────────┴────────────┐
   *   │ close the file input    │
   *   │ stream.                 │
   *   └────────────┬────────────┘
   *                ↓
   *   ┌────────────┴────────────┐
   *   │ return "res" as result. │
   *   └────────────┬────────────┘
   *                ⊙
   * </pre>
   * </p>
   * @param src 输入文件.
   * @throws IOException 异常.
   * @return 转换结果.
   */
  @Override
  public byte[] convert(final File src) throws IOException {
    byte[] res = null;
    if (src == null || this.inner == null) {
      return res;
    }
    if (!src.exists()) {
      throw new FileNotFoundException(src.getPath());
    }
    if (!src.canRead()) {
      throw new IOException("file can't be read. the file is " + src.getPath());
    }
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(src);
      res = this.inner.convert(fis);
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (Exception e) {
          this.getLogger().warn("", e);
        }
      }
    }
    return res;
  }

  @Override
  protected byte[] execute() throws IOException {
    return convert(file);
  }

}
