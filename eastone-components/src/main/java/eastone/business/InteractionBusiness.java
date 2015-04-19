/*
 * create:2015年4月19日 下午8:54:29
 * author:wangds  
 */
package eastone.business;

/**
 * .
 * @author wangds
 *
 */
public interface InteractionBusiness<IN,OUT> extends Business {
    void setInput(IN input);
    IN getInput();
    void setOutput(OUT output);
    OUT getOutput();
}
