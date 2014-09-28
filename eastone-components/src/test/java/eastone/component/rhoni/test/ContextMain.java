package eastone.component.rhoni.test;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;


/**
 * .
 * 
 * @author wangds.
 *
 */
public class ContextMain {

    /**
     * .
     * @author wangds 2014年9月22日 下午11:01:42.
     * @param args
     */
    public static void main(String[] args) {
        Context ctx = Context.enter();
        //ScriptableObject scope = ctx.initStandardObjects();
        
        Context ctx1 = Context.enter();
        Context ctx2 = Context.enter();
        ScriptableObject scope1 = ctx1.initStandardObjects();
        ScriptableObject scope2 = ctx2.initStandardObjects();
        
        Object r1 = ctx.evaluateString(scope1, "var a=1;", "<cmd>", 1, null);
        r1 = ctx.evaluateString(scope1, "a=a+1", "<cmd>", 1, null);
        
        System.out.println(Context.toString(r1));
        
        Object r2 = ctx.evaluateString(scope2, "var a=1;", "<cmd>", 1, null);
        r2 = ctx.evaluateString(scope2, "a=a+1", "<cmd>", 1, null);
        
        System.out.println(Context.toString(r2));
        
        Context.exit();
        
        
    }

}

