/*
 * create:2015年4月17日 下午4:16:05
 * author:wangds  
 */
package eastone.common.context;

import java.util.Collection;
import java.util.Map;

/**
 * .
 * @author wangds
 *
 */
public interface MapAsEnvironment extends Environment {

    public void setEnvironmentMap(Map<String, Object> map);
    public Map<String, Object> getEnvironmentMap();
    public Collection<String> getEnvironmentKey();
}
