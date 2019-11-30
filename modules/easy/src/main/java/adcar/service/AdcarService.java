package adcar.service;

import adcar.dao.AdcarDao;
import com.alibaba.fastjson.JSON;
import dict.dao.DictDao;
import favour.dao.FavourDao;
import favour.dao.bean.FavourBean;
import org.springframework.stereotype.Service;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class AdcarService {
//    AdcarDao mDictDao=new AdcarDao();

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
    public ResponseMsg add(String  msg) throws Exception  {
       return   getOrderDao() .add(msg);
    }

    public  ResponseMsg  list()throws Exception  {
        ResponseMsg data= getOrderDao().list();
        return data;
    }
    public  ResponseMsg  search( Map params)throws Exception  {
        ResponseMsg data= getOrderDao().search(params);
        return data;
    }
    public FavourBean get(String id) throws IOException {
        FavourDao dao=new FavourDao();

        return  dao.get(id);
    }



}
