package eastone.common.factory;

public interface Factory<T,E extends Exception> {

	public T getInstance() throws E;
	
}
