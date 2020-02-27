package comment;

import comment.dao.CommentDao;
import dao.bean.Comment;
import org.springframework.stereotype.Service;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.Map;

@Service
public class CommentService {
    CommentDao  orderDao;
    public CommentDao getOrderDao() {
        if (orderDao==null){
            orderDao=new CommentDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
    public ResponseMsg add( Map params) throws Exception {

        return getOrderDao().insert(params);
    }
//    public  ResponseMsg list()throws Exception  {
//       String data= CommentDao.list();
//        return data;
//    }
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

    public  ResponseMsg  search( Map params)throws Exception  {

        ResponseMsg data= getOrderDao().search(params);
        return data;
    }
}
