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
        Map<String, Object> map=new HashMap<>();
       map.putAll(msgMap);
        map.put("content",e.getMessage() );
        map.put("id", UUID.randomUUID()+"" );
        map.put("createtime", TimeAreaUtils.getTimeNow() );
        map.put("typeerror", "savelog" );
        JdbcTemplateEng.getInstance().parserData(map);
        Template t = null;
        String sql="";
        StringWriter result = new StringWriter();


        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql"+"/"+"errorlogcreate.sql";
        JdbcTemplateEng.exec(courseFile,map);
    }
}
