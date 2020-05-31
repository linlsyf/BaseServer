package base;

import ds.JdbcEng;
import freemarker.template.Template;
import utils.TimeAreaUtils;

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
        JdbcEng.getInstance().parserData(msgMap);
        Template t = null;
        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql"+"/"+"errorlogcreate.sql";
        JdbcEng.execLogError(courseFile,msgMap);
    }
}
