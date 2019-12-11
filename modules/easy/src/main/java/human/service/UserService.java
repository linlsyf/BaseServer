package human.service;

import com.alibaba.fastjson.JSON;

import human.dao.UserDao;
import auth.User;
import human.dao.bean.UserAuths;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import utils.ZStringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

    public  String list()throws Exception  {
       String data= UserDao.list();
        return data;
    }
    public User get(String id) throws IOException {
        UserDao  dao=new UserDao();

        return  dao.get(id);
    }

    public  boolean  checkUserExit(String loginId) throws IOException {
        ResponseMsg user  = getDao().getByRegisterId(loginId);
        boolean flag=false;
        if (user.getData().toString().length()>2){
            flag=true;
        }
        return flag;
    }

    public ResponseMsg add(Map params){

        Map  inputMap=new HashMap();
        inputMap.put("type",params.get("type"));
        inputMap.put("loginId",params.get("loginId"));
//        inputMap.put("register",params.get("loginId"));
        inputMap.put("pwd",params.get("pwd"));
         return getDao().insert(params);
    }
    public ResponseMsg addUser(Map params){

         return getDao().insertByName(params,"CreateUser.sql");
    }
    public ResponseMsg register(Map params) throws IOException {

       String loginId= (String)params.get("loginId");
        boolean isExit= checkUserExit(loginId);
        if (isExit){
            ResponseMsg   msg=new ResponseMsg();
             msg.setSuccess(false);
             msg.setMsg("用户名称已经存在");

             return  msg;

        }
         Map  addMap=new HashMap();
         addMap.put("registerId",params.get("loginId"));
         addMap.putAll(params);
        ResponseMsg   msg= addUser(addMap);
        if (msg.isSuccess()){
            String id=(String)msg.getData();
            if (ZStringUtils.isNotEmpty(id)){
                params.put("userid",id);
                msg= add(params);
//                saveTicket(msg);
            }
        }

        return  msg;
    }
    public ResponseMsg login(Map params) throws IOException {


        ResponseMsg msg=null;
         if(params.containsKey("type")){
             String type=(String)params.get("type");
                 msg= getDao().qqSearchLogin(params);

                  List<Object> result=JSON.parseArray(msg.getData().toString(),Object.class);

             if (null!=msg&&msg.isSuccess()&&result.size()==0){//新建一个用户
                 Map  emptyMap=new HashMap();
                  emptyMap.put("registerId",params.get("loginId"));
                  emptyMap.put("user",params.get("loginId"));
                msg= addUser(emptyMap);

                if (msg.isSuccess()){

                String id=(String)msg.getData();
                 if (ZStringUtils.isNotEmpty(id)){
                     params.put("userid",id);
                      msg= add(params);

                 }

                }
             }

         }
          if (null==msg){
              msg=  getDao().login(params);
          }
          if (msg.isSuccess()){
              if(msg.getData().toString().length()>2){
                  msg.setMsg("登录成功");
                  saveTicket(msg);
              }else {
                  msg.setSuccess(false);
                  msg.setMsg("登录失败");
              }
          }
        return msg;
    }

    public void saveTicket(ResponseMsg msg){
        String ticket= UUID.randomUUID()+"";
        List<User>   userList=   JSON.parseArray(msg.getData().toString(),User.class);
        Ztoken  ztoken=new Ztoken();
        ztoken.setUser(userList.get(0));
        TokenCache.saveToken(ticket,ztoken);
        msg.setTicket(ticket);
    }
}
