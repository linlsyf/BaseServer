package human.service;
import base.BaseBussinessDao;
import com.alibaba.fastjson.JSON;

import com.miracle.apps.cms.setting.impl.CmsImpExpServiceImpl._doImportTransCmd;
import config.LoginConfig;
import human.dao.UserDao;
import auth.User;
import human.dao.bean.UserAuths;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import utils.MD5Tools;
import utils.TreadPoolUtil;
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
//    public ResponseMsg loginExecute(final Map params) throws Exception {
////        TreadPoolUtil.getInstance().execute(new Runnable() {
////            @Override
////            public void run() {
////                try {
////                   login(params);
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
////            }
////        });
//    }
    public Map   login(Map params) throws Exception {
        List<Object> msg=null;//
        // jmeter 测试1000个人同时登录  使用线程池+队列
        // dubbo 多个部署  添加线程池
        //如果是QQ或者微信登录新建一个账号绑定
        if(params.containsKey("type")){
            String type=(String)params.get("type");
            List<Object> result= getDao().qqSearchLogin(params);
            //新建一个用户
            if (result.size()==0){
                Map  emptyMap=new HashMap();
                emptyMap.put("registerId",params.get("loginId"));
                emptyMap.put("name",params.get("loginId"));
                String pwd=(String)  params.get("pwd");
                emptyMap.put("pwd", MD5Tools.string2MD5(pwd));
//                ResponseMsg  msg= addUser(emptyMap);//user
//                if (msg.isSuccess()){
//                    String id=(String)msg.getData();
//                    if (ZStringUtils.isNotEmpty(id)){
//                        params.put("userid",id);
//                        msg= add(params);//user_auths
//
//                    }
//
//                }
            }

        }
        //获取用户登录信息
        if (null==msg){
            msg=  getDao().login(params);
        }

          return     saveTicket(msg);//保护用户登录信息

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
        List<Object> result = getDao().getByRegisterId(loginId);
        boolean flag=false;
        if (result.size()>2){
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
    public ResponseMsg logout(Map params)  {
        ResponseMsg msg=new ResponseMsg();
        String  ticket=(String)params.get("ticket");
        TokenCache.removeToken(ticket);
        msg.setSuccess(true);
        msg.setMsg("退出成功");
       return msg;


    }
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
    public List<Object>    Search( Map params, Ztoken ztoken) throws IOException {
        return  getDao().searchPage(params,User.class);
    }

    /**
     * 保存用户登录信息
     */
    public Map saveTicket(List<Object> userList){
        String ticket= UUID.randomUUID()+"";
        Map  resultMap=new HashMap();
         resultMap.put("userList",userList);
        try {
            Ztoken  ztoken=new Ztoken();
             if (userList.size()>0){
                 User user=(User)userList.get(0);
                 ztoken.setUser(user);
                 TokenCache.saveToken(ticket,ztoken);
                 resultMap.put("ticket",ticket);
             }

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;

    }
}
