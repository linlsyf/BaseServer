package amazon;

import amazon.dao.AmazonAccountDao;
import auth.User;
import base.BaseBean;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import spring.response.ResponseMsg;
import utils.TimeAreaUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class AmazonAccountService {
    static AmazonAccountDao mDao;

    public static AmazonAccountDao getDao() {
        if (mDao==null){
            mDao=new AmazonAccountDao();
            mDao.instance=mDao;
        }
        return mDao;
    }
    public String add( String  msg) throws Exception  {
        User order=  JSON.parseObject(msg, User.class);
        return order.getId();
    }

    public  ResponseMsg list()throws Exception  {
        Map  params=new HashMap();
        return getDao().searchPageByName(params, AmazonBean.class,"listAccount.sql");


       // return getDao().search();
    }


    public void  saveCustonInfo(){

        // String ip = SysUtils.getLoginUserIp();
          Map infoMap=new HashMap();
           infoMap.put("createtime", TimeAreaUtils.getTimeNow());
         getDao().insertByName(infoMap,"Create_View_Log_account.sql");


     }
    public  ResponseMsg searchViewCount(Map params)throws Exception  {
        return getDao().searchPageByName(params, BaseBean.class,"searchViewCountAccount.sql");
    }
    /*
      获取总数和今日数据
     */
    public  ResponseMsg getViewCountMsg(Map params)throws Exception  {
        return getDao().searchPageByName(params, AmazonBean.class,"getViewCountMsgAccount.sql");
    }

//
//    public ResponseMsg add(Map params){
//
//        Map  inputMap=new HashMap();
//        inputMap.put("type",params.get("type"));
//        inputMap.put("loginId",params.get("loginId"));
////        inputMap.put("register",params.get("loginId"));
//        inputMap.put("pwd",params.get("pwd"));
//         return getDao().insert(params);
//    }



}
