package applist.dao;

import base.BaseBussinessDao;

import java.io.IOException;

//import org.apache.ibatis.session.SqlSession;

/**
 *
 * Title: userDao
 *
 * @author chenxiaochan
 */
public class AppListDao extends BaseBussinessDao {
    public static final String mRootPath = "USER_BASE";

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



}