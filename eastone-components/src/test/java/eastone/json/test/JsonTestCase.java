/*
 * create:2015年11月30日 下午11:03:51
 * author:wangds  
 */
package eastone.json.test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

import eastone.json.JsonInterpreter;
import eastone.json.JsonUtil;
import eastone.json.fac.JsonInpProvFactory;

/**
 * .
 * @author wangds
 *
 */
public class JsonTestCase {

    @SuppressWarnings("unchecked")
    @Test
    public void test(){
        JsonInterpreter j = new JsonInpProvFactory().getInstance();
        String txt = "{\"a\":\"b\"}";
        Map<String, String> r = j.json2Object(txt, HashMap.class);
        TestCase.assertEquals("b", r.get("a"));
        String jt = j.object2Json(r);
        TestCase.assertEquals(jt, txt);
    }
    @Test
    public void testJsonUtil(){
        String txt = "{\"a\":\"b\"}";
        HashMap<String, Object> map = JsonUtil.toHashMap(txt);
        TestCase.assertEquals(map.get("a"), "b");
        String outtxt = JsonUtil.toJson(map);
        TestCase.assertEquals(txt, outtxt);
        O o = JsonUtil.toObject(txt, O.class);
        TestCase.assertEquals("b", o.getA());
        outtxt = JsonUtil.toJson(o);
        TestCase.assertEquals(txt, outtxt);
    }
}

class O{
    private Object a;
    /**
     * The setter method of the property a.
     * @param thea the a to set
     * @author wangds 2015年11月30日 下午11:19:10.
     */
    public void setA(Object a) {
        this.a = a;
    }
    
    /**
     * The getter method of the property a.
     * @author wangds 2015年11月30日 下午11:19:13.
     * @return the a.
     */
    public Object getA() {
        return a;
    }
}
