package test;

import base.BaseBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonReader;
import com.mw.utils.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import test.bean.CatBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormTest {

    public static  final  void main(String[] arg){

        StringBuffer strB = new StringBuffer();
        URL url = null;
        try {
//            System.setProperty("https.protocols", "TLSv1.2");

            url = new URL("http://shuyuan.miaogongzi.net/shuyuan/1653698279.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStreamReader isr = new InputStreamReader(connection.getInputStream(),"UTF-8");


            String txtSource = "";
            BufferedReader br = new BufferedReader(isr);
            String strd;
            while (( strd = br.readLine()) != null) {
                strB.append(strd);   //将读取的内容放入strB

            }
            br.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
//        strB=strB.toString();



//        Gson mGson = new GsonBuilder().disableHtmlEscaping().
//                registerTypeAdapter(String.class, new StringUnescapeDeserializer()).create();

        String regex4 = "(?<!:)\\/\\/.*|\\/\\*(\\s|.)*?\\*\\/";
       String msgdata= strB.toString().replaceAll(regex4, "");

//        JsonReader reader = new JsonTreeReader(jsonEl);


        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CatBean.class, new CarBeanTypeAdapter());
//        gsonBuilder.registerTypeAdapter(CatBean.class, new CarBeanTypeAdapter());
        gsonBuilder.setPrettyPrinting();

        final Gson mGson = gsonBuilder.create();
//        msgdata=    StringEscapeUtils.escapeHtml3(msgdata);

        CatBean account = mGson.fromJson(msgdata, CatBean.class);

        int I=0;

//         String   msg="''";
//     String result=    StringEscapeUtils.escapeHtml4(msg);
//
//        String word="c++";
//        String test="";
//        if (word.contains("+")){
//            test=word.replace("c++","C%2B%2B");
//        }
//
//        System.out.println(test);


//        String mlhRule="((fondscode==\"\"||fondscode==null)?\"\":fondscode)\n" +
//                "+((archivescategory1==\"\"||archivescategory1==null)?\"\":\"-\"+archivescategory1)\n" +
//                "+((archforyear==\"\"||archforyear==null)?\"\":\"-\"+archforyear)+((retentionperiodcode==''||retentionperiodcode==null)?\"\":\"-\"+retentionperiodcode)+((deptsn==\"\"||deptsn==null)?\"\":\"-\"+deptsn)+\"-\"+$padNumber(archivesitemnumber,4)\n" +
//                "+((indetailsno1==''||indetailsno1==null)?\"\":\"-\"+$padNumber(indetailsno1,3))";
//
//        String[] watchField=mlhRule.matches("/b[a-zA-Z][0-9a-zA-Z]*b/g");


//        String reg = "(\\w+),?";
//        String str = "aabb,xxx,yysin,ienif";
//        Pattern pattern = Pattern.compile(reg);//编译正则表达式(\w+),?
//        Matcher matcher = pattern.matcher(str);//用编译后的pattern去匹配目标字符串str
//        while(matcher.find()) {
//
//
//        }
//


//        int initNum=9;
//          int  n=9;
//
//          for(int i=1;i<=initNum;i++){
//              System.out.println("   ");
//              for(int k=1;k<i;k++){
//
//                  for(int j=i;j<=initNum;j++){
//
//                 System.out.println(""+i+"*"+j);
//
//
//                  }
//
//
//              }
//
//
//
//          }


        Map colMap=new HashMap();
        colMap.put("title","name is change");
         List<String>  keyList=new ArrayList<>(colMap.keySet());
        for (String  key: keyList ) {
             String value=(String)  colMap.get(key);
              int i=0;
        }


    }
    public static  final  void main2(String[] arg) throws IOException {
        File file=new File("C:\\Users\\lindanghong\\Downloads\\0015001.zip");
        ZipFile zipFile = new ZipFile(file, "GBK");

        Enumeration<ZipEntry> enu = zipFile.getEntries();



        while (enu.hasMoreElements()) {
            ZipEntry ze = enu.nextElement();

            if (!ze.isDirectory()) {
                String  filename=ze.getName();
                filename=filename.substring(filename.lastIndexOf("/")+1,filename.length());
                //create ifile start

                //create ifile end

                System.out.println(filename);


            }
        }



    }
}
