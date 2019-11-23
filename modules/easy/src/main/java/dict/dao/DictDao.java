package dict.dao;

import dict.dao.bean.DictBean;

import java.io.IOException;


public class DictDao {


    public static  boolean  add(DictBean user) throws IOException {
        boolean flag=false;

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

        return  flag;
    }
    public static  String  update(DictBean user) throws IOException {
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
        String result="";
        return  result;
    }
    public static  String  remove(DictBean user) throws IOException {
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
        String result="";
        return  result;
    }
    public static  String  list() throws IOException {
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
        String result="";
        return  result;
    }
    public static DictBean get(String id) throws IOException {
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        FavourBeanMapper studentMapper = sqlSession.getMapper(FavourBeanMapper.class);
//        FavourBean user = studentMapper.get(id);
//        // 释放资源
//        sqlSession.close();

//        String resultOrde=JSON.toJSONString(easy.FavourBean);

         return  null;
    }


}