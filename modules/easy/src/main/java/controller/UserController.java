package controller;

import com.alibaba.fastjson.JSON;

import human.dao.UserDao;
import auth.User;
import human.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;

import java.util.Map;

@Controller(value = "userController")
@RequestMapping(value = "/api/v1/user")
public class UserController {
//    ShopCartDao  dao=new ShopCartDao();

    //@Autowired
    UserService userService =new UserService();
    @RequestMapping(value = "/isonline" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel isonline(@RequestParam Map params)  {
        return userService.checkIsLogin(params);
    }
    @RequestMapping(value = "/login" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel login(@RequestParam Map params) throws Exception  {


          if (!params.containsKey("loginId")||!params.containsKey("pwd")){
              MBYViewModel mbyViewModel=new MBYResponseViewModel("300","请输入登陆账号密码");
              return mbyViewModel;
          }

        return   userService.login(params);
    }
    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        String result= userService.list();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        User order=  JSON.parseObject(msg, User.class);
        User user  = userService.get(order.getId());
        boolean flag=false;
        if (user!=null){
            flag=true;

        }

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        if (user!=null){
            responseMsg.setData(user);
        }
        String result=JSON.toJSONString(responseMsg);

        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        String reuslt= userService.add(msg);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);
//        Map<String, String> parm=new HashMap<String, String>();
//        parm.put("msg","有新的订单");
//
//        Collection<String> aliases=new ArrayList<String>();
//        aliases.add("ldh");
//        JpushManger.jpushAndroid(parm,true,aliases);
        return mbyViewModel;
    }
    @RequestMapping(value = "/register" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel register(@RequestParam Map params) throws Exception  {

                 if (!params.containsKey("type")||!params.containsKey("loginId")||!params.containsKey("pwd")){

                     MBYViewModel mbyViewModel=new MBYResponseViewModel("300","账号密码或者注册类型为空");
                     return mbyViewModel;
                 }
        return   userService.register(params);
    }
    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public String update(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        User order=  JSON.parseObject(msg, User.class);
        String result= UserDao.update(order);

        return result;
    }


    @RequestMapping(value = "/remove" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        User user=  JSON.parseObject(msg, User.class);
        String result= UserDao.remove(user);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }
//    @RequestMapping(value = "/checkUserExit" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel checkUserExit(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//        User order=  JSON.parseObject(msg, User.class);
//         boolean isExit=  userService.checkUserExit(order);
//
//        return MbyRespnseUtils.get("",isExit);
//    }
}