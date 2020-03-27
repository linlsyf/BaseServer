package controller;

import blog.service.BlogService;
import com.alibaba.fastjson.JSON;
import dict.service.DictService;
import human.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.Ztoken;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;

import java.util.Map;

@Controller(value = "blogController")
@RequestMapping(value = "/api/v1/blog")
public class BlogController {
//    ShopCartDao  dao=new ShopCartDao();

    //@Autowired
    BlogService dictService =new BlogService();

    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return dictService.search(params,ztoken);

    }
    @RequestMapping(value = "/get", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return dictService.get(params,ztoken);

    }

    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params, Ztoken ztoken) throws Exception  {
//        String msg=(String) params.get("msg");
//        Map data= JSON.parseObject(msg,Map.class);
        ResponseMsg reuslt= dictService.add(params,ztoken);
        return reuslt;
    }
    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel update(@RequestParam Map params, Ztoken ztoken) throws Exception  {

        ResponseMsg reuslt= dictService.update(params,ztoken);
        return reuslt;
    }

//
//    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel list( ) throws Exception {
//
//        String result= dictService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//        return mbyViewModel;
//}
//    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel get(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//
//        User order=  JSON.parseObject(msg, User.class);
//        User user  = dictService.get(order.getId());
//        boolean flag=false;
//        if (user!=null){
//            flag=true;
//
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        if (user!=null){
//            responseMsg.setData(user);
//        }
//        String result=JSON.toJSONString(responseMsg);
//
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//        return mbyViewModel;
//    }
//    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel add(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//
//        String reuslt= dictService.add(msg);
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);
////        Map<String, String> parm=new HashMap<String, String>();
////        parm.put("msg","有新的订单");
////
////        Collection<String> aliases=new ArrayList<String>();
////        aliases.add("ldh");
////        JpushManger.jpushAndroid(parm,true,aliases);
//        return mbyViewModel;
//    }
////    @RequestMapping(value = "/register" ,produces = MediaTypes.JSON_UTF_8)
////    @ResponseBody
////    public MBYViewModel register(@RequestParam Map params) throws Exception  {
////        String msg=(String) params.get("msg");
////
////        boolean isExit= dictService.register(msg);
////
////
////
////        return MbyRespnseUtils.get(isExit);
////    }
//    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public String update(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//        User order=  JSON.parseObject(msg, User.class);
//        String result= UserDao.update(order);
//
//        return result;
////    }
//    @RequestMapping(value = "/remove" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//        User user=  JSON.parseObject(msg, User.class);
//        String result= UserDao.remove(user);
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//
//        return mbyViewModel;
//    }
////    @RequestMapping(value = "/checkUserExit" ,produces = MediaTypes.JSON_UTF_8)
////    @ResponseBody
////    public MBYViewModel checkUserExit(@RequestParam Map params) throws Exception  {
////        String msg=(String) params.get("msg");
////        User order=  JSON.parseObject(msg, User.class);
////         boolean isExit=  dictService.checkUserExit(order);
////
////        return MbyRespnseUtils.get("",isExit);
////    }
}