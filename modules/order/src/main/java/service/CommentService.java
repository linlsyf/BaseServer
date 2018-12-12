package service;

import com.alibaba.fastjson.JSON;

import dao.CommentDao;
import dao.bean.Comment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class CommentService {

    public String add( String  msg) throws Exception  {

          Comment comment=  JSON.parseObject(msg, Comment.class);
        String CommentId= UUID.randomUUID().toString();
        comment.setId(CommentId);
        CommentDao.add(comment);
//         FileRecorder fileRecorder=FileListDao.getFileRecorderById(comment.getImageId());
//           fileRecorder.setRefId(comment.getId());
//           FileListDao.update(fileRecorder);
        return comment.getId();
    }
    public  String list()throws Exception  {
       String data= CommentDao.list();
        return data;
    }
    public  String getOrderedList()throws Exception  {
       String data= CommentDao.listByStatus(3);
        return data;
    }

    public Comment get(String id) throws IOException {
        CommentDao  dao=new CommentDao();
        return  dao.get(id);
    }

    public static String remove(Comment comment) throws IOException {
        CommentDao  dao=new CommentDao();
        return  dao.remove(comment);
    }
}
