package test;

import com.mw.utils.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormTest {

    public static  final  void main1(String[] arg){

         String   msg="''";
     String result=    StringEscapeUtils.escapeHtml4(msg);

        String word="c++";
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
    public static  final  void main(String[] arg) throws IOException {
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
