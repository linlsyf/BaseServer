package utils;

import base.LogHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ZStringUtils {

    public static String getFileString(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
        }catch(Exception e){
//            if (!map.containsKey("typeerror")){
                Map errMap=new HashMap();
                errMap.put("type","file_sql");
                LogHelper.saveLog(errMap,e);

//            }
            e.printStackTrace();
        }
        return result.toString();
    }
   //filePath是jar文件位置，name是jar文件里面文件的路径，相当于上面代码框中的entryName
    public InputStream getJarInputStream(String filePath, String name)
            throws Exception {
        URL url = new URL("jar:file:" + filePath + "!/" + name);
        JarURLConnection jarConnection = (JarURLConnection) url
                .openConnection();
        InputStream in = jarConnection.getInputStream();

        return in;
    }

    public static boolean isNotEmpty(String s){
        boolean isNotEmpty=true;
        if (null==s||s.trim().length()==0){
            isNotEmpty=false;
        }
        return isNotEmpty;
    }
}
