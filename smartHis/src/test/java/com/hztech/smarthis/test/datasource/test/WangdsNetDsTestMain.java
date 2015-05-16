/*
 * create:2015年5月12日 上午9:46:18
 * author:wangds  
 */
package com.hztech.smarthis.test.datasource.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.http.util.Asserts;

import eastone.common.context.BeanContext;
import eastone.common.context.BeanContextFactory;

/**
 * .
 * 
 * @author wangds
 *
 */
public class WangdsNetDsTestMain {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BeanContext<String> ctx = BeanContextFactory.getBeanContext();
        ctx.appendContext("com/hztech/smarthis/test/datasource/test/datasource.xml");
        
        System.out.println(ctx.getBean("EnvPath"));
        
        DataSource ds = ctx.getBean("datasource");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            ps = conn.prepareStatement("select 1 as \"c1\"");
            rs = ps.executeQuery();
            if(rs.next()){
                int v = rs.getInt("c1");
                System.out.println("value:"+v);
                Asserts.check(v==1, "列中值错误");
            }else{
                Asserts.check(false, "空纪录集");
            }
        } catch (SQLException e) {
            Asserts.check(false, "异常："+e.getLocalizedMessage());
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        }
    }
}
