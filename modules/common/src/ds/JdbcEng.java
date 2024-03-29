package ds;
import base.LogHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.mysql.jdbc.PreparedStatement;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.ResourceUtils;
import utils.ConfigUtils;
import utils.ZStringUtils;

import java.io.*;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;
import java.util.regex.Pattern;
/**
 * 数据库连接服务
 */
public class JdbcEng {
    private static JdbcTemplate jdbcTemplate;
    private static ApplicationContext ioc;
    private static JdbcEng mJdbcEng;
    /**
     * 指定加载路径获取 唯一加载对象
     */
    public static JdbcEng getInstance() {
        if (mJdbcEng == null) {
            File path = null;
            try {
                path = new File(ResourceUtils.getURL("classpath:").getPath());
                String  pathString=path.getAbsolutePath();
                pathString=pathString.substring(0,pathString.lastIndexOf("\\")+1);
                pathString=pathString+ConfigUtils.config_name;
              ioc = new FileSystemXmlApplicationContext(pathString);
            jdbcTemplate = ioc.getBean(JdbcTemplate.class);
            mJdbcEng =new JdbcEng();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Map errMap=new HashMap();
                errMap.put("type","getFile");
                LogHelper.saveLog(errMap,e);
            }
        }
        return mJdbcEng;
    }



    public static  void query( String tableName ) {

        String sql = "select * from "+tableName;
        RowCountCallbackHandler rcch = new RowCountCallbackHandler();
        jdbcTemplate.query(sql, rcch);
//
//
//
//             System.out.println("column name :" + rcch.getColumnNames()[i]);
//            System.out.println("column type :" + rcch.getColumnTypes()[i]);
  }
    /**
     * 调用springframework 中的JdbcTemplate
     * 传入模板查询
     */
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

