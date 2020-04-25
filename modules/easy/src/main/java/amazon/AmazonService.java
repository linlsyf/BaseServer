package amazon;

import amazon.dao.AmazonDao;
import auth.User;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import utils.ZStringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AmazonService {
    static AmazonDao mDao;

    public static AmazonDao getDao() {
        if (mDao==null){
            mDao=new AmazonDao();
            mDao.instance=mDao;
        }
        return mDao;
    }
    public String add( String  msg) throws Exception  {
        User order=  JSON.parseObject(msg, User.class);
        return order.getId();
    }

    public  ResponseMsg list()throws Exception  {
       return getDao().list();
    }
//    public User get(String id) throws IOException {
//        AmazonDao  dao=new AmazonDao();
//
//        return  dao.get(id);
//    }


    public ResponseMsg add(Map params){

        Map  inputMap=new HashMap();
        inputMap.put("type",params.get("type"));
        inputMap.put("loginId",params.get("loginId"));
//        inputMap.put("register",params.get("loginId"));
        inputMap.put("pwd",params.get("pwd"));
         return getDao().insert(params);
    }
    public ResponseMsg addUser(Map params){

         return getDao().insertByName(params,"CreateUser.sql");
    }
     public  synchronized void    updateViewVistCount() throws Exception {

        int count= AmazonViewCountUtils.todayNum;
        int tempCount=count;
         Map params=new HashMap();
         params.put("count",count);
         ResponseMsg  msg= getDao().updateViewCount(params);
            if (msg.isSuccess()){
                AmazonViewCountUtils.todayNum=AmazonViewCountUtils.todayNum-tempCount;
             System.out.println("updateViewVistCount:"+count);
            }

     }

}