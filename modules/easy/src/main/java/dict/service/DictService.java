package dict.service;

import adcar.dao.AdcarDao;
import base.BaseBean;
import base.BaseBussinessDao;
import com.alibaba.fastjson.JSON;
import config.LoginConfig;
import dict.dao.DictDao;
import dict.dao.bean.DictBean;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.Map;

@Service
public class DictService {

    DictDao orderDao;

    public DictDao getOrderDao() {
        if (orderDao==null){
            orderDao=new DictDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
//    public  String remove(String[] ids) {
//
//
//        return    getOrderDao().delete(ids);
//    }

    public  ResponseMsg  search(Map params, Ztoken ztoken)throws Exception  {

//        if (!TokenCache.containToken(ztoken.getTicket())&&!ztoken.getTicket().equals(LoginConfig.loginTemp)){
//            ResponseMsg data=new ResponseMsg();
//            data.setSuccess(false);
//            data.setCode(300+"");
//            data.setMsg("请先登录");
//            return data;
//        }

        ResponseMsg data= getOrderDao().searchPage(params, DictBean.class);
        return data;
    }
    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
        return getOrderDao().insert(params);
    }
    public ResponseMsg update( Map params, Ztoken ztoken) throws Exception  {

        return  getOrderDao().update(params);
    }
//
//    public boolean  register( String  msg) throws Exception  {
//        DictBean user=  JSON.parseObject(msg, DictBean.class);
//        boolean isSucess= DictDao.add(user);
//
//        return isSucess;
//    }
//    public  String list()throws Exception  {
//       String data= DictDao.list();
//        return data;
//    }
//    public DictBean get(String id) throws IOException {
//        DictDao dao=new DictDao();
//
//        return  dao.get(id);
//    }
//


}
