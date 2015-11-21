/*
 * create:2015年11月12日 下午5:09:53
 * author:wangds  
 */
package eastone.space;

/**
 * .
 * @author wangds
 *
 */
public class test {
    
    public static void main(String[] args) {
        /*
        zx 123.475342,42.085994
        yx 124.996948,42.110449

        ys 124.953003,43.125043
        zs 123.508301,43.145086
        */
        Gps gis1 = PositionUtils.gcj_To_Gps84(42.085994, 123.475342);
        Gps gis2 = PositionUtils.gcj_To_Gps84(42.110449, 124.996948);
        Gps gis3 = PositionUtils.gcj_To_Gps84(43.125043, 124.953003);
        Gps gis4 = PositionUtils.gcj_To_Gps84(43.145086, 123.508301);
        
        double min_lat = Math.min(gis1.getWgLat(), gis2.getWgLat());
        double max_lat = Math.max(gis1.getWgLat(), gis2.getWgLat());
        min_lat = Math.min(min_lat, gis3.getWgLat());
        min_lat = Math.min(min_lat, gis4.getWgLat());
        max_lat = Math.max(max_lat, gis3.getWgLat());
        max_lat = Math.max(max_lat, gis4.getWgLat());
        
        double min_lon = Math.min(gis1.getWgLon(), gis2.getWgLon());
        min_lon = Math.min(min_lon, gis3.getWgLon());
        min_lon = Math.min(min_lon, gis3.getWgLon());
        
        double max_lon = Math.max(gis1.getWgLon(), gis2.getWgLon());
        max_lon = Math.max(min_lon, gis3.getWgLon());
        max_lon = Math.max(min_lon, gis3.getWgLon());
        
        System.out.println(min_lat+","+min_lon);
        System.out.println(max_lat+","+max_lon);
        
    }

}
