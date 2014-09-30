/*
 * create:2014年9月28日 下午8:28:31
 * author:wangds  
 */
package eastone.common.exception;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * .
 * @author wangds
 *
 */
public class MultiException extends RuntimeException {

    /**
     * .
     */
    private final Collection<Throwable> causes;
    /**
     * MultiException.java.
     * @author wangds 2014年9月28日 下午8:28:39.
     */
    private static final long serialVersionUID = -762538912837136093L;

    /**
     * The constructor of MultiException.
     * @author wangds 2014年9月28日 下午8:34:06.
     */
    public MultiException(Collection<Throwable> c) {
        this.causes = c;
    }
    
    /*
     * @see java.lang.Throwable#getLocalizedMessage()
     * @author wangds 2014年9月28日 下午8:36:22.
     */
    @Override
    public String getLocalizedMessage() {
        StringBuffer buf = new StringBuffer();
        for(Throwable cur:this.causes){
            buf.append(cur.getLocalizedMessage());
            buf.append("\n");
        }
        return buf.toString();
    }
    
    /*
     * @see java.lang.Throwable#getMessage()
     * @author wangds 2014年9月28日 下午8:36:28.
     */
    @Override
    public String getMessage() {
        StringBuffer buf = new StringBuffer();
        for(Throwable cur:this.causes){
            buf.append(cur.getMessage());
            buf.append("\n");
        }
        return buf.toString();
    }
    
    /*
     * @see java.lang.Throwable#getStackTrace()
     * @author wangds 2014年9月28日 下午8:36:33.
     */
    @Override
    public StackTraceElement[] getStackTrace() {
        StackTraceElement[] res = new StackTraceElement[0];
        List<StackTraceElement> buf = new ArrayList<StackTraceElement>();
        
        for(Throwable cur:causes){
            StackTraceElement[] tmp = cur.getStackTrace();
            int len = tmp.length;
            for(int i=0;i<len;i++){
                buf.add(tmp[i]);
            }
        }
        res = new StackTraceElement[buf.size()];
        res = buf.toArray(res);
        return res;
    }
    
    /*
     * @see java.lang.Throwable#printStackTrace()
     * @author wangds 2014年9月28日 下午8:36:46.
     */
    @Override
    public void printStackTrace() {
        for(Throwable cur:this.causes){
            System.out.println("-------------------");
            cur.printStackTrace();
        }
    }
    
    /*
     * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
     * @author wangds 2014年9月28日 下午8:36:52.
     */
    @Override
    public void printStackTrace(PrintStream s) {
        for(Throwable cur:this.causes){
            s.println("-------------------");
            cur.printStackTrace(s);
        }
    }
    
    /*
     * @see java.lang.Throwable#setStackTrace(java.lang.StackTraceElement[])
     * @author wangds 2014年9月28日 下午8:37:04.
     */
    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
    }
    
}
