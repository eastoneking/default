/*
 * create:2015年5月4日 上午9:52:39
 * author:wangds  
 */
package eastone.common;

/**
 * 可清理接口.
 * <p>为了避免包中依赖关系混乱,从 {@linkplain eastone.common.processor.Clearable}中提取的接口.</p>
 * @author wangds
 *
 */
public interface Clearable {
    

    /**
     * 清理方法.
     */
    void clear();

}
