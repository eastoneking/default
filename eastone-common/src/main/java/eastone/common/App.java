package eastone.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class A extends eastone.common.Object{

    public void test(){
	logger.info("test");
    }

}


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Logger logger = LoggerFactory.getLogger(App.class);
    	logger.error("1234");
    }
}
