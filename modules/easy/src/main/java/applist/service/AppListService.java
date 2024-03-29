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
import java.util.List;
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
    public ResponseMsg addcustom(Map params, Ztoken ztoken){
        String  fileName="AddCustom.sql";


//        return  getDao().searchByName(params, AppMsg.class,fileName);
         return getDao().insertByName(params,fileName);
    }


    public List<Object> Search(Map params, Ztoken ztoken) throws IOException {
        return  getDao().searchPage(params, AppMsg.class);
    }
    public ResponseMsg deleteCustom(String id) throws Exception  {
        Map  eduNoticeMap=new HashMap();
        eduNoticeMap.put("ids",id);

        return  getDao().exeByName( eduNoticeMap,"deleteCustom.sql");

    }
    public  List<Object> searchCustom( Map params, Ztoken ztoken) throws IOException {

        String  fileName="SearchCustom.sql";


        return  getDao().searchByName(params, AppMsg.class,fileName);

    }
    public  List<Object> searchRadioVideo( Map params, Ztoken ztoken) throws IOException {

        String  fileName="searchRadioVideo.sql";


        return  getDao().searchByName(params, AppMsg.class,fileName);

    }


    public  List<Object> searchAppInfo(Map params, Ztoken ztoken) throws IOException {

         String  fileName="searchAppInfo.sql";


        return  getDao().searchByName(params, AppMsg.class,fileName);


    }
    public  List<Object> searchAppChildInfo(Map params, Ztoken ztoken) throws IOException {

         String  fileName="searchAppChildInfo.sql";


        return  getDao().searchByName(params, AppMsg.class,fileName);


    }
//    public ResponseMsg searchAppInfo( Map params, Ztoken ztoken) throws IOException {
//        return  getDao().searchPageByName(params, BaseBean.class);
//    }



}
