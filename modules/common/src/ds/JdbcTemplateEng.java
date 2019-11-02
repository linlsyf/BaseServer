package ds;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.StringUtils;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class JdbcTemplateEng {

    private static JdbcTemplate template;

    public static JdbcTemplate getInstance() {

        if (template == null) {
            String  path="C:\\EasyServer\\web\\WEB-INF\\applicationContext.xml";
            ApplicationContext ioc = new FileSystemXmlApplicationContext(path);
            template = ioc.getBean(JdbcTemplate.class);

        }
        return template;
    }

    public static <T> List<T> query(  String courseFile ,Class<T> mappedClass,  Map<String, Object> map) {
        File sqlFile=new File(courseFile);
        String templateString = StringUtils.getFileString(sqlFile);

        StringWriter result = new StringWriter();
        Template t = null;
        String sql="";
        try {
            Reader reader = new StringReader(templateString);
            t = new Template("test", reader, new Configuration());
            t.process(map, result);
            sql=result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getInstance().query(sql, new Object[]{}, new BeanPropertyRowMapper<T>(mappedClass));
    }

//    public static int execute(  String fileName , Map<String, Object> map) {
//        File sqlFile=new File(courseFile);
//
//
//        String templateString = StringUtils.getFileString(sqlFile);
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
    public static int create(  String courseFile , Map<String, Object> map) {
        File sqlFile=new File(courseFile);
        String templateString = StringUtils.getFileString(sqlFile);

        StringWriter result = new StringWriter();
        Template t = null;
        String sql="";
        try {
            Reader reader = new StringReader(templateString);
            t = new Template("test", reader, new Configuration());
            t.process(map, result);
            sql=result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getInstance().update(sql);
    }


}
