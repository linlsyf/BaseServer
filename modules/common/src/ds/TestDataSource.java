package ds;

import ds.JdbcTemplateEng;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataSource {


//    private ApplicationContext ioc = new FileSystemXmlApplicationContext("D:\\EasyServer\\web\\WEB-INF\\applicationContext.xml");
//    private JdbcTemplate template=ioc.getBean(JdbcTemplate.class);

    @Test
    public void test01(){
        String sql = "SELECT * FROM User";
//        List<User>  list= JdbcTemplateEng.getInstance().query(sql, new Object[]{}, new BeanPropertyRowMapper<User>(User.class));
//
//        int listsize=list.size();

//        String listsize=results.getName();

//        Map<String, String> map=new HashMap<String, String>();
//        map.put("username", "lisi");
//        String  templateString= StringUtils.getFileString(new File("E:\\testsql.sql"));
//
//        StringWriter result = new StringWriter();
//        Template t = null;
//        try {
//            Reader reader= new StringReader(templateString);
//            t = new Template("test", reader, new Configuration());
//            t.process(map, result);
//            System.out.println(result.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "admin");
        File sqlFile=new File("E:\\testsql.sql");
//        List<User>  list=  JdbcTemplateEng.query(sqlFile, User.class,map);
//        int listsize=list.size();

    }

}
