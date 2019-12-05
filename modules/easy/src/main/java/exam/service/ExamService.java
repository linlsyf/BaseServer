package exam.service;

import com.alibaba.fastjson.JSON;
import config.LoginConfig;
import dict.dao.DictDao;
import exam.dao.ExamDao;
import favour.dao.FavourDao;
import favour.dao.bean.FavourBean;
import org.springframework.stereotype.Service;
import service.Ztoken;
import spring.response.ResponseMsg;

import java.io.IOException;
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
    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
       return   getOrderDao() .insert(params);
    }
    public ResponseMsg update( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(ztoken);
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
    public ResponseMsg get(String id) throws IOException {
        FavourDao dao=new FavourDao();

        return  dao.get(id);
    }



}
