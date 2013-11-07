package eastone.common.processor.io;

/**
 * 修改文件时是覆盖或者追加.
 * <p>
 * 	修改记录:
 * 	<ol>
 * 		<li>建立初始版本,by wangdongshi@neusoft.com, 2013-10-13 22:43.</li>
 * 	</ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public enum FileOverwriteEnum {
	/**
	 * 覆盖方式.
	 * <p>不保存源文件的内容.</p>
	 */
	OVERWRITE,
	/**
	 * 追加方式.
	 * <p>保留源文件的内容,并在文件后追加新内容.</p>
	 */
	APPEND;
}
