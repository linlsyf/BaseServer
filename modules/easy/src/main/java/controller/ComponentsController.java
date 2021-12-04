package controller;

import blog.service.ArticleService;
import components.service.ComponentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.Ztoken;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import spring.response.ResultRespnseUtils;

import java.util.List;
import java.util.Map;

@Controller(value = "componentsController")
@RequestMapping(value = "/api/v1/components")
public class ComponentsController {
//    ShopCartDao  dao=new ShopCartDao();

    //@Autowired
    ComponentsService dictService =new ComponentsService();

    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        List<Object>  list=dictService.search(params,ztoken);

        return ResultRespnseUtils.getResponseMsg(null,list);

    }


    @RequestMapping(value = "/getIndexInfo", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel getIndexInfo(@RequestParam Map params, Ztoken ztoken ) throws Exception {


        return dictService.getIndexInfo(params,ztoken);

    }
    @RequestMapping(value = "/getIndexMsg", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel getIndexMsg(@RequestParam Map params, Ztoken ztoken ) throws Exception {


        return dictService.getIndexMsg(params,ztoken);

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
//        String result= AppListDao.update(order);
//
//        return result;
////    }
//    @RequestMapping(value = "/remove" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//        User user=  JSON.parseObject(msg, User.class);
//        String result= AppListDao.remove(user);
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