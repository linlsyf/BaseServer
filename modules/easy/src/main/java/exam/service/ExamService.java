package exam.service;

import auth.User;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.I2F;
import config.LoginConfig;
import dict.dao.DictDao;
import dict.dao.bean.DictBean;
import exam.dao.ExamCon;
import exam.dao.ExamDao;
import exam.dao.bean.ExamBean;
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
public class ExamService {
//    ErrorDao mDictDao=new ErrorDao();

    ExamDao orderDao;

    public  String remove(String[] ids) {


        return    getOrderDao().delete(ids);
    }

    public ExamDao getOrderDao() {
        if (orderDao==null){
            orderDao=new ExamDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
    public ResponseMsg updateUserExam( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }

          Map paramsSearch=new HashMap();
          paramsSearch.put("examid",params.get("examid"));
          paramsSearch.put("userid",params.get("userid"));

        ResponseMsg msg=null;
//        msg=getOrderDao().searchRecord(params);
//        boolean containRecord=false;
//        if (msg.isSuccess()) {
//            if (msg.getData().toString().length() > 2) {
//                containRecord=true;
//            }
//        }
//
//         if (!containRecord){
//             msg= getOrderDao().createUserExamRecord(params);
//
//         }else{
//
////             update   init later
//         }

        return  msg ;
    }
    public    List<Object>   searchEnglish(Map params, Ztoken ztoken)throws Exception  {

        if(params.containsKey("word")){
            String word=(String)params.get("word");
            params.put("search"  ,  "%"+word+ "%");
        }

      return  getOrderDao().searchByName(params, ExamBean.class,"SearchEnglish.sql");
    }
    public    List<Object>   searchEnglishSecond(Map params, Ztoken ztoken)throws Exception  {

        if(params.containsKey("search")){
            String word=(String)params.get("search");
            params.put("search"  ,  "%"+word+ "%");
        }

        return getOrderDao().searchByName(params, ExamBean.class,"SearchEnglishSecond.sql");
    }
    public ResponseMsg updateUserExamEnglish( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }

        Map paramsSearch=new HashMap();
        paramsSearch.put("examid",params.get("examid"));
        paramsSearch.put("userid",params.get("userid"));

        ResponseMsg msg=null;
//        msg=getOrderDao().searchRecord(params);
//        boolean containRecord=false;
//        if (msg.isSuccess()) {
//            if (msg.getData().toString().length() > 2) {
//                containRecord=true;
//            }
//        }
//
//        if (!containRecord){
//            msg= getOrderDao().createUserExamRecord(params);
//
//        }else{
//
////             update   init later
//        }

        return  msg ;
    }

    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
        return  responseMsg;
//        Map limitMap=new HashMap();
//           limitMap.put("name",params.get("name"));
//        ResponseMsg msg= search(limitMap);
//        if (msg.isSuccess()) {
//            if (msg.getData().toString().length() > 2) {
//                msg=new ResponseMsg();
//                msg.setSuccess(false);
//                msg.setMsg("已经存在题名相同的数据");
//                return  msg;
//            }
//        }
////        if (!params.containsKey("type")){
////            params.put("type", ExamCon.TYPE_STUDY_COMMON);
////            params.put("typename", ExamCon.TYPE_STUDY_COMMON_NAME);
////        }
//       return   getOrderDao() .insert(params);
    }
    public ResponseMsg update( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
       return   getOrderDao() .update(params);
    }

    public  ResponseMsg  list()throws Exception  {
        ResponseMsg data= getOrderDao().list();
        return data;
    }
    public    List<Object>   search( Map params)throws Exception  {

      return getOrderDao().search(params);
    }
    public    List<Object>   typeList( Map params)throws Exception  {

       return  getOrderDao().typeList(params);
    }
    public    List<Object>   radomExam( Map params)throws Exception  {

        String ticket=(String)params.get("ticket");

        Ztoken  ztoken=  TokenCache.getZtoken(ticket);
          if (null!=ztoken&&params.containsKey("filterUserRead")){
              User user=    ztoken.getUser();

               if (null!=user){

                   params.put("limitUserId",user.getId());
               }

          }

       return  getOrderDao().radomExam(params);
    }
    public ResponseMsg get(String id) throws IOException {

        return  getOrderDao().get(id);
    }



}
