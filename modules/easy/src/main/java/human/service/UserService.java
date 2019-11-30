package human.service;

import com.alibaba.fastjson.JSON;

import favour.dao.FavourDao;
import human.dao.UserDao;
import human.dao.bean.User;
import org.springframework.stereotype.Service;
import service.TokenCache;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    static UserDao   mDao;

    public static UserDao getDao() {
        if (mDao==null){
            mDao=new UserDao();
            mDao.instance=mDao;
        }
        return mDao;
    }
    public String add( String  msg) throws Exception  {
        User order=  JSON.parseObject(msg, User.class);
        return order.getId();
    }
    public boolean  register( String  msg) throws Exception  {
        User user=  JSON.parseObject(msg, User.class);
        boolean isSucess= UserDao.add(user);

        return isSucess;
    }
    public  String list()throws Exception  {
       String data= UserDao.list();
        return data;
    }
    public User get(String id) throws IOException {
        UserDao  dao=new UserDao();

        return  dao.get(id);
    }

    public  boolean  checkUserExit(User order) throws IOException {
        User user  = UserDao.getByRegisterId(order.getRegisterId());
        boolean flag=false;
        if (user!=null){
            flag=true;
        }
        return flag;
    }
    public ResponseMsg login(Map params) throws IOException {
        ResponseMsg msg=  getDao().login(params);
          if (msg.isSuccess()){
              String ticket= UUID.randomUUID()+"";
              TokenCache.mCache.put(ticket,ticket);
              msg.setMsg(ticket);
          }

        return msg;
    }
}
