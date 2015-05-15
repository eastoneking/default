/*
 * create:2015年5月15日 下午11:10:54
 * author:wangds  
 */
package eastone.json.fac;

import eastone.common.GeneralParentObject;
import eastone.common.factory.Factory;
import eastone.common.factory.ProviderFactory;
import eastone.json.JsonInterpreter;

/**
 * .
 * @author wangds
 *
 */
public class JsonInpProvFactory extends GeneralParentObject implements Factory<JsonInterpreter> {

    /*
     * @see eastone.common.factory.Factory#getInstance()
     * @author wangds 2015年5月15日 下午11:11:07.
     */
    @Override
    public JsonInterpreter getInstance() {
        JsonInterpreter res = null;
        res = new ProviderFactory().getInstance(JsonInterpreter.class);
        return res;
    }

}
