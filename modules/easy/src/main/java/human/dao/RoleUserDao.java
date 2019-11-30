package human.dao;

import com.alibaba.fastjson.JSON;

import human.dao.bean.RoleUser;
import human.dao.mapper.RoleUserMapper;
//import org.apache.ibatis.session.SqlSession;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;

/**
 *
 * Title: RoleUserDao
 *
 * @author chenxiaochan
 */
public class RoleUserDao {


    public static  boolean  add(RoleUser roleUser) throws IOException {
        boolean flag=false;

//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        RoleUserMapper studentMapper = sqlSession.getMapper(RoleUserMapper.class);
//
////       String id= UUID.randomUUID().toString();
////       RoleUser.setId(id);
//        int count=studentMapper.add(roleUser);
//        sqlSession.commit();
//        // 释放资源
//        sqlSession.close();
//        String msg="添加成功";
//          if (count>0){
//            flag=true;
//        }else{
//              msg="添加失败";
//          }
////        ResponseMsg responseMsg=new ResponseMsg();
////        responseMsg.setSuccess(flag);
////        responseMsg.setMsg(msg);
////        String result= JSON.toJSONString(responseMsg);

        return  flag;
    }
    public static  String  update(RoleUser RoleUser) throws IOException {
        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        RoleUserMapper studentMapper = sqlSession.getMapper(RoleUserMapper.class);
//
//        int count=studentMapper.update(RoleUser);
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
    public static  String  remove(RoleUser RoleUser) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        RoleUserMapper studentMapper = sqlSession.getMapper(RoleUserMapper.class);
//
//        int count=studentMapper.delete(RoleUser.getId());
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
        boolean flag=false;

//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        RoleUserMapper studentMapper = sqlSession.getMapper(RoleUserMapper.class);
//        List<RoleUser> RoleUserList = studentMapper.list();
////        for (RoleUser RoleUser:RoleUserList ) {
////            if (StringUtils.isNotEmpty(RoleUser.getImageName())){
////                RoleUser.setImagUrl(ServiceUtils.URL+"?type=2&"+"name="+RoleUser.getImageName());
////            }
////        }
//        // 释放资源
//        sqlSession.close();
//        flag=true;
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setData(RoleUserList);
//        String result=JSON.toJSONString(responseMsg);
        String result="";
        return  result;
    }
    public static  RoleUser  get(String id) throws IOException {
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        RoleUserMapper studentMapper = sqlSession.getMapper(RoleUserMapper.class);
//        RoleUser RoleUser = studentMapper.get(id);
//        // 释放资源
//        sqlSession.close();

//        String resultOrde=JSON.toJSONString(easy.RoleUser);

         return  null;
//         return  RoleUser;
    }


}