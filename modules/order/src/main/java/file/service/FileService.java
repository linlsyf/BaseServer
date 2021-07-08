package file.service;

import file.dao.FileListDao;
import file.dao.bean.FileRecorder;
import org.apache.tools.ant.types.FileList;
import org.springframework.stereotype.Service;
import spring.response.ResponseMsg;
import utils.FileStoreUtis;

import java.util.Map;

@Service
public class FileService {
    FileListDao orderDao;

    public FileListDao getOrderDao() {
        if (orderDao==null){
            orderDao=new FileListDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }

    public ResponseMsg add(Map mapInput) throws Exception  {

      return   getOrderDao().insert(mapInput);


    }
    public ResponseMsg get(Map mapInput) throws Exception  {
        String id=(String) mapInput.get("id");
        ResponseMsg msg=  getOrderDao().get(id, FileRecorder.class );
//        FileRecorder fileRecorder=(FileRecorder)   msg.getData();
//               if (null!=fileRecorder){
//                   String filePath= FileStoreUtis.getInstance().foldName+"/"+fileRecorder.getName();
//                   fileRecorder.setFilePath(filePath);
//                   msg.setData(fileRecorder);
//               }
      return   msg;


    }

}
