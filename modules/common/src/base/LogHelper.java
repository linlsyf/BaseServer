package base;

import ds.JdbcTemplateEng;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import utils.TimeAreaUtils;
import utils.ZStringUtils;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LogHelper {

    public  static Object  instance=new LogHelper();


    public static  void saveLog(Map msgMap,Exception e){
          String errorContent=e.getMessage();
        msgMap.put("content", errorContent);


        String title="";
         if (null!=e){
           if (errorContent.length()>10){
               title=errorContent.substring(0,10);
           }else{
               title=errorContent;
           }
         }


        msgMap.put("title",title);
        msgMap.put("id", UUID.randomUUID()+"" );
        msgMap.put("createtime", TimeAreaUtils.getTimeNow() );
        msgMap.put("typeerror", "savelog" );
        JdbcTemplateEng.getInstance().parserData(msgMap);
        Template t = null;
        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql"+"/"+"errorlogcreate.sql";
        JdbcTemplateEng.exec(courseFile,msgMap);
    }
}
