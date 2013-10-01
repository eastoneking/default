package eastone.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Eastone King
 *
 */
public class Object{

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final static Logger staticLogger(Class<?> c){
    	if(c==null){
    		c = eastone.common.Object.class;
    	}
    	Logger res = LoggerFactory.getLogger(c);
    	return res;
    }

}
