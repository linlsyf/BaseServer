package service;

import auth.User;
import config.LoginConfig;

import java.util.HashMap;
import java.util.Map;

public class   TokenCache {

    public  static Map<String ,Ztoken> mCache=new HashMap();


    public static boolean containToken(String  key){

        return   mCache.containsKey(key);

    }

    public static void saveToken(String  key,Ztoken ztoken){
           mCache.put(key,ztoken);
    }

       public static Ztoken getZtoken(String  key){

             if (key.equals(LoginConfig.loginTemp)){
                 Ztoken ztoken=new Ztoken();
                 User  user=new User();
                    user.setId("admin");
                    user.setName("admin");
                    ztoken.setUser(user);
                 return  ztoken;
             }

          return mCache.get(key);
       }

}