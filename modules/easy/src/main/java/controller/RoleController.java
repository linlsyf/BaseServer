package controller;

import com.alibaba.fastjson.JSON;

import human.dao.RoleDao;
import human.dao.bean.Role;
import human.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.Ztoken;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import spring.response.ResultRespnseUtils;

import java.util.Map;

@Controller(value = "RoleController")
@RequestMapping(value = "/api/v1/role")
public class RoleController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired

    RoleService roleService =new RoleService();

//    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel list( ) throws Exception {
//
//        String result= roleService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//        return mbyViewModel;
//}
//    @RequestMapping(value = "/get")
//    @ResponseBody
//    public MBYViewModel get(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//
//        Role order=  JSON.parseObject(msg, Role.class);
//        Role Role  = roleService.get(order.getId());
//        boolean flag=false;
//        if (Role!=null){
//            flag=true;
//
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        if (Role!=null){
//            responseMsg.setData(Role);
//        }
//        String result=JSON.toJSONString(responseMsg);
//
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//        return mbyViewModel;
//    }


    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
//        Map data= JSON.parseObject(msg,Map.class);
        ResponseMsg reuslt= roleService.add(params);
        return reuslt;
    }

    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search( @RequestParam Map params, Ztoken ztoken) throws Exception {
//        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
//            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
//            return mbyViewModel;
//        }
        Object result=roleService.search(params,ztoken);
        return ResultRespnseUtils.getResponseMsg(null,result);
    }

//
//    @RequestMapping(value = "/update")
//    @ResponseBody
//    public String update(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//        Role order=  JSON.parseObject(msg, Role.class);
//        String result= RoleDao.update(order);
//
//        return result;
//    }
//    @RequestMapping(value = "/remove")
//    @ResponseBody
//    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");
//        Role Role=  JSON.parseObject(msg, Role.class);
//        String result= RoleDao.remove(Role);
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
//
//        return mbyViewModel;
//    }

}