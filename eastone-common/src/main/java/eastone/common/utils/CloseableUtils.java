/*
 * create:2015年12月5日 下午8:40:54
 * author:wangds  
 */
package eastone.common.utils;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;

import eastone.common.GeneralParentObject;

/**
 * .
 * @author wangds
 *
 */
public final class CloseableUtils {
    
    public static void close(Closeable target){
        if(target!=null){
            try {
                target.close();
            } catch (IOException e) {
                Logger logger = GeneralParentObject.staticLogger(target.getClass());
                logger.warn(e.getLocalizedMessage(), e);
            }
        }
    }

}
