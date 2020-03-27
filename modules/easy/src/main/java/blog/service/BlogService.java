package blog.service;

import auth.User;
import base.BaseBean;
import blog.dao.BlogDao;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.I2F;
import config.LoginConfig;
import dict.dao.DictDao;
import exam.dao.ExamCon;
import exam.dao.ExamDao;
import favour.dao.bean.FavourBean;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import sun.security.krb5.internal.PAData;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {
//    ErrorDao mDictDao=new ErrorDao();

    BlogDao orderDao;

//    public  String remove(String[] ids) {
//
//
//        return    getOrderDao().delete(ids);
//    }

    public BlogDao getOrderDao() {
        if (orderDao==null){
            orderDao=new BlogDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }

    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
//        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
//        if (null!=responseMsg){
//            return responseMsg;
//        }
        Map limitMap=new HashMap();
           limitMap.put("name",params.get("name"));
        ResponseMsg msg= search(limitMap,ztoken);
        if (msg.isSuccess()) {
            if (msg.getData().toString().length() > 2) {
                msg=new ResponseMsg();
                msg.setSuccess(false);
                msg.setMsg("已经存在题名相同的数据");
                return  msg;
            }
        }
//        if (!params.containsKey("type")){
//            params.put("type", ExamCon.TYPE_STUDY_COMMON);
//            params.put("typename", ExamCon.TYPE_STUDY_COMMON_NAME);
//        }
       return   getOrderDao() .insert(params);
    }
//    public ResponseMsg update( Map params, Ztoken ztoken) throws Exception  {
//        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
//        if (null!=responseMsg){
//            return responseMsg;
//        }
//       return   getOrderDao() .update(params);
//    }

//    public  ResponseMsg  list()throws Exception  {
//        ResponseMsg data= getOrderDao().list();
//        return data;
//    }
    public  ResponseMsg  search( Map params, Ztoken ztoken )throws Exception  {

        ResponseMsg data= getOrderDao().searchPage(params, BaseBean.class);
        return data;
    }
//    public  ResponseMsg  typeList( Map params)throws Exception  {
//
//        ResponseMsg data= getOrderDao().typeList(params);
//        return data;
//    }
//    public  ResponseMsg  radomExam( Map params)throws Exception  {
//
//        String ticket=(String)params.get("ticket");
//
//        Ztoken  ztoken=  TokenCache.getZtoken(ticket);
//          if (null!=ztoken&&params.containsKey("filterUserRead")){
//              User user=    ztoken.getUser();
//
//               if (null!=user){
//
//                   params.put("limitUserId",user.getId());
//               }
//
//          }
//
//        ResponseMsg data= getOrderDao().radomExam(params);
//        return data;
//    }
//    public ResponseMsg get(String id) throws IOException {
//
//        return  getOrderDao().get(id);
//    }



}
