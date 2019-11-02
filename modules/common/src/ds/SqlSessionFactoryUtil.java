package ds;

//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by lindanghong on 2017/10/27.
 */
public class SqlSessionFactoryUtil {


//    //配置文件
    private static String CONFIG_FILE_LOCATION = "SqlMapConfig.xml";

    //ThreadLocal存放当前线程中的SqlSession
    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sessionFactory;
    private SqlSessionFactoryUtil() {
    }
//    //获取SqlSession
    public static SqlSession getSession() {
        SqlSession session = (SqlSession) threadLocal.get();

//        if (session == null) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
//        }

        return session;
    }
//    //构建SessionFactory
    public static void rebuildSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader(CONFIG_FILE_LOCATION);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    //关闭SqlSession
    public static void closeSession() {
        SqlSession session = (SqlSession) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
//    //将SessionFactory关闭
    public static void closeSessionFactory() {
        sessionFactory = null;
    }

}
