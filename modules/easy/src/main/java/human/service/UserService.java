package human.service;

import com.alibaba.fastjson.JSON;

import human.dao.UserDao;
import human.dao.bean.User;
import org.springframework.stereotype.Service;
import spring.response.ResponseMsg;

import java.io.IOException;

@Service
public class UserService {

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
    public ResponseMsg login(User loginUser) throws IOException {
        User user  = UserDao.getByLoginId(loginUser.getLoginId());
        boolean flag=false;
        if (user!=null){
            if (user.getPwd().equals(loginUser.getPwd())){
                flag=true;
            }
        }
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setData(user);
        return responseMsg;
    }
}
