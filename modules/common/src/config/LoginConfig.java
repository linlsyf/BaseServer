package config;

import auth.User;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import utils.TimeAreaUtils;

import java.util.Map;

public class LoginConfig {

    public static final String loginTemp="admin_temp";

    public static  ResponseMsg  loginCheck(Map params, Ztoken ztoken){
        ResponseMsg data=null;
        if (!TokenCache.mCache.containsKey(ztoken.getTicket())&&!ztoken.getTicket().equals(LoginConfig.loginTemp)){
             data=new ResponseMsg();
            data.setSuccess(false);
            data.setCode(300+"");
            data.setMsg("请先登录");

        }else{
            if (ztoken.getTicket().equals(LoginConfig.loginTemp)){
                params.put("creater","admin");
                params.put("createid","admin");
            }else{
             User  user= ztoken.getUser();
             if (null!=user){
                 params.put("creater",user.getId());
                 params.put("createid",user.getName());
             }

            }
            params.put("createtime", TimeAreaUtils.getTimeNow());

        }
        return data;
    }
}
