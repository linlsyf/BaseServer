package exam.service;

import auth.User;
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
        msg=getOrderDao().searchRecord(params);
        boolean containRecord=false;
        if (msg.isSuccess()) {
            if (msg.getData().toString().length() > 2) {
                containRecord=true;
            }
        }

         if (!containRecord){
             msg= getOrderDao().createUserExamRecord(params);

         }else{

//             update   init later
         }

        return  msg ;
    }
    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
        Map limitMap=new HashMap();
           limitMap.put("name",params.get("name"));
        ResponseMsg msg= search(limitMap);
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
    public  ResponseMsg  search( Map params)throws Exception  {

        ResponseMsg data= getOrderDao().search(params);
        return data;
    }
    public  ResponseMsg  typeList( Map params)throws Exception  {

        ResponseMsg data= getOrderDao().typeList(params);
        return data;
    }
    public  ResponseMsg  radomExam( Map params)throws Exception  {

        String ticket=(String)params.get("ticket");

        Ztoken  ztoken=  TokenCache.getZtoken(ticket);
          if (null!=ztoken){
              User user=    ztoken.getUser();

               if (null!=user){

                   params.put("limitUserId",user.getId());
               }

          }

        ResponseMsg data= getOrderDao().radomExam(params);
        return data;
    }
    public ResponseMsg get(String id) throws IOException {

        return  getOrderDao().get(id);
    }



}
