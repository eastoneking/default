package eastone.common.processor;

public abstract class AbstractProcessorWithResult<T,E extends Exception> extends eastone.common.Object implements ProcessorWithResult<T,E> {
	
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
	public void run() throws E {
		this.setResult(execute());
	}
	
	protected abstract T execute() throws E;
	
}
