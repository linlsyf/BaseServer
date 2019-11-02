package favour.service;

import com.alibaba.fastjson.JSON;
import dict.dao.DictDao;
import favour.dao.FavourDao;
import favour.dao.bean.FavourBean;
import org.springframework.stereotype.Service;

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
    public String add( String  msg) throws Exception  {
        FavourBean order=  JSON.parseObject(msg, FavourBean.class);

        getOrderDao() .add(order);
        return order.getId();
    }
    public boolean  register( String  msg) throws Exception  {
        FavourBean user=  JSON.parseObject(msg, FavourBean.class);
        boolean isSucess= FavourDao.add(user);

        return isSucess;
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
