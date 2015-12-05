/*
 * create:2015年11月30日 下午10:16:08
 * author:wangds  
 */
package eastone.mongodb.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DB;

import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;

/**
 * .
 * @author wangds
 *
 */
public class SpringMongodbTestCase {
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void test(){
        BeanContext ctx = BeanContextFactory.getBeanContext();
        ctx.appendContext("classpath:eastone/mongodb/test/test1.xml");
        MongoTemplate x =  (MongoTemplate) ctx.getBean("mongoTemplate");
        DB db = x.getDb();
        TestCase.assertEquals("ecourse",db.getName());
        
        long c = x.count(Query.query(Criteria.where("name").is("wangds")), E01Teacher.class);
        System.out.println(c);
        
        
        
    }

}
