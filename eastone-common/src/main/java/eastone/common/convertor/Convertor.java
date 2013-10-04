package eastone.common.convertor;

public interface Convertor<S,T,E extends Exception>{
	
	public T convert(S src) throws E;

}
