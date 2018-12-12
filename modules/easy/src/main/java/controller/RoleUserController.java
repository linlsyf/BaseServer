package controller;

import com.alibaba.fastjson.JSON;

import human.dao.RoleUserDao;
import human.dao.bean.RoleUser;
import human.service.RoleUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;

import java.util.Map;

@Controller(value = "RoleUserController")
@RequestMapping(value = "/api/v1/RoleUser")
public class RoleUserController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired

    RoleUserService roleUserService =new RoleUserService();

    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        String result= roleUserService.list();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/get")
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        RoleUser order=  JSON.parseObject(msg, RoleUser.class);
        RoleUser RoleUser  = roleUserService.get(order.getId());
        boolean flag=false;
        if (RoleUser!=null){
            flag=true;

        }

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        if (RoleUser!=null){
            responseMsg.setData(RoleUser);
        }
        String result=JSON.toJSONString(responseMsg);

        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
    }
    @RequestMapping(value = "/add")
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        String reuslt= roleUserService.add(msg);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);
//        Map<String, String> parm=new HashMap<String, String>();
//        parm.put("msg","有新的订单");
//
//        Collection<String> aliases=new ArrayList<String>();
//        aliases.add("ldh");
//        JpushManger.jpushAndroid(parm,true,aliases);
        return mbyViewModel;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        RoleUser order=  JSON.parseObject(msg, RoleUser.class);
        String result=RoleUserDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove")
    @ResponseBody
    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        RoleUser RoleUser=  JSON.parseObject(msg, RoleUser.class);
        String result= RoleUserDao.remove(RoleUser);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}