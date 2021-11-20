package file.dao;

import base.BaseBussinessDao;
import com.alibaba.fastjson.JSON;

import file.dao.bean.FileRecorder;
//import org.apache.ibatis.session.SqlSession;
import spring.response.ResponseMsg;

import java.io.IOException;

public class FileListDao extends BaseBussinessDao {
//
//    public static  String  update(FileRecorder order) throws IOException {
//        boolean flag=false;
////        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
////        FileRecorderMapper studentMapper = sqlSession.getMapper(FileRecorderMapper.class);
////
////        int count=studentMapper.update(order);
////        sqlSession.commit();
////
////        // 释放资源
////        sqlSession.close();
////        if (count>0){
////            flag=true;
////        }
////
////        ResponseMsg responseMsg=new ResponseMsg();
////        responseMsg.setSuccess(flag);
////        String result=JSON.toJSONString(responseMsg);
//
//        String result="";
//        return  result;
//    }

    public static FileRecorder getFileRecorderById(String id){
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        FileRecorderMapper studentMapper = sqlSession.getMapper(FileRecorderMapper.class);
//        FileRecorder order = studentMapper.findOrderById(id);
//        // 释放资源
//        sqlSession.close();
        return null;
    }
//    public static  String  get(String id) throws IOException {
//        boolean flag=false;
//
//        FileRecorder order =getFileRecorderById(id);
//        if (order!=null){
//            flag=true;
//        }
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        if (order!=null){
//            responseMsg.setData(order);
//        }
//        String result=JSON.toJSONString(responseMsg);
//        return  result;
//    }
}
