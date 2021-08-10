package human.service;
import base.BaseBussinessDao;
import com.alibaba.fastjson.JSON;

import com.miracle.apps.cms.setting.impl.CmsImpExpServiceImpl._doImportTransCmd;
import human.dao.UserDao;
import auth.User;
import human.dao.bean.UserAuths;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import utils.MD5Tools;
import utils.ZStringUtils;

import java.io.IOException;
import java.util.*;
/**
 * 类名： 用户管理服务
 *
 * */
@Service
public class UserService {
    static UserDao   mDao;
    public static UserDao getDao() {
        if (mDao==null){
            //获取用户dao层
            mDao=new UserDao();
            mDao.instance=mDao;
        }
        return mDao;
    }

    /**
     * 用户登录
     */
    public ResponseMsg login(Map params) throws IOException {
        ResponseMsg msg=null;
        //如果是QQ或者微信登录新建一个账号绑定
        if(params.containsKey("type")){
            String type=(String)params.get("type");
            msg= getDao().qqSearchLogin(params);
            List<Object> result=JSON.parseArray(msg.getData().toString(),Object.class);
            //新建一个用户
            if (null!=msg&&msg.isSuccess()&&result.size()==0){
                Map  emptyMap=new HashMap();
                emptyMap.put("registerId",params.get("loginId"));
                emptyMap.put("name",params.get("loginId"));
                String pwd=(String)  params.get("pwd");
                emptyMap.put("pwd", MD5Tools.string2MD5(pwd));
                msg= addUser(emptyMap);//user
                if (msg.isSuccess()){
                    String id=(String)msg.getData();
                    if (ZStringUtils.isNotEmpty(id)){
                        params.put("userid",id);
                        msg= add(params);//user_auths

                    }

                }
            }

        }
        //获取用户登录信息
        if (null==msg){
            msg=  getDao().login(params);
        }
        if (msg.isSuccess()){
            if(msg.getData().toString().length()>2){
                msg.setMsg("登录成功");
                saveTicket(msg);//保护用户登录信息
            }else {
                msg.setSuccess(false);
                msg.setMsg("登录失败");
            }
        }
        return msg;
    }
    /**
     * 注册用户
     */
    public ResponseMsg register(Map params) throws IOException {
        String loginId= (String)params.get("loginId");
        String code= (String)params.get("code");
        if(!"ldh".equals(code)){
            ResponseMsg   msg=new ResponseMsg();
            msg.setSuccess(false);
            msg.setMsg("邀请码错误");
            return  msg;
        }
        //检查用户是否已存在
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

        String  pwd=(String)params.get("pwd");
        pwd=MD5Tools.string2MD5(pwd);
        addMap.put("pwd", pwd);
        params.put("pwd", pwd);
        //添加用户表信息
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


    /**
     * 获取指定编号用户
     */
    public ResponseMsg get(String id) throws IOException {

        return  getDao().get(id,UserAuths.class);
    }
    /**
     * 检查用户是否存在
     */
    public  boolean  checkUserExit(String loginId) throws IOException {
        ResponseMsg user  = getDao().getByRegisterId(loginId);
        boolean flag=false;
        if (user.getData().toString().length()>2){
            flag=true;
        }
        return flag;
    }

    /**
     * 获取所有用户
     */
    public  String list()throws Exception  {
        String data= UserDao.list();
        return data;
    }
    /**
     * 添加用户表信息
     */
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
    /**
     * 更新用户信息
     */
    public ResponseMsg updateUser(Map params) throws IOException {
         params.remove("registerId");
         params.remove("loginId");
         params.put(BaseBussinessDao.KEY_updateFileName,"UpdateUser.sql");
         return getDao().update(params);
    }
    /**
     * 根据ticket检查用户是否登录
     */
    public ResponseMsg checkIsLogin(Map params)  {
         String  ticket=(String)params.get("ticket");
         boolean isHasLogin=false;
        Ztoken  ztoken= TokenCache.getZtoken(ticket);
        ResponseMsg msg=new ResponseMsg();
        if (null!=ztoken){
              isHasLogin=true;
              msg.setData(ztoken.getUser());
          }
           msg.setSuccess(isHasLogin);
           return  msg;
    }
    /**
     * 搜索用户
     */
    public ResponseMsg Search( Map params, Ztoken ztoken) throws IOException {
        return  getDao().searchPage(params,User.class);
    }

    /**
     * 保存用户登录信息
     */
    public void saveTicket(ResponseMsg msg){
        String ticket= UUID.randomUUID()+"";
        List<Object>   userList=new ArrayList<>();
        try {
            userList=(List<Object>) msg.getData();
            Ztoken  ztoken=new Ztoken();
             if (userList.size()>0){
                 User user=(User)userList.get(0);
                 ztoken.setUser(user);
                 TokenCache.saveToken(ticket,ztoken);
                 msg.setTicket(ticket);
             }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
