package applist.service;

import applist.AppMsg;
import applist.dao.AppListDao;
import base.BaseBean;
import org.springframework.stereotype.Service;
import service.Ztoken;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppListService {
    static AppListDao mDao;

    public static AppListDao getDao() {
        if (mDao==null){
            mDao=new AppListDao();
            mDao.instance=mDao;
        }
        return mDao;
    }
    public ResponseMsg add(Map params, Ztoken ztoken){

//        Map  inputMap=new HashMap();
//        inputMap.put("type",params.get("type"));
//        inputMap.put("loginId",params.get("loginId"));
////        inputMap.put("register",params.get("loginId"));
//        inputMap.put("pwd",params.get("pwd"));
         return getDao().insert(params);
    }


    public ResponseMsg Search( Map params, Ztoken ztoken) throws IOException {
        return  getDao().searchPage(params, AppMsg.class);
    }

    public MBYViewModel searchAppInfo(Map params, Ztoken ztoken) throws IOException {

         String  fileName="searchAppInfo.sql";


        return  getDao().searchPageByName(params, AppMsg.class,fileName);


    }
    public MBYViewModel searchAppChildInfo(Map params, Ztoken ztoken) throws IOException {

         String  fileName="searchAppChildInfo.sql";


        return  getDao().searchPageByName(params, AppMsg.class,fileName);


    }
//    public ResponseMsg searchAppInfo( Map params, Ztoken ztoken) throws IOException {
//        return  getDao().searchPageByName(params, BaseBean.class);
//    }



}
