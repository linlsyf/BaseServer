package favour.service;

import com.alibaba.fastjson.JSON;
import dict.dao.DictDao;
import favour.dao.FavourDao;
import favour.dao.bean.FavourBean;
import org.springframework.stereotype.Service;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;

@Service
public class FavourService {
//    FavourDao mDictDao=new FavourDao();

    FavourDao orderDao;

    public FavourDao getOrderDao() {
        if (orderDao==null){
            orderDao=new FavourDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
    public ResponseMsg add(String  msg) throws Exception  {
//        FavourBean order=  JSON.parseObject(msg, FavourBean.class);

       return   getOrderDao() .add(msg);
//        return order.getId();
    }

    public   List<FavourBean>  list()throws Exception  {
        List<FavourBean> data= getOrderDao().list();
        return data;
    }
    public FavourBean get(String id) throws IOException {
        FavourDao dao=new FavourDao();

        return  dao.get(id);
    }



}