            List<T> records= getInstance().jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<T>(mappedClass));

            return records;
        } catch (Exception e) {
            e.printStackTrace();
            if (!map.containsKey("typeerror")){
                Map errMap=new HashMap();
                errMap.put("type","list");
                LogHelper.saveLog(errMap,e);
            }
        }
        return new ArrayList<>();
    }
    /**
     * 调用springframework 中的JdbcTemplate
     * 传入模板查询
     */
    public static <T> List<T> groovyquery( String templateString , Class<T> mappedClass,  Map mapInput) {

        StringWriter result = new StringWriter();
        Template t = null;
        String sql="";
        try {
            Reader reader = new StringReader(templateString);
            t = new Template("test", reader, new Configuration());
            mapInput=  JdbcEng.getInstance().parserData(mapInput);

            t.process(mapInput, result);
            sql=result.toString();
            System.out.print("exe sql="+sql);

            List<T> records= getInstance().jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<T>(mappedClass));

            return records;
        } catch (Exception e) {
            e.printStackTrace();
            if (!mapInput.containsKey("typeerror")){
                Map errMap=new HashMap();
                errMap.put("type","list");
                LogHelper.saveLog(errMap,e);
            }
        }
        return new ArrayList<>();
    }
    /**
     * 替换掉特殊符号
     */
    public static String replaceSys(String sql){
        if (sql.contains(">=")){
            sql=sql.replace(">=","&gt;=");
//            sql=sql.replace(">=","<![CDATA[ >= ]]>");
        }
        if (sql.contains("<=")){
            sql=sql.replace("<=","&lt;=");
        }

        return  sql;
    }
    /**
     * 调用springframework 中的JdbcTemplate
     * 传入模板获取
     */
    public static <T> T get(String courseFile , Class<T> mappedClass, String id) {
        File sqlFile=new File(courseFile);
        String templateString = ZStringUtils.getFileString(sqlFile);

        StringWriter result = new StringWriter();
        Template t = null;
        String sql="";
        Map  getMap=new HashMap();
        getMap.put("id","'"+id+"'");
        try {
            Reader reader = new StringReader(templateString);
            t = new Template("test", reader, new Configuration());
            t.process(getMap, result);
            sql=result.toString();
            System.out.print("exe sql="+sql);
        } catch (Exception e) {
            e.printStackTrace();
//            if (!map.containsKey("typeerror")){
                Map errMap=new HashMap();
                errMap.put("type","list");
                LogHelper.saveLog(errMap,e);
//            }
        }
        List<T>    resultList= getInstance().jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<T>(mappedClass));
             T  reusltData=null;
             if (resultList.size()>0){
                 reusltData= resultList.get(0);
             }

         return   reusltData;
        //        return getInstance().template.query(sql, new Object[]{}, new BeanPropertyRowMapper<T>(mappedClass));
    }
    /**
     * 调用springframework 中的JdbcTemplate
     * 传入模板执行更新等操作
     */
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
            System.out.println(" jdbc_exe_sql=="+sql);
        } catch (Exception e) {
            if (!map.containsKey("typeerror")){
                Map errMap=map;
                errMap.put("type","exec");
                LogHelper.saveLog(errMap,e);
            }
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
          resultNum= getInstance().jdbcTemplate.update(sql);
            transactionManager.commit(status);
        } catch (Exception e) {
            //出现异常回滚事务，以免出现脏数据，数据不完整的问题
            transactionManager.rollback(status);
            Map errMap=map;
            errMap.put("type","exec");
            LogHelper.saveLog(errMap,e);
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
    /**
     * 调用springframework 中的JdbcTemplate
     * 传入模板执行更新等操作
     */
    public static int groovyExe(String templateString ,   Map mapInput) {
        StringWriter result = new StringWriter();
        Template t = null;
        String sql="";

        try {
            Reader reader = new StringReader(templateString);
            t = new Template("test", reader, new Configuration());
            t.process(mapInput, result);
            sql=result.toString();
            System.out.println(" jdbc_exe_sql=="+sql);
        } catch (Exception e) {
            if (!mapInput.containsKey("typeerror")){
                Map errMap=mapInput;
                errMap.put("type","exec");
                LogHelper.saveLog(errMap,e);
            }
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
          resultNum= getInstance().jdbcTemplate.update(sql);
            transactionManager.commit(status);
        } catch (Exception e) {
            //出现异常回滚事务，以免出现脏数据，数据不完整的问题
            transactionManager.rollback(status);
            Map errMap=mapInput;
            errMap.put("type","exec");
            LogHelper.saveLog(errMap,e);
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
    public static int groovyUpdate(  Map mapInput) {
        StringWriter result = new StringWriter();
        Template t = null;

        String templateString ="";

        String tableName=(String)mapInput.get("tableName");
        String sqlColumn = "select * from "+tableName;

        Map  createData=(Map)mapInput.get("data");


        RowCountCallbackHandler rcch = new RowCountCallbackHandler();
        jdbcTemplate.query(sqlColumn, rcch);
        String[]  columnNames=rcch.getColumnNames();
        int[]  columnTypes=rcch.getColumnTypes();

        int hint=0;
        List<CloumnBean>  createConfigList=new ArrayList();
        for (int i=0;i<rcch.getColumnNames().length;i++  ) {
            String  columnName=columnNames[i];
            if("id".equals(columnName)){
                continue;
            }
            if(createData.containsKey(columnName)){
                CloumnBean columnNameMap=new CloumnBean();
                columnNameMap.setName(columnName);
                columnNameMap.setType(columnTypes[i]);
                createConfigList.add(columnNameMap);
            }

        }
        String sql = "UPDATE "+tableName+" set ";

        for (int i=0;i<createConfigList.size();i++  ) {
            CloumnBean columnNameMap=createConfigList.get(i);
            String  name=columnNameMap.getName();
             if (i!=0&i!=createConfigList.size()){
                 sql=sql+",";
             }
            sql=sql+name+"="+ "'"+createData.get(name)+"'";



        }

        sql=sql+" where id='"+createData.get("id")+"' ";
        try {
            Reader reader = new StringReader(sql);
            t = new Template("test", reader, new Configuration());
            t.process(createData, result);
            sql=result.toString();
            System.out.println(" jdbc_exe_sql=="+sql);
        } catch (Exception e) {
//            if (!createData.containsKey("typeerror")){
//                Map errMap=createData;
//                errMap.put("type","exec");
//                LogHelper.saveLog(errMap,e);
//            }
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
            resultNum= getInstance().jdbcTemplate.update(sql);
            transactionManager.commit(status);
        } catch (Exception e) {
            //出现异常回滚事务，以免出现脏数据，数据不完整的问题
            transactionManager.rollback(status);
            Map errMap=new HashMap();
            errMap.put("type","exec");
            LogHelper.saveLog(errMap,e);
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




    /**
     * 调用springframework 中的JdbcTemplate
     * 传入模板执行更新等操作
     */
    public static Map groovyCreate(  Map mapInput) {

        Map resultMap=new HashMap();
        StringWriter result = new StringWriter();
        Template t = null;

        String templateString ="";

        String tableName=(String)mapInput.get("tableName");
        String sqlColumn = "select * from "+tableName;

        Object  createDataObject=mapInput.get("data");
        Map  createData;
          if (createDataObject instanceof Map){
              createData=(Map)mapInput.get("data");
          }else{
              createData=(Map)JSON.parseObject(createDataObject.toString(),Map.class);

          }

        RowCountCallbackHandler rcch = new RowCountCallbackHandler();
        jdbcTemplate.query(sqlColumn, rcch);
         List<String>  columnList=new ArrayList( createData.keySet());
          String sql = "INSERT INTO "+tableName+"(";

        for (String  columnKey:columnList) {
            sql=sql+columnKey+",";

        }


        sql=sql+"id  ) VALUES (";
        for (String  columnKey:columnList) {
            Object  columnValue=createData.get(columnKey);

        if (columnValue instanceof String ){
                sql=sql+ "'"+columnValue+"',";
            }else{
                sql=sql+ columnValue+",";

            }

        }
      String  id= UUID.randomUUID().toString();
        sql=sql+"'"+id+"') ";

        try {
            Reader reader = new StringReader(sql);
            t = new Template("test", reader, new Configuration());
            t.process(createData, result);
            sql=result.toString();
            System.out.println(" jdbc_exe_sql=="+sql);
        } catch (Exception e) {
//            if (!createData.containsKey("typeerror")){
//                Map errMap=createData;
//                errMap.put("type","exec");
//                LogHelper.saveLog(errMap,e);
//            }
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
            resultNum= getInstance().jdbcTemplate.update(sql);
            transactionManager.commit(status);
        } catch (Exception e) {
            //出现异常回滚事务，以免出现脏数据，数据不完整的问题
            transactionManager.rollback(status);
            Map errMap=new HashMap();
            errMap.put("type","exec");
            LogHelper.saveLog(errMap,e);
            return  resultMap;
        }
//        DefaultTransactionDefinition transDefinition = new DefaultTransactionDefinition();
//        transDefinition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        TransactionStatus transStatus = this.transactionManager.getTransaction(transDefinition);
////以下为JdbcTempalte的更新操作（省略具体代码）
//        resultNum= getInstance().template.update(sql);
////最后手动提交事务，可通过try{}catch(){} 进行异常回滚this.transactionManager.rollback(transStatus);
//        this.transactionManager.commit(transStatus);
        return  resultMap;
    }
    /**
     * 记录日志
     */
    public static int execLogError(String courseFile , Map<String, Object> map) {
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

            System.out.println(" jdbc_exe_sql=="+sql);

        } catch (Exception e) {
//            if (!map.containsKey("typeerror")){
//                Map errMap=map;
//                errMap.put("type","exec");
//                LogHelper.saveLog(errMap,e);
//
//            }
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
          resultNum= getInstance().jdbcTemplate.update(sql);
            transactionManager.commit(status);
        } catch (Exception e) {
            //出现异常回滚事务，以免出现脏数据，数据不完整的问题
            transactionManager.rollback(status);
//            Map errMap=map;
//            errMap.put("type","exec");
            //LogHelper.saveLog(errMap,e);
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

    /**
     * 转换map为查询语句
     */
      public  Map<String,Object>  parserData( Map<String,Object>  data){
          Iterator<String>  keys=data.keySet().iterator();
            while (keys.hasNext()){
                String  key=keys.next();
                String  value=data.get(key).toString();
                String newValue=value;
                  if (!isNumeric1(value)){
//                     newValue= "\""+value+"\"";
                     newValue= "'"+value+"'";
                  }
//                  if(null!=value){
                      data.put(key,newValue);
//
//                  }
            }
         return  data;
      }
    /**
     * 判断是否有数字
     */
    public static boolean isNumeric1(String str) {
        Pattern pattern =Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
