/*
 * create:2015年12月1日 上午12:05:39
 * author:wangds  
 */
package eastone.mongodb.test;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * .
 * @author wangds
 *
 */
@Document(collection="E01Teacher")
public class E01Teacher implements Serializable {

    /**
     * E01Teacher.java.
     * @author wangds 2015年12月1日 上午12:05:47.
     */
    private static final long serialVersionUID = 3141498204472594211L;

    private String id;
    
    private String name;
    
    /**
     * The setter method of the property id.
     * @param theid the id to set
     * @author wangds 2015年12月1日 上午12:19:30.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * The getter method of the property id.
     * @author wangds 2015年12月1日 上午12:19:33.
     * @return the id.
     */
    public String getId() {
        return id;
    }
    
    /**
     * The setter method of the property name.
     * @param thename the name to set
     * @author wangds 2015年12月1日 上午12:23:47.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * The getter method of the property name.
     * @author wangds 2015年12月1日 上午12:23:49.
     * @return the name.
     */
    public String getName() {
        return name;
    }
}
