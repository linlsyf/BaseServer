package spring.response;

import com.alibaba.fastjson.JSON;

public class MbyRespnseUtils {
//     public static MBYViewModel get(Object  o){
//         String result = getString(o,true);
//         MBYViewModel mbyViewModel=new MBYResponseViewModel("200",JSON.toJSONString(o));
//         return mbyViewModel;
//     }
//     public static MBYViewModel get(Object  o,boolean isSucess){
//         String result = getString(o,isSucess);
//         String  code="200";
//                 if (!isSucess){
//                     code="300";
//                 }
//         MBYViewModel mbyViewModel=new MBYResponseViewModel(code,result);
//         return mbyViewModel;
//     }
     public static MBYViewModel get(  ResponseMsg reuslt,boolean isSucess){
         String result = JSON.toJSONString(reuslt);
         String  code="200";
                 if (!isSucess){
                     code="300";
                 }
         MBYViewModel mbyViewModel=new MBYResponseViewModel(code,result);
         return mbyViewModel;
     }


//    private static String getString(Object o,boolean isSucess) {
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(isSucess);
//        responseMsg.setData(o);
//        return JSON.toJSONString(responseMsg);
//    }
}
