/*
 * create:2015年4月19日 下午8:28:59
 * author:wangds  
 */
package eastone.controller;

/**
 * .
 * @author wangds
 *
 */
public interface InteractionController<IN,OUT> extends Controller {
    void setInput(IN input);
    IN getInput();
    void setOutput(OUT output);
    OUT getOutput();
}
