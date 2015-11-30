/*
 * create:2015年11月23日 下午5:53:50
 * author:wangds  
 */
package eastone.common.utils;

import java.util.UUID;

/**
 * UUID工具.
 * <p>
 * 修改UUID字符串格式。
 * </p>
 * @author wangds
 *
 */
public class UUIDUtil {
    /**
     * 生成没有分隔符的uuid.
     * <p>
     * 去掉"-"分隔符，减少数据长度。
     * </p>
     * @author wangds 2015年11月23日 下午5:57:48.
     * @return
     */
    public static String generateUuidNoSeparator(){
        UUID uuid = UUID.randomUUID();
        StringBuffer buf = new StringBuffer(uuid.toString());
        buf.deleteCharAt(23).deleteCharAt(18).deleteCharAt(13).deleteCharAt(8);
        return buf.toString();
    } 

}
