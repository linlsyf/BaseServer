package common;

import base.BaseBean;
import ds.JdbcEng;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.HashMap;
import java.util.Map;

public class GroovyUtils {
    public static final  String MethodName="method";
    public static final  String GROOVYSTRINGS="groovy";
    public static final  String PARAMS="params";
    public static final  String DATA="data";

    public static final void main(String[] arg) {
//        String  classString="def cal(int a, int b){\n" +
//                "    return a+b\n" +
//                "}";
//
//        HashMap  exeMap=new HashMap();
//
//        exeMap.put(MethodName,"cal");
//        Object[] param = { 8,7 };
//        exeMap.put(PARAMS,param);
//        exeMap.put(GROOVYSTRINGS,classString);
//
//        Map resultMap=  exe(exeMap);
//        System.out.println(resultMap.get(DATA));

        HashMap  exeMap=new HashMap();
        HashMap  dataMap=new HashMap();
        dataMap.put("title","creategorrottitle");
        dataMap.put("name","creategorrotname");
        dataMap.put("content","this is test");
        dataMap.put("id","deb137f4-e2f1-4ce7-b7ba-8177964fb02d");
//        exeMap.put("tableName","blog");

        exeMap.put("data",dataMap);
        exeMap.put("tableName","blog");
        exeMap.put("id","deb137f4-e2f1-4ce7-b7ba-8177964fb02d");

        JdbcEng.getInstance().groovyUpdate(exeMap);

    }

    public static  String test() {
        return "this is test";
    }

    public static  Object sql(String sql,Map  params) {
          if(sql.contains("select")){
           return JdbcEng.getInstance().groovyquery(sql, BaseBean.class,params);
          }

          else{
              return JdbcEng.getInstance().groovyExe(sql,params);
          }

    }
    public static  Object groovyCreate(Map  params) {
              return JdbcEng.getInstance().groovyCreate(params);

    }
    public static  Object create(Map  params) {
              return JdbcEng.getInstance().groovyCreate(params);

    }
    public static  Object update(Map  params) {
              return JdbcEng.getInstance().groovyUpdate(params);

    }




    public static  Object exe( Map  exeMap ) {
        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class groovyClass = classLoader.parseClass((String) exeMap.get(GROOVYSTRINGS));
       Object resultMap=new Object();
        try {
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();

            Object result=   groovyObject.invokeMethod((String) exeMap.get(MethodName),(Map)exeMap);
            resultMap=result;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
       return  resultMap;

    }


}
