/*
 * create:2015年4月25日 下午7:17:51
 * author:wangds  
 */
package eastone.business;

import java.util.Collection;

import eastone.common.mediator.Mediator;

/**
 * .
 * @author wangds
 *
 */
public interface CompositeBusiness extends Business, Mediator {
    
    <B> void addBusiness(B biz);
    <B> void removeBusiness(B biz);
    Collection<Business> getSubBusinesses();
    void setSubBusinesses(Collection<Business> subBusinesses);

}
