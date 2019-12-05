package controller;

import com.alibaba.fastjson.JSON;
import error.service.ErrorService;
import favour.dao.bean.FavourBean;
import human.dao.UserDao;
import auth.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.Ztoken;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import utils.ZStringUtils;

import java.util.Map;

@Controller(value = "errorController")
@RequestMapping(value = "/api/v1/error")
public class ErrorController {
    //@Autowired
    ErrorService adcarService =new ErrorService();


    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {
        ResponseMsg reuslt= adcarService.list();
//        List<FavourBean> result= adcarService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return  reuslt;
}
    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search( @RequestParam Map params, Ztoken ztoken) throws Exception {


        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
            return mbyViewModel;
        }
        ResponseMsg reuslt= adcarService.search(params,ztoken);
//        List<FavourBean> result= adcarService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return  reuslt;
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        FavourBean order=  JSON.parseObject(msg, FavourBean.class);
       return   adcarService.get(order.getId());

    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params, Ztoken ztoken) throws Exception  {

        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
            return mbyViewModel;
        }
        String msg=(String) params.get("msg");

        return  adcarService.add(msg,ztoken);

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

        String result= adcarService.remove(ids);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}