package controller;

import com.alibaba.fastjson.JSON;
import favour.dao.bean.FavourBean;
import favour.service.FavourService;
import human.dao.UserDao;
import human.dao.bean.User;
import human.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.MbyRespnseUtils;
import spring.response.ResponseMsg;

import java.util.List;
import java.util.Map;

@Controller(value = "favourController")
@RequestMapping(value = "/api/v1/favour")
public class FavourController {
    //@Autowired
    FavourService userService =new FavourService();


    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        List<FavourBean> result= userService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return MbyRespnseUtils.get(result);
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        FavourBean order=  JSON.parseObject(msg, FavourBean.class);
        FavourBean user  = userService.get(order.getId());
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

}