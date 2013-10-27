package eastone.common.processor.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import eastone.common.processor.Clearable;
import eastone.common.processor.Processor;

/**
 * 将byte[]写入到文件的处理器.
 * <p>如果写入文件夹不存在,可以根据属性{@link #isMakeParentDirectory()}的设置决定
 * 是否创建父目录.</p>
 * <p>
 * 	修改记录:
 * 	<ol>
 * 		<li>补充注释. by wangds@gmail.com 2013-10-13 21:33</li>
 * 		<li>增加实现接口{@link eastone.common.processor.Clearable}, 
 * 			by wangds@gmail.com 2013-10-13 22:36</li>
 * 		<li>增加覆盖写入或追加写入模式的处理,wangds@gmail.com 2013-10-13 22:46.
 * 		<li>
 *  </ol>
 * </p>
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 * 
 */
public class Bytes2FileProcessor 
	extends eastone.common.Object 
	implements Processor<IOException>, Clearable {
	
	/**
	 * 是否创建父目录.
	 */
	private boolean makeParentDirectory;
	
	/**
	 * 要写入文件的数据.
	 */
	private byte[] data;
	
	/**
	 * 要操作的文件.
	 */
	private File file;
	
	/**
	 * 文件是覆盖写入或追加写入模式.
	 * <p>默认值为追加写入模式.</p>
	 */
	private FileOverwriteEnum overwrite = FileOverwriteEnum.APPEND;
	
	/**
	 * 设置文件写入模式.
	 * @param overWrite 写入模式.
	 * @see eastone.common.processor.io.FileOverwriteEnum
	 */
	public void setOverwrite(FileOverwriteEnum overWrite) {
		this.overwrite = overWrite;
	}
	
	/**
	 * 获得文件写入模式.
	 * @return 写入模式.
	 * @see eastone.common.processor.io.FileOverwriteEnum
	 */
	public FileOverwriteEnum getOverwrite() {
		return overwrite;
	}
	
	/**
	 * 设置要写入的数据.
	 * @param data 要写入的数据.
	 */
	public void setData(byte[] data) {
		this.data = data;
	}
	
	/**
	 * 设置要操作的文件.
	 * @param file 要操作的文件.
	 * <p>文件可以不存在.</p>
	 * 
	 */
	public void setFile(File file) {
		this.file = file;
	}
	/**
	 * 获得要写入的数据.
	 * @return 要写入的数据.
	 */
	public byte[] getData() {
		return data;
	}
	
	/**
	 * 获得要操作的文件.
	 * @return 要操作的文件.
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * 设置当文件所在目录不存在时是否创建目录.
	 * @param makeParentDirectory 是否创建.
	 * <p>
	 * <table>
	 * 	<tr>
	 * 		<th>值</th>
	 * 		<th>描述</th>
	 * 		<th>默认值</th>
	 *  </tr>
	 *  <tr>
	 *  	<th>true</th>
	 *  	<td>创建不存在的目录,如果缺失多个目录,则一同创建.</td>
	 *  	<td>是</td>
	 *  </tr>
	 *  <tr>
	 *  	<th>false</th>
	 *  	<td>如果不存在则不创建,并抛出异常.</td>
	 *  	<td>否</td>
	 *  </tr>
	 * </table>
	 * </p>
	 */
	public void setMakeParentDirectory(boolean makeParentDirectory) {
		this.makeParentDirectory = makeParentDirectory;
	}
	
	/**
	 * 获得是否创建缺失的目录.
	 * @return 是否创建缺失的目录.
	 */
	public boolean isMakeParentDirectory() {
		return makeParentDirectory;
	}
	
	/**
	 * 执行处理过程.
	 * <p>
	 * 业务逻辑：<br/>
	 * <pre>
	 *    ┌─────┐
	 *    │start│
	 *    └──┬──┘
	 *       ↓
	 *  ┌────┴─────┐
	 *  │check the │
	 *  │parent    │
	 *  │directory │
	 *  └────┬─────┘
	 *       ╱╲
	 *      ╱  ╲        no    ┌─────────┐
	 *     ╱make╲────────────→┤throw io ├──→◎
	 *     ╲ dir╱             │exception│
	 *      ╲  ╱              └─────────┘
	 *       ╲╱
	 *       ↓yes
	 *    ┌─────────┐
	 *    │make the │
	 *    │parent   │
	 *    │directy  │
	 *    └────┬────┘
	 *         ↓
	 *    ┌────┴────┐
	 *    │write the│
	 *    │bytes to │
	 *    │the file.│
	 *    └────┬────┘
	 *         ↓
	 *         │
	 *         ◎
	 * </pre>
	 * </p>
	 * @throws IOException 异常
	 */
	@Override
	public void process() throws IOException {
		assert file != null;
		if (this.data != null && this.file != null) {
			if (!validateParentPath(file)) {
				throw new IOException();
			}
			writeData2File(this.data, this.file);
		}
	}

	/**
	 * 将数据写入文件.
	 * @param data 数据内容
	 * @param file 文件
	 * @throws IOException 可能出现的异常.
	 */
	private void writeData2File(byte[] data, File file) throws IOException {
		assert file != null;
		FileOutputStream fos = null;
		try {
			
			boolean is_append = 
					FileOverwriteEnum.APPEND.equals(this.overwrite)
					|| this.overwrite == null;
			
			fos = new FileOutputStream(file, is_append);
			assert fos != null;
			fos.write(data);
			fos.flush();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					this.getLogger().warn("", e);
				}
			}
		}
	}

	/**
	 * 验证父目录是否存在.
	 * @param file 文件.
	 * <p>
	 * 父目录是指参数文件的父目录.如果本参数文件为"/home/appuser/test.txt",则父目录
	 * 为"/home/appuser"
	 * </p>
	 * 
	 * @return 父目录是否存在.
	 * <p>返回值列表:<br/>
	 * <table>
	 * 	<tr>
	 * 		<th>值</th>
	 * 		<th>含义</th>
	 * 	</tr>
	 * 	<tr>
	 * 		<th>true</th>
	 * 		<td>目录存在,或虽然验证前不存在,但是根据属性
	 * 		{@link #isMakeParentDirectory()}的设置已经成功创建.</td>
	 * 	</tr>
	 * 	<tr>
	 * 		<th>false</th>
	 * 		<td>目录不存在,且属性{@link #isMakeParentDirectory()}被设置为不创建,
	 * 		或目录不存在,属性{@link #isMakeParentDirectory()}虽然设置为创建,但实际
	 * 		创建不成功.</td>
	 * 	</tr>
	 * </table>
	 * </p>
	 */
	private boolean validateParentPath(File file) {
		boolean res = false;
		File parent = file.getParentFile();
		res = parent.exists();
		if ((!res) && makeParentDirectory) {
			try {
				parent.mkdirs();
				res = true;
			} catch (Exception e) {
				this.getLogger().warn(
						"can't create the path \"" + parent.getPath() + "\".");
			}
		}
		return res;
	}
	
	/**
	 * 清理处理器,以便重新利用.
	 * <p>属性{@link #data}设置为空;属性{@link #file}设置为空;
	 * 属性{@link #makeParentDirectory}设置为"true";写入模式为追加.</p>
	 */
	public void clear() {
		this.data = null;
		this.file = null;
		this.makeParentDirectory = true;
		this.overwrite = FileOverwriteEnum.APPEND;
	}

}
