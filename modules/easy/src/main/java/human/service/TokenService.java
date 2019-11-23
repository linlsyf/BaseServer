package human.service;

public class TokenService {

    public  static String  TOKEN_HEAD="token_";

     public static String  getToken(String ticket,String mac){


         return  TOKEN_HEAD+md5(ticket,mac);
//         return  TOKEN_HEAD+MD5

     }
//     public static String  getToken(String ticket,String mac){
//
//
//         return  TOKEN_HEAD+md5(ticket,mac);
////         return  TOKEN_HEAD+MD5
//
//     }
     //先不加密先  ？？
     public static String  md5(String ticket,String mac){


         return   ticket+"_"+mac;
     }

}
