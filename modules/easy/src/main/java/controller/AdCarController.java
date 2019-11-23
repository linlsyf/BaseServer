package controller;

import adcar.service.AdcarService;
import com.alibaba.fastjson.JSON;
import favour.dao.bean.FavourBean;
import human.dao.UserDao;
import human.dao.bean.User;
import human.dao.bean.Ztoken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import utils.ZStringUtils;

import java.util.Map;

@Controller(value = "adcarController")
@RequestMapping(value = "/api/v1/adcar")
public class AdCarController {
    //@Autowired
    AdcarService favourService =new AdcarService();


    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {
        ResponseMsg reuslt= favourService.list();
//        List<FavourBean> result= favourService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return  reuslt;
}
    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search( @RequestParam Map params, Ztoken ztoken) throws Exception {

        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数tic缺失");
            return mbyViewModel;
        }
        ResponseMsg reuslt= favourService.search(params,ztoken);
//        List<FavourBean> result= favourService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return  reuslt;
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        FavourBean order=  JSON.parseObject(msg, FavourBean.class);
        FavourBean user  = favourService.get(order.getId());
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

        ResponseMsg reuslt= favourService.add(msg);

//        MBYViewModel mbyViewModel= MbyRespnseUtils.get( reuslt,reuslt.isSuccess());

        return reuslt;
    }

    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public String update(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        User order=  JSON.parseObject(msg, User.class);
        String result= UserDao.update(order);

        return result;
    }
    @RequestMapping(value = "/delete" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel remove(@RequestParam  Map params) throws Exception  {

        String[] ids;
         String  id=(  String)params.get("ids");
            if(null==id){
            Map     dataMap=(Map) JSON.parseObject((String)params.get("msg"),Map.class);
            id=(String)dataMap.get("ids");
            }
           ids=new String[]{id};
          if (null==ids){

            return new MBYResponseViewModel("300","error");
          }

        String result= favourService.remove(ids);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}