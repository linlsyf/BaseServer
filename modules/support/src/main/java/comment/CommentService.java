package comment;

import comment.dao.CommentDao;
import dao.bean.Comment;
import org.springframework.stereotype.Service;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * 留言管理服务类
 */
@Service
public class CommentService {
    CommentDao  orderDao;
    /**
     * 获取数据库管理服务
     */
    public CommentDao getOrderDao() {
        if (orderDao==null){
            orderDao=new CommentDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
    /**
     * 添加留言
     */
    public ResponseMsg add( Map params) throws Exception {

        return getOrderDao().insert(params);
    }
    /**
     * 获取留言详情
     */
    public Comment get(String id) throws IOException {
        CommentDao  dao=new CommentDao();
        return  dao.get(id);
    }
    /**
     * 删除留言
     */
    public static String remove(Comment comment) throws IOException {
        CommentDao  dao=new CommentDao();
        return  dao.remove(comment);
    }
    /**
     * 搜索留言
     */
    public List<Object> search(Map params)throws Exception  {
        return getOrderDao().search(params);
    }
}
