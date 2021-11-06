package favour.service;

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
public class FavourService {
//    ErrorDao mDictDao=new ErrorDao();

    FavourDao orderDao;

    public  String remove(String[] ids) {


        return    getOrderDao().delete(ids);
    }

    public FavourDao getOrderDao() {
        if (orderDao==null){
            orderDao=new FavourDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
    public ResponseMsg add(Map params) throws Exception  {
       return   getOrderDao() .add(params);
    }

    public  ResponseMsg  list()throws Exception  {
        ResponseMsg data= getOrderDao().list();
        return data;
    }
    public  List<Object>  search( Map params)throws Exception  {
     return getOrderDao().search(params);
    }
    public ResponseMsg get(String id) throws IOException {
        FavourDao dao=new FavourDao();

        return  dao.get(id,FavourBean.class);
    }



}
