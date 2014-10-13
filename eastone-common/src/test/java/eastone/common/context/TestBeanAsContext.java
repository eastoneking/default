/*
 * create:2014年10月5日 下午7:05:07
 * author:wangds  
 */
package eastone.common.context;

/**
 * .
 * @author wangds
 *
 */
public class TestBeanAsContext extends BeanAsContext{
    public String abc;
    
    /**
     * The setter method of the property a.
     * @param thea the a to set
     * @author wangds 2014年10月5日 下午2:52:41.
     */
    public void setAbc(String abc) {
        this.abc = abc;
    }
    
    /**
     * The getter method of the property a.
     * @author wangds 2014年10月5日 下午2:52:51.
     * @return the a.
     */
    public String getAbc() {
        return this.abc;
    }
}

