package dict.service;

import adcar.dao.AdcarDao;
import base.BaseBean;
import base.BaseBussinessDao;
import com.alibaba.fastjson.JSON;
import config.LoginConfig;
import dict.dao.DictDao;
import dict.dao.bean.DictBean;
import org.lib.speech.engine.Engine;
import org.lib.speech.engine.SpeechEngine;
import org.lib.speech.process.DefaultStreamProcess;
import org.lib.speech.process.ProcessCenter;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import utils.FileStoreUtis;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class DictService {

    DictDao orderDao;
    DictService instance;
    public DictService  getInstance(){
                if (null==instance){
                    instance=new DictService();
                }
                return  instance;
    }

    public DictDao getOrderDao() {
        if (orderDao==null){
            orderDao=new DictDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
//    public  String remove(String[] ids) {
//
//
//        return    getOrderDao().delete(ids);
//    }

    public  ResponseMsg  search(Map params, Ztoken ztoken)throws Exception  {

//        if (!TokenCache.containToken(ztoken.getTicket())&&!ztoken.getTicket().equals(LoginConfig.loginTemp)){
//            ResponseMsg data=new ResponseMsg();
//            data.setSuccess(false);
//            data.setCode(300+"");
//            data.setMsg("请先登录");
//            return data;
//        }

        ResponseMsg data= getOrderDao().searchPage(params, DictBean.class);
        return data;
    }
    public  ResponseMsg  searchEnglish(Map params, Ztoken ztoken)throws Exception  {

               if(params.containsKey("word")){
                   String word=(String)params.get("word");
                   params.put("search"  ,  "%"+params.get("word")+ "%");
               }

        ResponseMsg data= getOrderDao().searchPageByName(params, DictBean.class,"SearchEnglish.sql");
        return data;
    }
    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
        return getOrderDao().insert(params);
    }
    public ResponseMsg update( Map params, Ztoken ztoken) throws Exception  {

        return  getOrderDao().update(params);
    }
    public ResponseMsg audio( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg data=new ResponseMsg();
        //获取tomcat 路径
//		    String ROOT = "E:\\java\\apache-tomcat-7.0.77";
        String ROOT = "C:";
//        String sentences = "test今年这是测试";
        String sentences = (String)params.get("sentences");

        String rootDir = ROOT+"/tts/";
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

        } else
//            if(listArr.size()>0)
            {
            //TODO::否则只有一个,直接返回语音路径

            localhost_dir = dir+listArr.get(0);
        }
        data.setData(localhost_dir);

       return  data;
    }
    public ResponseMsg getAudio( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg data=new ResponseMsg();
        //获取tomcat 路径
//		    String ROOT = "E:\\java\\apache-tomcat-7.0.77";
        String ROOT = "C:";
//        String sentences = "test今年这是测试";
        String sentences = (String)params.get("sentences");

        String rootDir =   FileStoreUtis.baseOutputFilePath+"/tts/";
        List<String> listArr = new ArrayList<String>();
        String dir = ROOT+"/data/jyutping-wong-44100-v7/"; //读取wav文件路径

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
        data.setData(localhost_dir);

        return  data;
    }
//
//    public boolean  register( String  msg) throws Exception  {
//        DictBean user=  JSON.parseObject(msg, DictBean.class);
//        boolean isSucess= DictDao.add(user);
//
//        return isSucess;
//    }
//    public  String list()throws Exception  {
//       String data= DictDao.list();
//        return data;
//    }
//    public DictBean get(String id) throws IOException {
//        DictDao dao=new DictDao();
//
//        return  dao.get(id);
//    }
//


}
