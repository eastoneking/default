/*
 * create:2015年5月7日 上午10:20:58
 * author:wangds  
 */
package eastone.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import eastone.common.GeneralParentObject;

/**
 * .
 * @author wangds
 *
 */
public final class MybatisUtil {

    public static <T, P> Collection<T> selectList(SqlSessionFactory fac, String sql, P param, int offset, int limit){
        Collection<T> res = null;
        if(fac==null){
            throw new NullPointerException();
        }
        if(sql==null){
            throw new NullPointerException();
        }
        SqlSession s = null;
        try{
            s = fac.openSession(ExecutorType.REUSE, false);
            res = s.selectList(sql, param, new RowBounds(offset, limit));
        }finally{
            if(s!=null){
                try{
                    s.close();
                }catch(Exception e){
                    Logger logger = GeneralParentObject.staticLogger(MybatisUtil.class);
                    logger.error(e.getLocalizedMessage(), e);
                }
            }
        }
        return res;
    }
    
    public static <T, P> T selectOne(SqlSessionFactory fac, String sql, P param){
        T res = null;
        if(fac==null){
            throw new NullPointerException();
        }
        if(sql==null){
            throw new NullPointerException();
        }
        SqlSession s = null;
        try{
            s = fac.openSession(ExecutorType.REUSE, false);
            res = s.selectOne(sql, param);
        }finally{
            if(s!=null){
                try{
                    s.close();
                }catch(Exception e){
                    Logger logger = GeneralParentObject.staticLogger(MybatisUtil.class);
                    logger.error(e.getLocalizedMessage(), e);
                }
            }
        }
        return res;
    }

    public static <P> int update(SqlSessionFactory fac, String sql, P param){
        int res = 0;
        if(fac==null){
            throw new NullPointerException();
        }
        if(sql==null){
            throw new NullPointerException();
        }
        SqlSession s = null;
        try{
            s = fac.openSession(ExecutorType.REUSE, false);
            res = s.update(sql, param);
            s.commit();
        }catch(Exception e){
            try{
                s.rollback();
            }catch(Exception ex){
                Logger logger = GeneralParentObject.staticLogger(MybatisUtil.class);
                logger.error(ex.getLocalizedMessage(), ex);
            }
            throw e;
        }finally{
            if(s!=null){
                try{
                    s.close();
                }catch(Exception e){
                    Logger logger = GeneralParentObject.staticLogger(MybatisUtil.class);
                    logger.error(e.getLocalizedMessage(), e);
                }
            }
        }
        return res;
    }
    
    public static <P> Collection<int[]> multiUpdate(SqlSessionFactory fac, String sql, Collection<P> params, int batchSize){
        Collection<int[]> res = new ArrayList<int[]>(params==null?10:params.size());
        if(batchSize<1){
            batchSize = 100;
        }
        if(fac==null){
            throw new NullPointerException();
        }
        if(sql==null){
            throw new NullPointerException();
        }
        SqlSession s = null;
        try{
            s = fac.openSession(ExecutorType.BATCH, false);
            Iterator<P> it=params.iterator();
            int i=0;
            while(it.hasNext()){
                P cur = it.next();
                try{
                    s.update(sql, cur);
                    if(i>0&&i%batchSize==0){
                       for(BatchResult r:s.flushStatements()){
                           res.add(r.getUpdateCounts());
                       }
                    }
                }catch(Exception e){
                    Logger logger = GeneralParentObject.staticLogger(MybatisUtil.class);
                    logger.error(e.getLocalizedMessage(), e);
                }
                i++;
            }
            if(i%batchSize!=0){
                for(BatchResult r:s.flushStatements()){
                    res.add(r.getUpdateCounts());
                }
            }
            s.commit();
        }catch(Exception e){
            try{
                s.rollback();
            }catch(Exception ex){
                Logger logger = GeneralParentObject.staticLogger(MybatisUtil.class);
                logger.error(ex.getLocalizedMessage(), ex);
            }
            throw e;
        }finally{
            if(s!=null){
                try{
                    s.close();
                }catch(Exception e){
                    Logger logger = GeneralParentObject.staticLogger(MybatisUtil.class);
                    logger.error(e.getLocalizedMessage(), e);
                }
            }
        }
        return res;
    }

}
