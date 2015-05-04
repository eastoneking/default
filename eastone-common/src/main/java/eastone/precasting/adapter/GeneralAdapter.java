/*
 * create:2015年4月29日 下午8:10:23
 * author:wangds  
 */
package eastone.precasting.adapter;

import eastone.common.GeneralParentObject;
import eastone.common.adapter.Adapter;

/**
 * .
 * @author wangds
 *
 */
public class GeneralAdapter<T> extends GeneralParentObject implements Adapter<T>{

    /**
     * The constructor of GeneralAdapter.
     * @author wangds 2015年4月29日 下午8:13:11.
     */
    public GeneralAdapter(){
        
    }
    /**
     * The constructor of GeneralAdapter.
     * @author wangds 2015年4月29日 下午8:12:55.
     * @param thAdaptee 被代理对象.
     */
    public GeneralAdapter(T thAdaptee){
        
    }
    /**
     * 被代理对象.
     */
    private T adaptee;
    /*
     * @see eastone.common.adapter.Adapter#getAdaptee()
     * @author wangds 2015年4月29日 下午8:10:53.
     */
    @Override
    public T getAdaptee() {
        return this.adaptee;
    }
    /**
     * The setter method of the property adaptee.
     * @param theadaptee the adaptee to set
     * @author wangds 2015年4月29日 下午8:11:46.
     */
    public void setAdaptee(T adaptee) {
        this.adaptee = adaptee;
    }

}
