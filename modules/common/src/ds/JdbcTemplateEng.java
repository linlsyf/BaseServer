package ds;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.ResourceUtils;
import utils.ConfigUtils;
import utils.ZStringUtils;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JdbcTemplateEng {

    private static JdbcTemplate template;
    private static ApplicationContext ioc;

    private static JdbcTemplateEng  mInStance;
    public static JdbcTemplateEng getInstance() {
        if (mInStance == null) {
            File path = null;
            try {
                path = new File(ResourceUtils.getURL("classpath:").getPath());

                String  pathString=path.getAbsolutePath();
                pathString=pathString.substring(0,pathString.lastIndexOf("\\")+1);
                pathString=pathString+ConfigUtils.config_name;
              ioc = new FileSystemXmlApplicationContext(pathString);
            template = ioc.getBean(JdbcTemplate.class);
            mInStance=new JdbcTemplateEng();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
        return mInStance;
    }

    public static <T> List<T> query(  String courseFile ,Class<T> mappedClass,  Map<String, Object> map) {
        File sqlFile=new File(courseFile);
        String templateString = ZStringUtils.getFileString(sqlFile);

        StringWriter result = new StringWriter();
        Template t = null;
        String sql="";
        try {
            Reader reader = new StringReader(templateString);
            t = new Template("test", reader, new Configuration());
            t.process(map, result);
            sql=result.toString();
            System.out.print("exe sql="+sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getInstance().template.query(sql, new Object[]{}, new BeanPropertyRowMapper<T>(mappedClass));
    }

//    public static int execute(  String fileName , Map<String, Object> map) {
//        File sqlFile=new File(courseFile);
//
//
//        String templateString = ZStringUtils.getFileString(sqlFile);
//
//        StringWriter result = new StringWriter();
//        Template t = null;
//        String sql="";
//        try {
//            Reader reader = new StringReader(templateString);
//            t = new Template("test", reader, new Configuration());
//            t.process(map, result);
//            sql=result.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return getInstance().update(sql);
//    }
    public static int exec(String courseFile , Map<String, Object> map) {
        File sqlFile=new File(courseFile);
        String templateString = ZStringUtils.getFileString(sqlFile);

        StringWriter result = new StringWriter();
        Template t = null;
        String sql="";
        try {
            Reader reader = new StringReader(templateString);
            t = new Template("test", reader, new Configuration());
            t.process(map, result);
            sql=result.toString();

//            Map newDataMap=new HashMap();
//            newDataMap.put("data",map) ;
//            t.process(newDataMap, result);
//            sql=result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

       int resultNum=-1;

//开启新事务
        DataSourceTransactionManager transactionManager = ioc.getBean(
                "transactionManager", DataSourceTransactionManager.class);//
        DefaultTransactionDefinition dte= new DefaultTransactionDefinition();
        //设置隔离级别
        dte.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = transactionManager.getTransaction(dte);
        try {
          resultNum= getInstance().template.update(sql);
            transactionManager.commit(status);
        } catch (Exception e) {
            //出现异常回滚事务，以免出现脏数据，数据不完整的问题
            transactionManager.rollback(status);
            return -1;
        }

//        DefaultTransactionDefinition transDefinition = new DefaultTransactionDefinition();
//        transDefinition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        TransactionStatus transStatus = this.transactionManager.getTransaction(transDefinition);
////以下为JdbcTempalte的更新操作（省略具体代码）
//        resultNum= getInstance().template.update(sql);
////最后手动提交事务，可通过try{}catch(){} 进行异常回滚this.transactionManager.rollback(transStatus);
//        this.transactionManager.commit(transStatus);



        return resultNum;
    }


      public  Map<String,Object>  parserData( Map<String,Object>  data){


          Iterator<String>  keys=data.keySet().iterator();
            while (keys.hasNext()){
                String  key=keys.next();
                String newValue="'"+data.get(key).toString()+"'";
                  data.put(key,newValue);
            }


         return  data;
      }




}
