package common;

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
        String  classString="def cal(int a, int b){\n" +
                "    return a+b\n" +
                "}";

        Map  exeMap=new HashMap();

        exeMap.put(MethodName,"cal");
        Object[] param = { 8,7 };
        exeMap.put(PARAMS,param);
        exeMap.put(GROOVYSTRINGS,classString);

        Map resultMap=  exe(exeMap);
        System.out.println(resultMap.get(DATA));

    }

    public static  String test() {
        return "this is test";
    }
    public static  void testAdd(String[] arg) {
        String  classString="def cal(int a, int b){\n" +
                "    return a+b\n" +
                "}";

        Map  exeMap=new HashMap();
        exeMap.put(MethodName,"cal");
        Object[] param = { 8,7 };
        exeMap.put(PARAMS,param);

        Map resultMap=  exe(exeMap);
        System.out.println(resultMap.get(DATA));

    }
    public static  Map exe( Map  exeMap ) {
        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class groovyClass = classLoader.parseClass((String) exeMap.get(GROOVYSTRINGS));
       Map resultMap=new HashMap();
        try {
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();

            Object result=   groovyObject.invokeMethod((String) exeMap.get(MethodName),exeMap.get(PARAMS));
            resultMap.put(DATA,result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
       return  resultMap;

    }


}
