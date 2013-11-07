package eastone.common.processor.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import eastone.common.convertor.Convertor;
import eastone.common.processor.AbstractProcessorWithResult;

/**
 * 从输入流获取字节数组的处理器.
 * <p>
 * 本处理器会输入流中读取全部数据,不能只读一部分.所有数据读出后,不会关闭被读取的输入
 * 流.
 * </p>
 * <p>修改列表:
 * <ol>
 * 	<li>by wangdongshi@neusoft.com, 2013-10-16 12:16
 * 		<ul>
 * 			<li>补充注释.</li>
 * 		</ul>
 * 	</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public class InputStream2BytesProcessor 
	extends AbstractProcessorWithResult<byte[], IOException> 
	implements Convertor<InputStream, byte[], IOException> {
	
	/**
	 * 默认缓冲大小.
	 */
	private static final int DEFAULT_BUFFER_SIZE = 524288;

	/**
	 * 每次读取的数据长度.
	 * <p>
	 * 默认值5M.
	 * </p>
	 */
	private int bufferSize = DEFAULT_BUFFER_SIZE;
	
	/**
	 * 要读取的输入流.
	 * <p>输入流应该已经打开.</p>
	 */
	private InputStream inputStream;
	
	/**
	 * 设置每次读取的数据长度.
	 * @param bufferSize 每次读取的数据长度
	 */
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
	
	/**
	 * 获取每次读取的数据长度.
	 * @return 每次读取的数据长度.
	 */
	public int getBufferSize() {
		return bufferSize;
	}
	
	/**
	 * 设置要读取的输入流.
	 * @param inputStream 要读取的输入流.
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	/**
	 * 获取要读取的输入流.
	 * @return 要读取的输入流.
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	@Override
	protected byte[] execute() throws IOException {
		return convert(inputStream);
	}
	
	/**
	 * 从输入流中读取数据的过程.
	 * <p>处理过程:
	 * <pre>
	 *                ○
	 *                ↓              
	 *   ┌──┬─────────┴────────────┐ if the argument is null.
	 *   │if│ test input argument. ├→────────────────────────⊙
	 *   └──┴─────────┬────────────┘
	 *                ↓              
	 *   ┌────────────┴────────────┐
	 *   │build the buffer for     │
	 *   │reading datas            │
	 *   └────────────┬────────────┘
	 *                ↓              
	 *   ┌────────────┴────────────┐
	 *   │initialized byte array   │
	 *   │for reading datas.       │
	 *   └────────────┬────────────┘
	 *                ↓
	 *   ┌─────┬──────┴────────────┐
	 *   │while│ reading bytes's   │
	 *   ├─────┘ length is greate  │
	 *   │ than 0                  │
	 *   ├~~~~~~~~~~~~~~~~~~~~~~~~~┤
	 *   │ save the bytes to the   │
	 *   │ buffer.                 │
	 *   └────────────┬────────────┘
	 *                ↓
	 *   ┌────────────┴────────────┐
	 *   │flush and close the      │
	 *   │buffer.                  │
	 *   └────────────┬────────────┘
	 *                ↓
	 *   ┌────────────┴────────────┐
	 *   │save the buffer's content│
	 *   │ as res,and return the   │
	 *   │ res as result value.    │
	 *   └────────────┬────────────┘
	 *                ◎
	 *</pre>
	 * </p>
	 * @param src 输入流.
	 * @return 文件内容.
	 * @throws IOException 异常.
	 */
	@Override
	public byte[] convert(InputStream src) throws IOException {
		byte[] res = null;
		
		if (src == null) {
			return res;
		}
		
		ByteArrayOutputStream buf = null;
		try {
			buf = new ByteArrayOutputStream();
			byte[] cur = new byte[bufferSize];
			int len = -1;
			while ((len = src.read(cur)) >= 0) {
				buf.write(cur, 0, len);
			}
			buf.flush();
		} finally {
			try {
				buf.close();
			} catch (Exception e) {
				this.getLogger().warn("", e);
			}
		}
		res = buf.toByteArray();
		return res;
	}
	
}
