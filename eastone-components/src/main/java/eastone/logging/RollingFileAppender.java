/*
 * create:2015年11月23日 上午11:10:44
 * author:wangds  
 */
package eastone.logging;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * 支持环境变量.
 * @author wangds
 *
 */
public class RollingFileAppender extends org.apache.log4j.RollingFileAppender{
    
    /**
     * RollingFileAppender.java.
     * @author wangds 2015年11月23日 下午1:07:29.
     */
    private static final String SUFFIX = "HOME";

    static{
        
        Map<String,String> env=System.getenv();
        
        Properties props = System.getProperties();
        for(Entry<String, String> cur:env.entrySet()){
            String key = cur.getKey();
            String val = cur.getValue();
            if(StringUtils.endsWithIgnoreCase(key, SUFFIX)){
                props.put(key, val);
            }
        }
    }

}
