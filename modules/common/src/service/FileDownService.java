package service;

import utils.FileStoreUtis;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class FileDownService {



    public static void downloadFile(HttpServletResponse response, String type, String id) {
        String fileName = "";
        if(type==null){
            type="1";
        }

        String name="";
//        if (type.equals("2")){
//            FileRecorder  recorder=  FileListDao.getFileRecorderById(id);
//            if (recorder==null){
//                return;
//            }
//            name=recorder.getName();
//        }else{
            name=id;
//        }

        fileName = FileStoreUtis.getInstance().baseOutputFilePath+name;
        //获取输入流
        try {
            File douwnFile=new File(fileName);
            InputStream bis = new BufferedInputStream(new FileInputStream(douwnFile));
            //假如以中文名下载的话
            //转码，免得文件名中文乱码
            String orgName = URLEncoder.encode(name,"UTF-8");
            //设置文件下载头
            response.addHeader("Content-Disposition", "attachment;filename=" + orgName);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            response.setContentLength(bis.available());
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int total=bis.available();
            int hasRead=0;
            int len = 0;
            while((len = bis.read()) != -1){
                out.write(len);
                out.flush();
            }
            out.close();
        }
        catch (Exception e){
            String  msg=e.getMessage();
            String log=msg;
        }
    }
}
