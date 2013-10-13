package eastone.common.processor;

/**
 * 抽象的带有执行结果的处理器.
 * <p>保存实现了执行结果的接口器.</p>
 * <p>修改列表:
 * <ol>
 * 	<li>
 * 		<ul>
 * 			<li>补充注释</li>
 * 			<li>增加方法{@link #clear()},用于清理结果.</li>
 * 			<li>修改方法{@link #process()},在开始处理之前检查结果是否为空,如果不为空,抛出异常,提示结果未清理.</li>
 * 		</ul>
 * 		by wangds@gmail.com 2013-10-13 10:40
 * 	</li>
 * </ol>
 * </p>
 * @param <T> 执行结果的类型.
 * @param <E> 执行过程中可能出现的异常,必须继承自{@link java.lang.Exception}.
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractProcessorWithResult<T,E extends Exception> extends eastone.common.Object implements ProcessorWithResult<T,E> {
	
	/**
	 * 保存执行结果的属性.
	 */
	private T result=null;
	
	@Override
	public void setResult(T result) {
		this.result = result;
	}
	
	@Override
	public T getResult() {
		return this.result;
	}
	
	@Override
	public void process() throws E {
		if(this.result!=null){
			//TODO 提示消息使用i18n.
			new RuntimeException("上次执行结果尚未清空.请在执行之前调用方法clear().");
		}
		this.setResult(execute());
	}
	
	protected abstract T execute() throws E;
	
	public void clear(){
		this.result=null;
	}
	
}
