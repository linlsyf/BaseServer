package error.service;

import adcar.dao.AdcarDao;
import com.alibaba.fastjson.JSON;
import config.LoginConfig;
import dict.dao.DictDao;
import error.dao.ErrorDao;
import favour.dao.FavourDao;
import favour.dao.bean.FavourBean;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import utils.ZStringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ErrorService {
//    ErrorDao mDictDao=new ErrorDao();

    ErrorDao orderDao;

    public  String remove(String[] ids) {


        return    getOrderDao().delete(ids);
    }

    public ErrorDao getOrderDao() {
        if (orderDao==null){
            orderDao=new ErrorDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }


    public  ResponseMsg  list()throws Exception  {
        ResponseMsg data= getOrderDao().list();
        return data;
    }
    public  List<Object>  search(Map params, Ztoken ztoken)throws Exception  {

//        if (!TokenCache.containToken(ztoken.getTicket())&&!ztoken.getTicket().equals(LoginConfig.loginTemp)){
//            ResponseMsg data=new ResponseMsg();
//            data.setSuccess(false);
//            data.setCode(300+"");
//            data.setMsg("请先登录");
//            return data;
//        }

       return  getOrderDao().search(params);
    }
    public ResponseMsg get(String id) throws IOException {

        return  getOrderDao().get(id,FavourBean.class);
    }


    public MBYViewModel add(String msg, Ztoken ztoken) {


        return null;
//        getOrderDao().ad
    }
}
