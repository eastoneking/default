/*
 * create:2015年5月11日 下午1:59:32
 * author:wangds  
 */
package eastone.business;

import java.util.Map;

/**
 * .
 * @author wangds
 *
 */
public class TestIaBizProc implements IaBizProcedure<Map<String,Object>, Map<String, Object>>{


    @Override
    public void beforeProcess() {
        
    }

    @Override
    public void onProcessd() {
        
    }

    @Override
    public void afterProcess() {
        
    }

    @Override
    public <E> void beforeThrowException(E exception) {
        
    }

    @Override
    public <E> void throwedException(E exception) {
        
    }

    @Override
    public <E> void afterThrowException(E exception) {
        
    }

    @Override
    public Map<String, Object> beforeChangeInput(Map<String, Object> newValue, Map<String, Object> oldValue) {
        return newValue;
    }

    @Override
    public void onChangedInput(Map<String, Object> newValue, Map<String, Object> oldValue) {
        
    }

    @Override
    public void afterChangedInput(Map<String, Object> newValue, Map<String, Object> oldValue) {
        
    }

    @Override
    public Map<String, Object> beforeChangeOutput(Map<String, Object> newValue, Map<String, Object> oldValue) {
        newValue.put("checkpoint", true);
        return newValue;
    }

    @Override
    public void onChangedOutput(Map<String, Object> newValue, Map<String, Object> oldValue) {
        
    }

    @Override
    public void afterChangedOutput(Map<String, Object> newValue, Map<String, Object> oldValue) {
        
    }
}
