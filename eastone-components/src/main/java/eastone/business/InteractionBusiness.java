/*
 * create:2015年4月19日 下午8:54:29
 * author:wangds  
 */
package eastone.business;

/**
 * 带有交互能力的业务接口.
 * @author wangds
 *
 */
public interface InteractionBusiness<IN,OUT> extends Business {
    /**
     * 设置业务输入.
     * @author wangds 2015年4月24日 上午9:32:53.
     * @param input 业务输入数据.
     */
    void setInput(IN input);
    /**
     * 获得业务输入.
     * @author wangds 2015年4月24日 上午9:34:22.
     * @return 业务输入数据.
     * <p><i>输入数据有可能在业务处理过程中被改变.</i></p>
     */
    IN getInput();
    /**
     * 设置输出结果.
     * @author wangds 2015年4月24日 下午1:29:28.
     * @param output 输出结果.
     */
    void setOutput(OUT output);
    /**
     * 获得输出结果.
     * @author wangds 2015年4月25日 上午11:35:58.
     * @return 输出结果.
     */
    OUT getOutput();
}
