package human.dao;

import base.BaseBussinessDao;

import auth.User;
import human.dao.bean.UserAuths;
//import org.apache.ibatis.session.SqlSession;
import spring.response.ResponseMsg;
import utils.MD5Tools;
import utils.ZStringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Title: userDao
 *
 * @author chenxiaochan
 */
public class UserDao extends BaseBussinessDao {
    public static final String mRootPath = "USER_BASE";




    public static boolean add(User user) throws IOException {
        boolean flag = false;

//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        FavourBeanMapper studentMapper = sqlSession.getMapper(FavourBeanMapper.class);
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

        return flag;
    }

    public static String update(User user) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        FavourBeanMapper studentMapper = sqlSession.getMapper(FavourBeanMapper.class);
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
        String result = "";
        return result;
    }

    public static String remove(User user) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        FavourBeanMapper studentMapper = sqlSession.getMapper(FavourBeanMapper.class);
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
        String result = "";
        return result;
    }

    public static String list() throws IOException {
//        boolean flag=false;
//
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        FavourBeanMapper studentMapper = sqlSession.getMapper(FavourBeanMapper.class);
//        List<User> userList = studentMapper.list();
////        for (User user:userList ) {
////            if (ZStringUtils.isNotEmpty(user.getImageName())){
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
        String result = "";
        return result;
    }



    public List<Object> getByRegisterId(String id) throws IOException {

        Map  params=new HashMap();
        params.put("loginId",id);
        return searchByName(params, UserAuths.class,"RegisterSearch.sql");

    }

    public   List<Object> qqSearchLogin(Map params) throws IOException {

        return searchByName(params, UserAuths.class,"LoginTypeSeach.sql");

    }

    public   List<Object> login(Map params) throws IOException {
        String  pwd=(String)params.get("pwd");
           if(ZStringUtils.isNotEmpty(pwd)){
               params.put("pwd", MD5Tools.string2MD5(pwd));
           }
         return searchByName(params, UserAuths.class,"Login.sql");
//        return searchPage(mRootPath, params, User.class);
    }

}