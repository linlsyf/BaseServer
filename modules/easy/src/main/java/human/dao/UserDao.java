package human.dao;

import com.alibaba.fastjson.JSON;

import human.dao.bean.User;
import human.dao.mapper.UserMapper;
//import org.apache.ibatis.session.SqlSession;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 *
 * Title: userDao
 *
 * @author chenxiaochan
 */
public class UserDao {


    public static  boolean  add(User user) throws IOException {
        boolean flag=false;

//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        UserMapper studentMapper = sqlSession.getMapper(UserMapper.class);
//
//       String id= UUID.randomUUID().toString();
//       user.setId(id);
//        int count=studentMapper.add(user);
//        sqlSession.commit();
//        // 释放资源
//        sqlSession.close();
//        String msg="添加成功";
//          if (count>0){
//            flag=true;
//        }else{
//              msg="添加失败";
//          }
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setMsg(msg);
//        String result= JSON.toJSONString(responseMsg);

        return  flag;
    }
    public static  String  update(User user) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        UserMapper studentMapper = sqlSession.getMapper(UserMapper.class);
//
//        int count=studentMapper.update(user);
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
    public static  String  remove(User user) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        UserMapper studentMapper = sqlSession.getMapper(UserMapper.class);
//
//        int count=studentMapper.delete(user.getId());
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
//        return  result;
        String result="";
        return  result;
    }
    public static  String  list() throws IOException {
//        boolean flag=false;
//
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        UserMapper studentMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = studentMapper.list();
////        for (User user:userList ) {
////            if (StringUtils.isNotEmpty(user.getImageName())){
////                user.setImagUrl(ServiceUtils.URL+"?type=2&"+"name="+user.getImageName());
////            }
////        }
//        // 释放资源
//        sqlSession.close();
//        flag=true;
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setData(userList);
//        String result=JSON.toJSONString(responseMsg);
//         return  result;
        String result="";
        return  result;
    }
    public static  User  get(String id) throws IOException {
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        UserMapper studentMapper = sqlSession.getMapper(UserMapper.class);
//        User user = studentMapper.get(id);
//        // 释放资源
//        sqlSession.close();

//        String resultOrde=JSON.toJSONString(easy.user);

         return  null;
    }
    public static  User  getByRegisterId(String id) throws IOException {
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        UserMapper studentMapper = sqlSession.getMapper(UserMapper.class);
//        User user = studentMapper.getByRegisterId(id);
//        // 释放资源
//        sqlSession.close();

//        String resultOrde=JSON.toJSONString(easy.user);

         return  null;
    }
    public static  User  getByLoginId(String id) throws IOException {
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        UserMapper studentMapper = sqlSession.getMapper(UserMapper.class);
//        User user = studentMapper.getByLoginId(id);
//        // 释放资源
//        sqlSession.close();

         return  null;
    }
}