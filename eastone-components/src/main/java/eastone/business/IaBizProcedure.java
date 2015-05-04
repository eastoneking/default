/*
 * create:2015年4月25日 下午7:07:48
 * author:wangds  
 */
package eastone.business;

/**
 * .
 * @author wangds
 *
 */
public interface IaBizProcedure<I, O> extends BizProcedure {
    I beforeChangeInput(I newValue, I oldValue);
    void onChangedInput(I newValue, I oldValue);
    void afterChangedInput(I newValue, I oldValue);
    O beforeChangeOutput(O newValue, O oldValue);
    void onChangedOutput(O newValue, O oldValue);
    void afterChangedOutput(O newValue, O oldValue);

}
