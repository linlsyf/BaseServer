package exam.service;

import com.alibaba.fastjson.JSON;
import config.LoginConfig;
import dict.dao.DictDao;
import exam.dao.ExamDao;
import favour.dao.bean.FavourBean;
import org.springframework.stereotype.Service;
import service.Ztoken;
import spring.response.ResponseMsg;

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
    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
//        Map limitMap=new HashMap();
//        ResponseMsg msg= search(limitMap);//才数据超过50万条限制


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
    public ResponseMsg get(String id) throws IOException {
        ExamDao dao=new ExamDao();

        return  dao.get(id);
    }



}
