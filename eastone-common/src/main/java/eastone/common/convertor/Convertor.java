package eastone.common.convertor;

public interface Convertor<S,T,E extends Exception>{
	
	public T convers(S src) throws E;

}
