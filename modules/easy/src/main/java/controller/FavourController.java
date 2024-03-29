package controller;

import com.alibaba.fastjson.JSON;
import favour.dao.bean.FavourBean;
import favour.service.FavourService;
import human.dao.UserDao;
import auth.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import spring.response.ResultRespnseUtils;

import java.util.Map;

@Controller(value = "favourController")
@RequestMapping(value = "/api/v1/favour")
public class FavourController {
    //@Autowired
    FavourService favourService =new FavourService();


    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {
        ResponseMsg reuslt= favourService.list();
//        List<FavourBean> result= adcarService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return  reuslt;
}
    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search( @RequestParam Map params) throws Exception {


        Object result= favourService.search(params);
//        List<FavourBean> result= adcarService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return ResultRespnseUtils.getResponseMsg(null,result);
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        FavourBean order=  JSON.parseObject(msg, FavourBean.class);
       return  favourService.get(order.getId());
        
    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params) throws Exception  {
//        String msg=(String) params.get("msg");

        ResponseMsg reuslt= favourService.add(params);

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