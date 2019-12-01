package config;

import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;

public class LoginConfig {

    public static final String loginTemp="admin_temp";

    public static  ResponseMsg  loginCheck(Ztoken ztoken){
        ResponseMsg data=null;
        if (!TokenCache.mCache.containsKey(ztoken.getTicket())&&!ztoken.getTicket().equals(LoginConfig.loginTemp)){
             data=new ResponseMsg();
            data.setSuccess(false);
            data.setCode(300+"");
            data.setMsg("请先登录");

        }
        return data;
    }
}
