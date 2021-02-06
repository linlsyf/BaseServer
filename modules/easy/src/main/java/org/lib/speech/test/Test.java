package org.lib.speech.test;

import org.lib.speech.engine.Engine;
import org.lib.speech.engine.SpeechEngine;
import org.lib.speech.process.DefaultStreamProcess;
import org.lib.speech.process.ProcessCenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class Test {


//    public static void main(String[] args) {
//        String shell = "ping www.baidu.com";//需要执行的命令
//        System.out.println(shell);
//        BufferedReader br = null;
//        try {
//            Process p = Runtime.getRuntime().exec(shell);//调用控制台执行shell
//            br = new BufferedReader(new InputStreamReader(p.getErrorStream()));//获取执行后出现的错误；getInputStream是获取执行后的结果
//
//            String line = null;
//            StringBuilder sb = new StringBuilder();
//            while ((line = br.readLine()) != null) {
//                sb.append(line + "\n");
//                System.out.println(sb);
//            }
//            System.out.println(sb);//打印执行后的结果
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally
//        {
//            if (br != null)
//            {
//                try {
//                    br.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    public static void main(String[] args) {
//        String localhost_dir = "";
//        Runtime run = null;
//        try {
//            run = Runtime.getRuntime();
//            //调用解码器来将wav文件转换为mp3文件
//            Process p=run.exec("/usr/bin/lame /java/5/a.wav"); //16为码率，可自行修改
//
//
//            //释放进程
//            p.getOutputStream().close();
//            p.getInputStream().close();
//            p.getErrorStream().close();
//            p.waitFor();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            //最后都要执行的语句
//            //run调用lame解码器最后释放内存
//            run.freeMemory();
//        }
//
//    }
//    public static void main(String[] args) {
//        String localhost_dir = "";
//        Runtime run = null;
//        try {
//            run = Runtime.getRuntime();
//            //调用解码器来将wav文件转换为mp3文件
//            Process p=run.exec("E:/java/apache-tomcat-7.0.77/webapps/JavaWeb/lame/ lame -b 16 F:/Visual-NMP-x64/www/demo/a.wav"); //16为码率，可自行修改
//
//            //释放进程
//            p.getOutputStream().close();
//            p.getInputStream().close();
//            p.getErrorStream().close();
//            p.waitFor();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            //最后都要执行的语句
//            //run调用lame解码器最后释放内存
//            run.freeMemory();
//        }
//
//    }


    public static void main(String[] args) {
        // data    properties 要放到D盘后续需要修改
// 建造一个流处理器，参数设置是否重新读取字典文件
        ProcessCenter pc = new DefaultStreamProcess(true);
// 建立一个语音引擎，第二个参数设置是否转换为粤语口语发音
        Engine engine = new SpeechEngine(pc, true);
// 任何一个String作为你想要它发音的句子
        String sentences = "苏哈仔，看看它是如何发音的";
// 第一种方法：直接要它发音
        engine.getPronounces(sentences);
// 另外，如果你想获得初始的发音素材，可以这样显示到控制台
        List<Object[]> list = engine.getPronounceElements(sentences);
        Iterator<Object[]> iter = list.iterator();
        while (iter.hasNext()) {
            Object[] obj = iter.next();
            if (obj[0] instanceof File) {
                for (int i = 0; i < obj.length; i++) {
                    File file = (File) obj[i];
                    System.out.print(file.getName() + " ");
                }
            } else {
                for (int i = 0; i < obj.length; i++) {
                    System.out.print(obj[i] + " ");
                }
            }
            System.out.println();
        }
    }

}


