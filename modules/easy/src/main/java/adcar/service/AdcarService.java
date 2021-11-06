package adcar.service;

import adcar.dao.AdcarDao;
import com.alibaba.fastjson.JSON;
import config.LoginConfig;
import dict.dao.DictDao;
import favour.dao.FavourDao;
import favour.dao.bean.FavourBean;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdcarService {
//    ErrorDao mDictDao=new ErrorDao();

    AdcarDao orderDao;

    public  String remove(String[] ids) {

        return    getOrderDao().delete(ids);
    }


    public AdcarDao getOrderDao() {
        if (orderDao==null){
            orderDao=new AdcarDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
    public ResponseMsg add(Map  msg) throws Exception  {
       return   getOrderDao() .insert(msg);
    }

    public  ResponseMsg  list()throws Exception  {
        ResponseMsg data= getOrderDao().list();
        return data;
    }
    public    List<Object>   search(Map params, Ztoken ztoken)throws Exception  {

//        if (!TokenCache.containToken(ztoken.getTicket())&&!ztoken.getTicket().equals(LoginConfig.loginTemp)){
//            ResponseMsg data=new ResponseMsg();
//            data.setSuccess(false);
//            data.setCode(300+"");
//            data.setMsg("请先登录");
//            return data;
//        }

       return getOrderDao().search(params);
    }
    public ResponseMsg get(String id) throws IOException {

        return  getOrderDao().get(id,FavourBean.class);
    }



}
