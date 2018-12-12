package spring.response;

import com.alibaba.fastjson.JSON;

public class MbyRespnseUtils {
     public static MBYViewModel get(Object  o){
         String result = getString(o,true);
         MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
         return mbyViewModel;
     }
     public static MBYViewModel get(Object  o,boolean isSucess){
         String result = getString(o,true);
         MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
         return mbyViewModel;
     }


    private static String getString(Object o,boolean isSucess) {
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(isSucess);
        responseMsg.setData(o);
        return JSON.toJSONString(responseMsg);
    }
}
