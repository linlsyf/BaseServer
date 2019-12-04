package controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayUserUserinfoShareRequest;
import com.alipay.api.response.AlipayUserUserinfoShareResponse;


import dao.OrderDao;
import dao.bean.ShopOrder;
import dao.bean.ShopOrderMsg;
import dao.bean.ShopRecorder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.OrderService;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.MbyRespnseUtils;
import spring.response.ResponseMsg;

import java.util.*;

@Controller(value = "orderController")
@RequestMapping(value = "/api/v1/order")
public class OrderController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired
//    OrderService orderService=new OrderService();
//
//    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel list( ) throws Exception {
//        List<ShopOrder> orderMsgList=orderService.list();
////        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//        return MbyRespnseUtils.get(orderMsgList);
//}
//    @RequestMapping(value = "/pay", produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel pay( ) throws Exception {
//
//         String APP_ID="2016091100483029";
//         String APP_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCzFPs2Mxc5mN880BIjx7cfd+OnoxFr6KRPv8Yo4DsyyeUNpvMQGRLwfDGq2OI9Y8ZYcUMrZ6/qlZiNrqUr3k9dsOXIeM865oqD2IU9MzeJCDfz7jfVyDSG+YnIzUEdp30RpGIYSwrehAvwHBORZhn1U3bIGkifevVphDosGo3+D8v1I10WdkC+4PB7m9++movMhllBSoM3mPGCVcyp1ZSX7Dr1bRg0t1SpBPyAcdGzuSyVsJxK9rXPPg4xBkH5eDFPXzXNQOW4nT6s+Xyd2lLxOsv++2NbF952UXOcyVDoBC9/9xXWUhzs/Rr2HuwPKoI+sXtsxw/KO/00dZFBBQNAgMBAAECggEBAIeAwtB6bo4g5QvB2fGfPQR7usrmlwTSi+8lNyXYdpJBLyL2aaHHGP1pxycriW14AzbQv9V14HvK7ZQcJeXPujJ7Lssuk3eJHBAt6zhQoUHVN9j4Ec2qOfZt2cdXwkV8jZuiixGnJqaHnkLZRkXsO3ve8O2AuiF4Hljbz99M+FY9bbCGQ9rAki4tfpeFdwCrOdpAgRdpxt9HM+9RCVGn7UzQLe1NzKGnn+0EXyF4s1fSeexPMsOzM8Vg59RETlPp85uD4bTwrQuEfLmZ57f5I3J5Tdd+m2ob80CsN0hZeylJMCM9Ddr/BHpIB/hxBFI3GrBtuJG+M6hQuLa/0UzTbzECgYEA7wl+CAa6AbYouAPxse4Ez5LkrIAoHO7F4dL33yQ6YGHMSZWiAq0IwD5/sFEQEn33N8qvLrkRjsgmiGHWes5DBXBx80nR/iZH0WAANJSL/78MlpyAXSHCbOAr3/bc/tMBsxdLJMqJwVGcXrbHMhZw94GZ4d6hwOCYIyBGQjIoVe8CgYEA0J8pXs9r+I0LVBqCFWGBzEQO6stUmpmgF81ZWA4mKoqt+7w0Iez/uLyyGfccCuavMGHRxBYM6aZA4iRxqGvzGAm1EYKudctAllzIIDqge26BHevkCpCvVLYHBYtNFXcs8mo7PG9s5mMvLgUSYkS2cXV5Uu8++C9wKC+3OM6GUcMCgYEAx4HJshNDLmiGJcgM82/wjftRZvR0Bmn3uRqnDZQkMQuPQR9loAwh0KqZUmTmIDkInIVLn5iRofVFy/C03bzHzYNjaCaF4TS8HnGc2kXdb3Bapl4q+RBTQSH9HKnjG8Crm3lmm2d8gGCIPbkaGqEGWl3OPOnfYadS84ZdfaR1a/sCgYAW4Z4T/AQHmtCnRNEHr04hLUXFks+QtVDNy4QFGGgvOk6i0Z2WKvxRMsEGAAhfWbXVRKVRMGnyJn3vT7f3lP9wn3/wj7i6yrQmyb5ZapS3dQNMWNcGIaBZVi2m+gRWWl/fpq8gjcgP7Mj77yp5BLhN8WiBJCRv7CQNBE7AOEabKQKBgBsFpPyBE++eW5LNCgRtdr7feyxT8bsYNlEnZa1R3ow6adHeM/6Ft98ZNoxsf/7uauKB882+4pVmVeRDu1NlgxNzWAo2WQuktP9T4himD61Z5SKCzg2HhDd6E/ydmp9s0TMqJ4FwaNibGXvP40NobDiuEKJPQkWb/eyS6e2S8awG";
//
//        String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2N67iiUNXZMzcJjqieRP4lDrnJQk/QG589DHyWIgNQLbDxryrdZHn3L6d5juX3Bm39eJpYr/2kDKR+p2+4GxqpBUjVNwCS6w8hDc2lEpWQNOsBEi/tA0TCwXoWZ0DNX58e8GPXeLJbID6QxJgtJXfZVtdQmkoeukGfBqegoosjotvs7kaBnUMy8AvyIbUO2aTpbERtKEI5J1ALHZHciVBpC9e0GzIXTO8t9949culRXK5TJ9jnnYFRYjT789vVoshMrPw76ZHd77ttpDOMR4aWN/w8t94dYks0EsugVh8wD0Wj3r6BEwLJnfZ+zaYijQuU8Eo2acNSygTTpnFEWi4wIDAQAB";
//
//
//
//        AlipayClient alipayClient = new
//                DefaultAlipayClient ("https://openapi.alipaydev.com/gateway.do",APP_ID,
//                APP_PRIVATE_KEY
//                ,"json","utf-8",
//                ALIPAY_PUBLIC_KEY,"RSA2" );
//        AlipayUserUserinfoShareRequest request = new AlipayUserUserinfoShareRequest();
////授权类接口执行API调用时需要带上accessToken
//        AlipayUserUserinfoShareResponse response= alipayClient.execute(request,"accessToken");
//
//         int i=0;
////业务处理
////...
//        return MbyRespnseUtils.get("");
//}
//
//
//
//
//    @RequestMapping(value = "/listOrdered", produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel getOrdered( ) throws Exception {
//
//        List<ShopRecorder> orderList=orderService.getOrderedList();
////        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//        return MbyRespnseUtils.get(orderList);
//    }
//    @RequestMapping(value = "/getMyOrder", produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel getMyOrder(@RequestParam Map params) throws Exception  {
//          String msg=(String) params.get("msg");
//
//        List<ShopRecorder> orderList=orderService.getMyOrder(msg);
////        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//        return MbyRespnseUtils.get(orderList);
//    }
////    @RequestMapping(value = "/getSign", produces = MediaTypes.JSON_UTF_8)
////    @ResponseBody
////    public MBYViewModel getSign( ) throws Exception {
////
////       String order= GetSignUtils.get();
//////        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
////        return MbyRespnseUtils.get(order);
////}
//    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel get(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//
//        ShopOrder order=  JSON.parseObject(msg, ShopOrder.class);
//        ShopOrderMsg orderMsg   = orderService.get(order.getId()) ;
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(true);
//        responseMsg.setData(orderMsg);
//        String result=JSON.toJSONString(responseMsg);
//       MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//        return mbyViewModel;
//    }
//    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel add(@RequestParam Map params) throws Exception  {
//
//
//        orderService.add("");
//        String reuslt="";
////        String msg=(String) params.get("msg");
////
////        String reuslt=orderService.add(msg);
////        Map<String, String> parm=new HashMap<String, String>();
////        parm.put("msg","有新的订单");
//
////        Collection<String> aliases=new ArrayList<String>();
////        aliases.add("ldh");
////        JpushManger.jpushAndroid(parm,true,aliases);
//        return MbyRespnseUtils.get(reuslt);
//    }
//    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public String update(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//        ShopOrder order=  JSON.parseObject(msg, ShopOrder.class);
//        String result= OrderDao.update(order);
//
//        return result;
//    }
//    @RequestMapping(value = "/remove" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//        ShopOrder order=  JSON.parseObject(msg, ShopOrder.class);
//        String result=OrderDao.remove(order);
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//
//        return mbyViewModel;
//    }
}