package org.lib.speech.test;

import org.lib.speech.engine.Engine;
import org.lib.speech.engine.SpeechEngine;
import org.lib.speech.process.DefaultStreamProcess;
import org.lib.speech.process.ProcessCenter;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import java.util.ArrayList;
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
public static void main (String args[]) throws Exception{

    //获取tomcat 路径
//		    String ROOT = "E:\\java\\apache-tomcat-7.0.77";
    String ROOT = "D:";

    String sentences = "阿法第三方";
//			int num = RandomNum();
//    Calendar now = Calendar.getInstance();
    String rootDir = ROOT+"/tts/";
    //String timeDir = ""+(now.get(Calendar.YEAR))  + (now.get(Calendar.MONTH) + 1) +(now.get(Calendar.DAY_OF_MONTH)) + "/" + (now.get(Calendar.HOUR_OF_DAY)) +"/";
    //System.out.println(rootDir+timeDir);
    //File file_mk = new File(rootDir+timeDir+num+"/");


    List<String> listArr = new ArrayList<String>();
    String dir = ROOT+"/data/jyutping-wong-44100-v7/"; //读取wav文件路径

//			String dir = ROOT+"/webapps/java-tts/data/jyutping-wong-44100-v7/"; //读取wav文件路径
    //String data_dir = timeDir+num+"/"; //生成文件路径
    //createDir(rootDir+timeDir+num);
    String localhost_dir = rootDir+sentences+".wav"; //生成的wav语音包
    ProcessCenter pc = new DefaultStreamProcess(false);
    // 建立一个语音引擎，第二个参数设置是否转换为粤语口语发音
    Engine engine = new SpeechEngine(pc, true);

    List<Object[]> list = engine.getPronounceElements(sentences);
    Iterator<Object[]> iter = list.iterator();
    //获取需要播放的文件名
    while (iter.hasNext()) {
        Object[] obj = iter.next();
        if (obj[0] instanceof File) {
            for (int i = 0; i < obj.length; i++) {
                File file = (File) obj[i];
                //	  	System.out.print(file.getName() + " ");
                listArr.add(file.getName());
            }
        }
    }
    //如果这个语音大于 2 个
    if (listArr.size() >= 2){

        AudioInputStream audio1 = AudioSystem.getAudioInputStream(new File(dir+listArr.get(0)));
        AudioInputStream audio2 = AudioSystem.getAudioInputStream(new File(dir+listArr.get(1)));
        AudioInputStream audioBuild = new AudioInputStream(
                new SequenceInputStream(audio1, audio2),
                audio1.getFormat(),
                audio1.getFrameLength() +
                        audio2.getFrameLength()
        );
        AudioInputStream audio3;
        //大于两个时继续合并
        for(int i = 2; i<listArr.size();i++){
            audio3 = AudioSystem.getAudioInputStream(new File(dir+listArr.get(i)));
            audioBuild = new AudioInputStream(
                    new SequenceInputStream(audioBuild, audio3),
                    audioBuild.getFormat(), audioBuild.getFrameLength() +
                    audio3.getFrameLength()
            );
        }
        //生成语音
        AudioSystem.write(audioBuild, AudioFileFormat.Type.WAVE, new File(localhost_dir));

    } else {
        //TODO::否则只有一个,直接返回语音路径
        localhost_dir = dir+listArr.get(0);
    }



    System.out.println(localhost_dir);

//			//输出 wav IO流
//			try{
//				response.setHeader("Content-Type", "audio/mpeg");
//				File file = new File(localhost_dir);
//				int len_l = (int) file.length();
//				byte[] buf = new byte[2048];
//				FileInputStream fis = new FileInputStream(file);
//				OutputStream out = response.getOutputStream();
//				len_l = fis.read(buf);
//				while (len_l != -1) {
//					out.write(buf, 0, len_l);
//					len_l = fis.read(buf);
//				}
//				out.flush();
//				out.close();
//				fis.close();
//			}catch (Exception e){
//				System.out.println(e);
//			}
    //response.setHeader("Content-Length",len_l+"");
    //删除文件夹,只能按路径删除
    //	deleteFile(rootDir+num+".wav");

}

    public static void main2(String[] args) {
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


