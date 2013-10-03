package eastone.common.processor;

public interface Processor <E extends Exception>{

	public void run() throws E;
	
}
