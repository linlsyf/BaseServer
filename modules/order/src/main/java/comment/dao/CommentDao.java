package comment.dao;

import base.BaseBussinessDao;
import com.alibaba.fastjson.JSON;

import dao.Mapper.CommentMapper;
import dao.bean.Comment;
//import org.apache.ibatis.session.SqlSession;
import exam.dao.bean.ExamBean;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 *
 * Title: ShopCartDao
 *
 * @author chenxiaochan
 */
public class CommentDao extends BaseBussinessDao {


//
//    public   ResponseMsg  add(String inputString) throws IOException {
//
//        return insert(inputString);
//    }
    public static  String  update(Comment order) throws IOException {
        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        CommentMapper studentMapper = sqlSession.getMapper(CommentMapper.class);
//
//        int count=studentMapper.update(order);
//        sqlSession.commit();
//
//        // 释放资源
//        sqlSession.close();
//        if (count>0){
//            flag=true;
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        String result=JSON.toJSONString(responseMsg);
        String result="";
        return  result;
    }
    public static  String  remove(Comment comment) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        CommentMapper studentMapper = sqlSession.getMapper(CommentMapper.class);
//
//        int count=studentMapper.delete(comment.getId());
//        sqlSession.commit();
//
//        // 释放资源
//        sqlSession.close();
//        if (count>0){
//            flag=true;
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        String result=JSON.toJSONString(responseMsg);
        String result="";
        return  result;
    }
    public static  String  list() throws IOException {
//        boolean flag=false;
//
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        CommentMapper studentMapper = sqlSession.getMapper(CommentMapper.class);
//        List<Comment> userList = studentMapper.findAllComment();
//
//        // 释放资源
//        sqlSession.close();
//        flag=true;
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setData(userList);
//        String result=JSON.toJSONString(responseMsg);
        String result="";
        return  result;
    }
    public static  String  listByStatus(int  status) throws IOException {
//        boolean flag=false;
//
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        CommentMapper studentMapper = sqlSession.getMapper(CommentMapper.class);
//        List<Comment> userList = studentMapper.listByStatus(status);
//
//        // 释放资源
//        sqlSession.close();
//        flag=true;
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setData(userList);
//        String result=JSON.toJSONString(responseMsg);
        String result="";
        return  result;
    }
    public static  Comment  get(String id) throws IOException {
        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        CommentMapper studentMapper = sqlSession.getMapper(CommentMapper.class);
//        Comment order = studentMapper.get(id);
//        // 释放资源
//        sqlSession.close();
//
////        String resultOrde=JSON.toJSONString(easy.order);
////        if (order!=null){
////            flag=true;
////
////        }
////
////        ResponseMsg responseMsg=new ResponseMsg();
////        responseMsg.setSuccess(flag);
////        if (order!=null){
////            responseMsg.setData(order);
////
////        }
////        String result=JSON.toJSONString(responseMsg);

         return  null;
    }
    public   ResponseMsg   search(Map params) throws IOException {

        return   searchPage(params, Comment.class);

    }
}