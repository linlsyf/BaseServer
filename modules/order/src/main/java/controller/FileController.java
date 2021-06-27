package controller;

import com.alibaba.fastjson.JSON;

import com.miracle.apps.cms.setting.impl.CmsImpExpServiceImpl._doImportMenu;
import file.service.FileService;
import spring.response.ResponseMsg;
import utils.FileStoreUtis;
import file.dao.FileListDao;
import file.dao.bean.FileRecorder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller(value = "fileController")
@RequestMapping(value = "/api/v1/file")
public class FileController {
    FileService service=new FileService();
    @RequestMapping(value = "/upload")
    @ResponseBody
    public MBYViewModel uploadFile(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest request) throws UnsupportedEncodingException {

          String  origFileName=        uploadFile.getOriginalFilename();
       String saveFileName=new String(origFileName.getBytes("ISO-8859-1"), "UTF-8");
        String id= UUID.randomUUID().toString();
//        order.setId(id);
        String suffix = saveFileName.substring(saveFileName.lastIndexOf(".") + 1);
        String dbFileName=id+"."+suffix;
        File targetFile = new File(FileStoreUtis.getInstance().baseOutputFilePath, dbFileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        String result="";
        FileRecorder recorder;
        MBYResponseViewModel mbyViewModel=null;
        //保存
        try {
            uploadFile.transferTo(targetFile);
            recorder= createRecord(targetFile, id);
        } catch (Exception e) {
            e.printStackTrace();
            result="上传失败"+e.getMessage();
            mbyViewModel=new MBYResponseViewModel("200",result);
            return mbyViewModel;
        }
        result="上传成功";
        mbyViewModel=new MBYResponseViewModel("200",result);
         mbyViewModel.setData(recorder);
        return mbyViewModel;
    }
     public FileRecorder createRecord(File targetFile,String id) throws Exception {
         FileRecorder  fileRecorder=new FileRecorder();
         fileRecorder.setName(targetFile.getName());
//         fileRecorder.setPath(targetFile.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
         fileRecorder.setId(id);
         Map mapInput=new HashMap();
         mapInput.put("id",id);
         mapInput.put("name",targetFile.getName());
         mapInput.put("path",targetFile.getAbsolutePath());
         service.add(mapInput);
         fileRecorder.setId(id);
          return fileRecorder;
     }
    @RequestMapping(value = "/get")
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {

       return  service.get(params);

    }
    /**
     * 文件下载功能
     * @param request
     * @param response
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request,HttpServletResponse response, @RequestParam  Map data) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件
        String type= (String) data.get("type");
        String id= (String) data.get("id");
        downloadFile(response, type, id);

    }
    @RequestMapping("/downApk")
    public void downApk(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String  type="3"; //模拟文件，myfile.txt为需要下载的文件
        String  name=request.getParameter("name");

        downloadFile(response, type, name);

    }

    private void downloadFile(HttpServletResponse response, String type, String id) throws Exception {
        String fileName = "";
        if(type==null){
            type="1";
        }

        String name="";
        if (type.equals("2")){
            Map getMap=new HashMap();
            getMap.put("id",id);
            ResponseMsg  msg= service.get(getMap);
            FileRecorder  recorder=(FileRecorder) msg.getData();
//            FileRecorder  recorder=  FileListDao.getFileRecorderById(id);
            if (recorder==null){
                return;
            }
            name=recorder.getName();
        }else{
            name=id;
        }

         fileName =FileStoreUtis.getInstance().baseOutputFilePath+name;
        //获取输入流
        try {
            File  douwnFile=new File(fileName);
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