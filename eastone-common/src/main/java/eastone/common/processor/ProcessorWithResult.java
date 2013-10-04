package eastone.common.processor;

public interface ProcessorWithResult<T,E extends Exception> extends Processor<E>,ResultContainer<T>{

}
