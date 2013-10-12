package eastone.common.processor;
/**
 * 
 * @author 王东石 <wangds@gmail.com>
 *
 * @param <E>
 */
public interface Processor <E extends Exception>{

	public void run() throws E;
	
}
