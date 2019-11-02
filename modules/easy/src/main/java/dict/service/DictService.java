package dict.service;

import com.alibaba.fastjson.JSON;
import dict.dao.DictDao;
import dict.dao.bean.DictBean;
import org.springframework.stereotype.Service;
import spring.response.ResponseMsg;

import java.io.IOException;

@Service
public class DictService {

    public String add( String  msg) throws Exception  {
        DictBean order=  JSON.parseObject(msg, DictBean.class);
        return order.getId();
    }
    public boolean  register( String  msg) throws Exception  {
        DictBean user=  JSON.parseObject(msg, DictBean.class);
        boolean isSucess= DictDao.add(user);

        return isSucess;
    }
    public  String list()throws Exception  {
       String data= DictDao.list();
        return data;
    }
    public DictBean get(String id) throws IOException {
        DictDao dao=new DictDao();

        return  dao.get(id);
    }



}
